<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%@include file="../common/header.jsp" %>

<div class="container">
	<div class="row">
	
		<div class="col-md-2 col-md-offset-2">
			
			<div>
				<img src="<%=request.getContextPath() %>/res/img/head.jpg
				" alt="..." class="img-rounded">
			</div>
			<form role="form">
			  
				<div class="form-group">
				    <label for="exampleInputFile">File input</label>
				    <input type="file" id="exampleInputFile">
				    <p class="help-block">Example block-level help text here.</p>
			    </div>

			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>  <!-- col-3 -->

		<div class="col-md-6">


			<h3>个人信息</h3>
			<h4>昵称：${user.nickname}</h4>
			<h4>邮箱地址：${user.email}</h4>


			<h3>修改个人资料</h3>

			<form role="form" method="post" action="<%=request.getContextPath() %>/admin/modify-normal-user.action">
			  <div class="form-group">
			    <label for="newNickname">新昵称</label>
			    <input name="nickname" type="text" class="form-control" id="newNickname" placeholder="Your new nickname">

			   <div class="form-group">
			    <label for="newPassword">新密码</label>
			    <input name="password" type="password" class="form-control" id="newPassword" placeholder="New Password">
			 	</div>

			  <div class="form-group">
			    <label for="newRepeatPassword">确认新密码</label>
			    <input type="password" class="form-control" id="newRepeatPassword" placeholder="Repeat new password">
			  </div>

			  <div class="form-group">
			    <input name="user_id" type="hidden" class="form-control" id="user_id" value = "${user.USER_ID}">
			  </div>

			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>  <!-- col-3 -->

	</div>  <!-- row -->

</div>  <!-- container -->

       
<%@include file="../common/footer.jsp" %>
