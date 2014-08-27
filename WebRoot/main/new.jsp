<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<p>
<h3>最新图书</h3>
</p>
<div class="row">
	<s:iterator value="pros">
		<div class="col-4 col-sm-4 col-lg-3 book-grid">

			<a href='product.action?id=${product_id}'>
				<img class="img-rounded"
					src="<%=request.getContextPath() %>/res/img/product/${productPic}"
					width=100 height=140/ alt="${productName}">
			</a>

			<div class="caption text-left">
				<h3>
					<a href='product.action?id=${product_id}'> ${productName}</a>
				</h3>
				<p><h4>定价：<del>￥${fixedPrice}</del> </h4></p>
				<p><h4>丁丁价：￥${dangPrice}</h4></p>
			</div>

		</div>
	</s:iterator>

</div>