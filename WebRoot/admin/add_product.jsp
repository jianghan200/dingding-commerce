<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="./common/header.jsp"%>



<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/admin-dashboard.css" rel="stylesheet">

<body>

<%@include file="./common/nav-sidebar.jsp"%>

<div class = "container">
	<div class = "row">
	
			<form  class = "col-md-8 col-md-offset-2"  name="ctl00" method="post"  action="add-product.action">
				<h2>
					以下均为必填项
				</h2>
				
				<table class="table table-striped table-bordered table-hover" align="center" >
					<tr>
						<td valign="top" class="w1">
							<h4>书名：</h4>
						</td>
						<td>
							<input name="product.productName" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<small><h5>书名</h5></small>
									<span id="product.productName" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<h4>描述</h4>
						</td>
						<td>
							<input name="product.description" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
						   <small><h5>书的大概内容</h5></small>
								<span id="name.info" ></span>
							</div>
						</td>
					</tr>
					<tr>
						<td >
							<h4>市场价</h4>
						</td>
						<td>
							<input name="product.fixedPrice""  id="txtPassword"
								class="text_input" />
							<div id="passwordValidMsg">
									<small><h5>市场价</h5></small>
								<span id="password.info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td >
							<h4>丁丁价</h4>
						</td>
						<td>
							<input name="dangPrice"  id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<small><h5>在丁丁网的价钱</h5></small>
							<span id="dangPrice" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
	
					</tr>
				</table>
				
          
					<input class="btn-primary " name="submit"  type="submit" value="添加书本"/>

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



  </body>
</html>
