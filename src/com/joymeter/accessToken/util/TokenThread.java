package com.joymeter.accessToken.util;


import org.springframework.stereotype.Component;

import com.joymeter.accessToken.bean.AccessToken;
@Component
public class TokenThread implements Runnable{

private AccessTokenUtil accessTokenUtil = new AccessTokenUtil();

private AccessToken accessToken=AccessToken.getAccessToken();
		

String accessTokenString = null;
		public String getAccessTokenString(){
			return accessTokenString;
		}
		@Override
		public void run() {
			while(true){
				try {
					//调用工具类获取access_token(每日最多获取2000次，每次获取的有效期为7200秒)
					accessToken=accessTokenUtil.getAccessToken();		
					if(null!=accessToken){
						System.out.println("accessToken获取成功："+accessToken.getExpires_in());
						//7000秒之后重新进行获取
						this.accessTokenString=accessToken.getAccess_token();
						Thread.sleep((accessToken.getExpires_in()-200)*1000);
					}else{
						//60秒之后尝试重新获取
						Thread.sleep(60*1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	
}
