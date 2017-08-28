<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>交易取消</title>
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
<script type="text/javascript">
  close();
		function close() {
			alert(3);
			var ctime=3;
			windows.setTimeout('close()',1000);
			if(ctime<0){
				window.close();
			}
			else{
				document.getElementById("time").innerHTM="此页面将在"+time+"秒后关闭";
			}
		}
		function closei() {
			alert(1);
			window.close();
		}
</script>
    
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
				<a href="javascript:closei();" id="closeButton"
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