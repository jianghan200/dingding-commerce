<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@include file="../common/header.jsp"%>
		

		<div class="container">
          <div class="row">
               <div class="col-md-6 col-md-offset-3">
              <h4> 生成订单骤: 1.确认订单 >
               <span class="text-danger"> 2.填写送货地址</span> > 3.订单成功</h4>
          		</div>
          </div>

          <div class="row">
            <div class="col-md-6 col-md-offset-3">
			<p>
				选择地址：			
				<s:select list="address" label="" name="id"
				  listKey="id" listValue="full_address" 
				  headerKey="0" headerValue="填写新地址" onchange="change(this.value);"  >
					
				</s:select>				
			</p>
			<form name="ctl00" method="post" action="<%=request.getContextPath() %>/order/address.action" id="f">
				<input type="hidden" name="id" id="addressId" />

				<table class="tab_login tab_login table-striped table-hover table-condensed table-bordered">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="receiveName"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
								<span id="nameinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="fullAddress" class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="address" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="postalCode"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="code" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="phone"
								id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="pho" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="mobile"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
								<span id="mob" style="color:red"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="order_info.action"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
			</div>
          </div> <!-- row2 -->
        </div><!-- container -->

		<%@include file="../common/footer.jsp"%>
		
		<script type="text/javascript">
		  var flag={
		    "all":false,
		    "name":false,
		    "address":false,
		    "code":false,
		    "phone":false,
		    "mobile":false
		  };
		
		  function change(id){
		    alert(id);
		    if(id==0){
		    $("#receiveName").val("");
		    $("#fullAddress").val("");
		    $("#postalCode").val("");
		    $("#phone").val("");
		    $("#mobile").val("");
		    }
		    $.post(
		     "<%=request.getContextPath() %>/order/textAdd.action",
		     {"id":id},
		     function(data){

		        $("#addressId").val(id);
		        $("#receiveName").val(data.receive_name);
		        $("#fullAddress").val(data.receive_name);
		        $("#postalCode").val(data.postal_code);
		        $("#phone").val(data.mobile);
		        $("#mobile").val(data.phone);
		        flag.all = true;
		      
		      }
		    );
		  };
		  
		  //验证收件人名
		  $(function(){
		    $("#receiveName").blur(function(){
		      var name = $("#receiveName").val();
		      if(name==""){
		        $("#nameinfo").html("<img src='../images/wrong.gif'/>不能为空");
		        flag.name = false;////设置成为通过检测
		        return;
		      }else{
		         $("#nameinfo").html("<img src='../images/right.gif'/>");
		         flag.name = true;
		      }
		    });
		  });
		  //验证收件人地址
		  $(function(){
		    $("#fullAddress").blur(function(){
		      var name = $("#fullAddress").val();
		      if(name==""){
		        $("#address").html("<img src='../images/wrong.gif'/>不能为空");
		        flag.address=false;
		      }else{
		        $("#address").html("<img src='../images/right.gif'/>");
		        flag.address=true;
		        return;
		      }
		    });
		  });
		  //验证邮编
		  $(function(){
		    $("#postalCode").blur(function(){
		      var name = $("#postalCode").val();
		      var codePattern =/^[0-9]{6}$/;
		      if(name==""){
		        $("#code").html("<img src='../images/wrong.gif'/>不能为空");
		        flag.code = false;
		      }else if(!codePattern.test($.trim(name))){
		        $("#code").html("<img src='../images/wrong.gif'/>格式不正确");
		        flag.code = true;
		      }else{
		      $("#code").html("<img src='../images/right.gif'/>");
		      flag.code = true;
		      return;
		      }
		    });
		  });
		  //验证电话
		  $(function(){
		    $("#phone").blur(function(){
		      var name = $("#phone").val();
		      var codePattern =/^(0(10|2[1-3][3-9]\d{2}))?[1-9]\d{6,7}$/;
		      if(name==""){
		        $("#pho").html("<img src='../images/wrong.gif'/>不能为空");
		        flag.phone = false;
		      }else if(!codePattern.test($.trim(name))){
		        $("#pho").html("<img src='../images/wrong.gif'/>格式不正确");
		        flag.phone = false; 
		      }else{
		        $("#pho").html("<img src='../images/right.gif'/>");
		         flag.phone = true;
		         return;
		      }
		    });
		  });
		  //验证手机
		  $(function(){
		    $("#mobile").blur(function(){
		      var name = $("#mobile").val();
		       var codePattern =/^(\+86|0086)?\s?\d{11}$/;
		      if(name==""){
		        $("#mob").html("<img src='../images/wrong.gif'/>不能为空");
		        flag.moblie = false; 
		      }else if(!codePattern.test($.trim(name))){
		        $("#mob").html("<img src='../images/wrong.gif'/>格式不正确");
		        flag.moblie = false; 
		      }else{
		        $("#mob").html("<img src='../images/right.gif'/>");
		         flag.mobile = true;
		         return;
		      }
		    });
		  });
		 
		    //表单提交处理 
		  $(function(){
		    $("#f").submit(function(){
		      //检测表单是否都通过检查
		      if(flag.name&&flag.address&&flag.code&&flag.phone&&flag.mobile||flag.all){
		        return true;
		      }else{
		        alert("请检测表单");
		        return false;
		      }
		    });
		  
		  });
		</script>
	</body>
</html>

