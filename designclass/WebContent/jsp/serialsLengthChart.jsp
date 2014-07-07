<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "s" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%
		List<Integer>serialLengthCounts = new ArrayList<Integer>();
	serialLengthCounts = (List<Integer>)session.getAttribute("serialLengthCounts");
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/responsive-nav.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="../js/Chart.js"></script>
	<title>序列长度的柱状图</title>
	</head>
	<body>
	<s:menu></s:menu>
	<div role="main" id="maindiv" class="main">
		<span style="color:blue;font-size:18px">序列长度分布(单位:字符)</span>
		<div style="width:80%;margin-left:50px"> 
			<canvas id="canvas" height="450px" width="600px"></canvas>
		</div>
    </div>


	<script>
	var randomScalingFactor = function(){ return Math.round(Math.random()*100)};

	var barChartData = {
		labels : ["0-100","101-200","201-300","301-400","401-500","501-600","601-700","701-800","801-900","901-1000",
		         "1001-1500","1501-2000","2001-2500","2501-3000","3001-5万" ],
		datasets : [
		
			{
				fillColor : "rgba( 102 ,255, 102,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [<%=serialLengthCounts.get(0)%>,<%=serialLengthCounts.get(1)%>,<%=serialLengthCounts.get(2)%>,<%=serialLengthCounts.get(3)%>,<%=serialLengthCounts.get(4)%>,<%=serialLengthCounts.get(5)%>,<%=serialLengthCounts.get(6)%>,
				        <%=serialLengthCounts.get(7)%>,<%=serialLengthCounts.get(8)%>,<%=serialLengthCounts.get(9)%>,<%=serialLengthCounts.get(10)%>,<%=serialLengthCounts.get(11)%>,<%=serialLengthCounts.get(12)%>
				        ,<%=serialLengthCounts.get(13)%>,<%=serialLengthCounts.get(14)%>]
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
