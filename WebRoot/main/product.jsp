<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="../common/header.jsp"%>
 <div class="container">
 
 <div class="row">
 	<div class="col-md-4">
	    <h1>${book.productName }</h1>
			  <div>
			      <div>
					<A
						href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')"
						name="bigpicture_bk"><IMG id="img_show_prd"
						src="<%=request.getContextPath() %>/res/img/product/${book.productPic }"
						style="width:300px;height:400px;"></IMG></A>
				 </div>
		          <INPUT id="hid_largepictureurl" type=hidden></INPUT>
	           </div>
	</div>
  
   <div class="col-md-4">
   

			 <H2>内容简介 </H2>
			 <h3>${book.description }</h3>
			  <H2>作者简介 </H2>
			<h3>${book.author}${book.authorSummary }</h3>
				<H2 >目录</H2>
				<h3>${book.catalogue }</h3>
				<H2>媒体评论 </H2>
				<h3>好，非常畅销!难得的一本好书,是非常值得一看的书！</h3>
							
 		<div >
		   <h2>所属分类：</h2> <A class="blue12a"
			href="http://product.dangdang.com/category.ashx?code=01.00.00.00.00.00"
			target=_blank>图书</A> &gt;&gt; 
			<A 
			href="http://product.dangdang.com/category.ashx?code=01.30.00.00.00.00"
			>社会科学</A> &gt;&gt; 
			<A href="http://product.dangdang.com/category.ashx?code=01.30.07.00.00.00" >教育</A> &gt;&gt; 
			<A href="http://product.dangdang.com/category.ashx?code=01.30.07.04.00.00"
			>各级教育</A>
	      </div>
		 
  </div>
   <div class="col-md-4">
   
			<h2>作 者： ${book.author }</h2>
		    <h2>出 版 社： ${book.publishing }</h2>
			<h2> 出版信息：</h2>
			<li>出版时间： ${book.publishTime}</li>
			<li>字 数： ${book.wordNumber }</li>
			<li>版 次： ${book.whichEditon }</li>
			<li>页 数： ${book.totalPage }</li>
			<li>印刷时间： ${book.printTime }</li>
			<li>开 本： 16开</li>
			<li>印 次： ${book.printNumner }</li>
			<li>纸 张： 胶版纸 </li>
			<li>I S B N ： ${book.isbn }</li>
			<li>包 装： 平装</li>
			 <!-- info of products -->
 			<h5>定价：<SPAN id="originalPriceTag">￥${book.fixedPrice }</h5>
		   <h5>丁丁价：￥<B>${book.dangPrice }</B></h5>
		   <h5> 节省：￥${book.fixedPrice-book.dangPrice }</h5>
		 
			<div id="cartinfo${book.product_id}"></div>
			<button id="book" onclick="buy(${book.product_id});" class="btn btn-success">购买</button>
			
	
	 </div> <!-- product --> 
</div>  <!-- row -->
</div>  <!-- container -->



<%@include file="../common/footer.jsp"%>

	<script type="text/javascript">
		function buy(id) {
			
			$.post("../cart/buy.action", {
				"pid" : id
			}, function(data) {

					alert("Merry!");
					if (data) {
						alert(data);
						$("#cartinfo" + id).html("<h3>商品放入了购物车</h3>");
					} else {
					alert("哭了");
					$("#cartinfo" + id).html("<h3> 您已经购买过了</h3>");
					}
				}
			);

		};
	</script>

</BODY>
</HTML>
