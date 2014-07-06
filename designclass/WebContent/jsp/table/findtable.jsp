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
<title>查询序列信息</title>
</head>
<body>
<div style="margin:0 auto;text-align:center;">
	<span style="margin:0px;padding:0px;font-family:"微软雅黑","黑体","宋体";font-size:18px;height:36px;">字符串精确查询：</span>
	</br>说明：（用户输入一个无间隔片段序列（如“DGR”），输出所有包含该字符串的序列，）
	<form name = "seriinfoForm" id = "seriinfoForm" action ="/designclass/serial/exactFindSeriInfos.do?currentPage=1" method="post">
		<table class="altrowstable">
			<thead>
				<tr>
					<th style="width:80%">序列id</th>
					<!-- <th style="width:25%">序列描述</th>
					<th style="width:45%">序列号</th> -->
				    <th style="width:200px">操作</th>
				</tr>
				<tr>
					<td><input style="height:30px;width:600px;font-size:18px;"  type="text" name = "exactStr" id = "exactStr"/></td>
				    <td><input type="submit" value ="精确查找"name = "exactBtn" class="button button-rounded button-flat" /></td> 
				</tr>
				
			</thead>
		</table>
	</form>	
	
	
	</br>
	<span style="margin:0px;padding:0px;font-family:"微软雅黑","黑体","宋体";font-size:18px;height:36px;">字符串模糊查询：</span>
	</br>说明：（用户输入一个有间隔片段序列（如“D**G”），其中“*”可以匹配任何字符，输出所有包含该字符串的序列）
	<form name = "seriinfoForm" id = "seriinfoForm" action ="/designclass/serial/inexactFindSeriInfos.do?currentPage=1" method="post">
		<table class="altrowstable">
			<thead>
				<tr>
					<th style="width:80%">序列id</th>
					<!-- <th style="width:25%">序列描述</th>
					<th style="width:45%">序列号</th> -->
				    <th style="width:200px">操作</th>
				</tr>
				<tr>
					<td  ><input style="height:30px;width:600px;font-size:18px;"  type="text" name = "inexactStr" id = "inexactStr"/></td>
				    <td><input type="submit" value ="模糊查找"name = "inexactBtn" class="button button-rounded button-flat" /></td> 
				</tr>
				
			</thead>
		</table>
	</form>	
	
	</br>
	<span style="margin:0px;padding:0px;font-family:"微软雅黑","黑体","宋体";font-size:18px;height:36px;">质量查询：</span>
	</br>说明：（用户输入一个质量数m和一个误差参数e，例如质量为1190，误差为0.001）
	<form name = "seriinfoForm" id = "seriinfoForm" action ="/designclass/serial/addSeriInfo.do" method="post">
		<table class="altrowstable">
			<thead>
				<tr>
					<th style="width:40%">质量m</th>
					<th style="width:40%">误差e</th>
				    <th style="width:200px">操作</th>
				</tr>
				<tr>
					<td  ><input style="height:30px;width:300px;font-size:18px;"  type="text" name = "quality" id = "quality"/></td>
				  	<td  ><input style="height:30px;width:300px;font-size:18px;"  type="text" name = "deviation" id = "deviation"/></td>
				    <td><input type="submit" value ="质量查找"name = "qualFindBtn" class="button button-rounded button-flat" /></td> 
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