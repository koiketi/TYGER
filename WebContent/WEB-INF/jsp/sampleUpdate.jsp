<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param></s:include><%-- /共通Header呼び出し/ --%>
<body>
	<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<!-- 段組みの入れ子。親となるspan10を分割する -->
	<div class="row">
		<div class="span2"></div>
		<div class="span6">
			<div class="container-fluid"><!-- information-->
				<H3>取得結果</H3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="10%">ID</th>
							<th width="60%">名前</th>
							<th width="10%">年齢</th>
							<th width="20%">更新日</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="10%"><s:property value="testDataEntityTarget.person_id" /></td>
							<td width="60%"><s:property value="testDataEntityTarget.name" /></td>
							<td width="10%"><s:property value="testDataEntityTarget.age" /></td>
							<td width="20%"><s:property value="testDataEntityTarget.updt_date" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="span2"></div>
	</div>

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form action="updateSample" cssClass="form-inline"  cssStyle="padding: 0px 5px" >
				<div id="div_actionerror">
					<font size="3px" color="#ff0000"><s:actionerror /></font>
				</div>
				<H3>更新内容入力</H3>
				<s:token/>
				<span class="label">ID</span>
				<s:textfield type="text" readonly="true"  name="testDataInputEntity.person_id" value="%{testDataEntityTarget.person_id}"  cssClass="input-medium" placeholder="ID?"  ></s:textfield>
				<span class="label label-important">名前</span>
				<s:textfield type="text" name="testDataInputEntity.name" value="%{testDataEntityTarget.name}" cssClass="input-xlarge" placeholder="NAME?"  ></s:textfield>
				<span class="label label-important">年齢</span>
				<s:textfield type="text" name="testDataInputEntity.age" maxlength="3" value="%{testDataEntityTarget.age}" cssClass="input-mini" placeholder="AGE?"  ></s:textfield>
				<s:submit id="update" value="更新" cssClass="btn btn-primary"  action="updateSample" method="updateData" />
				<s:reset cssClass="btn btn-inverse" value="リセット" />
				<s:hidden name='testDataEntityTarget.person_id' value='%{testDataEntityTarget.person_id}' />
				<s:hidden name='testDataEntityTarget.name' value='%{testDataEntityTarget.name}' />
				<s:hidden name='testDataEntityTarget.age' value='%{testDataEntityTarget.age}' />
				<s:hidden name='testDataEntityTarget.updt_date' value='%{testDataEntityTarget.updt_date}' />
			</s:form>
		</div>
	</div><!-- /information-->

</div>
<div class="span1" ></div>


</div><!-- contents-->

</body>
</html>