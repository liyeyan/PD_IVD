<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/include.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  	<link rel="stylesheet" type="text/css" href="${ctx}/easyui1_5/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/easyui1_5/themes/icon.css">
	<script type="text/javascript" src="${ctx}/easyui1_5/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/easyui1_5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/easyui1_5/datagrid-filter.js"></script>

</head>

<body>
<form action="detailList.html"  method="post" name="queryForm" id="queryForm">
<input type="hidden" name="id" value="${batchId }" style="scinput" />
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${ctx}/batch.html">首页</a></li>
    <li><a href="${ctx}/batch.html">信息管理</a></li>
    <li><a href="${ctx}/batch.html">批次信息</a></li>
    <li><a href="#">查看详情</a></li>
    </ul>
    </div>

    <div class="formbody">


    <div id="usual1" class="usual">

  	<div id="tab2" class="tabson">
		<ul class="seachform">
			<li><label></label><input type="text" name="sampleId" id="sampleId" class="scinput" value="" style="width:100px;"/></li>
			<li><label></label><input type="text" name="name" id="name" class="scinput" value="" style="width:100px;"/></li>
			</li>
			<ul class="toolbar">
				<li onclick="javascript:search();"><span><img src="../images/t04.png"/></span>查询</li>
			</ul>
		</ul>


		<ul class="seachform">
	        <li><label>&nbsp;</label><input name="" type="button" class="btn" onclick="doBack()" value="返回"></li>
    </ul>
		<table class="tablelist">
			<thead>
			<tr>
				<th width="50px">编号<i class="sort"></i></th>
				<th width="100px">食品次亚类</th>
				<th width="100px">包装分类</th>
				<th width="100px">区域类型</th>
				<th width="100px">抽样地点</th>
				<th width="100px">抽样环节</th>
				<th width="100px">抽样省</th>
				<th width="100px">样品状态</th>
				<th width="100px">样品类型</th>
				<th width="100px">生产省</th>
				<th width="100px">经济地带</th>
				<th width="100px">抽样季度</th>
				<th width="100px">生产季度</th>
				<th width="100px"> 保质率</th>
				<th width="100px">年销售额</th>
				<th width="100px">山梨酸</th>
				<th width="100px">亚硝酸盐</th>
				<th width="100px">铅</th>
				<th width="100px">铬</th>
				<th width="100px">镉</th>
				<th width="100px">检测结果</th>

			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${not empty sampleList}">
					<c:forEach items="${sampleList}" var="sample" varStatus="vs">
						<tr>
							<td>${vs.index+1}</td>
						<td>${sample.foodSubclass}</td>
						<td>${sample.packing}</td>
							<td>${sample.area}</td>
							<td>${sample.location}</td>
							<td>${sample.link}</td>
							<td>${sample.province}</td>
							<td>${sample.sampleState}</td>
							<td>${sample.sampeType}</td>
							<td>${sample.productionProvince}</td>
							<td>${sample.zone}</td>
							<td>${sample.sampleQuarter}</td>
							<td>${sample.productionQuarter}</td>
							<td>${sample.guaranteeQualityRate}</td>
							<td>${sample.salesVolume}</td>
							<td>${sample.sorbicAcid}</td>
							<td>${sample.nitrite}</td>
							<td>${sample.lead}</td>
							<td>${sample.chromium}</td>
							<td>${sample.cadmium}</td>
							<td>${sample.resultD}</td>

						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="20">没有相关数据</td>
					</tr>
				</c:otherwise>
			</c:choose>

			</tbody>
		</table>
    ${sample.page.pageStr }
     <br/>
    </div>

	</div>
	<script type="text/javascript">
      $("#usual1 ul").idTabs();
    </script>

    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





    </div>

</form>
</body>

</html>
