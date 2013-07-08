<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
	<div id="mainContainer" class="container">
<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form action="joinregistSample!registData" cssClass="form-search" cssStyle="padding: 0px 5px" >
				<s:if test="hasActionErrors()"><%-- ActionErrorsがある時だけにする --%>
				<div id="div_actionerror" class="alert alert-error">
					<s:actionerror />
				</div></s:if>
				<s:token/>
				<span class="label label-important">ID</span>
				<s:textfield type="text"  name="testDataInputEntity.person_id"  cssClass="input-medium search-query" placeholder="ID?"  ></s:textfield>
				<s:submit id="search" value="検索" cssClass="btn btn-primary"  action="selectSample" method="selectData" />
			</s:form>
		</div>
	</div><!-- /information-->

<s:if test="%{testDataEntity != null}">
	<div class="container-fluid"><!-- information-->
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<th>更新日</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="testDataEntity.person_id" /></td>
					<td><s:property value="testDataEntity.name" /></td>
					<td><s:property value="testDataEntity.age" /></td>
					<td><s:property value="testDataEntity.updt_date" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</s:if>

</div>

<div class="span1" ></div>


</div><!-- contents-->
</div><!-- container -->
</body>
</html>