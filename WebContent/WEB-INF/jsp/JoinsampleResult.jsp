<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript">
<!--
	function clearFormInput() {
		displayElement(document.getElementById('div_actionerror'), 'none');
		clearForm(document.Login);
	}
// -->
</script>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
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
				<H3>実行結果</H3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="40%">名前</th>
							<th width="60%">メールアドレス</th>
							<th width="10%">数字キー</th>
							<th width="60%">コメント</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="40%"><s:property value="joinDataEntityTarget.user_name" /></td>
							<td width="60%"><s:property value="joinDataEntityTarget.mailaddress" /></td>
							<td width="10%"><s:property value="joinDataEntityTarget.key" /></td>
							<td width="60%"><s:property value="joinDataEntityTarget.comment" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="span2"></div>
	</div>

<a href="menu">menuへ</a>
</div>
<div class="span1" ></div>

</div><!-- contents-->


</body>
</html>