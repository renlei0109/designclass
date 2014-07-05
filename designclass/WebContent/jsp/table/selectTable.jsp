<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.lei.model.SeriInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/designclass/css/blue.css" rel="stylesheet">
<script src="/designclass/js/icheck.min.js"></script>
<script src="/designclass/js/jquery-1.9.1.min.js"></script>
<%
	int currentPage =Integer.valueOf( session.getAttribute("currentPage").toString());
	int totalPage = 265951/20;
	List<SeriInfo>seriInfos = new ArrayList<SeriInfo>();
	seriInfos = (List<SeriInfo>)session.getAttribute("seriInfos");
%>
<script>
	
	$(document).ready(function(){
		var flag = 1;
	    $("#delBtn").click(function(){
	    	var checked = [];
	    	flag = 0;
	        $('input:checkbox:checked').each(function() {
	            checked.push($(this).val());
	        });
	      	if(checked.length==0){
	      		alert("请至少选择一个需要删除的项");
	      		return ;
	      	}
	        $.ajax({
	        	  type: 'POST',//提交方式 post 或者get
	        	  url: "/designclass/serial/delSeriInfo.do",//提交到那里 后他的服务
	        	  cache : false,
	        	  traditional :true,	//必须加上该句话来序列化
	        	  data: {'checked':checked},//提交的参数 
	        	  success:function(msg){
	        		 	    alert("删除成功！！");//弹出窗口，这里的msg 参数 就是访问后台给的参数 
	        		  		window.location.href = window.location.href;   
	        	            
	        	        },
	        	    error:function(){
	        	        ajax("删除失败！");
	        	        }
	        	});
		});
	});
	
	    
		/*  	if(flag){
			    $('input:button').click(function(){
			        alert("***************");
			        $('input:checkbox:checked').each(function() {
			            checked.push($(this).val());
			        });
			        alert(checked);
			        checked = [];
			    });
		 	}  */
			
			
	$(document).ready(function(){
			    $('input').iCheck({
			    checkboxClass: 'icheckbox_minimal',
			    radioClass: 'iradio_minimal',
			    increaseArea: '20%' // optional
			    /* alert("fsd"); */
			  });
			});
	
</script>

<!-- <script>
	$(document).ready(function(){
		alert("fdsf222");
	    var checked = [];
	    $("#delBtn").click(function(){
	    	alert("fsdf");
	        $('input:checkbox:checked').each(function() {
	            checked.push($(this).val());
	        });
	        alert(checked);
	    });
	});
</script> -->

<!-- <script>
	$(document).ready(function(){
		alert("fdsf");
	    var checked = [];
	    $("#delBtn").click(function(){
	    	alert("fsdf");
	        $('input:checkbox:checked').each(function() {
	            checked.push($(this).val());
	        });
	        alert(checked);
	    });
	});
</script> -->

<!-- 
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
</script> -->


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
<title>Insert title here</title>
</head>
<body>
<div style="margin:0 auto;text-align:center;">
	<input type="button" value ="删除" id = "delBtn"/>
	<table class="altrowstable">
		
		<thead>
			<tr>
				<th></th>
				<th style="width:20%">序列id</th>
				<th style="width:25%">序列描述</th>
				<th style="width:45%">序列号</th>
				<th style="width:25%">质量</th>
			    <th style="width:15%">操作</th>
			</tr>
			<%
				for(SeriInfo sInfo :seriInfos){
			%>
			<tr>
				<td><input type="checkbox" name="idcheckbox" value="<%=sInfo.getId()%>"></td>
				<td><%=sInfo.getId() %></td>
				<td><%=sInfo.getDescription()%></td>
				<td><%=sInfo.getSerial() %></td>
				<td><%=sInfo.getQuality() %></td>
			    <td><input type="button" value ="删除"name = "delBtn"/></td> 
			</tr>
			<%} %>
			
		</thead>
	</table>
	<div style="margin:0 auto">
		<tr>
				<%if(currentPage>0){ %>
					<td><a href="/designclass/serial/getSeriInfos.do?currentPage=<%=currentPage-1 %>" style="color:blue"><--上一页 </a></td>
					&nbsp;
				<%} %>
				<td>当前页数:<%=currentPage+1 %></td>
				&nbsp;&nbsp;
				<td>总页数:<%=totalPage %></td>
				&nbsp;
				<td><a href="/designclass/serial/getSeriInfos.do?currentPage=<%=currentPage+1 %>" style="color:blue">下一页--></a></td>
		</tr>
	</div>	
</div>	
</body>
</html>