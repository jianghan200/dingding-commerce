<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="../common/header.jsp"%>


<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/res/css/main-page.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/res/css/sidebar.css"
	rel="stylesheet">

<div class="container">

	<div class="row row-offcanvas row-offcanvas-right">


		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<h2>Hello!</h2>
		</div>
		<!--/span-->


<div class="col-xs-12 col-sm-9">
	<p class="pull-left visible-xs">
		<button type="button" class="btn btn-primary btn-xs"
			data-toggle="offcanvas">Toggle nav</button>
	</p>


<div class="row" >
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">


  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox" align="center">
    <div class="item active">
      <a href="product.action?id=2"><img src="<%=request.getContextPath() %>/res/img/ding1.jpg" alt=" "></a>
      <div class="carousel-caption">

      </div>
    </div>
    <div class="item">
      <a href="product.action?id=3"><img src="<%=request.getContextPath() %>/res/img/ding2.jpg" alt=" "></a>
      <div class="carousel-caption">

      </div>
    </div>
    <div class="item">
      <a href="product.action?id=4"><img src="<%=request.getContextPath() %>/res/img/ding3.jpg" alt=" "></a>
      <div class="carousel-caption">

      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</div> <!--  row for carousel -->

			<div class="row" id="recommend">
				<h2>Recommend!</h2>
			</div>

			<!--热销图书开始-->
			<div id="hot"></div>
			<!--热销图书结束-->
			<hr/>
			<!--最新上架图书开始-->
			<div id="new">
				<s:action name="new" namespace="/main" executeResult="true">
				</s:action>
			</div>
			<!--最新上架图书结束-->
			<hr/>
			
		</div>
		<!--/.container-->




    <footer>

      <center>
         <div >

              Copyright &copy; 丁丁网 2014, All Rights Reserved
         </div>
         <div>
             <a href="#" target="_blank"> 
              <img src="<%=request.getContextPath() %>/res/img/validate.gif"/> 
             </a>
             <p>
              <a href="" target="#">京ICP证041189号</a>
             </p>
         </div>
       </center>

    </footer>



		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=request.getContextPath() %>/res/lib/jquery/jQuery.js"></script>
		<script
			src="<%=request.getContextPath() %>/res/lib/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="<%=request.getContextPath() %>/res/lib/bootstrap/docs.min.js"></script>


		<script type="text/javascript">
			$(function() {
				//异步方式加载左侧类别信息
				$("#sidebar").load("main/category.action");
			});
			$(function() {
				//异步方式加载左侧类别信息
				$("#recommend").load("main/recommend.action");
			});
			$(function() {
				//异步方式加载热销类别信息
				$("#hot").load("main/hot.action");
			});

			function cat_show(cat_id){

				$("#category-"+cat_id).toggle(400);

			}

		</script>

		</body>
		</html>