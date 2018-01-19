<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>用Java SpringMvc开发的一个项目管理系统</title>
  <meta name="description" content="项目管理、系统、Java、SpringMvc">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${contextPath}/resources/css/amazeui.min.css" />
  <link rel="stylesheet" href="${contextPath}/resources/css/admin.css">
  <link rel="stylesheet" href="${contextPath}/resources/css/app.css">
</head>
<style>
.password{border-radius: 0px 0px 0px 0px !important}
</style>
<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				项目管理系统<span> 注册</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<span><a href="${contextPath}" style="color:white">登录 </a></span> | <i> 注册</i>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" onsubmit="return false">
				<fieldset>
					<div class="am-form-group">
						<input type="email" class="" id="userName" name="username" placeholder="输入电子邮件" required />
					</div>
					<div class="am-form-group">
						<input type="password" class="password" id="passWord" name="repassword" placeholder="设置个密码吧" required  minlength=6/>
					</div>
					<div class="am-form-group">
						<input type="password" class="" id="repassWord" name="repassword" placeholder="确认密码" data-equal-to="#passWord" required minlength=6 />
					</div>
					<p><button type="submit" class="am-btn am-btn-default" id="register">注册</button></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>


<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/amazeui.min.js"></script>
<script src="${contextPath}/resources/js/app.js"></script>
<script src="${contextPath}/resources/js/md5.min.js"></script>
<script src="${contextPath}/resources/layer/layer.js"></script>
<script>
	$(function(){
		$('#register').bind('click',function(){
			var userName = $('#userName').val();
			var passWord = $('#passWord').val();
			var repassWord  = $('#repassWord').val();
			var emailCode = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			
			if(emailCode.test(userName)&&passWord.length>=6&&repassWord.length>=6){
				if(passWord==repassWord){
					$.ajax({
						url:'insertUser',
						type:'post',
						dataType:'json',
						data:{'userName':userName,'passWord':md5(passWord)},
						success:function(res){
							if(res.code == 102){
								layer.alert(res.msg, {
									  icon: 1,
									  skin: 'layer-ext-moon',
									  title:'提示信息',
									  time:1000,
									  end: function () {
										  window.location.href="${contextPath}/login.jsp";
							            }
									})
							}else{
								layer.alert(res.msg, {
									  icon: 2,
									  skin: 'layer-ext-moon',
									  title:'提示信息',
									  time:1000,
									})
							}
						},
						error:function(){
							layer.alert(res.msg, {
								  icon: 2,
								  skin: 'layer-ext-moon',
								  title:'提示信息',
								  time:1000,
								})
						}
					})
				}else{
					layer.alert('两次输入的密码不一致！', {
						  icon: 2,
						  skin: 'layer-ext-moon',
						  title:'提示信息',
						  time:1000,
						})
				}
			}
		})
	})
</script>
</body>
</html>