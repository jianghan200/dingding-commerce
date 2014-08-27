<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="">
	<h2>分类浏览</h2>
	<ul class="list-unstyled">
		<s:iterator value="cats" var="c1">
			
				<li class="list-unstyled">
					
					<h4 class="bg-info list-unstyled" onclick="cat_show(${c1.cat_id});"> ${c1.name} <span class="caret"></span> </h4>
					<ul id="category-${c1.cat_id}">
						<s:iterator value="#c1.subCats" var="c2">
							<li class="list-unstyled" ><a href='booklist.action?cid=${c2.cat_id}&pid=${c1.cat_id }'>${c2.name }</a></li>
						</s:iterator>
					</ul>
				</li>
		</s:iterator>
	</ul>

	<a class="back-to-top" href="#top"> 返回顶部 </a>
</div>



