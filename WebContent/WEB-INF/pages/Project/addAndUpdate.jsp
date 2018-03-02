<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>项目列表</title>
    <meta name="description" content="项目、列表、管理、进度">
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
                        <span class="am-icon-code"></span> 项目添加
                    </div>
                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">项目名称</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="title" placeholder="项目名称" required />
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">项目负责人</label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{btnWidth: '100%', btnSize: 'sm'}" id="principalID" required>
										  
										</select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">项目组成员</label>
                                    <div class="am-u-sm-9">
                                        <select multiple data-am-selected="{btnWidth: '100%', btnSize: 'sm'}" id="memberID" required>
										 
										</select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">项目开始时间</label>
                                    <div class="am-u-sm-9">
                                       <input type="text" class="am-form-field" placeholder="项目开始时间" id="startTime" data-am-datepicker  required />
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">项目结束时间</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="am-form-field" placeholder="项目结束时间" id="endTime" data-am-datepicker required />
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">项目简介</label>
                                    <div class="am-u-sm-9">
                                        <textarea class="" rows="5"  placeholder="输入项目简介" id="description" required ></textarea>
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
 		//加载成员信息
 		$.post("${contextPath}/user/getAllUser","",function(res){
 			var data=res.data;
 			if(data){
 				for(var i=0;i<data.length;i++){
 					document.getElementById("principalID").innerHTML +=' <option value="'+data[i].userID+'">'+data[i].name+'</option>';
 				}
 				for(var i=0;i<data.length;i++){
 					document.getElementById("memberID").innerHTML +=' <option value="'+data[i].userID+'">'+data[i].name+'</option>';
 				}
 			}
 		},"json");
 		
 		//新增项目按钮绑定
 		$('#saveData').bind('click',function(){
 			var title = $('#title').val();
 			var principalID = $('#principalID').val();
 			var memberID = $('#memberID').val();
 			var startTime = $('#startTime').val();
 			var endTime = $('#endTime').val();
 			var description = $('#description').val();
 			if(title!='' && principalID!='' && memberID!='' && startTime!='' && endTime!='' && description!=''){
 				$.post("${contextPath}/project/insertProject",{'title':title},function(res){
 					alert(res.msg);
 				},"json");
 			}
 		})
 	})
 	</script>
</body>

</html>