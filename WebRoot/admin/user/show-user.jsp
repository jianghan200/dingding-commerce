<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="../common/header.jsp"%>


<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/admin-dashboard.css" rel="stylesheet">

<body>

<%@include file="../common/nav-sidebar.jsp"%>


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
        

        <tr>
            <td>${user.USER_ID}</td>
            <td>${user.nickname}</td>
            <td>${user.email}</td>
            <td>${user.lastLoginTime}</td>
            <td>${user.lastLoginIp}</td>
            <th> <a class="btn btn-primary" href="<%=request.getContextPath() %>/admin/delete-user.action?user_id=${user.USER_ID}">删除</a></th>
        </tr>

    </s:iterator>

              </tbody>
            </table>
          </div>
        </div>
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
