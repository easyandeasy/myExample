package com.download.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

/**
 * 文件下载
 * @author tang
 *
 */
public class DownloadAction {

	private String fileName;
	
	public String execute(){
		return Action.SUCCESS;
	}
	
	public InputStream getInputStream() throws FileNotFoundException{
		HttpServletRequest req = ServletActionContext.getRequest();
		String path = req.getRealPath("/download");
		System.out.println(path);
		return new FileInputStream(new File(path,this.getFileName()));
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
