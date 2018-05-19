<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户列表</title>
    <meta name="description" content="用户、列表、管理、权限">
    <meta name="keywords" content="project,manager,prossce">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${contextPath}/resources/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${contextPath}/resources/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${contextPath}/resources/css/amazeui.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/admin.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/app.css">
</head>

<body data-type="generalComponents">
        <div class="tpl-content-wrapper">
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 用户添加
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">

                        <div class="am-u-sm-5 am-u-md-9">
                            <form class="am-form am-form-horizontal" onsubmit="return false">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">姓名</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="name" placeholder="姓名" required />
                                        <input type="hidden" id="id" />
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">用户名</label>
                                    <div class="am-u-sm-9">
                                        <input type="email" id="username" placeholder="用户名" required />
                                    </div>
                                </div> 
                               <div class="am-form-group">
								  <label for="user-email" class="am-u-sm-3 am-form-label">性别</label>
								  <div class="am-u-sm-9">
								  <label class="am-radio-inline">
								    <input type="radio" name="sex" value="0" data-am-ucheck> 男
								  </label>
								  <label class="am-radio-inline">
								    <input type="radio" name="sex" value="1" data-am-ucheck> 女
								  </label>
								  <label class="am-radio-inline">
								    <input type="radio" name="sex" value="2" data-am-ucheck> 保密
								  </label>
								  </div>
								</div>

                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">年龄</label>
                                    <div class="am-u-sm-9">
                                       <input type="number" class="am-form-field" placeholder="年龄" id="age"  required />
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">职位</label>
                                    <div class="am-u-sm-9">
                                        <select  id="positionID" >
										  
										</select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">联系方式</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="am-form-field"  minlength="11" placeholder="联系方式" id="phone" required />
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="submit" class="am-btn am-btn-primary" id="saveData">保存修改</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/amazeui.min.js"></script>
<script src="${contextPath}/resources/js/app.js"></script>
<script src="${contextPath}/resources/layer/layer.js"></script>
 	<script>
 	$(function(){
 		
 		getAllPosition();
 		
 		getPositionInfo();
 		
 		//新增项目按钮绑定
 		$('#saveData').bind('click',function(){
 			var id = $('#id').val();
 			
 			var name = $('#name').val();
 			var username = $('#username').val();
 			var sex = $('#sex').val();
 			
 			var age = $('#age').val();
 			var positionID = $('#positionID').val();
 			var phone = $('#phone').val();
 			
 			if(name!='' && username!='' && sex!='' && age!='' && positionID!='' && phone!=''){
 				$.ajax({
 					url:'${contextPath}/admins/addAdmins',
 					type:'post',
 					dataType:'json',
 					data:{'id':id,'name':name,'username':username,'sex':sex,'age':age,'positionID':positionID,'phone':phone},
	 				success:function(res){
	 					if(res.code=="103"){
	 						layer.alert(res.msg, {
								  icon: 1,
								  skin: 'layer-ext-moon',
								  title:'提示信息',
								  time:1000,
								})
	 					}else if (res.code=="104"){
	 						layer.alert(res.msg, {
								  icon: 1,
								  skin: 'layer-ext-moon',
								  title:'提示信息',
								  time:1000,
								})
	 					}else{
	 						layer.alert(res.msg, {
								  icon: 2,
								  skin: 'layer-ext-moon',
								  title:'提示信息',
								  time:1000,
								})
	 					}
	 				}
 				})

 			}
 		})
 	})
 	
 	//加载职位列表信息
 	function getAllPosition(){
 		$.post("${contextPath}/position/getAllPosition","",function(res){
 			var data=res.data;
 			if(data){
 				for(var i=0;i<data.length;i++){
 					document.getElementById("positionID").innerHTML +=' <option value="'+data[i].positionid+'">'+data[i].name+'</option>';
 				}
 			}
 		},"json");
 	}
 	//初始化项目信息
 	function getProjectInfo(){
		$.post("${contextPath}/project/getProjectInfoById/?id=${id}","",function(res){
			console.log(res.data);
			var data = res.data;
			if(data){
 			$('#id').val(data.id);
 			$('#title').val(data.title);
			
 			$('#principalID').val(data.principalid);
 			var arr = data.memberid.split(",");
 		
 			$('#memberID').val(arr).trigger('change');
 			
 			$('#startTime').datepicker('setValue',data.starttime);
 			$('#endTime').datepicker('setValue', data.endtime);
 			$('#description').val(data.description);
			}
		});
 	}
 	</script>
</body>

</html>