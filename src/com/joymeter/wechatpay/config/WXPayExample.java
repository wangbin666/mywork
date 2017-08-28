package com.joymeter.wechatpay.config;

import java.util.HashMap;
import java.util.Map;

import com.github.wxpay.sdk.WXPay;

public class WXPayExample {
    /**
     * 统一下单
     * @param openid
     * @param money
     * @return
     * @throws Exception
     */
    public static Map<String, String> pay(String openid,String money) throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        long m=System.currentTimeMillis();
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "joy充值");
        String trade_no=""+20170810+m;
        data.put("out_trade_no", trade_no);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", money);
        data.put("spbill_create_ip", "115.196.222.240");
        data.put("notify_url", "http://pay.qingcailuobo.cn/wbweixin/notify");
        data.put("trade_type", "JSAPI");  // 此处指定为公共号支付
//        NATIVE JSAPI
        data.put("product_id", "12");
        

        data.put("openid", openid);
        Map<String, String> resp =null;
        try {
             resp= wxpay.unifiedOrder(data);
//            String code_url=resp.get("code_url");
//            HttpUtil.httpRequest("http://db1e00d1.ngrok.io/wb_weixin/weixinpay.jsp?codeurl="+code_url, "GET");
            System.out.println(resp);
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}