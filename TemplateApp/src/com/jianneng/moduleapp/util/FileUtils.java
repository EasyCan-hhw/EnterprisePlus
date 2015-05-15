package com.jianneng.moduleapp.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.Environment;

public class FileUtils {

	private String SDPATH;//�洢�ļ���·��

	public String getSDPATH() {
		return SDPATH;
	}

	public void setSDPATH(String sDPATH) {
		SDPATH = sDPATH;
	}
	
	/**
	 * ���췽�� ��ȡSDCard·��
	 */
	public FileUtils() {
		//��õ�ǰ�ⲿ�洢�豸��Ŀ¼
	  SDPATH=Environment.getExternalStorageDirectory()+"/"; 
	  System.out.println("sd card's directory path:"+SDPATH);
	}
	
	/**
	 * ��SDCard�ϴ����ļ�
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private File createSDFile(String fileName)throws IOException {
	  File file=new File(SDPATH+fileName); 
	  file.createNewFile(); 
	  return file;
	}
	
	
	/**
	 * ��SDCard�ϴ���Ŀ¼
	 * @param dirName
	 * @return
	 */
	private File createSDDir(String dirName) {

	  File dir=new File(SDPATH+dirName); 

	  System.out.println("storage device's state :"+Environment.getExternalStorageState()); 
	  
	  if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){ 
		  
		  System.out.println("this directory real path is:"+dir.getAbsolutePath()); 
		  
		  System.out.println("the result of making directory:"+dir.mkdir()); 
	  
	  } 
	  return dir;
	}
	
	/**
	 * �ж��ļ��Ƿ����
	 * @param fileName
	 * @return
	 */
	private boolean isFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
	
	/**
	 * �����ļ���ָ��Ŀ¼
	 * @param path �����ļ���·��
	 * @param fileName �����ļ����ļ���
	 * @param inputStream �����ļ�������
	 * @return ����һ��File
	 */
	private File writeSDFromInput(String path,String fileName,InputStream inputStream) {
		
		File file = null;
		OutputStream outputStream = null;
		
		try {
			//����SDCard�ϵ�Ŀ¼
			File temp = createSDDir(path);
			System.out.println("directory in the sd card:"+temp.exists()); 
			file = createSDFile(path+fileName);
			System.out.println("file in the sd card:"+file.exists());
			outputStream = new FileOutputStream(file);
			byte buffer[] = new byte[4*1024];
			while((inputStream.read(buffer))!=-1){ 
				outputStream.write(buffer); 
		    } 
			//д��
			outputStream.flush();  
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//�ر�д����
				outputStream.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	/**
	 * �ж�SDCard�Ƿ����
	 * @return
	 */
	private boolean ifSDCard(){
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
