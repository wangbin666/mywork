package com.joymeter.wechatpay.control;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.joymeter.common.util.HttpUtil;
import com.joymeter.common.util.WxSign;
import com.joymeter.common.util.XmlUtil;
import com.joymeter.menu.service.MenuManager;
import com.joymeter.wechatpay.config.WXPayExample;
import com.joymeter.weixin.bean.Weixin;

import net.sf.json.JSONObject;
@RequestMapping("/")
@Controller
public class PayServlet  {
	/**
	 * 进入付款输入页面
	 * @param request
	 * @return
	 */
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	@RequestMapping("/index")
	public String index(HttpServletRequest request,Map<String,Object> map){
		String code=request.getParameter("code");
		String openid=null;
		if(code==null){
			log.info("code获取失败此处做异常处理:");
		}
		else{
			//获取openid
			String url=" https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
			url = url.replace("APPID", Weixin.appId).replace("SECRET", Weixin.appSecret)
		            .replace("CODE", code);
			JSONObject json =   HttpUtil.httpRequest(url, "GET");
			System.out.println(json);
			log.info("获取openid返回结果:"+json);
	        openid=json.getString("openid");
			map.put("openid", openid);
		}
		return "pay";
	}
	/**
	 * 唤起JSSDK页面进行支付
	 * @param req
	 * @param resp
	 * @param map
	 * @return
	 */
	@RequestMapping("/payServlet")
    public String wechatPay(HttpServletRequest req,HttpServletResponse resp, Map<String, Object> map){
	String openid=req.getParameter("openid");
    String money=req.getParameter("money");
    log.info("此处需要对金额进行校验处理");
	Map<String,String> map2=null;
	try {
		//得到调用统一支付下单成功后返回的参数
	 map2 =	WXPayExample.pay(openid,money);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//时间戳
	 String timeStamp = System.currentTimeMillis()/1000+"";
     //生成签名paySign
	 SortedMap<Object,Object> map3 = new TreeMap<Object,Object>();
     map3.put("appId",map2.get("appid"));
     map3.put("timeStamp", timeStamp);
     map3.put("signType","MD5");
     map3.put("nonceStr", map2.get("nonce_str"));
     map3.put("package","prepay_id="+map2.get("prepay_id"));	 
     String paySign=WxSign.createSign(map3, Weixin.apiKey);
	 map.put("timeStamp", timeStamp);
	 String prepay_id="prepay_id="+map2.get("prepay_id");
	 map.putAll(map2);
	 
	 map.put("paySign", paySign);
	 map.put("package", prepay_id);

	 return "pay2";
    }
	@RequestMapping("/notify")
	public void notify(HttpServletRequest req,HttpServletResponse resp){
        
		
	    
		PrintWriter out=null;
		Map<String,String> xmlMap = null;
		try {
			//得到返回的数据
			xmlMap=XmlUtil.toMap(req.getInputStream());
			out = resp.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(xmlMap);
		Map<String,String> map2 = new HashMap<>();
		map2.put("return_code", "SUCCESS");
		String json=XmlUtil.MapToXML(map2);
		
		
        System.out.println(json);
        out.write(json);
  		out.flush();
	}
	@RequestMapping("/return")
	public String returnResutlt(HttpServletRequest req,HttpServletResponse resp){
		
		String msg = req.getParameter("msg");

		return msg;
		
	}
	
	}

