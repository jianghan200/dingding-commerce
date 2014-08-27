<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="./common/header.jsp"%>



<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/admin-dashboard.css" rel="stylesheet">

<body>

<%@include file="./common/nav-sidebar.jsp"%>

<div class = "container">
	<div class = "row">
	
			<form  class = "col-md-8 col-md-offset-2"  name="ctl00" method="post"  action="add-user.action">
				<h2>
					以下均为必填项
				</h2>
				
				<table class="table table-striped table-bordered table-hover" align="center" >
					<tr>
						<td valign="top" class="w1">
							<h4>邮箱/手机号码：</h4>
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<small><h5>邮箱/手机号码为用户名，并用于找回密码等服务</h5></small>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<h4>用户昵称：</h4>
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
						   <small><h5>您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符</h5></small>
								<span id="name.info" ></span>
							</div>
						</td>
					</tr>
					<tr>
						<td >
							<h4>设置密码：</h4>
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
							<div id="passwordValidMsg">
									<small><h5>密码由大小写英文字母、数字组成，长度6－20位。</h5></small>
								<span id="password.info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td >
							<h4>确认密码：</h4>
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<small><h5>请再次输入密码</h5></small>
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
	
					</tr>
				</table>
				
          
					<input class="btn-primary " name="submit"  type="submit" value="添加用户"/>

			</form>
		</div>


</div>


		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=request.getContextPath() %>/res/lib/jquery/jQuery.js"></script>
		<script
			src="<%=request.getContextPath() %>/res/lib/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="<%=request.getContextPath() %>/res/lib/bootstrap/docs.min.js"></script>


		<script type="text/javascript" src="<%=request.getContextPath() %>/res/js/add_user.js"></script>

  </body>
</html>
