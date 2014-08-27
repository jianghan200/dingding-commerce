<%@page contentType="text/html;charset=utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#new_bang').toggle(function() {
			//第一次点击
				//$('#d2').css('display','block');
				//$('#d2').show('slow');  //slow,normal,fast
				$('#book_r_b2_1x').slideDown('slow');
			}, function() {
				//第二次点击
				//$('#d2').css('display','none');
				//$('#d2').hide('slow');
				$('#book_r_b2_1x').slideUp('slow');
			});
	});
</script>
<div class="book_r_border2" id="__XinShuReMai">
	<div class="book_r_b2_1x" id="new_bang">
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		
			<div id="book_r_b2_1x" onmouseover=;  style="display:none;">
	
	 <s:iterator value="bookNames"> 
				<h3 class="second">
					<span class="dot_r">${priduct_name}</span><a href="#"
						target="_blank">更多&gt;&gt;</a>
				</h3>
			</s:iterator> 
			</div>
	
	</div>

</div>
