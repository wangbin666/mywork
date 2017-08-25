package com.joymeter.message.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.joymeter.weixin.bean.Weixin;


@Component
public  class MessageReply {

	 /**
	   * 自动回复消息
	   * 1、获取XML数据
	   * 2、xml-->解析-->存放在map中-->xml数据
	   * 3、xml数据解析转化为对象
	   * 4、将对象中的属性from<---->to调换位置 更改时间  内容
	   * 5、将对象再转为xml
	   * 6、resp发送出去
	   * * @param resp
	 * @throws IOException 
	   */
	public void echoMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer=resp.getWriter();
		Map<String,String> xmlMap = null;

		try {
			//2、xml--解析--存放Map中--xml数据
	      xmlMap = MessageUtil.toMap(req.getInputStream());
	      System.out.println(xmlMap);
	        //xml数据转化为对象
	      Message message = MessageUtil.toMessage(xmlMap);
	        //将对象中的属性 from --to 互换
	      String from = message.getFromUserName();
	      String to = message.getToUserName();
	      message.setFromUserName(to);
	      message.setToUserName(from);
	      message.setCreateTime(System.currentTimeMillis());
	      String content = message.getContent();
	      content = null==content?"":content.trim();
	      //返回数据
	      String reply="";
	      //获取消息类型
	      String type=xmlMap.get("MsgType");
//	      String openId=xmlMap.get("openid");
//	      System.out.println("openId="+openId);C
	      //比较
	      if(type.equals(Weixin.TEXT)){
	    	  if(content.equals("1")||content.equalsIgnoreCase("sxt")){
	    		  reply=sxtText();
	    		
	    	  }
	    	  else if(content.equals("2")||content.equalsIgnoreCase("mm")){
	    		  reply=sxtText2();
	    	  }

	    	  else {
	    		  reply=mainMenu();
	    	  }
	    	  
	     }
	      else if(type.equals(Weixin.type_image)){
	    	 reply="图片消息";
	     }else if(type.equals(Weixin.type_voice)){
	    	 reply="语音消息";
	     }else if(type.equals(Weixin.type_voice)){
	    	 reply="视频消息";
	     }else if(type.equals(Weixin.SHORTVIDEO)){
	    	 reply="小视频消息";
	     }else if(type.equals(Weixin.LOCATION)){
	    	 reply="地址位置消息";
	     }else if(type.equals(Weixin.LINK)){
	    	 reply="链接消息";
	     }else if(type.equals(Weixin.LOCATION)){
	    	 reply="地址位置消息";
	     }
	      else if(type.equals(Weixin.EVENT)){
	    	  //获取事件类型
	    	  String eventType=xmlMap.get("Event").toLowerCase();
	    	  if(eventType.equals(Weixin.SUBSCRIBE)){//关注事件
	    		  reply=mainMenu();
	    		  message.setMsgType(Weixin.TEXT);
	    	  }
	    	  else if(eventType.equals(Weixin.UNSUBSCRIBE)){
	    		  System.out.println("有人退出了");
	    	  }
	    	  else if(eventType.equals(Weixin.CLICK)){  
	    		  String eventKey = xmlMap.get("EventKey").toLowerCase();
	    		  if (eventKey.equals("11")) {
//						OpenId op = new OpenId();
//						op.getOpenId();
	    			  //执行统一下单接口并获得返回
//	    			  System.out.println("123");
//	    	         WXPayExample.pay(from);

						reply = "充值完成！";
					} 
	    		  else if (eventKey.equals("12")) {
						reply = "公交查询！";
					} 
	    		  else if (eventKey.equals("13")) {
//	    			UserInfo ui=new UserInfo();
//	    			JSONObject json= ui.getUserInfo(from);
//	    			String nickname=json.getString("nickname");
//	    			String province =json.getString("province");
//	    			reply="姓名"+nickname+"省"+province;
	    		  }
	    		  else {
	    			  reply="服务暂未开通";
	    		  }
	  
	    	  }
	    	  else if(eventType.equals(Weixin.VIEW)){
	    	
	    	  }
	      }
	      
	      //设置回送信息
	         message.setContent(reply);
	      //将message对象转化为xml格式
	         String xmlStr = MessageUtil.toXml(message);
	         System.out.println(xmlStr);
	      //使用writer对象发送出去
	      writer.print(xmlStr);
	      writer.flush();  
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}
	private String sxtText2() {
	    StringBuffer buffer = new StringBuffer();
	    buffer.append("开始玩遍天下:\n");
	    buffer.append("1、死了都要爱\n");
	    buffer.append("2、青鸟飞鱼\n");
	    buffer.append("3、为了你\n");
		return buffer.toString();
	}
	/**
	 * 返回信息
	 * @return
	 */
	private String sxtText() {
	    StringBuffer buffer = new StringBuffer();
	    buffer.append("线上学习大纲:\n");
	    buffer.append("1、前端\n");
	    buffer.append("2、JAVASE\n");
	    buffer.append("3、无可奈何\n");
		return buffer.toString();
	}
	private String mainMenu() {
	     StringBuffer buffer = new StringBuffer();
	     buffer.append("欢迎您的关注，请按以下说明进行操作:\n");
	     buffer.append("1、选项1");
	     buffer.append("2、选项2");
	     buffer.append("3、选项3");
	     return buffer.toString();
	}
	private String weather(String content) {
//	     content=content.replace("市","");
//	     //获取天气字符串
//	     String weatherStr=WeatherUtil.getWeather(content);
//	     //处理null
//	     if(null==weatherStr||(weatherStr=weatherStr.trim()).equals("")){
//	    	 return other(content);
//	     }
//	     return weatherStr;
		return "此功能开发中";
	}
}
