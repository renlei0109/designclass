<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "s" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%
		List<Integer>characterCounts = new ArrayList<Integer>();
		characterCounts = (List<Integer>)session.getAttribute("characterCounts");
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/responsive-nav.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="../js/Chart.js"></script>
	<title>序列字母的分布图</title>
	</head>
	<body>
	<s:menu></s:menu>
	<div role="main" id="maindiv" class="main">
		<span style="color:blue;font-size:18px">序列字母分布(单位:个)</span>
		<div style="width:80%;margin-left:50px"> 
			<canvas id="canvas" height="450px" width="600px"></canvas>
		</div>
    </div>


	<script>
	var randomScalingFactor = function(){ return Math.round(Math.random()*100)};

	var barChartData = {
		labels : ["A","B","C","D","E","F","G","H","I","J",
		         "K","L","M","N","O","P","Q","R","S","T","U"
		         ,"V","W","X","Y","Z"],
		datasets : [
		
			{
				fillColor : "rgba( 204 ,102 ,255,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [<%=characterCounts.get(0)%>,<%=characterCounts.get(1)%>,<%=characterCounts.get(2)%>,<%=characterCounts.get(3)%>,<%=characterCounts.get(4)%>,<%=characterCounts.get(5)%>,<%=characterCounts.get(6)%>,
				        <%=characterCounts.get(7)%>,<%=characterCounts.get(8)%>,<%=characterCounts.get(9)%>,<%=characterCounts.get(10)%>,<%=characterCounts.get(11)%>,<%=characterCounts.get(12)%>
				        ,<%=characterCounts.get(13)%>,<%=characterCounts.get(14)%>,<%=characterCounts.get(15)%>,<%=characterCounts.get(16)%>,<%=characterCounts.get(17)%>,<%=characterCounts.get(18)%>
				        ,<%=characterCounts.get(19)%>,<%=characterCounts.get(20)%>,<%=characterCounts.get(21)%>,<%=characterCounts.get(22)%>,<%=characterCounts.get(23)%>,<%=characterCounts.get(24)%>
				        ,<%=characterCounts.get(25)%>]
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
