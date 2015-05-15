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
					//�ر�������
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
			url.getPort();//��ö˿ں� 
			url.getHost();//���������
			if (url != null) {
				//doInput ��ʾ���Դӷ�����ȡ������
				//outInput ��ʾ���Դӷ��������� ����
				httpUrlConnection = (HttpURLConnection) url.openConnection();//����һ��URLConnection
				
				//���÷�������Ӧʱ��
				httpUrlConnection.setConnectTimeout(3000);
				
				//����GET��ʽ��ȡ����
				httpUrlConnection.setRequestMethod("GET");
				
				//��ȡ������״̬��
				int responsecode = httpUrlConnection.getResponseCode();
				if (responsecode == 200) {
					
					//�ӷ�������ȡһ��������
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
		//�ӷ��������ѹ����ZIP,���浽����D��
		saveZIPToDisk();
	}
	
	 /** 
     *  
     * @Project: Android_MyDownload 
     * @Desciption: ֻ�ܶ�ȡ�ı��ļ�����ȡmp3�ļ�������ڴ�������� 
     * @Author: LinYiSong 
     * @Date: 2011-3-25~2011-3-25 
     */  
    public void  DownFileClickListener(){  
        	
        	InputStream input = null;
            String urlStr="http://121.40.199.144/themes/093c64e29531afe3527376525ed5fa94.zip";  
            String fileName = "093c64e29531afe3527376525ed5fa94.zip";
            
            
    }
	
}
