package com.jianneng.moduleapp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpUtils {

	public static String URL_PATH = "http://qzs.qq.com/qzone/client/photo/qzone_shuoshuo_pic/4_3.jpg";
	
	public HttpUtils(){
		
	}
	
	public static void saveZIPToDisk(){
		InputStream inputStream = getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileoutputStream = null;
		try {
			fileoutputStream = new FileOutputStream("D:\\test.png");
			while ((len = inputStream.read(data))!= -1) {
				fileoutputStream.write(data, 0, len);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (inputStream != null) {
				try {
					//关闭输入流
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileoutputStream != null) {
				try {
					fileoutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static InputStream  getInputStream(){
		InputStream inputStream = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			URL url = new URL(URL_PATH);
			url.getPort();//获得端口号 
			url.getHost();//获得主机名
			if (url != null) {
				//doInput 表示可以从服务器取回数据
				//outInput 表示可以从服务器发送 数据
				httpUrlConnection = (HttpURLConnection) url.openConnection();//返回一个URLConnection
				
				//设置服务器相应时间
				httpUrlConnection.setConnectTimeout(3000);
				
				//采用GET方式获取数据
				httpUrlConnection.setRequestMethod("GET");
				
				//获取服务器状态码
				int responsecode = httpUrlConnection.getResponseCode();
				if (responsecode == 200) {
					
					//从服务器获取一个输入流
					inputStream = httpUrlConnection.getInputStream();
					
				}else {
					return null;
				}
			}
		
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inputStream;
	}
	
	public static void main(String[] args) {
		//从服务器获得压缩包ZIP,保存到本地D盘
		saveZIPToDisk();
	}
	
	 /** 
     *  
     * @Project: Android_MyDownload 
     * @Desciption: 只能读取文本文件，读取mp3文件会出现内存溢出现象 
     * @Author: LinYiSong 
     * @Date: 2011-3-25~2011-3-25 
     */  
    public void  DownFileClickListener(){  
        	
        	InputStream input = null;
            String urlStr="http://121.40.199.144/themes/093c64e29531afe3527376525ed5fa94.zip";  
            String fileName = "093c64e29531afe3527376525ed5fa94.zip";
            
            
    }
	
}
