package com.joymeter.weixin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joymeter.menu.service.MenuManager;
import com.joymeter.message.bean.MessageReply;
import com.joymeter.weixin.bean.Weixin;



@Controller

public class WeiXinControl {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	@Autowired
	private MessageReply messageReply;
    @RequestMapping(value = "/connection", method ={RequestMethod.GET})
	  public void connection(HttpServletRequest req, HttpServletResponse resp){
        log.info("初次进行token验证");
			PrintWriter out=null;
			try {
				out = resp.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connect(req,out);
	  }
	@RequestMapping(value = "/connection", method ={RequestMethod.POST})
      public void reply(HttpServletRequest req, HttpServletResponse resp)	{
       try {
		messageReply.echoMsg(req,resp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    }
	  /**
	   * 
	   * RpKdxsblmketsIvH8HdRQTBNgBfHuAo5R1OETzKmKBp
	   * 接入微信
	   * @param req
	   * @param out
	   */
	  private void connect(HttpServletRequest req, PrintWriter out) {
	  	//
	  	//获取参数
	  	String signature= req.getParameter("signature");
	  	String timestamp= req.getParameter("timestamp");
	  	String nonce= req.getParameter("nonce");
	  	String echostr= req.getParameter("echostr");
	  	List<String> list =new ArrayList<>();
	  	list.add(Weixin.token);
	  	list.add(timestamp);
	  	list.add(nonce);
	      //排序
	  	Collections.sort(list);
	  	//拼接字符串---->用shal加密
	  	StringBuffer StringBuffer = new StringBuffer();
	  	for(String string:list){
	  		StringBuffer.append(string);
	  	}
	  	String shalStr=DigestUtils.sha1Hex(StringBuffer.toString());
	  	//对比
	  	boolean flag = shalStr.equals(signature);
	  	if(flag){
	  		log.info("token验证成功");
      	  	out.write(echostr);
	  		out.flush();
	  	}
	  	else{
        log.info("token验证失败");	  	}
	  	out.close();
	  }
	  
}
