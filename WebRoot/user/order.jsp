<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%@include file="../common/header.jsp" %>

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

 <div class="container-fluid">
	<div class="row">
	
		<div class="col-sm-3 col-md-2">
			
			<div>
				<img src="<%=request.getContextPath() %>/res/img/head.jpg
				" alt="..." class="img-rounded">
			</div>

			<h2>欢迎你${user.nickname}</h2>

		</div>  <!-- col-3 -->

		<div class="col-sm-9 col-md-10 main">
          <h1 class="page-header">订单管理</h1>

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
 
	</div>  <!-- row -->

</div>  <!-- container -->

       
<%@include file="../common/footer.jsp" %>
