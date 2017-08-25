<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>交易取消</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

<link rel="stylesheet" href="liba/weui.min.css">
<link rel="stylesheet" href="css/jquery-weui.css">
<link rel="stylesheet" href="css/demos.css">

</head>

<body >
	<div class="weui-msg">
		<div class="weui-msg__icon-area">
			<i class="weui-icon-warn weui-icon_msg"></i>
		</div>
		<div class="weui-msg__text-area">
			<h2 class="weui-msg__title">交易取消</h2>
			<p class="weui-msg__desc">
				本次交易已经取消，请重新选择您要购买的商品<a href="javascript:void(0);">文字链接</a>
			</p>
		</div>
		<div class="weui-msg__opr-area">
			<p class="weui-btn-area">
				<a href="javascript:;" class="weui-btn weui-btn_primary">此页面将在3秒后关闭</a>
				<a href="javascript:CloseWebPage();" id="closeButton"
					class="weui-btn weui-btn_default">立即关闭</a>
			</p>
		</div>
		<div class="weui-msg__extra-area">
			<div class="weui-footer">
				<p class="weui-footer__links">
					<a href="javascript:void(0);" class="weui-footer__link">www.joymeter.cn</a>
				</p>
				<p class="weui-footer__text">Copyright © 2008-2016 weui.io</p>
			</div>
		</div>
	</div>
<script type="text/javascript">
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

	<script type="text/javascript">
		function close() {
			setTimeout(function() {
				window.close();
			}, 3000);
		}
		function closei() {
			window.close();
		}
	</script>


	<script src="liba/jquery-2.1.4.js"></script>
	<script src="liba/fastclick.js"></script>
	<script src="liba/1.7.2.min.js"></script>
	<script>
		$(function() {
			FastClick.attach(document.body);
		});
	</script>
</body>

</html>