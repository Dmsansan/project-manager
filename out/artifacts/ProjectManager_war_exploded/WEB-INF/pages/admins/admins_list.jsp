<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户列表</title>
    <meta name="description" content="用户、列表、管理、会员">
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


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="${contextPath}/resources/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                            <span class="tpl-dropdown-list-fr">3小时前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                            <span class="tpl-dropdown-list-fr">15分钟前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                            <span class="tpl-dropdown-list-fr">2天前</span>
                        </li>
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-comment-o"></span> 消息 <span class="am-badge tpl-badge-danger am-round">9</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                        <li>
                            <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="${contextPath}/resources/img/user02.png" alt=""> </span>
                                <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> 禁言小张 </span>
                                <span class="tpl-dropdown-content-time">10分钟前 </span>
                                </span>
                                <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                            </a>
                            <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="${contextPath}/resources/img/user03.png" alt=""> </span>
                                <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> Steam </span>
                                <span class="tpl-dropdown-content-time">18分钟前</span>
                                </span>
                                <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-calendar"></span> 进度 <span class="am-badge tpl-badge-primary am-round">4</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-primary">4</span> 个任务进度</h3><a href="###">全部</a></li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">Amaze UI 用户中心 v1.2 </span>
                                <span class="percent">45%</span>
                                </span>
                                <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">新闻内容页 </span>
                                <span class="percent">30%</span>
                                </span>
                                <span class="progress">
                       <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-secondary" style="width:30%"></div></div>
                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">管理中心 </span>
                                <span class="percent">60%</span>
                                </span>
                                <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-warning" style="width:60%"></div></div>
                    </span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> <img src="${contextPath}/resources/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                        <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>







    <div class="tpl-page-container tpl-page-header-fixed">


         <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                	Project Manager列表
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="${contextPath}/index" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-home"></i>
                            <span>首页</span>
                        </a>
                    </li>
                    <li class="tpl-left-nav-item">
                        <a href="${contextPath}/project/view" class="nav-link">
                            <i class="am-icon-bar-chart"></i>
                            <span>项目管理</span>  <i class="tpl-left-nav-content tpl-badge-danger" id="projectCount">  </i>
                        </a>
                    </li>
					
					<li class="tpl-left-nav-item">
                        <a href="#" class="nav-link  active">
                            <i class="am-icon-users"></i>
                            <span>用户管理</span>  <i class="tpl-left-nav-content tpl-badge-danger" id="adminsCount">  </i>
                        </a>
                    </li>
                    
                    <li class="tpl-left-nav-item">
                        <a href="${contextPath}/login.jsp" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-key"></i>
                            <span>登录</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>





        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
               	用户列表
            </div>
            <ol class="am-breadcrumb">
                <li><a href="${contextPath}/index" class="am-icon-home">首页</a></li>
                <li class="am-active">用户列表</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 用户列表
                    </div>
                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success" onclick="add()"><span class="am-icon-plus"></span> 新增</button>
                                    <!-- <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button> -->
                                </div>
                            </div>
                        </div>
                        
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field">
                                <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form" onSubmit="return false">
                                <table class="am-table am-table-striped am-table-hover table-main" id="project">
                                    <thead>
                                        <tr>
                                            <th class="table-id" style="width:100px;">用户ID</th>
                                            <th class="table-title">姓名</th>
                                            <th class="table-type">用户名</th>
                                            <th class="table-type">性别</th>
                                            <th class="table-author am-hide-sm-only">年龄</th>
                                            <th class="table-author am-hide-sm-only">职位</th>
                                            <th class="table-author am-hide-sm-only">联系方式</th>
                                            <th class="table-date am-hide-sm-only">注册时间</th>
                                            <th class="table-set">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="adminsList">
                                        
                                    </tbody>
                                </table>
                                <div class="am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination" id="page">
                                           
                                        </ul>
                                    </div>
                                </div>
                                <hr>

                            </form>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>
        </div>

    </div>


    <script src="${contextPath}/resources/js/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/amazeui.min.js"></script>
    <script src="${contextPath}/resources/js/app.js"></script>
    <script src="${contextPath}/resources/layer/layer.js"></script>
  
    <script>
    var pageNum = 10;//默认每页显示的数量10条
    var page;//当前页
    
    //时间转换为年月日
    function timeToDate(time){
    	var date = new Date(time);
    	Y = date.getFullYear() + '-';
    	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    	D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
    	h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
    	m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
    	s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds()); 
    	return Y+M+D+""+h+m+s; 
    }
    
    //新增用户窗口
    function add(){
        layer.open({
            type: 2,
            title: '',
            shadeClose: true,
            shade: 0.3,
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '600px'],
            content: '${contextPath}/admins/addAndUpdateView/?userID=0',
            end: function () {
                location.reload();
            }
          });
    }
    //获取总用户数量
    function getAdminsCount(){
    	$.ajax({
    		url:'${contextPath}/admins/getCountAdmins',
    		type:'get',
    		dataType:'json',
    		success:function(data){
    			$('#adminsCount').text(data.count);	
    		}
    	})
    }
    $(document).ready(function(){
    	getAdminsCount();
    	
    	$.ajax({
    		url:"listData",
    		type:"post",
    		dataType:"json",
    		success:function(res){
    			console.log(res.data);
    			var data = res.data;
    			loadData(data);
    			//分页开始
    			var total = res.total;//总的记录数量
    			var totalPage= Math.ceil(total/pageNum);//总的页数
    			
    			var pageHtml="";
    			var prePage=res.page-1;
    			var nextPage=res.page+1;
    			for(var j=1;j<=totalPage;j++){
    				pageHtml +='<li><a href="#"  onclick="getProjectList('+j+')">'+j+'</a></li>';
    				pageHtml = pageHtml;
    			}
    			document.getElementById("page").innerHTML='<li><a href="#" onclick="getProjectList('+prePage+')">«</a></li>'+pageHtml+'<li><a href="#" onclick="getProjectList('+nextPage+')">»</a></li>';
    			
    		},
    		error:function(res){
    			layer.msg(res.msg);
    		}
    	});
    })
    //实现分页
    function getProjectList(page){
    	if(page<1){
    		layer.msg("已经是第一页了！");
    		return false;
    	}
    	$.ajax({
    		url:"list",
    		type:"post",
    		dataType:"json",
    		data:{'page':page,'pageNum':pageNum},
    		success:function(res){
    			var data = res.data;
    			loadData(data);
    		},
    		error:function(res){
    			
    		}
    	})
    }
    //加载数据
    function loadData(data){
    	$('#projectList').empty();
    	for(var i=0;i<data.length;i++){
			//用户性别
			var sex;
			switch(data[i].sex){
				case 0 : sex="男";break;
				case 1 : sex="女";break;
				case 2 : sex="保密";break;
				default: status="未知";
			}
			document.getElementById("adminsList").innerHTML += '<tr>'+
            '<td>'+data[i].userID+'</td>'+
            '<td><a href="#">'+data[i].name+'</a></td>'+
            '<td>'+data[i].userName+'</td>'+
            '<td>'+sex+'</td>'+
            '<td class="am-hide-sm-only">'+data[i].age+'</td>'+
            '<td class="am-hide-sm-only">'+data[i].position.name+'</td>'+
            '<td class="am-hide-sm-only">'+data[i].phone+'</td>'+
            '<td class="am-hide-sm-only">'+timeToDate(data[i].logStamp)+'</td>'+
            '<td>'+
                '<div class="am-btn-toolbar">'+
                    '<div class="am-btn-group am-btn-group-xs">'+
                        '<button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="update('+data[i].userID+')"><span class="am-icon-pencil-square-o"></span> 编辑</button>'+
                        '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="del('+data[i].userID+')"><span class="am-icon-trash-o"></span> 删除</button>'+
                    '</div>'+
                '</div>'+
           ' </td>'+
        '</tr>';
		}
    }
   
   //弹出编辑页面
   function update(userID){
	   layer.open({
           type: 2,
           title: '',
           shadeClose: true,
           shade: 0.3,
           maxmin: true, //开启最大化最小化按钮
           area: ['893px','620px'],
           content: '${contextPath}/admins/addAndUpdateView/?userID='+userID,
           end: function () {
               location.reload();
           }
         });
   }
   
   //删除项目
   function del(userID){
	   layer.confirm('确认删除该用户？', {
		   btn: ['确认','取消'] 
		 }, function(){
			$.post("${contextPath}/admins/delAdmins/?userID="+userID,"",function(res){
				if(res.code==1){
					layer.msg(res.msg, {icon: 1});
				}else {
                    layer.msg(res.msg, {icon: 2});
                }
			})
		 }, function(){
		 });
   }
    </script>
</body>

</html>