<%--
  Created by IntelliJ IDEA.
  User: gjh
  Date: 2019/10/9
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="images/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        var msg='${msg}';
        if(""!=msg)
        {
         alert(msg)
        }


    </script>

</head>

<body>
<form action="login.do" method="post">
    <table width="990" height="650" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
            <td width="318" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="299" align="right"><img src="images/login1_01.gif" width="318" height="299" /></td>
                    </tr>
                    <tr>
                        <td height="351" align="right"><img src="images/login1_04.gif" width="318" height="351" /></td>
                    </tr>
                </table>
            </td>
            <td width="366" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="299" background="images/login_6.gif"><img src="images/login1_02.gif" width="366" height="299" /></td>
                    </tr>
                    <tr>
                        <td height="96" valign="top" background="images/login_9.gif">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="25%" height="25">&nbsp;</td>
                                    <td width="48%" valign="top">
                                        <label>
                                            <input name="uname" type="text" class="txt" size="25" />
                                        </label>
                                    </td>
                                    <td width="27%" rowspan="2"><input type="image" src="images/login_2.gif"/></td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>
                                        <input name="upwd" type="password" class="txt" size="25" />
                                    </td>
                                </tr>
                                <tr>
                                    <td height="36">&nbsp;</td>
                                    <td><a href="useradd.do"><img src="images/login_3.gif" width="77" height="25" border="0" /></a>&nbsp;<a href="#"><img src="images/login_4.gif" width="77" height="25" border="0" /></a></td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td height="255" background="images/login1_07.gif">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="129">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center">版权所有 &copy; <a href="http://www.865171.cn">www.865171.cn</a> 联系QQ:215288671</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td width="318" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="299" align="left" background="images/login1_03.gif">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="351" align="left" background="images/login1_06.gif">&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>