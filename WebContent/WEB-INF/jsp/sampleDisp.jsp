<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param></s:include><%-- /共通Header呼び出し/ --%>
<body>
<script type="text/javascript">
<!--

	function selectData() {

		var form = document.getElementById("searchForm");

		form.action = "updateSample!selectData";
		form.submit();
	}

	function updateSample(person_id) {

		var form = document.getElementById("updateForm");

		form.action = "updateSample!updateDisplay";
		$('#updateId').val(person_id);
		form.submit();
	}

	function deleteSample(person_id) {

		if(window.confirm('対象データを削除します。本当によろしいですか。')){

			var form = document.getElementById("updateForm");

			form.action = "updateSample!deleteData";
			$('#updateId').val(person_id);
			form.submit();

		} else{

			window.alert('削除をキャンセルしました');

		}

	}

// -->
</script>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
<div class="hero-unit" style="margin-top: 40px;">
	<h1>ユーザー検索</h1>
	<p>ユーザーの検索を行います。</p>
</div>

<div class="row-fluid"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form id="searchForm" action="updateSample!selectData"  style="padding: 0px 5px"  class="form-search">
				<div id="div_actionerror">
					<font size="3px" color="#ff0000"><s:actionerror /></font>
				</div>
				<s:token/>
				<span class="label label-important">ID</span>
				<s:textfield type="text"  name="testDataInputEntity.person_id"  cssClass="input-medium search-query" placeholder="ID?"></s:textfield>
				<span class="label label-important">名前</span>
				<s:textfield type="text"  name="testDataInputEntity.name"  cssClass="input-xlarge search-query" placeholder="NAME?"></s:textfield>
				<button type="submit" id="search" class="btn btn-primary"><i class="icon-search"></i>検索</button>
			</s:form>
		</div>
	</div><!-- /information-->

<s:if test="%{testDataEntityList != null}">
	<!-- 段組みの入れ子。親となるspan10を分割する -->
	<div class="row">
		<div class="span2"></div>
		<div class="span6">
			<div class="container-fluid"><!-- information-->
				<form id="updateForm">
				<s:hidden id="updateId" name='testDataInputEntity.person_id' value='' />
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>操作</th>
							<th style="width: 46px;">ID</th>
							<th style="width: 154px;">名前</th>
							<th style="width: 46px;">年齢</th>
							<th style="width: 84px;">更新日</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="testDataEntityList" var="dto">
						<tr>
							<td style="width: 130px;">
								<div class="btn-group">
									<button class ="btn btn-mini btn-danger" style="height:60p; font-weight: bold; vertical-align:middle;" onClick="updateSample('${person_id}')"><i class="icon-edit"></i>更新</button>
									<button class ="btn btn-mini btn-inverse" style="height:60p; font-weight: bold; vertical-align:middle;" onClick="deleteSample('${person_id}');return false;"><i class="icon-remove icon-white"></i>削除</button>
								</div>
							</td>
							<td><s:property value="person_id" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="age" /></td>
							<td><s:date name="updt_date" format="yyyy/MM/dd"/></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
			</form>
			</div>
		</div>
		<div class="span2"></div>
	</div>
</s:if>

</div>
<div class="span1" ></div>

</div><!-- contents-->

</body>
</html>