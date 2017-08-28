<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款操作</title>
</head>

<body onload="javascript:pay();" >


</body>


<script type="text/javascript">

function pay(){

if (typeof WeixinJSBridge == "undefined"){
   if( document.addEventListener ){
       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
   }else if (document.attachEvent){
       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
   }
}else{
   onBridgeReady();
} 
}


function onBridgeReady(){

    WeixinJSBridge.invoke(
        'getBrandWCPayRequest', {
      
            "appId":"${appid}",     //公众号名称，由商户传入      
            "timeStamp":"${timeStamp}",         //时间戳，自1970年以来的秒数      
            "nonceStr":"${nonce_str}", //随机串      
            "package":"prepay_id="+"${prepay_id}",      
            "signType":"MD5",         //微信签名方式：     
             "paySign":"${paySign}"//微信签名

        },
        function(res){  
             var msg="";
            if(res.err_msg == "get_brand_wcpay_request:ok" ) {

            	msg="success"
            
            }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
            if(res.err_msg == "get_brand_wcpay_request:cancel" ) {

            	msg="canner"
            	
            } 
            if(res.err_msg == "get_brand_wcpay_request:fail" ) {

            	msg="fail";
            } 
//             self.location="http://pay.qingcailuobo.cn/wbweixin/return?msg="+msg;
        	window.close();
        }
    ); 
 }

 </script>
</html>