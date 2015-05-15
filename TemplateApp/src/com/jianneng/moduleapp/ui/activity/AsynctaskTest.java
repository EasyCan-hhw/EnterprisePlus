package com.jianneng.moduleapp.ui.activity;

import com.jianneng.moduleapp.util.BasicHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class AsynctaskTest extends AsyncTask<String, Void, String > {

	private static String TAG = "AsynctaskTest-->";
	private BasicHttpClient httpclient = new BasicHttpClient();
	
	@Override
	protected void onPreExecute() {
		Log.e(TAG, "onPreExecute()");
	}
	
	@Override
	protected String doInBackground(String... params) {
		System.out.println(params[0]);
		String value = httpclient.HttpGet(params[0]);
		Log.e(TAG, "doInBackground()"+value);
		
		return value;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
		Log.e(TAG, "onProgressUpdate()"+values);
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		
		Log.e(TAG, "onPostExecute()"+result);
	}
	

}
