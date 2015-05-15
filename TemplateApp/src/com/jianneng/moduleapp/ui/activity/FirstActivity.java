package com.jianneng.moduleapp.ui.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.jianneng.moduleapp.R;
import com.jianneng.moduleapp.model.testInfo;
import com.jianneng.moduleapp.task.base.BaseActivity;
import com.jianneng.moduleapp.util.BasicHttpClient;
import com.jianneng.moduleapp.util.JsonUtils;
import com.jianneng.moduleapp.util.sdCard.OperationSDcard;


public class FirstActivity extends BaseActivity {

	private OperationSDcard sdcard = new OperationSDcard();
	private TextView Text_zip,http_value;
	private  String urls = "http://121.40.199.144/api?&";
	private String urlvalue = "action=theme_list&controller=theme&agent_phone=13564376214&access_token=0be9c814946aac8c8a50b36ee12b096d";
	private AsynctaskTest task = new AsynctaskTest();
	private BasicHttpClient httpClient = new BasicHttpClient();
	private String value;
	private OperationSDcard sdCard = new OperationSDcard();
	private List<testInfo> listInfo = new ArrayList<testInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		baseSetContentView(R.layout.fragment_main);

		Text_zip = (TextView) findViewById(R.id.Text_zip);
		http_value = (TextView) findViewById(R.id.http_value);
		
		String vlaue1 = Environment.getExternalStorageDirectory().getAbsolutePath(); 
		String value2 = Environment.getExternalStorageDirectory()+"/"; 
		 http_value.setText("vlaue1="+vlaue1+"----value2="+value2);
		
		
		//Android中判断SD卡是否存在，并且可以进行写操作，可以使用如下代码
		
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			System.out.println("true");
		}else{
			System.out.println("false");
			
		}
		
		Text_zip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(){
					@Override
					public void run(){
					//你要执行的方法
					value = task.doInBackground(urls+urlvalue);
					//执行完毕后给handler发送一个空消息
					handler.sendEmptyMessage(0);
					}
					}.start();
				
			}
		});
		
	}

		 

		//定义Handler对象
		private Handler handler =new Handler(){
		@Override
		//当有消息发送出来的时候就执行Handler的这个方法
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				//处理UI
				try {
					JSONObject jo = new JSONObject(value.toString());
					if (!jo.getString("msg").equals("OK")) {
						
						System.out.println(jo.getString("msg"));
						if (jo.getString("msg").equals("Invalid User Or Pwd")) {
							Log.e("Invalid User Or Pwd", "用户名密码失效！");
						}else {
							Log.e("other", "无返回数据！");
						}
						
					}else {
						
						JSONArray array = jo.getJSONArray("list");
						 List<testInfo> listdata =  (List<testInfo>) JsonUtils.getListByJSONArray(array.toString(), ArrayList.class, testInfo.class);
						 String jsonValue = listdata.get(0).getTheme_name();
						 http_value.setText(jsonValue);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		};
		 
		


}
