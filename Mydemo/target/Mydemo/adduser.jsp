<%--
  Created by IntelliJ IDEA.
  User: gjh
  Date: 2019/10/9
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
    <link href="css/comm.css" rel="stylesheet" type="text/css" />
</head>


<script type="text/javascript">
    var msg='${msg}';
    if(""!=msg)
    {
        alert(msg)
    }


</script>


<body>
<form id="form1" method="post" action="add.do">
    <table width="97%" border="0" cellspacing="10" cellpadding="0">
        <tr>
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C4E7FB">
                    <tr>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                                <tr>
                                    <td>
                                        &nbsp;<a href="SysInfo.aspx" class="font1">首页</a> &gt; 系统管理 &gt; 员工用户资料编辑
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">

                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            员工姓名：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <input name="u_name" type="text" style="width:180px;" />
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请输入你的姓名！
                        </td>
                    </tr>
                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            登录密码：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <input name="u_pwd" type="password"  value="888" style="width:180px;"/>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请输入系统登录密码,默认密码：888！
                        </td>
                    </tr>

                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            用户角色：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <select name="roleid">
                                <c:forEach items="${list}" var="t">


                                    <option value="${t.roleid}">${t.rolename}</option>

                                </c:forEach>


                            </select>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请选择用户的角色！
                        </td>
                    </tr>


                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            职务：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <select name="dutyid">
                                <c:forEach items="${zhiwu}" var="t">


                                    <option value="${t.codeid}">${t.codetext}</option>

                                </c:forEach>



                            </select>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请选择用户所任职务！
                        </td>
                    </tr>
                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            部门：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <select name="deptid">
                                <c:forEach items="${bumen}" var="t">


                                    <option value="${t.codeid}">${t.codetext}</option>

                                </c:forEach>

                            </select>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请选择用户所在部门！
                        </td>
                    </tr>
                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            加入公司时间：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <input name="joindate" type="text" style="..." onfocus="WdatePicker()"/>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请选择用户加入公司的时间！
                        </td>
                    </tr>

                    <tr>
                        <td height="26" align="right" bgcolor="#FFFFFF" class="style1">
                            学历：
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" width="20%">
                            <select name="enduid">
                                <c:forEach items="${xueli}" var="t">


                                    <option value="${t.codeid}">${t.codetext}</option>

                                </c:forEach>
                            </select>
                        </td>
                        <td height="26" align="left" bgcolor="#FFFFFF" style="color: red;">
                            请选择用户的学历！
                        </td>
                    </tr>



                </table>
            </td>
        </tr>
        <tr>
            <td align="center">

                <input type="image"  src="images/index1_82.gif">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="image" src="images/return-btn.gif">
            </td>
        </tr>
        <tr>
            <td align="center">
                <img src="images/logo.gif" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>