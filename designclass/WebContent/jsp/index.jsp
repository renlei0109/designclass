<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "s" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/responsive-nav.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <title>Responsive Nav &middot; Advanced Left Navigation Demo</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
 </head>
  <body>
	
  <!--   <div role="navigation" id="foo" class="nav-collapse">
      <ul>
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">数据浏览</a></li>
        <li><a href="#">数据插入</a></li>
        <li><a href="#">数据删除</a></li>
        <li><a href="#">序列查询</a></li>
        <li><a href="#">统计功能</a></li>
       </ul>
    </div> -->
    <s:menu></s:menu>

    <div role="main" class="main">
    		<jsp:include page="table/selectTable.jsp"></jsp:include>
    </div>

    <script>
      var navigation = responsiveNav("foo", {customToggle: ".nav-toggle"});
    </script>
  </body>
</html>
