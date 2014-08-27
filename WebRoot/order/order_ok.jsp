
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@include file="../common/header.jsp"%>
		

		<div class="container">
          <div class="row">
               <div class="col-md-6 col-md-offset-3">
               生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="text-danger">3.订单成功</span>
          		</div>
          </div>
        

    	<div class="row">
               <div class="col-md-6 col-md-offset-3">
		
				<div class="">
					<h2>订单提交成功</h2>
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：${orderNum}，金额总计${money}
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						<a href="../main/ding.jsp">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>
		</div>

		<%@include file="../common/footer.jsp"%>
	</body>
</html>

