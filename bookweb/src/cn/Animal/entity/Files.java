package cn.Animal.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Files {
	public static void main(String[] args){
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream("D:\\1.抽象和封装.txt");
			
			int i ;
			byte[] words = new byte[fis.available()];
			//StringBuffer sbf = new StringBuffer("");
			while((i=fis.read(words))!=-1){
				//sbf.append(new String(words,0,i,"GBK"));
				
			}
			//System.out.println(words);
			fos = new FileOutputStream("E:\\path.txt");
			fos.write(words,0,words.length);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
				if(fos != null){
					fos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}








/*	try{
		String str = "好好学习 java";
		byte[] words = str.getBytes();
		for(int i = 0; i<words.length;i++){
			System.out.println(words[i]);
		}
		fos = new FileOutputStream("D:\\path.txt");
		fos.write(words,0,words.length);
		System.out.println("PATH环境变量文件已更新！");
	}catch(IOException e){
		System.out.println("创建文件时出错！");
	}finally{
		try{
			if(fos != null){
				fos.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}*/
