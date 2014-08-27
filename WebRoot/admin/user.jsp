<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="./common/header.jsp"%>


<script type="text/javascript">

		   function delete_user (id){
		    $.post(
		        "user/delete-user.action",
		        {"user_id":id},
		        //data是接受到服务器响应回来的数据
		        function(data){
		        
		          if(data){
		          	$("#dl-"+id).remove();
		          }else{
		            alert("Haha 2!");
		          }
		        }
		      );
		    }
 </script>
 
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/admin-dashboard.css" rel="stylesheet">

<body>

<%@include file="./common/nav-sidebar.jsp"%>


        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">后台管理</h1>

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>用户ID</th>
                  <th>用户名</th>
                  <th>邮箱</th>
                  <th>Header</th>
                  <th>Header</th>                
                </tr>
              </thead>
              <tbody>

    <s:iterator value="users" var="user">
        

        <tr id="dl-${user.USER_ID}">
            <td>${user.USER_ID}</td>
            <td>${user.nickname}</td>
            <td>${user.email}</td>
            <td>${user.lastLoginTime}</td>
            <td>${user.lastLoginIp}</td>
            <th> <div  class="btn btn-primary delete-user" href="<%=request.getContextPath() %>/admin/delete-user.action" onclick="delete_user(${user.USER_ID});">删除</div></th>
        </tr>

    </s:iterator>

              </tbody>
            </table>
          </div>
        </div>
 
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/res/lib/jquery/jQuery.js"></script>
    <script src="<%=request.getContextPath() %>/res/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/res/lib/bootstrap/docs.min.js"></script>
  </body>
</html>
