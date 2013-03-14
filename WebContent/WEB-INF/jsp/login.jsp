<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
<body onload="defaultFocus()">

<s:include value="/WEB-INF/jsp/navbarBlank.jsp"></s:include><%-- /共通navbar呼び出し/--%>

<!-- 初期表示時のfocus設定処理。各画面に実装する -->
<script type="text/javascript">
<!--
	// 初期表示時のfocus設定処理
	function defaultFocus() {
		// ※名称が重複していないこと前提
		var focusTarget = document.getElementsByName('employee.employeeId');
		focusTarget[0].focus();
	}
// -->
</script>
	<div id="mainContainer" class="container">
		<div class="row"><!-- error表示領域 -->
			<div class="offset2 span8">
				<div class="control-group" >
	<s:if test="hasActionErrors()"><%-- ActionErrorsがある時だけにする --%>
					<div class="alert alert-error"><s:actionerror /></div>
	</s:if>
	<s:else>
				<div class="alert alert-error" style="background-color:#ffffff; border-color:#ffffff; padding:10px 35px 10px 14px;">
					<br />
				</div>
	</s:else>
				</div>
			</div>
			<div class="offset2"></div>
		</div>
	</div><!-- error表示領域 -->
	<div class="container"><!-- contents -->
		<div class="row">
			<div class="offset2 span8">
				<div class="row"><!-- information-->
					<s:form id="loginForm" action="login!login" cssClass="form-horizontal">
						<div class="control-group" style="vertical-align:middle;">
							<div class="span2" style="text-align: right;">
								<span class="inputLabel">ＩＤ</span>
							</div>
							<div class="span6" style="text-align: left;">
								<s:textfield cssClass="input-large" name="employee.employeeId" maxlength="16" placeholder="ID?" autocomplete="off"/>
							</div>
						</div>
						<div class="control-group" style="vertical-align:middle;">
							<div class="span2" style="text-align: right;">
								<span class="inputLabel">パスワード</span>
							</div>
							<div class="span6" style="vertical-align:middle; text-align: left;">
								<s:password cssClass="input-large" name="employee.password" maxlength="20" placeholder="PASSWORD?" autocomplete="off"/>
							</div>
						</div>
						<div class="row">
							<div class="span8" style="text-align: center;">
								<s:submit id="loging" value="　ログイン　" cssClass="btn btn-danger btn-large"
									action="login" method="login" text-algin="center"></s:submit>
							</div>
						</div>
					</s:form>
				</div><!-- /information-->
			</div>
			<div class="offset2"></div>
		</div>
	</div><!-- contents -->
</body>
</html>