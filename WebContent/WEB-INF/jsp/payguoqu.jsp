<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>支付页面</title>
<link rel="stylesheet" href="../style/weui.css" />
</head>
<body ontouchstart>
	超仪超市支付
	<form action="payServlet" method="post">
		<input type="text" name="openid" value="${openid}">
		<div class="weui-flex js_category">
			<p class="weui-flex__item">表单</p>
			<img src="../images/icon_nav_form.png" alt="">
		</div>
		<div class="page__category js_categoryInner">

			<div class="weui-cells page__category-content">

				<a class="weui-cell weui-cell_access js_item" data-id="input"
					href="javascript:;">
					<div class="weui-cell__bd">
						<p>Input</p>
					</div>
					<div class="weui-cell__ft"></div>
				</a> <a class="weui-cell weui-cell_access js_item" data-id="button"
					href="javascript:;">
					<div class="weui-cell__bd">
						<p>Button</p>
					</div>
					<div class="weui-cell__ft"></div>
				</a> <input type="submit" name="submit" value="提交" />
			</div>
		</div>

	</form>
</body>
</html>