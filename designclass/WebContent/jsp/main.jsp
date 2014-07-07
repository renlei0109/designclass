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
    <s:menu></s:menu>
    <div role="main" id="maindiv" class="main">
    	课程设计任务书</br>
1.	【题目】序列数据管理系统</br>
2.	【功能实现要求】</br>
2.1 文件读取转换</br>
文件“uniprot_sprot.fasta”的格式如下 （文件大小约为125M，包含几十万如下所示的序列）：
>P13813|110KD_PLAKN 110 kDa antigen (PK110) (Fragment) - Plasmodium knowlesi
FNSNMLRGSVCEEDVSLMTSIDNMIEEIDFYEKEIYKGSHSGGVIKGMDYDLEDDENDEDEMTEQMVEEVADHITQDMIDEVAHHVLDNITHDMAHMEEIVHGLSGDVTQ
……….
其中，“P13813|110KD_PLAKN”为序列的ID，“110 kDa antigen (PK110) (Fragment) - Plasmodium knowlesi”为序列的附加描述，“FNSN..”为实际存储的序列。
具体要求：编写程序将文件内所有信息读取存储到事先设计好的关系数据库表中。
</br>
2.2	数据库设计：设计相应的关系数据库表，满足如下要求</br>
（1）存储上述序列文件中的所有信息；</br>
（2）存储如下所示的每个字符的“质量”信息（例如，G的质量为57；一个字符串的质量为其包含的所有字符的质量之和，“FN”的质量为147+114=261）；</br>
（3）能够满足后面提到的快速查询、插入、删除和修改功能；</br>
G=57;A=71；S=87; P=97; V=99; T=101;C=103;L=113;I=113;X=113; N=114;O=114;
B=114;D=115;Q=128;K=128;Z=128;E=129;M=131;H=137;F=147;R=156;Y=163;W=186;
（4）可以根据需要建立多个表或只建立一个表，或使用索引技术，但数据导入后所占空间不得超过原始数据的10倍（<1.5G）
</br>
2.3	用户界面设计：设计用户界面和菜单，为2.4中要求的操作提供支持</br>
具体要求：界面友好，易于使用</br>

2.4	数据管理功能实现：实现如下功能</br>
（1）	数据浏览：允许用户通过图形界面浏览数据库中的信息</br>
（2）	数据插入与删除：允许用户通过图形界面插入与删除序列；</br>
（3）	数据修改：允许用户通过图形界面进行序列修改；</br>
（4）	序列查询：实现以下几个查询功能</br>
4.1 字符串精确查询：用户输入一个无间隔片段序列（如“DGR”），输出所有包含该字符串的序列，并高亮显示该片段在序列中出现的所有位置。</br>
4.2 字符串模糊查询：用户输入一个有间隔片段序列（如“D**G”），其中“*”可以匹配任何字符，输出所有包含该字符串的序列，并高亮显示该片段在序列中出现的所有位置。</br>
4.3 质量查询：用户输入一个质量数m和一个误差参数e，例如质量为1190，误差为0.001. 输出所有的质量在m-e与m+e之间的序列片段以及实际误差。</br>
对于上述所有查询，还需要在查询结束后，显示查询时间。</br>
（5）	统计功能： </br>
1.	统计数据库中序列的长度分布，并以直方图的方式（或其他图形格式）展现给用户</br>
2.	统计数据库中不同字符出现的频率分布，并以直方图的方式（或其他图形格式）展现给用户</br>
3.	统计数据库中序列的质量分布，并以直方图的方式（或其他图形格式）展现给用户</br>
3.【分组】</br>
具体要求：4-5个人一组，并确定组长1名，；组长负责项目的总体设计、实现与人员分工。//组长有加分</br>

4.【技术路线】 开发工具和数据库每个小组可以自行选择。</br>

5.【课程设计报告的格式和提交内容】</br>
报告除了在封面（封面格式有统一规定）中应有专业、班级、姓名、学号和课程设计日期以外，其正文一般有如下几个方面的内容：</br>
1）系统分析报告</br>
以无歧义的陈述说明设计的任务。可以画出功能模块图、数据流图等。</br>
2）系统实现中的核心算法描述</br>
3）概念结构设计</br>
定义数据字典，画出E-R图</br>
4）物理结构设计</br>
画出数据库总体的物理模型图
说明本系统中所用到表结构，注明主码，外码，索引，约束等</br>
5）数据库部署描述</br>
描述数据库模型创建到数据库中的过程，数据库使用的连接串的参数</br>
6）数据库程序设计</br>
数据库中所有存储过程和触发器的列表，包括名称、参数、功能、作者等
数据库中每个存储过程和触发器和功能设计</br>
7）附录</br>
带注释的源程序。只要经典代码、核心代码。</br>
带注释的存储过程和触发器的代码</br>s


    </div>
    <script>
      var navigation = responsiveNav("foo", {customToggle: ".nav-toggle"});
    </script>
  </body>
</html>
