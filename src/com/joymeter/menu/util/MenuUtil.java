package com.joymeter.menu.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.joymeter.accessToken.util.AccessTokenUtil;
import com.joymeter.common.util.HttpUtil;
import com.joymeter.menu.bean.Menu;

import net.sf.json.JSONObject;




	/**
	* 类名: WeixinUtil </br>
	* 包名： com.souvc.weixin.util
	* 描述: 公众平台通用接口工具类 </br>
	* 开发人员： souvc  </br>
	* 创建时间：  2015-12-1 </br>
	* 发布版本：V1.0  </br>
	 */
    @Component
	public class MenuUtil {
	    
	    private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	    
	    // 菜单创建（POST） 限100（次/天）
	    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	    
	    /**
	     * 创建菜单
	     * 
	     * @param menu 菜单实例
	     * @param accessToken 有效的access_token
	     * @return 0表示成功，其他值表示失败
	     */
	    public static int createMenu(Menu menu) {
	        int result = 0;
	        // 拼装创建菜单的url
	        AccessTokenUtil as =new AccessTokenUtil();
//	        String accessToken="m2ScsKDJDhz4fPup4eTZZm2FG3jhnAmSV0vEgOlovhn-edopNDfs7LUgjRUXfDBm-SLIZ5sXB_RXOVrRJsU8_4_MciZK778pFKX1DSMPohkAGVeAFADJY";
	        String accessToken = as.getAccessToken().getAccess_token();

	        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
	        // 将菜单对象转换成json字符串
	        String jsonMenu = JSONObject.fromObject(menu).toString();
	       System.out.println(jsonMenu);
	        // 调用接口创建菜单
	        JSONObject jsonObject = HttpUtil.httpRequest(url, "POST", jsonMenu);
	        System.out.println(jsonObject);
	        if (null != jsonObject) {
	            if (0 != jsonObject.getInt("errcode")) {
	                result = jsonObject.getInt("errcode");
	                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	            }
	        }

	        return result;
	    }	    
	    
	  
	}
