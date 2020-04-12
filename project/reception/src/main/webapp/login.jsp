<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录 - 锐聘网</title>
    <link href="css/base.css" type="text/css" rel="stylesheet" />
    <link href="css/login.css" type="text/css" rel="stylesheet" />
    <meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
    <meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
    <script>
        function validate(){
            let email = document.getElementById("email");
            let password = document.getElementById("password");
            if(email.value === ""){
                alert("邮箱不能为空！");
                email.focus();
                return false;
            }
            if(password.value === ""){
                alert("密码不能为空！");
                password.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%
	String applicantEmail = "";
	String applicantPwd = "";
	// 从客户端读取Cookie
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if("COOKIE_APPLICANTEMAIL".equals(cookie.getName())){
				// 解密获取存储在Cookie中的求职者Email
				applicantEmail = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
			if("COOKIE_APPLICANTPWD".equals(cookie.getName())){
				// 解密获取存储在Cookie中的求职者登录密码
				applicantPwd = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
		}
	}
%>
<iframe src="top.html" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
<div class="content">
    <div class="page_name">登陆</div>
    <div class="login_content">
        <!-- 登录表单开始 -->
        <form action="./ApplicantLoginServlet" method="post" onsubmit="return validate();">
            <div class="login_l">
                <p class="font14">使用注册邮箱登录</p>
                <div class="span1">
                    <label class="tn-form-label">邮箱：</label>
                    <input  class="tn-textbox" name="email" id="email" type="text">
                </div>
                <div class="span1">
                    <label class="tn-form-label">密码：</label>
                    <input class="tn-textbox" name="password" id="password"  type="password">
                </div>
                <div class="tn-form-row-button">
                    <div class="span1">
                        <input name="" type="submit" class="tn-button-text" value="登   录">
                        <span class="it-register-text">
                        <input checked="checked" name="rememberMe"
                        id="rememberMe" class="tn-checkbox"
                        type="checkbox" value="true"/>
                        <label for="RememberPassword" style="color:gray">记住密码</label>
                        </span>
                    </div>
                </div>
                <input type="hidden" name="requestPath" value="${requestScope.requestPath}" >
                <div class="clear"></div>
            </div>
            <div class="login_r">
                <p align="center"> <b>还没有帐号？</b><a  href="register.html">10秒钟快速注册</a></p>

                <div><img src="images/reg_pic.jpg"></div>

                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </form>
        <!-- 登录表单结束-->
    </div>
</div>
<iframe src="foot.html" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>

</body>
</html>
