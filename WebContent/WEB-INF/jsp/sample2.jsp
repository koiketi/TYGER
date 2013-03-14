<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.1.js"></script>

<script type="text/javascript">
<!--
$(document).ready(function() {
	$('#search').click(function() {

		$("#disp_out").hide();
		$("#loading").show();

		$.post(
				$('#selectSample2').attr('action'),  // post-url
				// post-data
				{
					'struts.token.name': $('#selectSample2 [name=struts\\.token\\.name]').val(),
					'struts.token': $('#selectSample2 [name=struts\\.token]').val(),
					'testDataInputEntity.person_id': $('#selectSample2_testDataInputEntity_person_id').val(),
					'method:selectData2': $('#search').val()

				},
				function(testDataEntity, textStatus ) {
					$("#loading").fadeOut(function() {
						$("#disp_out").show();
					});
					$('#disp_person_id').text(testDataEntity.person_id);
					$('#disp_name').text(testDataEntity.name);
					$('#disp_age').text(testDataEntity.age);
					$('#disp_upate_date').text(testDataEntity.updt_date);
				},
				'json'
		);
		return false;
	});
});

// -->
</script>
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
			<s:form action="selectSample2" cssClass="form-search" cssStyle="padding: 0px 5px" >
				<s:token/>
				<span class="label label-important">ID</span>
				<s:textfield type="text"  name="testDataInputEntity.person_id"  cssClass="input-medium search-query" placeholder="ID?"  ></s:textfield>
				<s:submit id="search" value="検索" cssClass="btn btn-primary"  method="selectData2" />

			</s:form>
		</div>
	</div><!-- /information-->

	<div id="loading" style="display:none;text-align:center;"><img src="img/loading.gif" /></div>
	<div class="container-fluid" id="disp_out"><!-- information-->
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
					<td><span id="disp_person_id"></span></td>
					<td><span id="disp_name"></span></td>
					<td><span id="disp_age"></span></td>
					<td><span id="disp_upate_date"></span></td>
				</tr>
			</tbody>
		</table>
	</div>

</div>

<div class="span1" ></div>


</div><!-- contents-->
</div><!-- container -->
</body>
</html>