package com.jianneng.moduleapp.util.sdCard;

import java.io.File;
import android.os.Environment;

public class OperationSDcard {

	private static String  sdCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
	/**
	 * �ж�SD���Ƿ����
	 * @return
	 */
	public boolean isSDCard(){
		
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			return true;
		}else{
			return false;	
		}
		
	}
	
    
   /**
    * �ж�SD�����ļ��Ƿ����  
    * @param fileName
    * @param path
    * @return
    */
    public boolean isFileExist(String fileName, String path)  
    {  
        File file = new File(sdCardRoot + path + File.separator + fileName);  
        return file.exists();  
    }  
    
}
