package cn.mybatisspringmvc.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mybatisspringmvc.beans.Student;
import cn.mybatisspringmvc.beans.Users;
import cn.mybatisspringmvc.service.IStudentService;
import cn.mybatisspringmvc.service.IUsersService;
import cn.mybatisspringmvc.service.StudentServiceImpl;
import cn.mybatisspringmvc.service.UsersServiceImpl;
import cn.mybatisspringmvc.utils.PageUtil;

@Controller
@RequestMapping("/test")
public class MyController {
	
	private IStudentService stuService = new StudentServiceImpl();
	private IUsersService userService = new UsersServiceImpl();

	//鐧诲綍
	@RequestMapping("/dologin")
	public String doLogin(String uname,String upwd){
		//鏌ヨ鏁版嵁搴撳垽鏂敤鎴锋槸鍚﹀瓨鍦�
		//System.out.println(uname + "\t" + upwd);
		Users user = new Users(); 
		user.setUname(uname);
		user.setUpwd(upwd);
		
		boolean flag = userService.isLogin(user);
		if(flag) {
			return "/students.jsp";//濡傛灉鐧诲綍鎴愬姛锛岃烦杞埌鍒濆鍖栨暟鎹�
		}
		return "/index.jsp";
	}
	
	//鍒濆鍖栨暟鎹�
	@RequestMapping("/doQueryStudent")
	public void doQueryStudent(HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Student> stus = stuService.queryStudentInfo();
		map.put("stus", stus);//瀛樺偍瀛︾敓
		JSONObject myJson = JSONObject.fromObject(map);
		String json = myJson.toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	
	
	//鍒嗛〉鏁版嵁
	@RequestMapping("/doPageStudent")
	public void doPageStudent(int pageNow,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int count = stuService.queryStudentInfoCount();
		PageUtil page = new PageUtil();
		page.setPageNow(pageNow);
		page.setPageSize(15);
		page.setRecordCount(count);
		
		Map mapPage = new HashMap();
		mapPage.put("startRow", page.getStartRow());
		mapPage.put("endRow", page.getEndRow());
		List<Student> stus = stuService.queryStudentInfoPage(mapPage);
		
		Map<String,Object> map = new HashMap<String,Object>();
		String obj = "{'total':100,'rows':[";
		int i = 1;
		for (Student stu : stus) {
			if(stus.size() == i) {
				obj += "{itemid:'" + stu.getId() + "',productid:'"+stu.getSname()+"',listprice:'"+sdf.format(stu.getSbirth())+"',unitcost:'"+stu.getSclass()+"',attr1:'"+stu.getSaddress()+"',status:'p'}";
			} else {
				obj += "{itemid:'" + stu.getId() + "',productid:'"+stu.getSname()+"',listprice:'"+sdf.format(stu.getSbirth())+"',unitcost:'"+stu.getSclass()+"',attr1:'"+stu.getSaddress()+"',status:'p'},";
			}
			i++ ;
		}
		obj += "]}";
		map.put("json", obj);
		map.put("count", page.getPageCount());
		JSONObject myJson = JSONObject.fromObject(map);
		String json = myJson.toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}
	
	//娣诲姞瀛︾敓淇℃伅
	@RequestMapping("/doAddStudent")
	@ResponseBody
	public Object doAddStudent(int id ,String sname,Date sbirth,String sclass,String saddress){
		ModelAndView mv = new ModelAndView();
		System.out.println(id + "\t" + sname + "\t" + sbirth + "\t" + sclass + "\t" + saddress);
		Student stu = new Student(sname,sbirth,sclass,saddress);
		boolean flag = stuService.addStudentInfo(stu);
		return stu.getId();
	}
	
	
	//娣诲姞瀛︾敓淇℃伅
	@RequestMapping("/doUpdateStudent")
	@ResponseBody
	public Object doUpdateStudent(int id ,String sname,Date sbirth,String sclass,String saddress){
		ModelAndView mv = new ModelAndView();
		System.out.println(id + "\t" + sname + "\t" + sbirth + "\t" + sclass + "\t" + saddress);
		Student stu = new Student(id,sname,sbirth,sclass,saddress);
		boolean flag = stuService.addUpdateInfo(stu);
		return "";
	}
	
	

}
