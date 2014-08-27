
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@include file="../common/header.jsp"%>
		

		<div class="container">
          <div class="row">
               <div class="col-md-8 col-md-offset-2">
              <h3> 生成订单骤: <span class="text-danger">1.确认订单</span>   > 2.填写送货地址 > 3.订单成功
          		</h3></div>
          </div>
        <div class="row">
         	<div class="col-md-8 col-md-offset-2">

				<table class="tab_login table-striped table-hover table-condensed table-bordered">
					<tr>
						<td valign="top" class="w1" style="text-align: left">
							<b>序号</b>
						</td>
						<td valign="top" class="w1" style="text-align: left">
							<b>商品名称</b>
						</td>
						<td valign="top" class="w1" style="text-align: left">
							<b>商品单价</b>
						</td>
						<td valign="top" class="w1" style="text-align: left">
							<b>商品数量</b>
						</td>
						<td valign="top" class="w1" style="text-align: left">
							<b>小计</b>
						</td>
					</tr>

					<!-- 订单开始 -->
					<s:iterator value="buyPros" status="rowstatus">
				
						<tr>
							<td valign="top">
								<s:property value="#rowstatus.index+1"/>
							</td>
							<td valign="top">
								${pro.productName}
							</td>
							<td valign="top">
								${pro.dangPrice}
							</td>
							<td valign="top">
								${qty}
							</td>
							<td valign="top">
								${pro.dangPrice*qty}
							</td>
						</tr>
					</s:iterator>
						
					<!-- 订单结束 -->
					<tr>
						<td valign="top" class="w1" style="text-align: left" colspan="5">
							<b>总价￥${dangTotal}</b>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<h4><a href="../cart/cartlist.action">取消 </a>
				
					&nbsp;&nbsp;&nbsp;<a href="address_form.action">
					下一步 </a></h4>
				</div>
			</div>
		</div>
		
		 </div> <!-- container -->
		<%@include file="../common/footer.jsp"%>
	</body>
</html>


