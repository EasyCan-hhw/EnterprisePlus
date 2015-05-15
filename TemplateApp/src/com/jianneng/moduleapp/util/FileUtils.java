package com.jianneng.moduleapp.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.Environment;

public class FileUtils {

	private String SDPATH;//存储文件的路径

	public String getSDPATH() {
		return SDPATH;
	}

	public void setSDPATH(String sDPATH) {
		SDPATH = sDPATH;
	}
	
	/**
	 * 构造方法 获取SDCard路径
	 */
	public FileUtils() {
		//获得当前外部存储设备的目录
	  SDPATH=Environment.getExternalStorageDirectory()+"/"; 
	  System.out.println("sd card's directory path:"+SDPATH);
	}
	
	/**
	 * 在SDCard上创建文件
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
	 * 在SDCard上创建目录
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
	 * 判断文件是否存在
	 * @param fileName
	 * @return
	 */
	private boolean isFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
	
	/**
	 * 下载文件到指定目录
	 * @param path 下载文件的路径
	 * @param fileName 下载文件的文件名
	 * @param inputStream 下载文件数据流
	 * @return 返回一个File
	 */
	private File writeSDFromInput(String path,String fileName,InputStream inputStream) {
		
		File file = null;
		OutputStream outputStream = null;
		
		try {
			//创建SDCard上的目录
			File temp = createSDDir(path);
			System.out.println("directory in the sd card:"+temp.exists()); 
			file = createSDFile(path+fileName);
			System.out.println("file in the sd card:"+file.exists());
			outputStream = new FileOutputStream(file);
			byte buffer[] = new byte[4*1024];
			while((inputStream.read(buffer))!=-1){ 
				outputStream.write(buffer); 
		    } 
			//写入
			outputStream.flush();  
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭写入流
				outputStream.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	/**
	 * 判断SDCard是否存在
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
