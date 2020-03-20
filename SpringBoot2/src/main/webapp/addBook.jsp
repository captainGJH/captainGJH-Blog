<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript" charset="utf-8"
        src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
        src="js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8"
        src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

  var editor = new UE.ui.Editor();
   editor.render("myEditor");

    //1.2.4以后可以使用一下代码实例化编辑器 .

    //UE.getEditor(’myEditor’)

</script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
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
<jsp:include page="head.jsp"/>

<center>
    <h1>上传作品</h1>
<form action="addnews" method="post">
    <p>
        资讯类型： <select name="ox" id="ox">
        <option value="">请选择</option>

            <option value="1">艺术访谈</option>
        <option value="2">艺术技法</option>
        <option value="3">美术理论</option>

    </select>


    </p>
    <h2>标题名</h2>
    <p>
        <input name="title" id="title" />
    </p>
    <p>
				<textarea style="width:700px;height:300px;" rows="30" cols="100"
                          name="newbodys" id="myEditor" class="xheditor"></textarea>
    </p>
    <br>

        <input type="submit"  value="添加" style="width: 50px" />
    </p>

</form>
</center>
<jsp:include page="bottom.jsp"/>

<script type="text/javascript">
var a=${msg}
    if(a==1)
    {
     alert("添加成功");
    }


</script>
</body>
</html>

