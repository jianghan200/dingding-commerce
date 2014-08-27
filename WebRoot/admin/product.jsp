<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="./common/header.jsp"%>


<script type="text/javascript">

		   function delete_product (product_id){
		    $.post(
		    "admin/delete-product.action",
		        {"product_id":product_id},
		        //data是接受到服务器响应回来的数据
		       
		        function(data){
		       
		          if(data){
		          	$("#dl-"+product_id).remove();
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
                  <th>ID</th>
                  <th>书名</th>
                  <th>描述</th>    
                  <th>丁丁价</th>              
                </tr>
              </thead>
              <tbody>

    <s:iterator value="products" var="product">
        

        <tr id="dl-${product.product_id}">
            <td>${product.product_id}</td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>${product.dangPrice}</td>

            <th> <div  class="btn btn-primary delete-product" href="<%=request.getContextPath() %>/admin/delete-product.action" onclick="delete_product(${product.product_id});">删除</div></th>
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
