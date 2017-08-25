package com.joymeter.accessToken.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joymeter.accessToken.bean.AccessToken;
import com.joymeter.common.util.HttpUtil;
import com.joymeter.weixin.bean.Weixin;

import net.sf.json.JSONObject;
@Component
public class AccessTokenUtil {
	/**
	 * 获取accessToken
	 * @param appID		微信公众号凭证
	 * @param appScret	微信公众号凭证秘钥
	 * @return
	 */
	//公司微信
//	public  String appID = "wxa8c9e5fe21169ce9";
//	public  String appScret = "ada4a0169ee884000d9fc815f929fe1f";
	@Autowired
	private AccessToken accessToken;
	//测试微信公共号
//	public String appID="wx457eb0bd25d7d9ac";
//	public String appScret="f7e7863924093a48c0a0a9f59c1da07a";
	   
	
	public  AccessToken getAccessToken() {
	
        accessToken = AccessToken.getAccessToken() ;
		

		// 访问微信服务器
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Weixin.appId + "&secret="
				+ Weixin.appSecret;
		JSONObject json =   HttpUtil.httpRequest(url, "GET");
		System.out.println(json);
		accessToken.setAccess_token(json.getString("access_token"));
		accessToken.setExpires_in(new Integer(json.getString("expires_in")));
		return accessToken;
}
}