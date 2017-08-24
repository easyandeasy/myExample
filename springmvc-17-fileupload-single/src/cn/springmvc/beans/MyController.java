package cn.springmvc.beans;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	@RequestMapping("/upload.do")
	public String register(MultipartFile img,HttpSession session) throws Exception {
//		String path = "d:/images";
		//获取当前服务器下的images目录
		String path = session.getServletContext().getRealPath("/images");
		//获取到上传文件的原始名称
		String fileName = img.getOriginalFilename();
		File file = new File(path,fileName);
		img.transferTo(file );
		return "/success.jsp";
	}
}
