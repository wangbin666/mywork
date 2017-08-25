package com.joymeter.accessToken.bean;

import org.springframework.stereotype.Component;

@Component
public class AccessToken {
	private String access_token;	//access_token
	private int	expires_in;		//有效时间

	private static AccessToken accessToken = null;
	public static AccessToken getAccessToken(){
		if(accessToken==null){
			accessToken=new AccessToken();
		}
		return accessToken;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}


	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}

	
}
