package com.jianneng.moduleapp.util.sdCard;

import java.io.File;
import android.os.Environment;

public class OperationSDcard {

	private static String  sdCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
	/**
	 * 判断SD卡是否存在
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
    * 判断SD卡上文件是否存在  
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
