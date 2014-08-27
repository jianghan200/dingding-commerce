<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="../common/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-xs-6 col-sm-3 list-unstyled" id="sidebar">
			<s:iterator value="cats">
				<li>
					<h2><a href="booklist.action?cid=${cat_id}&pid=${parentId} ">${name }&nbsp;(${pnum })</a>
					</h2>
				</li>
			</s:iterator>
		</div>
		<!--/span-->
		<div class="col-xs-12 col-sm-9">

			<div class="row">
				<div class="col-12 pager">
					<!--分页导航开始-->
					<s:if test="page>1">
						  <li ><a href="booklist.action?cid=${cid }&pid=${pid }&page=${page-1}">上一页</a></li>
					</s:if>
					<s:else>
						<!-- 什么都不显示 -->
					</s:else>

					第${page}页/共${maxPage}页
					<s:if test="page<maxPage">
						<li ><a href="booklist.action?cid=${cid }&pid=${pid }&page=${page+1}">下一页</a></li>
					</s:if>
					<s:else>
						<!-- 什么都不显示 -->
					</s:else>
					<!--分页导航结束-->
				</div>
			</div>

			<s:iterator value="pros">
				<div class="row">
					<div class="col-md-3">
						<a href='product.action?id=${product_id}' class="thumbnail">
							<img src="../productImages/${productPic }" width="180" height="256" />
						</a>
					</div>
					<div class="col-md-9">
							<h2>
								<a href='product.action?id=${product_id}'>${productName}</a>
							</h2>
							<h4>顾客评分：100
								作 者: <a href='#'>${author}</a>
								出版社： <a href='#'>${publishing}</a>
								出版时间：<s:date name="publishTime" format="yyyy年MM月dd日" />
							</h4>
							<h5>${description}</h5>
							<h6>
								<p>定价：<del>￥${fixedPrice}</del></p>
								<p>丁丁价：￥${dangPrice}</p>
								<p>节省：￥${fixedPrice-dangPrice }</p>
							</h6>
							<button id="book"
								onclick="buy(${product_id});" class="btn btn-success">购买</button>
							<span id="cartinfo${product_id}"></span>

					</div><!-- col-md-9 -->
				</div> <!-- row -->
				</s:iterator>

			</div>
		</div>
	</div>
</div>  <!-- container -->

	<script type="text/javascript">
		function buy(id) {
			$.post("../cart/buy.action", {
				"pid" : id
			}, function(data) {
				if (data) {
					$("#cartinfo" + id).html(
							"<img src='../images/right.gif'/>商品放入了购物车");
				} else {
					$("#cartinfo" + id).html(
							"<img src='../images/wrong.gif'/> 您已经购买过了");
				}
			}

			);

		};
	</script>

	<%@include file="../common/footer.jsp"%>