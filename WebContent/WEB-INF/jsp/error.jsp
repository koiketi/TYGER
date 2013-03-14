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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/sysstyle.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap_United.css" rel="stylesheet">

<title>System Error!!!</title>
</head>
<body>
<s:include value="/WEB-INF/jsp/navbarBlank.jsp"></s:include><%-- /共通navbar呼び出し/--%>
<div class="row-fluid" style="padding-top:60px"><!-- contents-->
	<div class="span1" ></div>
		<div class="span10">
			<div class="container-fluid"><!-- information-->
				<div class="well well-large alert alert-error"><!-- エラーメッセージ出力箇所 -->
					<p>システムエラーが発生しました。大変お手数おかけいたしますが、システム管理者までご連絡ください。</p>
					<H3>Error Message</H3>
					<P><s:property value="exception.message" /></P>
					<H3>Technical Details</H3>
					<P><s:property value="exceptionStack" /></P>
			    </div>
			</div><!-- /information-->
		</div>
	<div class="span1" ></div>

</div><!-- contents-->

</body>
</html>