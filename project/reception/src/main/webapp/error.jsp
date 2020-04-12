<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
// 获得请求的绝对地址
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+
					":"+request.getServerPort()+path+"/";%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>锐聘网</title>
<base href="<%=basePath%>">
<link href="css/base.css" type="text/css" rel="stylesheet"/>
<link href="css/error.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<jsp:include page="top.html"></jsp:include>
	<div class="success_content">
		<div class="success_left">
			<div class="error"><img alt="" src="images/error.gif"></div>
			<h2 align="center">出错了！</h2>
		</div>
		<div class="success_right">
			<p class="green16"><%=exception%></p>
			<p class="green16"><%=exception%></p>
			<a href="javascript:window.history.go(-1);">
				<span class="tn-button">返回上一步</span>
				<a href="index.jsp"><span class="tn-button">返回首页</span></a>
			</a>
		</div>
	</div>
	<jsp:include page="foot.html"></jsp:include>
</body>
</html>