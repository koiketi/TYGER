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
<title>Sample system</title>
</head>
<body>
	<table border="0px" width="100%">
		<tr>
			<td align="left"><span class="header_font"><I>
						Sample</I></span></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<hr>
	<s:form action="Login">
		<div id="div_actionerror">
			<font size="3px" color="#ff0000"><s:actionerror /></font>
		</div>
		<br>
		<br>
		<br>
		<div class="login">
			<table class="tbl_login" border="0" width="100%">
				<tr>
					<td width="80pt">ログインID</td>
					<td><s:textfield style="width:120px" name="loginUser.id"
							value="%{#session.erruserid}" /></td>
				</tr>
				<tr>
					<td width="80pt">パスワード</td>
					<td><s:password style="width:120px" name="loginUser.password" /></td>
				</tr>
			</table>
			<table>
				<tr style="height: 50pt;" >
					<td>　　　　<s:submit id="login" cssClass="defaultbutton" value="ログイン" /></td>
					<td>　　<input type="button" value="キャンセル" class="defaultbutton"
						onClick="clearFormInput();"></td>
				</tr>
			</table>
		</div>
		<br>
		<br>
	</s:form>
</body>
</html>