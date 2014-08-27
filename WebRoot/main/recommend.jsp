<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<p>
<h3>编辑推荐</h3>
</p>
<s:iterator value="redBook">
	<div class="thumbnail col-12 col-sm-12 col-lg-6 recommend-book">
		<div class="row">
			<div class="col-md-4">

				<a href='product.action?id=${product_id}'><img
					src="<%=request.getContextPath() %>/res/img/product/${productPic}"
					 width="128" height="160" /> </a>
								
			</div>
			<div class="col-md-8">
				<div class="caption text-left">
					<h3>
						<a href='product.action?id=${product_id}'> ${productName}</a>
					</h3>

					<h4>
						作者：${author} 著 <br />
						出版社：&nbsp;&nbsp;${publishing}&nbsp;&nbsp;<br />出版时间：${publishTime} <br />
						介绍： <span>${description}</span>
						<p>定价：￥${fixedPrice}&nbsp;&nbsp;丁丁价：￥${dangPrice}</p>
					</h4>

				</div>
			</div>
		</div>
	</div>
</s:iterator>

