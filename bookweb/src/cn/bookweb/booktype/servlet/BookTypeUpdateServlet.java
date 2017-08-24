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
 * 修改分类类型控制器
 * @author tang
 *
 */
public class BookTypeUpdateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookTypeService service = new BookTypeServiceImpl();
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
							if(name.equals("tname3")){//判断input标签的属性名是否是 tname3，是就将对象的值添加到对象中
								b.setTname(formname);
							}
							if(name.equals("pid3")){//判断input标签的属性名是否是 pid3，是就将对象的值添加到对象中
								if(formname.equals("0")){//判断选择了类型，为0说明没有选择类型
									b.setPid(null);//将存储为null
								}else{
									b.setPid(formname);//否则将选择的类型添加到对象中
								}
							}
							if(name.equals("tcontext3")){//判断input标签的属性名是否是 tcontext3，是就将对象的值添加到对象中
								b.setTcontext(formname);
							}
							if(name.equals("tid3")){//判断input标签的属性名是否是 tid3，是就将对象的值添加到对象中
								b.setTid(formname);
							}
						}
					}
					if(service.replaceBookType(b)){
						out.println("<script type='text/javascript'> alert('修改成功！');</script>");
					}
					out.println("<script type='text/javascript'> location.href='jsp/after/adminmanage.jsp'</script>");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
