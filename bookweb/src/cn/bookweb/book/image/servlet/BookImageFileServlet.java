package cn.bookweb.book.image.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;

/**
 * 图片上伟控制器
 * @author tang
 *
 */
public class BookImageFileServlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Book bk = (Book)request.getSession().getAttribute("update");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		IBookService service = new BookServiceImpl();
		String add = request.getParameter("add");
		if(isMultipart){
			DiskFileItemFactory factory = new DiskFileItemFactory();//为解析类提供配置信息
			ServletFileUpload sfu = new ServletFileUpload(factory);//创建解析类的实例
			//开始解析
			String fileName = null;//文件名
			String formname = "";//文本框的值
			String name = "";//input标签的name属性值
			Book b = new Book();
			//每个表单域中数据会封装到一个对应的FileItem对象上
			try{
				List<FileItem> items = sfu.parseRequest(request);
				//区分表单域
				for(int i =0 ;i<items.size();i++){
					FileItem item = items.get(i);
					//isFormField 为 true ，表示这不是文件上伟表单域
					if(!item.isFormField()){
						ServletContext sctx = getServletContext();
						//获取存放文件的物理路径
						String path = sctx.getRealPath("/book_img");
						//获取文件名
						fileName = item.getName();
						File filetomcat = new File(path+"\\"+fileName);
						if(!filetomcat.exists()){
							item.write(filetomcat);//将文件添加到tomcat文件夹下
							//File file = new File("D:\\软件\\Myeclipse10.7\\two\\bookweb\\WebRoot\\book_img\\",fileName);
							//item.write(file);//将文件添加到项目文件夹下
							
						}
					}else{//普通表单操作
						formname = item.getString("utf-8");//文本框的值
						name = item.getFieldName();//input标签的name属性值
					}
					addBookInfo(name, formname,b,fileName,bk);
				}
				
				request.getSession().setAttribute("newbook", b.getBname());//将书名存储到会话中
				if(add.equals("add")){
					if(service.addBookInfo(b)){//判断是否添加图书成功。为true成功，否则不成功  
						request.getSession().setAttribute("addbook", "添加");
						out.print("<script type='text/javascript'>"+"location.href='jsp/after/success.jsp';"+"</script>");
					}else{
						out.print("<script type='text/javascript'>"+"alert('添加失败！'); location.href='jsp/after/addbook.jsp';"+"</script>");
					}
				}else{
					boolean flag = service.replaceBookInfo(b);
					request.getSession().setAttribute("addbook", "修改");
					if(flag){
						out.println("<script type='text/javascript'> location.href='jsp/after/success.jsp' </script>");
					}else{
						out.println("<script type='text/javascript'> alert('修改失败！');  location.href='jsp/after/welcome.jsp' </script>");
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			out.print("<script type='text/javascript'>"+"alert('添加失败！'); location.href='jsp/after/addbook.jsp';"+"</script>");
		}
	}
	
	
	/**
	 * 获取文本框中的数据
	 * @param name input标签名的值
	 * @param formname 文本框输入的值
	 * @param b 图书对象
	 */
	public void addBookInfo(String name,String formname,Book b,String filename,Book bk){
		if(name.equals("bid")){
			b.setBid(Integer.parseInt(formname));
		}
		if(name.equals("bname")){//图书名称
			b.setBname(formname);
		}
		if(name.equals("autdor")){//图书作者
			b.setAuthor(formname);
		}
		if(name.equals("price")){//图书定价
			b.setPrice(Float.parseFloat(formname));
		}
		if(name.equals("currprice")){//图书当前价
			b.setCurrprice(Double.parseDouble(formname));
		}
		if(name.equals("discount")){//图书折扣
			b.setDiscount(Double.parseDouble(formname));
		}
		if(name.equals("press")){//图书出版社
			b.setPress(formname);
		}
		if(name.equals("publishtime")){//图书出版时间
			b.setPublishtime(formname);
		}
		if(name.equals("edition")){//图书版次
			b.setEdition(Integer.parseInt(formname));
		}
		if(name.equals("pagenum")){//图书页数
			b.setPagenum(Integer.parseInt(formname));
		}
		if(name.equals("wordnum")){//图书字数
			b.setWordnum(Integer.parseInt(formname));
		}
		if(name.equals("printtime")){//图书印刷时间
			b.setPrinttime(formname);
		}
		if(name.equals("paper")){//图书纸质
			b.setPaper(formname);
		}
		if(name.equals("author")){//图书作者
			b.setAuthor(formname);
		}
		if(name.equals("type1")){//图书大类型
			b.setBigtid(formname);
		}
		if(name.equals("type2")){//图书小类型
			b.setTid(formname);
		}
		if(name.equals("stock")){//图书库存
			b.setStock(Integer.parseInt(formname));
		}
		if(filename != null){
			b.setImagebig(bk.getImagebig());
		}else{
			if(name.equals("image")){
				b.setImagebig(formname);
			}
		}
	
	}

}
