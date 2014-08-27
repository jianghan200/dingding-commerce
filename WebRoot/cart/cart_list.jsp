<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@include file="../common/header.jsp"%>

<div class="container">
        <div class="row">
             <div class="col-md-10 col-md-offset-1">
             
             	<div class="row">
	             	<h2 id="cart_tips">
					您已选购以下商品 <span>${msg}</span>
				</h2>
				</div>
				<div class="row">
					<div class="col-12">
					
<table class="table table-striped table-hover table-condensed">
		<thead>
			<tr>
				<th><span>商品编号</span></th>
				<th><span>商品样式</span></th>
				<th><span>商品名</span></th>
				<th><span>市场价</span></th>
				<th><span>丁丁价</span></th>
				<th><span>数量</span></th>
				<th><span>变更数量</span></th>
				<th><span>删除</span></th>
			</tr>
		</thead>
		<tbody>
		<s:if test="item.size()>0">
					<s:iterator value="item">
			<tr>
					<td>9317290</td>
					<td><span><img src="../productImages/${pro.productPic}" width="128" height="160" />
					</span></td>
					<td><a href="#">${pro.productName}</a></td>
					<td><span>￥${pro.fixedPrice}</span></td>
					<td>&nbsp;&nbsp; <span>￥${pro.dangPrice}</span>
					</td>
					<td>&nbsp;&nbsp;${qty}</td>

					<td><input name="num" type="text" id="num${pro.product_id}"
						size="3" maxlength="4" /> <a
						href="<%=request.getContextPath() %>/cart/cartlist.action"
						onclick="update(${pro.product_id});">变更</a></td>
					<td><a
						href="<%=request.getContextPath() %>/cart/delete.action?pid=${pro.product_id}">删除</a>
					</td>
			</tr>
			</s:iterator>
		</s:if>
		</tbody>


	</table>
					</div><!-- COL-X DEFINE FOR PRODUCT TABLE -->
				</div><!-- row for products table -->
					
				<s:if test="item.size()=0">
					<h2>您还没有挑选商品</h2>
				</s:if>
				
				<div class="row">
					<div class="col-12">
					
							<div> <a href='../main/ding.jsp'> 继续挑选商品>></a></div>
		<div>
			
				<h5>您共节省： <span> ￥<span id="total_economy">${cutDown}</span>
				</span> <span id='total_vip_economy'> ( 其中享有优惠： <span> ￥<span
						id='span_vip_economy'>0.00</span>
				</span>)
				</span> \
				
				<span>|</span> <span>商品金额总计：</span> <span> ￥<span
					id='total_account'>${SdangTotal}</span>
				</span></h5>
		
			    <div id="balance">
				<a name='checkout' class="btn btn-primary"
					href='<%=request.getContextPath()%>/order/order_info.action'> 结算
				</a>

				<a class="btn btn-default pull-right" href='<%=request.getContextPath()%>/cart/reset.action'>清空购物车</a>
		     	</div>
	</div>
	

						</div><!-- COL-X DEFINE FOR ORDER INFO -->
				</div><!-- row for ORDER INFO -->
				<div class="row">
					<div class="col-12">
				<h5>您已删除以下商品，如果想重新购买，请点击“恢复”</h5>
	<table class="table table-striped table-hover table-condensed col-sx-6">
			<tbody>
				<s:iterator value="delPros">
					<tr>
						<td width="58">&nbsp;</td>
						<td width="365"><a href="#">${pro.productName}</a></td>
						<td width="106">￥${pro.fixedPrice}</td>
						<td width="134"><span>￥${pro.dangPrice}</span></td>
						<td width="56"><a
							href="<%=request.getContextPath() %>/cart/recovery.action?pid=${pro.product_id}">恢复</a>
						</td>
						<td width="16">&nbsp;</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
				
				</div><!-- for deleted products -->
				
				</div><!-- for deleted products -->
        	</div> <!-- big col-x define -->
  </div> <!-- big row -->
  </div> <!-- container -->



<!--页尾开始 -->
<%@include file="../common/footer-basic.jsp"%>
	
<script type="text/javascript">
		
		//除掉字符串两端的空格 replace
			function strip(str){
				var reg = /(\s*)|(\s*$)/;
				return str.replace(reg,'');
			}
		
		   function update(id){
		    var num = $("#num"+id).val();
		    if(strip(num).length == 0){
					alert('数量不能为空');
					return;
				}
				//必须是数字
				var reg = /^[0-9]+$/;
				if(!reg.test(strip(num))){
					alert('必须是数字');
					return;
				}
		      $.post(
		        "<%=request.getContextPath()%>
	/cart/update.action", {
			"id" : id,
			"num" : num
		}, function(data) {
			if (data) {
				return true;
			}
		}

		);
	};

	
</script>
	
