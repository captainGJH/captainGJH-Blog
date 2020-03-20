<%--
  Created by IntelliJ IDEA.
  User: wrc
  Date: 2019/11/27
  Time: 19:51
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

</head>


<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="k20"></div>
<div class="container">
    <!-- 图片新闻 开始 -->
    <div class="w300 left">
        <div class="picnews">
            <ul class="bigImg">
                <li>
                    <a href="#" target="_blank"><img src="img/1.jpg" /></a>
                    <h4><a href="#" target="_blank">美女玩家猎魔人 Cosplay</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/2.jpg" /></a>
                    <h4><a href="#">《第2次机战OG》魔装机神系机体情报</a></h4></li>
                <li>
                    <a href="#" target="_blank"><img src="img/3.jpg" /></a>
                    <h4><a href="#">Dreamhack冬季赛：Hero夺冠 香槟狂欢</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/4.jpg" /></a>
                    <h4><a href="#">妹子战丧尸！Bioware王牌画师插画赏</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/5.jpg" /></a>
                    <h4><a href="#">《刺客信条3》简体中文版已送审</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/6.jpg" /></a>
                    <h4><a href="#">《上古世纪》 中文版截图独家曝光</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/7.jpg" /></a>
                    <h4><a href="#">本周精选大湿级Cos欣赏 佐助亲吻小樱</a></h4>
                </li>
                <li>
                    <a href="#" target="_blank"><img src="img/8.jpg" /></a>
                    <h4><a href="#">《斗仙》11月29日封测 试玩截图首曝</a></h4>
                </li>
            </ul>

            <div class="smallScroll">
                <a class="sPrev" href="javascript:void(0)">←</a>
                <div class="smallImg">
                    <ul>
                        <li><a><img src="img/1.jpg" /></a></li>
                        <li><a><img src="img/2.jpg" /></a></li>
                        <li><a><img src="img/3.jpg" /></a></li>
                        <li><a><img src="img/4.jpg" /></a></li>
                        <li><a><img src="img/5.jpg" /></a></li>
                        <li><a><img src="img/6.jpg" /></a></li>
                        <li><a><img src="img/7.jpg" /></a></li>
                        <li><a><img src="img/8.jpg" /></a></li>
                    </ul>
                </div>
                <a class="sNext" href="javascript:void(0)">→</a>
            </div>

            <div class="pageState"></div>

        </div>

        <script type="text/javascript">
            //大图切换
            jQuery(".picnews").slide({ titCell:".smallImg li", mainCell:".bigImg", effect:"fold", autoPlay:true,delayTime:200,
                startFun:function(i,p){
                    //控制小图自动翻页
                    if(i==0){ jQuery(".picnews .sPrev").click() } else if( i%4==0 ){ jQuery(".picnews .sNext").click()}
                }
            });

            //小图左滚动切换
            jQuery(".picnews .smallScroll").slide({ mainCell:"ul",delayTime:100,vis:4,scroll:4,effect:"left",autoPage:true,prevCell:".sPrev",nextCell:".sNext",pnLoop:false });
        </script>
        <div class="k20"></div>
        <div class="liuhongxuan">
            <img src="images/lhx.jpg"><p><strong class="f16 red">刘红选</strong></p><p style="margin:10px 0 0 0;"><strong>真实是人生的命脉，
            是一切价值的根基。</strong></p><p style="margin:10px 0 0 0;">艺术是指用形象来反映现实但比现实有典型性的社会意识形态，包括文学、书法、绘画、雕塑、建筑、音乐、舞蹈、戏剧、电影、曲艺等。</p>
        </div>
    </div>
    <!-- 图片新闻 结束 -->
    <div class="w15 left"></div>
    <!-- 文字新闻 结束 -->
    <div class="w340 left">
        <h3 class="tt1"><span class="right"><a href="#">更多>></a></span><strong class="f18 hei">资讯中心</strong></h3>
        <dl class="newsdl">
            <dt><a href="#">美归还多国文物为何独缺中国</a></dt>
            <dd>中国是深受文物盗窃、盗掘和非法贩运之害的国家。而美国则是世界上最主要的中国文物进口国之一。</dd>
        </dl>
        <ul class="newsul">
            <li><a href="#">人民喜爱的艺术家系列邀请展第二季开幕式在</a></li>
            <li><a href="#">“盛世中国”—2015当代书画名家系列邀请展之十人</a></li>
            <li><a href="#">刘勃麟：中国艺术界最知名的隐形人</a></li>
            <li><a href="#">2015当代书画名家系列邀请展在京开幕</a></li>
            <li><a href="#">慎重对待“艺术品转卖提成费”立法</a></li>
        </ul>
        <ul class="newsul">
            <li><a href="#">人民喜爱的艺术家系列邀请展第二季开幕式在</a></li>
            <li><a href="#">“盛世中国”—2015当代书画名家系列邀请展之十人</a></li>
            <li><a href="#">刘勃麟：中国艺术界最知名的隐形人</a></li>
            <li><a href="#">2015当代书画名家系列邀请展在京开幕</a></li>
            <li><a href="#">慎重对待“艺术品转卖提成费”立法</a></li>
        </ul>
        <ul class="newsul">
            <li><a href="#">人民喜爱的艺术家系列邀请展第二季开幕式在</a></li>
            <li><a href="#">“盛世中国”—2015当代书画名家系列邀请展之十人</a></li>
            <li><a href="#">刘勃麟：中国艺术界最知名的隐形人</a></li>
            <li><a href="#">2015当代书画名家系列邀请展在京开幕</a></li>
        </ul>
    </div>
    <!-- 文字新闻 结束 -->
    <!-- 名家 开始 -->
    <div class="w330 right">
        <h3 class="huajia"><span class="right"><a href="#">更多>></a></span><strong class="f18 hei">推荐会员</strong></h3>
        <div class="k10"></div>
        <ul class="huajia_pic">
            <li><a href="#"><img src="img/hy1.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy2.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy3.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy4.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy5.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy6.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy7.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy8.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy9.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy7.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy8.jpg"><p class="huajia_t">画家名称</p></a></li>
            <li><a href="#"><img src="img/hy9.jpg"><p class="huajia_t">画家名称</p></a></li>
        </ul>
        <div class="clear"></div>
        <div class="k10"></div>
        <h3 class="tjhc_t"><strong class="f18 hei">最新会员</strong></h3>
        <div class="k10"></div>
        <ul class="tjhc_list">
            <li><a href="#">宗少山</a></li>
            <li><a href="#">宗燧岩</a></li>
            <li><a href="#">朱乃正</a></li>
            <li><a href="#">李文</a></li>
            <li><a href="#">阿年</a></li>
            <li><a href="#">王晓银</a></li>
            <li><a href="#">俞晓夫</a></li>
            <li><a href="#">孙建东</a></li>
            <li><a href="#">崔如琢</a></li>
            <li><a href="#">石虎</a></li>
            <li><a href="#">曾梵志</a></li>
            <li><a href="#">张晓刚</a></li>
            <li><a href="#">蔡玉水</a></li>
            <li><a href="#">宋雨桂</a></li>
            <li><a href="#">应天齐</a></li>
            <li><a href="#">张江舟</a></li>
            <li><a href="#">袁武</a></li>
            <li><a href="#">周韶华</a></li>
            <li><a href="#">尼玛泽仁</a></li>
            <li><a href="#">孙文启</a></li>
        </ul>
    </div>
    <div class="clear"></div>
    <script type="text/javascript">
        /*鼠标移过，左右按钮显示*/
        jQuery(".huajia_pic li").hover(function(){ jQuery(this).find(".huajia_t").stop(true,true).fadeTo("show",0.8) },function(){ jQuery(this).find(".huajia_t").fadeOut() });
    </script>
    <!-- 名家 结束 -->
    <div class="clear"></div>
    <div class="k20"></div>
    <div><img src="images/banner.jpg" width="1000" height="80"></div>
    <div class="k20"></div>
    <!-- 艺术展览 开始 -->
    <div class="lm_box" style="height:220px;">
        <h3 class="lm_tt3"><span class="right"><a href="#">即将开始</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">正在展览</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">展览回顾</a></span><strong class="f18 hei">艺术展览</strong></h3>
        <div class="k20"></div>
        <ul class="zhanlan_pic">
            <li><a href="#"><img src="img/zl1.jpg"><p>艺术展览</p></a></li>
            <li><a href="#"><img src="img/zl2.jpg"><p>艺术展览</p></a></li>
            <li><a href="#"><img src="img/zl3.jpg"><p>艺术展览</p></a></li>
            <li><a href="#"><img src="img/zl4.jpg"><p>艺术展览</p></a></li>
        </ul>
    </div>
    <!-- 艺术展览 结束 -->
    <div class="k20"></div>
    <!-- 学术知识 开始 -->
    <div class="lm_box" style="height:470px;">
        <h3 class="lm_tt3"><span class="right"><a href="#">艺术访谈</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">艺术技法</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">美术理论</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">知识课堂</a></span><strong class="f18 hei">学术知识</strong></h3>
        <div class="k20"></div>
        <div class="xs_left left">
            <h3 class="xs_tt1"><span class="right"><a href="#" class="more">更多>></a></span><span class="f16">艺术访谈</span></h3>
            <div class="k10"></div>
            <ul class="xs_list1">
                <li><span class="right hui">05/14</span><a class="f14" href="#">传承与衍革——画家魏明魏昆父子访谈</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">阙长山访谈录：近水居人淡字美</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">陆惟华油画作品展”策展人黄凯丽女士的对话</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">承古开今写春秋-访书法家邹武生</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">冷军：我们的写实油画比西方好得多</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">泰山胜迹图诗联书画艺术展”首展暨...</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">漆语三人行分享会之漆语心声</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">《美术纵横》吴陆升老师访谈录</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">李小山：尽量不做事后让自己脸红的事</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">庄文俊访谈（四）：广结中国文人的父亲</a></li>
            </ul>
        </div>
        <div class="xs_k left"></div>
        <div class="xs_center left">
            <h3 class="xs_tt2"><span class="right"><a href="#" class="more">更多>></a></span><span class="f16">艺术技法</span></h3>
            <div class="k10"></div>
            <ul class="xs_list2">
                <li><span class="right hui">05/14</span><a class="f14" href="#">传承与衍革——画家魏明魏昆父子访谈</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">阙长山访谈录：近水居人淡字美</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">陆惟华油画作品展”策展人黄凯丽女士的对话</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">承古开今写春秋-访书法家邹武生</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">冷军：我们的写实油画比西方好得多</a></li>
            </ul>
            <div class="k10"></div>
            <h3 class="xs_tt2"><span class="right"><a href="#" class="more">更多>></a></span><span class="f16">美术理论</span></h3>
            <div class="k10"></div>
            <ul class="xs_list2">
                <li><span class="right hui">05/14</span><a class="f14" href="#">陆惟华油画作品展”策展人黄凯丽女士的对话</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">承古开今写春秋-访书法家邹武生</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">冷军：我们的写实油画比西方好得多</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">泰山胜迹图诗联书画艺术展”首展暨...</a></li>
                <li><span class="right hui">05/14</span><a class="f14" href="#">漆语三人行分享会之漆语心声</a></li>
            </ul>
        </div>
        <div class="xs_k left"></div>
        <div class="xs_right left">
            <h3 class="xs_tt3"><span class="right"><a href="#"><img src="images/more.jpg" style="margin:10px 0 0 0;"></a></span><span class="f16 bai">知识课堂</span></h3>
            <ul class="xs_list3" style="background:#e3e3e3; padding:10px;">
                <li><a class="f14" href="#">策展人黄凯丽女士的对话</a></li>
                <li><a class="f14" href="#">承古开秋-访书法家邹武生</a></li>
                <li><a class="f14" href="#">我们的写实油画比西方好得多</a></li>
                <li><a class="f14" href="#">泰山胜迹图诗联书画艺首展暨...</a></li>
                <li><a class="f14" href="#">漆语三人行分享会之漆语心声</a></li>
                <li><a class="f14" href="#">策展人黄凯丽女士的对话</a></li>
                <li><a class="f14" href="#">承古开秋-访书法家邹武生</a></li>
                <li><a class="f14" href="#">我们的写实油画比西方好得多</a></li>
                <li><a class="f14" href="#">泰山胜迹图诗联书画艺首展暨...</a></li>
                <li><a class="f14" href="#">漆语三人行分享会之漆语心声</a></li>
                <li><a class="f14" href="#">策展人黄凯丽女士的对话</a></li>
                <li><a class="f14" href="#">承古开秋-访书法家邹武生</a></li>
            </ul>
        </div>
    </div>
    <!-- 学术知识 结束 -->
    <div class="k20"></div>
    <div><img src="images/banner.jpg" width="1000" height="80"></div>
    <div class="k20"></div>
    <!-- 名作欣赏 开始 -->
    <div class="lm_box" style="height:400px;">
        <h3 class="lm_tt3"><span class="right"><a href="#">国画</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">油画</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">书法</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">版画</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">雕塑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">水粉</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">水彩</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">素描</a></span><strong class="f18 hei">名作欣赏</strong></h3>
        <div class="k20"></div>
        <ul class="zhanlan_pic">
            <li><a href="#"><img src="img/zl1.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl2.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl3.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl4.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl1.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl2.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl3.jpg"><p>名作欣赏</p></a></li>
            <li><a href="#"><img src="img/zl4.jpg"><p>名作欣赏</p></a></li>
        </ul>
    </div>
    <!-- 名作欣赏 结束 -->
    <div class="k20"></div>
    <!-- 友情链接 开始 -->
    <div class="lm_box">
        <h3 class="lm_tt3"><strong class="f18 hei">友情链接</strong></h3>
        <div class="k20"></div>
        <a href="#">结构素描教程</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">经典语录大全</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">工艺品</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">书画艺术网</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">水墨中国</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">培训讲师</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">辉煌艺术网</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">搜藏网</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">中国书画艺术家协会</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#"></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">图文店</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">传统文化门户网</a>
    </div>
    <!-- 友情链接 结束 -->
</div>
<!-- 底部 -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</body>
</html>
