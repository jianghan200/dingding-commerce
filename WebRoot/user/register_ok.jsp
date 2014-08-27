<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%@include file="../common/header.jsp" %>

		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/images/login_success.jpg" />
				</div>
				<h5>
					${user.nickname}，欢迎加入丁丁网
				</h5>
				<h6>
					请牢记您的登录邮件地址：${user.email}
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="#">我的丁丁</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="../main/main.jsp">浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>
		
<%@include file="../common/footer.jsp" %>

