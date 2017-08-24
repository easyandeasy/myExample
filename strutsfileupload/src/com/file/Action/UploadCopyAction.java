package com.file.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadCopyAction extends ActionSupport {

	//封装上传文件属性
	private File upload;

	//封装上传文件的类型
	private String uploadContentType;

	//封装上传文件名称
	private String uploadFileName;

	//存入文件的路径
	private String savePath;

	//上传文件
	public String execute() throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("");//获取当前项目的根目录
		String url = path + savePath + uploadFileName;//将根目录   +  要上传到的文件夹名（该名称在struts.xml配置文件中设置）+ 文件名
		//System.out.println(upload);
		FileUtils.copyFile(upload, new File(url));//第一个参数File是：旧的文件路径。第二个参数File是：新的文件路径。意思是将旧的文件拷贝到新的路径去
		//System.out.println(url);
		return SUCCESS;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
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
