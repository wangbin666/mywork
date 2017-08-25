package com.joymeter.message.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.xstream.XStream;




public class MessageUtil {
@Autowired
private Message message;
public  static Map<String,String> toMap(InputStream is) throws DocumentException, IOException{
		//获取saxreader
		SAXReader reader = new SAXReader();
		//获取文档
		Document doc = reader.read(is);
		//获取根元素
		Element root = doc.getRootElement();
		//获取其他元素
		@SuppressWarnings("unchecked")
		List<Element> elements = root.elements();
		Map<String,String> map = new HashMap<String,String>();
		for(Element e:elements){
			map.put(e.getName(),e.getText());
		}
		is.close();
		return map;
	}

public static Message toMessage(Map<String,String> map){
	Message message=new Message();
	//注意都是首字母大写
	message.setMsgType(map.get("MsgType"));
	message.setFromUserName(map.get("FromUserName"));
	message.setToUserName(map.get("ToUserName"));
	message.setContent(map.get("Content"));
	message.setCreateTime(Integer.valueOf(map.get("CreateTime")));
	message.setMsgId(map.get("MsgId"));
	
	return message;
}
/**
 * 将返回消息封装成xml
 * 方法1
 * @param message
 * @return
 */
public static String toXml(Message message) {
	StringBuffer sb = new StringBuffer();
	Date date = new Date();
	sb.append("<xml><ToUserName><![CDATA[");
	sb.append(message.getToUserName());
	sb.append("]]></ToUserName><FromUserName><![CDATA[");
	sb.append(message.getFromUserName());
	sb.append("]]></FromUserName><CreateTime>");
	sb.append(date.getTime());
	sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
	sb.append(message.getContent());
	sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");
	return sb.toString();
}
/**
 * 将放回消息封装成xml
 *方法2
 * @param message
 * @return
 */
public static String toXml2(Message message) {
	//实例化XStream
	XStream stream = new XStream();
	//使用别名 作为根元素，否则根元素为包名:类名 即替换根元素名称
	//<xml>
	//<ToUserName></ToUserName>
	//<xml>
	stream.alias("xml",message.getClass());
	System.out.println(stream.toXML(message));
	return stream.toXML(message);

}
}
