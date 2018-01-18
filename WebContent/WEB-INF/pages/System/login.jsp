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
  <link rel="stylesheet" href="resources/css/amazeui.min.css" />
  <link rel="stylesheet" href="resources/css/admin.css">
  <link rel="stylesheet" href="resources/css/app.css">
</head>
<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				项目管理系统<span> 登录</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i>登录 </i> | <span> <a href="user/register" style="color:white">注册</a></span>
		</div>
		<div class="am-u-sm-10 login-am-center" >
			<form class="am-form" onsubmit="return false">
				<fieldset>
					<div class="am-form-group">
						<input type="email" class="" id="userName" placeholder="输入电子邮件" required />
					</div>
					<div class="am-form-group">
						<input type="password" class="" id="passWord" placeholder="输入密码" required minlength=6/>
					</div>
					<p><button type="submit" class="am-btn am-btn-default" id="login">登录</button></p>
				</fieldset>
			</form>
		</div>
		<div style="width:70%;margin:auto;margin-top:-40px;height:40px;line-height:40px;">
			 <label class="am-checkbox" style="float:left">
			      <input type="checkbox" checked="checked" id="autoLogin" >
			      <span style="color:white">自动登录</span>
			 </label>
			 <label class="am-checkbox" style="float:right;margin-top:10px;">
			      <a style="color:white;" href="">忘记密码？</a>
			 </label>
		</div>
	</div>
</div>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/amazeui.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/jquery.min.js"></script> 
<script src="resources/js/amazeui.min.js"></script> 
<script src="resources/js/amazeui.dialog.min.js"></script> 
<script src="resources/js/md5.min.js"></script>
<script src="resources/layer/layer.js"></script>
<script>
	$(function(){
		$('#login').bind('click',function(){
			var userName = $('#userName').val().trim();
			var passWord = $('#passWord').val().trim();
			var emailCode = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			var cheackBox = $('#autoLogin').is(':checked');
			if(emailCode.test(userName) && passWord.length >= 6){
				$.ajax({
					url:'user/login',
					dataType:'json',
					type:'post',
					data:{'userName':userName,'passWord':md5(passWord),'cheackBox':cheackBox},
					success:function(res){
						if(res.code==103){
							layer.alert(res.msg, {
								  icon: 1,
								  skin: 'layer-ext-moon',
								  title:'提示信息',
								  time:1000,
								  end: function () {
									  window.location.href="index";
						            }
								})
						}else{
							layer.alert(res.msg,{
								icon:2,
								skin: 'layer-ext-moon',
								title:'提示信息',
								time:2000
							})
						}
					},
					error:function(){
						layer.alert(res.msg,{
							icon:2,
							skin: 'layer-ext-moon',
							title:'提示信息',
							time:2000
						}) 
					}
				});
			}
		});
	});
</script>
</body>
</html>
