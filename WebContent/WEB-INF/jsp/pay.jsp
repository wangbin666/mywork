<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>支付页面</title>
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

<body>

	<br>
	<br>
	<br>
	<header class='demos-header'>
		<h1 class="demos-title">超仪超市</h1>
	</header>

    <div class="weui-cells weui-cells_form">
<form action="payServlet" method="post" id="pay">
		<input type="hidden" name="openid" value="${openid}">
	<div class="weui-cell">
		<div class="weui-cell__hd">
			<label class="weui-label"><font color="green">请支付</font></label>
		</div>
		<div class="weui-cell__bd">
			<input class="weui-input" type="tel" id="money" name="money" placeholder="请输入金额">
		</div>
	</div>
</form>
	<div class="weui-btn-area">
		<a class="weui-btn weui-btn_primary" href="javascript:"
			id="showTooltips">确定</a>
	</div>
</div>
	<script src="liba/jquery-2.1.4.js"></script>
	<script src="liba/fastclick.js"></script>
	<script>
		$(function() {
			FastClick.attach(document.body);
		});
	</script>
	<script src="js/jquery-weui.js"></script>
	<script>
		$("#showTooltips").click(function() {
			var money = $('#money').val();
			if (!/^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/.test(money)) {
				$.toptip('请输入正确金额');
			} else {
				$.toptip('提交成功', 'success');
				$("#pay").submit();
			}
		});
	</script>
</body>
</html>
