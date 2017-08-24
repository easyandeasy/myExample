package cn.bookweb.booktype.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;
import cn.bookweb.md5.util.MD5Utils;

/**
 * 添加类型控制器
 * @author tang
 *
 */
public class BookTypeAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookTypeService service = new BookTypeServiceImpl();
		String typess = request.getParameter("typess");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			DiskFileItemFactory factory = new DiskFileItemFactory();//为解析类提供配置信息
			ServletFileUpload sfu = new ServletFileUpload(factory);//创建解析类的实例
			//开始解析
			String formname = "";//文本框的值
			String name = "";//input标签的name属性值
			BookType b = new BookType();
			//每个表单域中数据会封装到一个对应的FileItem对象上
			try{
				//判断添加的类型名称是否已存在
				
					int tid = 0;
					List<FileItem> items = sfu.parseRequest(request);
					List<BookType> list = service.queryBookTypeAllInfo();
					
					//区分表单域
					for(int i =0 ;i<items.size();i++){
						FileItem item = items.get(i);
						//isFormField 为 true ，表示这不是文件上伟表单域
						if(item.isFormField()){//普通表单操作
							formname = item.getString("utf-8");//文本框的值
							name = item.getFieldName();//input标签的name属性值
							if(name.equals("tname")){
								b.setTname(formname);
							}
							if(name.equals("pid")){
								if(formname.equals("0")){
									b.setPid(null);
								}else{
									b.setPid(formname);
								}
							}
							if(name.equals("tcontext")){
								b.setTcontext(formname);
							}
						}
					}
					int id = Integer.parseInt(list.get(1).getTid());
					for(BookType bk :list){//查询出大类的编号
						if(bk.getTid().length()<3){
							if(Integer.parseInt(bk.getTid())>id){
								id= Integer.parseInt(bk.getTid());
								tid = Integer.parseInt(bk.getTid());
							}
						}
					}
					if(b.getPid()==null){//判断分类是否为空，为空说明是大类
						b.setTid(Integer.toString(tid+1));
					}
					boolean flag = service.addBookType(b);
					String str = "";
					String pid = "";
					if(flag){
						str = "添加成功！";
						if(b.getPid()!=null){//判断分类是否为空，不为空说明是所属哪个大类
							List<BookType> list2 = service.queryBookTypeAllInfo();
							for(BookType bt :list2){
								if(bt.getTname().equals(b.getTname())){
									pid = MD5Utils.md5(Integer.toString(bt.getOrderby()));
									break;
								}
							}
							b.setTid(pid);//添加分类id
							service.replaceBookTypeByTname(b);
						}
					}else{
						str = "添加失败！";
					}//
					out.println("<script type='text/javascript'>  window.location.href='jsp/after/adminmanage.jsp'  </script>");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
