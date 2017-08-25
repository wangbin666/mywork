package com.joymeter.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joymeter.menu.service.MenuManager;

public class XmlUtil {
	/**
	 * xml解析成map
	 * @param is
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

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
    
	public static String MapToXML(Map map) {  
        log.info("将Map转成Xml, Map：" + map.toString());  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        mapToXMLTest2(map, sb);  
        sb.append("</xml>");  
        log.info("将Map转成Xml, Xml：" + sb.toString());  
        try {  
            return sb.toString(); 
        } catch (Exception e) {  
            log.error(e.toString());  
        }  
        return null;  
    }  
  
    private static void mapToXMLTest2(Map map, StringBuffer sb) {  
        Set set = map.keySet();  
        for (Iterator it = set.iterator(); it.hasNext();) {  
            String key = (String) it.next();  
            Object value = map.get(key);  
            if (null == value)  
                value = "";  
            if (value.getClass().getName().equals("java.util.ArrayList")) {  
                ArrayList list = (ArrayList) map.get(key);  
                sb.append("<" + key + ">");  
                for (int i = 0; i < list.size(); i++) {  
                    HashMap hm = (HashMap) list.get(i);  
                    mapToXMLTest2(hm, sb);  
                }  
                sb.append("</" + key + ">");  
  
            } else {  
                if (value instanceof HashMap) {  
                    sb.append("<" + key + ">");  
                    mapToXMLTest2((HashMap) value, sb);  
                    sb.append("</" + key + ">");  
                } else {  
                    sb.append("<" + key + ">" + value + "</" + key + ">");  
                }  
  
            }  
  
        }  
    }  

	
}
