<%@page contentType="text/html;charset=utf-8"%>


<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/main/ding.jsp">丁丁网</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<%=request.getContextPath()%>/main/ding.jsp">首页</a>
				</li>
				<s:if test="%{#session.user!=null}">
					
				</s:if>
				<s:if test="%{#session.user==null}">
					<li><a
						href="<%=request.getContextPath()%>/user/login_form.jsp">登录</a>
					</li>
					<li><a
						href="<%=request.getContextPath()%>/user/register_form.jsp">注册</a>
					</li>
				</s:if>

			</ul>

			
				
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/cart/cartlist.action">购物车</a>
				</li>

				<s:if test="%{#session.user!=null}"> <!--  only show when user has login -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <s:property value="%{#session.user.nickname}"/> 的丁丁<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=request.getContextPath()%>/user/info.jsp">个人信息</a>

						<li><a href="<%=request.getContextPath()%>/admin/show-orderbyuser.action?User_id=${user.USER_ID}">我的订单</a>
				        </li>
						<li class="divider"></li>
				        <li><a href="<%=request.getContextPath()%>/main/index.jsp">帮助中心</a>
				        </li>

						<li><a href="<%=request.getContextPath()%>/user/exit.action">登出</a>
				        </li>
	
					</ul>
				</li>
				</s:if>
			</ul>
			

		</div>
		<!--/.nav-collapse -->
	</div>
</div>






