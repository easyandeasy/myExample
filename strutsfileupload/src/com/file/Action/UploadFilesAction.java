package com.file.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 多文件上传
 * @author tang
 *
 */
public class UploadFilesAction extends ActionSupport {

	//封装文件标题属性
	private String title;
	
	//封装上传文件属性
	private File upload;
	
	//获取文件上传的路径
	private String savePath;
	
	//获取提交的多个文件
	private File[] uploads;
	
	//封装上传文件的类型
	private String[] uploadContentType;
	
	//封装上传文件名称
	private String[] uploadFileName;
	
	//批量上传文件第一个方法
	/*private String upload() throws IOException {
		byte[] buffer = new byte[1024];
		for (int i = 0;i<upload.length();i++) {
			FileInputStream fis = new FileInputStream(getUploads()[i]);
			FileOutputStream fos = new FileOutputStream(getSavePath()+"\\"+this.getUploadFileName()[i]);
			int length = fis.read(buffer);
			while(length>0) {
				fos.write(buffer, 0, length);
				length = fis.read(buffer);
			}
			fis.close();
			fos.flush();
			fos.close();
		}
		return SUCCESS;
	}*/
	
	//批量上传文件 第二个方法
	private String uploadtwo() throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		byte[] buffer = new byte[1024];
		for (int i = 0;i<uploads.length;i++) {
			FileInputStream fis = new FileInputStream(uploads[i]);
			FileOutputStream fos = new FileOutputStream(new File(path,uploadFileName[i]));
			int length = fis.read(buffer);
			while(length>0) {
				fos.write(buffer, 0, length);
				length = fis.read(buffer);
			}
			fis.close();
			fos.flush();
			fos.close();
		}
		return SUCCESS;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File[] getUploads() {
		return uploads;
	}

	public void setUploads(File[] uploads) {
		this.uploads = uploads;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
