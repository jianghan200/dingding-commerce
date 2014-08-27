<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="<%=request.getContextPath()%>/res/lib/bootstrap/favicon.ico">


<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/res/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/admin-signin.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/lib/bootstrap/theme.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="<%=request.getContextPath()%>/res/lib/bootstrap/ie-emulation-modes-warning.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="<%=request.getContextPath()%>/res/lib/bootstrap/ie10-viewport-bug-workaround.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">
		<form class="form-signin" role="form" method="post" action="<%=request.getContextPath() %>/admin/user.action" >
			<h2 class="form-signin-heading">Please sign in</h2>

			<input type="email" name="name" class="form-control" placeholder="管理用户名"
				required autofocus> 
				
			<input type="password" name="password" class="form-control" placeholder="密码" required>
			
			
			<div class="checkbox">
				<label> 
					<input type="checkbox" value="remember-me">				Remember me 
				</label>
			</div>
			
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Sign  in
			</button>
		</form>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
