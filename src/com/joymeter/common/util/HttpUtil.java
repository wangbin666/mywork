package com.joymeter.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

public class HttpUtil {
    /**
     * 描述:  发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
	  public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
	    	JSONObject json = null;
	       
	        try {
				URL getUrl=new URL(requestUrl);
				HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
				http.setRequestMethod(requestMethod); 
				http.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);

				http.connect();
              OutputStream outputStream = http.getOutputStream();
              // 注意编码格式，防止中文乱码
              outputStream.write(outputStr.getBytes("UTF-8"));
              outputStream.flush();
              outputStream.close();
				
				InputStream is = http.getInputStream(); 
				int size = is.available(); 
				byte[] b = new byte[size];
				is.read(b);

				String message = new String(b, "UTF-8");
		
				 json = JSONObject.fromObject(message);

              is.close();
				return json;
			
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return json;
	    }
	  public static JSONObject httpRequest(String requestUrl, String requestMethod){
			JSONObject json = null;
		  try {
				URL getUrl=new URL(requestUrl);
				HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
				http.setRequestMethod(requestMethod); 
				http.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);

				http.connect();
				InputStream is = http.getInputStream(); 
				int size = is.available(); 
				byte[] b = new byte[size];
				is.read(b);

				String message = new String(b, "UTF-8");
		
				 json = JSONObject.fromObject(message);

			return json;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return json;
		}
		  
		  
	  }
	  

