<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="./common/header.jsp"%>


<script type="text/javascript">

		   function delete_order (order_id){
		    $.post(
		    "admin/delete-order.action",
		        {"order_id":order_id},
		        //data是接受到服务器响应回来的数据
		       
		        function(data){
		          if(data){
		          	$("#dl-"+order_id).remove();
		          }else{
		            alert("Haha 3!");
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
                  <th>订单号</th>
                  <th>总价钱</th>
                  <th>接收姓名</th>    
                  <th>接收地址</th>
                  <th>电话号码</th>                
                </tr>
              </thead>
              <tbody>

    <s:iterator value="orders" var="order">
        

        <tr id="dl-${order.order_id}">
            <td>${order.order_id}</td>
            <td>${order.total_price}</td>
            <td>${order.receive_name}</td>
            <td>${order.full_address}</td>
            <td>${order.mobile}</td>
            <th> <div  class="btn btn-primary delete-order" href="<%=request.getContextPath() %>/admin/delete-order.action" onclick="delete_order(${order.order_id});">删除</div></th>
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
