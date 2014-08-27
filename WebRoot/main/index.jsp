<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%@include file="../common/header.jsp" %>

<div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">

        <h1><s:property value="%{#session.user.nickname}"/>您好，欢迎光临丁丁网</h1>
        <p>尊敬的客户，如您在浏览本网站的过程中，有任何疑问，或需要帮助，欢迎联系我们，Tel：18825169104； Email：185721053@qq.com；ADD:暨南大学南海楼612</p>
        <p><a href="<%=request.getContextPath()%>/main/ding.jsp"class="btn btn-primary btn-lg" role="button">返回首页 &raquo;</a></p>

      </div>


</div>
         
<%@include file="../common/footer.jsp" %>