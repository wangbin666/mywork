<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- <script src="liba/1.7.2.min.js"></script> -->
<body onload="javascript:close()">
<a href="javascript:CloseWebPage()">123</a>

<script type="text/javascript">
function close(){
	window.opener=null;
	setTimeout("self.close()",5000);
}
function CloseWebPage(){

	 if (navigator.userAgent.indexOf("MSIE") > 0) {

	  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {

	   window.opener = null;

	   window.close();

	  } else {

	   window.open('', '_top');

	   window.top.close();

	  }

	 }

	 else if (navigator.userAgent.indexOf("Firefox") > 0) {

	  window.location.href = 'about:blank ';

	 } else {

	  window.opener = null;

	  window.open('', '_self', '');

	  window.close();

	 }

	}
</script>
</body>
</html>