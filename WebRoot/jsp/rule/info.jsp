<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html lang="true">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${ctx }/css/styleForybcx.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui1_5/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui1_5/themes/icon.css">
    <script type="text/javascript" src="${ctx}/easyui1_5/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui1_5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui1_5/datagrid-filter.js"></script>
    <style type="text/css">
    body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
    .scinput{width:300px;height:20px;line-height:20px;}
    .info{height:40px;line-height:40px;margin-left: 300px; }
    .info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
    .info td{text-align:left;}
    </style>
</head>

<body>
<form action="save.html" method="post" name="queryForm" id="queryForm">
    <input type="hidden" name="id" value="${id }"/>
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="${ctx}/batch.html">首页</a></li>
            <li><a href="${ctx}/batch.html">风险管理</a></li>
            <li><a href="${ctx}/batch.html">规则管理</a></li>
            <li><a href="#">新增规则</a></li>
        </ul>
    </div>

    <div class="formbody">


        <div id="usual1" class="usual">

            <div id="tab2" class="tabson">
                <div class="formtitle"><span>规则信息</span></div>
                <table border="0" cellpadding="0" cellspacing="0" style="margin-left: 35%">
                    <tr class="info">
                        <th>规则类型:</th>
                        <td>
                            <select name="ruleType" id="ruleType"  class="scinput" onchange="getRule()">
                                <option value="-1">请选择</option>
                                <option value="1">基本规则</option>
                                <option value="2">组合规则</option>
                            </select>
                        </td>
                    </tr>
                    <div id="assRule">
                        <tr class="info">
                            <th>关联规则:</th>
                            <td>
                                <select name="assModel" id="assModel"  class="scinput">
                                    <option value="-1">请选择</option>
                                    <option value="1">规则1</option>
                                    <option value="2">规则2</option>
                                    <option value="3">规则3</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="info">
                            <th>组合模式:</th>
                            <td>
                                <select name="assModel" id="assModel"  class="scinput">
                                    <option value="-1">请选择</option>
                                    <option value="1">顺序关系</option>
                                    <option value="2">集合关系</option>
                                    <option value="3">或者关系</option>
                                </select>
                            </td>
                        </tr>

                    </div>
                    <div id="baseRule">
                        <tr class="info">
                            <th>规则名称:</th>
                            <td><input type="text" name="ruleName" id="ruleName" maxlength="30"  class="scinput"  value="${rule.ruleName }"  maxlength="30"/></td>
                        </tr>
                        <tr class="info">
                            <th>关联类型:</th>
                            <td>
                                <select name="assType" id="assType"  class="scinput" onchange="myFunction()">
                                    <option value="-1">请选择</option>
                                    <option value="1">抽检地区</option>
                                    <option value="2">生产地区</option>
                                    <option value="3">食品分类</option>
                                    <option value="4">包装分类</option>
                                    <option value="5">区域类型</option>
                                    <option value="6">检测项目</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="info">
                            <th>关联对象:</th>
                            <td>
                                <select name="type2" id="type2"  class="scinput" style="width: 145px;" onchange="myFunction2()">
                                    <option value="-1">请选择</option>
                                </select>
                                <select name="assObj" id="assObj"  class="scinput" style="width: 150px;">
                                    <option value="-1">请选择</option>
                                }
                                </select>
                            </td>
                        </tr>
                        <tr class="info">
                            <th>阈值:</th>
                            <td><input type="text" name="rate" id="rate" maxlength="3" class="scinput" style="width: 50px" value="${rule.rate }"/>&nbsp;%&nbsp;&nbsp;&nbsp;请填写1-100，超出范围系统将发出预警。</td>
                        </tr>
                        <tr class="info">
                            <th>检测时间:</th>
                            <td>
                                <input type="text" name="ruleTimeF" id="ruleTimeF" class="scinput" style="width: 145px;" value="${rule.ruleTimeF }" onclick="WdatePicker()"/>
                                <input type="text" name="ruleTimeT" id="ruleTimeT" class="scinput" style="width: 150px;" value="${rule.ruleTimeT }" onclick="WdatePicker()"/>
                            </td>
                        </tr>
                        <tr class="info">
                            <th>预警时机:</th>
                            <td>
                                <select name="warnTime" id="warnTime" class="scinput" style="width: 145px;" onchange="myFunction3()">
                                    <option value="-1">请选择</option>
                                    <option value="1">立即触发</option>
                                    <option value="2">定时触发</option>
                                </select>
                                <input id="tips" type="hidden" value="每天早上9:00预警。"></input>
                            </td>
                        </tr>
                        <tr class="info">
                            <th>事件类型:</th>
                            <td>
                                <select name="warnType" id="warnType" class="scinput">
                                    <option value="-1">请选择</option>
                                    <option value="1">邮件通知</option>
                                    <option value="2">短信通知</option>
                                </select>
                            </td>
                        </tr>
                    </div>
                </table>
                <br/><br/>
                <input name="" id="send" type="button" class="btn" onclick="save()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="" id="back" type="button" class="btn" onclick="history.go(-1)" value="返回"/>
                <br/>


            </div>

        </div>

    </div>

