package com.jianneng.moduleapp.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

public class BasicHttpClient {

	private static final int TIME_OUT = 1000*6;//��ʱ
	private static final String METHOD_POST = "POST";
	private static final String  METHOD_GET = "GET";
	private static final int HTTP_OK = 200;
	private static final String TAG = "BasicHttpClient";
	
	/**
	 * get��ʽģ��HTTP����
	 * @param urlstr
	 */
	public String HttpGet(String urlstr){
		
		URL url = null;
		HttpURLConnection conn = null;
		InputStream inStream = null;
		String response = null;
		
		try {
			url = new URL(urlstr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setConnectTimeout(TIME_OUT);
			conn.setRequestMethod(METHOD_GET);
			conn.setRequestProperty("accept", "*/*");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode == HTTP_OK) {
				
				inStream = conn.getInputStream();
				response = getResponse(inStream);
				
				
			}else{
				Log.e(TAG, "GET="+responseCode);
				response = "�����룺"+responseCode;
				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
		
	}
	
	
	public String httpPost(String urlstr,String params){
		byte[] data = params.getBytes();
		URL url = null;
		HttpURLConnection conn = null;
		InputStream instream = null;
		String response = null;
		
		try {
			
			url = new URL(urlstr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(TIME_OUT);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(METHOD_POST);
			conn.setRequestProperty("Connection", "Keep-Alive");//�������ӳ�ͨ
			conn.setRequestProperty("Charset", "UTF-8");//���ñ����ʽ
			conn.setRequestProperty("Content-length", String.valueOf(data.length));
			conn.setRequestProperty("Content-Type", "application/X-WWW-form-urlencoded");//���ô������ͣ��������ͨ���ַ���������������Ļ�Ҫ������Ӧ���޸�
			conn.connect();
			//DataoutputStream������д�뵽��������
			DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			outputStream.write(data);
			//.flush() �ύ��������
			outputStream.flush();
			//�ر�������
			outputStream.close();
			int responseCode = conn.getResponseCode();
			if (responseCode == HTTP_OK) {
				instream = conn.getInputStream();
				response = getResponse(instream);
			}else {
				Log.e(TAG, "POST="+responseCode);
				response = "�����룺"+responseCode;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	

	private String getResponse(InputStream inStream) throws IOException {
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int len = -1;
		byte[] buffer = new byte[1024];
		while ((len=inStream.read(buffer))!=-1) {
			
			outputStream.write(buffer, 0, len);
			
		}
		
		byte[] data = outputStream.toByteArray();
		
		return new String(data);
	}
	
	
}
