package com.file.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	//封装文件标题属性
	private String title;
	
	//封装上传文件属性
	private File file;

	//封装上传文件的类型
	private String uploadContentType;
	
	//封装上传文件名称
	private String uploadFileName;
	
	
	//上传文件
		private String upload() throws IOException {
			String path = ServletActionContext.getServletContext().getRealPath("/upload");
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream(this.getFile());
			FileOutputStream fos = new FileOutputStream(new File(path,uploadFileName));
			int length = fis.read(buffer);
			while(length>0) {
				fos.write(buffer, 0, length);
				length = fis.read(buffer);
			}
			fis.close();
			fos.flush();
			fos.close();
			return SUCCESS;
		}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
