<%--
  Created by IntelliJ IDEA.
  User: wrc
  Date: 2019/11/27
  Time: 20:10
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
    <LINK id="css" href="css/css.css" type="text/css" rel="stylesheet" />
    <LINK id="css" href="css/style.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="http://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="top">
    <dl>
        <dt>欢迎来到中国职业书画家网！</dt>
        <dd><a href="#">加入收藏</a></dd>
        <dd><a href="#">设为首页</a></dd>
        <dd> <a data-toggle="modal" data-target="#login" href="" style="color: #B9B9FF"><span
                class="glyphicon glyphicon-log-in"></span> 会员登录</a> |</dd>
        <dd><a data-toggle="modal" data-target="#reg" href="" style="color: #B9B9FF"><span
                class="glyphicon glyphicon-user"></span> 会员注册</a></dd>
    </dl>
</div>
<div class="header">
    <div class="logo"><img src="images/logo.jpg"></div>
    <div class="search">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><input name="" type="text" class="search_inps" onfocus="OnfocusFun(this,'请输入关键词')" onblur="OnBlurFun(this,'请输入关键词')" value="请输入关键词"></td>
                <td align="right"><input name="" type="button" class="search_btn"></td>
            </tr>
        </table>
    </div>
</div>
<!-- 头部结束 -->
<!-- 注册 -->
<div id="header">
    <!--顶部bar 开始-->
    <div id="headCont">
        <audio id="audioPlayer"></audio>
        <!--二级导航-->
        <!-- 用户登录窗口 -->
        <div id="reg" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-title">
                        <h1 class="text-center">注册</h1>
                    </div>
                    <div class="modal-body">
                        <form action="usermain/credit_loaning.do" method="post"onsubmit="return zheng()">
                            <input type="hidden" value="0" id="tid" name="tid"/>

                            <div class="form-group">
                                <label for="">用户名</label>
                                <input class="form-control" id="uname"  name="uname" type="text" value="">
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input class="form-control" id="uname"  name="uname" type="text" value="">
                            </div>
                            <div class="form-group">
                                <label for="">再次输入</label>
                                <input class="form-control" id="uname"  name="uname" type="text" value="">
                            </div>
                            <div class="form-group">
                                <label for="">手机号</label>
                                <input class="form-control" id="phone" name="upwd"
                                       type="text" value="${sessionScope.user.u_phone}">

                            </div>


                            <div class="form-group">
                                <label for="">短信验证码</label>
                                <input class="form-control" type="text" placeholder="验证码" id="yzm"/>
                                <input type="button" id="bt1" onclick="yan()" class="btn" value="获取验证码"/>

                                <label for="">

                                </label>

                            </div>


                            <div class="text-right">

                                <button class="btn btn-primary" type="submit">下一步</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 注册结束-->
<!-- 登录开始 -->
<div id="login" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-title">
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">
                <form action="login.do" method="post" onsubmit="return denglu()">

                    <div class="form-group">
                        <label for="" id="ddname">用户名</label>
                        <input class="form-control" id="dname" name="uname" type="text" onblur="yes()">
                    </div>
                    <div class="form-group">
                        <label for="" id="ddpwd">密码</label>
                        <input class="form-control" id="dpwd" name="upwd"
                               type="password">
                        <label for="">
                            <a href="updatePwd.jsp" >忘记密码？</a>
                        </label>
                    </div>
                    <div class="text-right">
                        <input type="checkbox" name="issave" value="1" id="mysave"/>记住密码
                        <button class="btn btn-primary" type="submit" onclick="denglu()" >登录</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal"
                       data-target="#chose">还没有账号？点我注册</a>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- 登录结束 -->
<!-- 导航开始 -->
<div class="menu">
    <ul>
        <li><a href="#" class="menu_on">网站首页</a></li>
        <li><a href="#">资讯中心</a></li>
        <li><a href="#">学术知识</a></li>
        <li><a href="#">书画名家</a></li>
        <li><a href="#">名作欣赏</a></li>
        <li><a href="#">艺术市场</a></li>
        <li><a href="#">美术机构</a></li>
        <li><a href="#">美术展讯</a></li>
    </ul>
</div>
<!-- 导航结束 -->
</body>
</html>
