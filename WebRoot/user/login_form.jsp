<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="../common/header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-md-5 col-md-offset-1">
			<%@include file="../common/introduce.jsp"%>
		</div>

		<div class="col-md-4">


			<form class="form-signin" role="form" action="login.action"
				id="ctl00">
				<h1 class="form-signin-heading">登录丁丁网</h1>
				<input type="email" name="name" id="txtUsername"
					class="form-control" placeholder="Email address" required autofocus>
				<input type="password" name="password" id="userpassword"
					class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
			</form>



		</div>
	</div>
</div>



<script type="text/javascript">
	//表单是否通过检测
	var flag = {
		"userEamil" : false,
		"userPassword" : false
	};
	$(function() {
		$("#txtUsername").blur(function() {
			var username = $("#txtUsername").val();
			//非空检测
			if (username == "") {
				$("#username").html("<img src='../images/wrong.gif'/>");

				flag.userEmail = false;
				return;
			} else {
				$("#username").html("");
				return;
			}
		});
	});

	$(function() {
		flag.userPassword = false;
		$("#txtPassword").blur(function() {
			var password = $("#txtPassword").val();
			if (password == "") {
				$("#userpassword").html("<img src='../images/wrong.gif'/>");
				flag.userPassword = false;
				return;

			} else {
				$("#userpassword").html("");
				flag.userPassword = true;
				return;
			}
		});
	});

	$(function() {
		$("#ctl00").submit(function() {
			var username = $("#txtUsername").val();
			var password = $("#txtPassword").val();
			//检测表单是否都通过检查
			if (username == "" || password == "") {
				alert("请检测表单");
				return false;

			} else {
				return true;

			}
		});
	});
</script>
<%@include file="../common/footer.jsp"%>
