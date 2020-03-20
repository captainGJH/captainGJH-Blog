<%--
  Created by IntelliJ IDEA.
  User: wrc
  Date: 2019/11/27
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'MyJsp.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<!-- 底部 开始 -->
<div class="k20"></div>
<div class="footlinks bai f14"><a href="#">设为首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">加入收藏</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">关于我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">版权申明</a></div>
<div class="copy">版权所有 Copyright 2015-2016 中国职业书画家网 ALL rights reserved<br>
    联系方式：E-mail:123456789@qq.COM  QQ:123456789 公司电话：010-12345678 139000000001 网站备案：京ICP备091542372号</div>
<!-- 底部 结束 -->
</body>
</html>
