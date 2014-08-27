<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 丁丁网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
		<script type="text/javascript">
		
		  var flag = {"code":false};
		 $(function(){
		   $("#validatecode").blur(function(){
		      var validatecode = $("#validatecode").val();
		      alert(validatecode);
		     if(validatecode==""){
		     flag.code = false;
		     $("#errorMsg").html("<img src='../images/wrong.gif'/>验证码不能为空");
		     return;
		     }
		   
		    $("#errorMsg").html("<img src='../images/window_loading.gif'/>正在检测");
		    $.post(
		      "/dang/user/emailCode.action",
		      {"validat":validatecode},
		      function(data){
		        if(data){
		          $("#errorMsg").html("<img src='../images/right.gif'/>验证码正确");
		          flag.code = true;
		          return;
		        }else{
		          $("#errorMsg").html("<img src='../images/wrong.gif'/>验证码不正确");
		          flag.code = false;
		          return;
		        }
		      }
		    );
		   
		   });
		  
		    
		 });
		 
		  	  //表单提交处理
		  	 
		  $(function(){
		    $("#f").submit(function(){
		      //检测表单是否都通过检查
		      if( flag.code){
		        return true;
		      }else{
		        alert("请检测表单");
		        return false;
		      }
		    });
		  
		  });
		 
		</script>
	</head>
	<body>
		<%@include file="../common/header.jsp"%>

		<div class="login_step">
			注册步骤: 1.填写信息 >
			<span class="red_bold">2.验证邮箱</span> > 3.注册成功
		</div>
		<form action="register_ok.action"  id="f" method="post" >
			<div class="validate_email">
				<h2>
					感谢您注册丁丁网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<span class="red"><span id="lblEmail">${user.email}</span>
						</span>
						<span class="t1"> 
						请登录您的邮箱收信。
					</div>
					<h4>
						第二步：输入验证码 [${emailVerifyCode}]
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input name="code" type="text" id="validatecode" class="yzm_text" />
						<input class="finsh" type="submit" value="完 成" id="Button1" />
						<span id="errorMsg" class="no_right"></span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/footer.jsp"%>
	</body>
</html>