</form>


<script type="text/javascript">

    function getRule() {
        $("#assRule").attr("style","display:none;");
        var type=$("#ruleType").val();
        if (type==1) {
        //1是基本规则 2是组合规则
            console.log(type);
            //$("#baseRule").show();
            //$("#assRule").hide();
        }else{
            //$("#baseRule").hide();
            //$("#assRule").show();
        }
    }
    function myFunction(){
        $("#assObj").empty().append("<option value='-1'>请选择</option>");
        var type1=$("#assType").val();
        if (type1==1 || type1==2) {
            $("#type2").show().empty().append("<option value='-1'>请选择</option>");
            $("#assObj").css('width','150px');
            $.ajax({
                url:'${pageContext.request.contextPath}/rule/district.html',
                type:'post',
                async:false,
                data:{'level':1},
                dataType:'json',
                contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                success:function(data){
                    for(var i=0;i<data.length;i++) {
                        $("#type2").append("<option value='"+data[i].id+"'>"+data[i].district+"</option>");//新增

                    }
                }
            });
        }else {
            $("#type2").hide();
            $("#assObj").css('width','300px');
            if(type1==3){
                $("#assObj").append("<option value='粮食加工品'>粮食加工品</option>").append("<option value='调味品'>食用油、油脂及其制品</option>")
                    .append("<option value='调味品'>调味品</option>").append("<option value='肉制品'>肉制品</option>")
                    .append("<option value='乳制品'>乳制品</option>").append("<option value='散装'>食用油、油脂及其制品</option>")
                    .append("<option value='方便食品'>方便食品</option>").append("<option value='饮料'>饮料</option>")
                    .append("<option value='罐头'>罐头</option>").append("<option value='饼干'>饼干</option>")
                    .append("<option value='冷冻饮品'>冷冻饮品</option>").append("<option value='速冻食品'>速冻食品</option>")
                    .append("<option value='薯类和膨化食品'>薯类和膨化食品</option>").append("<option value='糖果制品'>糖果制品</option>")
                    .append("<option value='茶叶及相关制品'>茶叶及相关制品</option>").append("<option value='酒类'>酒类</option>")
                    .append("<option value='蔬菜制品'>蔬菜制品</option>").append("<option value='水果制品'>水果制品</option>")
                    .append("<option value='炒货食品及坚果制品'>炒货食品及坚果制品</option>").append("<option value='蛋制品'>蛋制品</option>")
                    .append("<option value='可可及烘焙咖啡产品'>可可及烘焙咖啡产品</option>").append("<option value='食糖'>食糖</option>")
                    .append("<option value='水产制品'>水产制品</option>").append("<option value='淀粉及淀粉制品'>淀粉及淀粉制品</option>")
                    .append("<option value='糕点'>糕点</option>").append("<option value='豆制品'>豆制品</option>")
                    .append("<option value='蜂产品'>蜂产品</option>").append("<option value='保健食品'>保健食品</option>")
                    .append("<option value='特殊医学用途配方食品'>特殊医学用途配方食品</option>").append("<option value='婴幼儿配方食品'>婴幼儿配方食品</option>")
                    .append("<option value='特殊膳食食品'>特殊膳食食品</option>").append("<option value='其他食品'>其他食品</option>")
                    .append("<option value='食品添加剂'>食品添加剂</option>");


            }else if(type1==4){
                $("#assObj").append("<option value='预包装'>预包装</option>").append("<option value='散装'>散装</option>");
            }else if(type1==5){
                $("#assObj").append("<option value='城市'>城市</option>").append("<option value='乡村'>乡村</option>")
                .append("<option value='景点乡镇'>景点乡镇</option>");
            }else if(type1==6){
                $("#assObj").append("<option value='城市'>城市</option>").append("<option value='乡村'>乡村</option>")
                    .append("<option value='景点乡镇'>景点乡镇</option>");
            }
        }


    }
    function myFunction2(){
        $("#assObj").empty().append("<option value='-1'>请选择</option>");
        var type2=$("#type2").val();
        if (type2!=-1) {
            $.ajax({
                url:'${pageContext.request.contextPath}/rule/district.html',
                type:'post',
                async:false,
                data:{'pId':type2,'level':2},
                dataType:'json',
                contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                success:function(data){
                    for(var i=0;i<data.length;i++) {
                        $("#assObj").append("<option value='"+data[i].district+"'>"+data[i].district+"</option>");//新增

                    }
                }
            });
        }
    }

    function myFunction3(){
        var warnTime=$("#warnTime").val();
        console.log(warnTime);
        if (warnTime==2) {
            $("#tips").show();
        }else {
            $("#tips").hide();
        }

    }
    function save(){

        $("#queryForm").submit();
    }
</script>
</body>

</html>