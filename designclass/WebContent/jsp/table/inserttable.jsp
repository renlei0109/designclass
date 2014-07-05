<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.lei.model.SeriInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/designclass/css/button.css" rel="stylesheet">
<link href="/designclass/css/blue.css" rel="stylesheet">
<script src="/designclass/js/icheck.min.js"></script>
<script src="/designclass/js/jquery-1.9.1.min.js"></script>
<script>
	
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加序列信息</title>
</head>
<body>
<div style="margin:0 auto;text-align:center;">
	<span style="margin:0px;padding:0px;background-color:#E7EAEB;font-family:"微软雅黑","黑体","宋体";font-size:18px;height:36px;">添加新的序列信息</span>
	<form name = "seriinfoForm" id = "seriinfoForm" action ="/designclass/serial/addSeriInfo.do" method="post">
		<table class="altrowstable">
			<thead>
				<tr>
					<th style="width:20%">序列id</th>
					<th style="width:25%">序列描述</th>
					<th style="width:45%">序列号</th>
				    <th style="width:15%">操作</th>
				</tr>
				<tr>
					<td style="hight:80px"><input type="text" name = "id" id = "id"/></td>
					<td><input type="text" name = "description" id = "description"/></td>
					<td><input type="text" name = "serial" id = "serial"/></td>
				    <td><input type="submit" value ="添加"name = "addBtn" class="button button-rounded button-flat" /></td> 
				</tr>
				
			</thead>
		</table>
	</form>	
	<div style="margin:0 auto">
	<%-- 	<tr>
				<%if(currentPage>0){ %>
					<td><a href="/designclass/serial/getSeriInfos.do?currentPage=<%=currentPage-1 %>" style="color:blue"><--上一页 </a></td>
					&nbsp;
				<%} %>
				<td>当前页数:<%=currentPage+1 %></td>
				&nbsp;&nbsp;
				<td>总页数:<%=totalPage %></td>
				&nbsp;
				<td><a href="/designclass/serial/getSeriInfos.do?currentPage=<%=currentPage+1 %>" style="color:blue">下一页--></a></td>
		</tr> --%>
	</div>	
</div>	
</body>
</html>