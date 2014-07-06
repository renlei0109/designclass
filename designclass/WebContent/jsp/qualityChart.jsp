<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "s" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%
		List<Long>qualityCounts = new ArrayList<Long>();
		qualityCounts = (List<Long>)session.getAttribute("qualityCounts");
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/responsive-nav.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="../js/Chart.js"></script>
	<title>质量的柱状图</title>
	</head>
	<body>
	<s:menu></s:menu>
	<div role="main" id="maindiv" class="main">
		<span style="color:blue;font-size:18px">质量分布(单位:个)</span>
		<div style="width:80%;margin-left:50px"> 
			<canvas id="canvas" height="450px" width="600px"></canvas>
		</div>
    </div>


	<script>
	var randomScalingFactor = function(){ return Math.round(Math.random()*100)};

	var barChartData = {
		labels : ["0-5000","5001-10000","10001-15000","15001-20000","20001-25000","25001-30000","30001-35000","35001-40000","40001-45000","45001-50000",
		         "50001-55000","55001-60000","60001-65000","65001-70000","70001-20万" ],
		datasets : [
		
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [<%=qualityCounts.get(0)%>,<%=qualityCounts.get(1)%>,<%=qualityCounts.get(2)%>,<%=qualityCounts.get(3)%>,<%=qualityCounts.get(4)%>,<%=qualityCounts.get(5)%>,<%=qualityCounts.get(6)%>,
				        <%=qualityCounts.get(7)%>,<%=qualityCounts.get(8)%>,<%=qualityCounts.get(9)%>,<%=qualityCounts.get(10)%>,<%=qualityCounts.get(11)%>,<%=qualityCounts.get(12)%>
				        ,<%=qualityCounts.get(13)%>,<%=qualityCounts.get(14)%>]
			} 
		]

	}
	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myBar = new Chart(ctx).Bar(barChartData, {
			responsive : true
		});
	}

	</script>
	</body>
</html>
