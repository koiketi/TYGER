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
<link href="css/bootstrap_custom.css" rel="stylesheet">

<title>Sample system</title>
</head>
<body>

<div class="navbar navbar-fixed-top"> <!--navbar-->
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			<a class="brand" href="./">Sample system</a>
			<div class="nav-collapse">
			</div>
		</div>
	</div>
</div> <!--/navbar-->

<!-- contents1可変-->
<div class="row-fluid" style="padding-top:60px">
	<div class="span12 well">class="row-fluid"は可変。入れ子にした場合は入れ子の中の合計が12となるようにする。</div>
</div>

<div class="row-fluid" style="padding-top:5px; border:1px solid gray;">
	<div class="span12">
		<div>
			<hr style=" height: 4px; background-color: #ad3140;">
			<center><h1>ログイン画面</h1></center>
			<hr style=" height: 4px; background-color: #ad3140;">
		</div>
	</div>
</div>
<div class="row-fluid" style="padding-top:20px; border:1px solid gray;">
	<div class="span1" style="border:1px solid gray; background-color: #ffffff;">左(span1)</div>
	<div class="span10" style="border:1px solid gray;">
		<div style="border:1px solid gray; background-color: #cccccc;">
			span10の親(可変なのでこの中の合計は「12」)
		</div>
		<div class="row-fluid">
			<div class="span1" style="border:1px solid gray; background-color: #ff0000;">入れ子１(span1)</div>
			<div class="span2" style="border:1px solid gray; background-color: #00ff00;">入れ子２(span2)</div>
			<div class="span6" style="border:1px solid gray;">
				<div class="container-fluid"><!-- information-->
					<span>入れ子３(span6)</span>
					<s:form action="login" class="form-horizontal">
						<div class="control-group">
							<span class="label label-important">ID</span>
							<s:textfield name="employeeId" cssClass="input-medium" placeholder="ID?" />
						</div>
						<div class="control-group">
							<span class="label label-important">PASSWORD</span>
							<s:password name="employeePassword" cssClass="input-xlarge" placeholder="PASSWORD?" />
						</div>
						<div class="form-actions">
							<s:submit id="loging" value="ログイン" cssClass="btn btn-primary" action="login" method="login"></s:submit>
						</div>
					</s:form>
				</div><!-- /information-->
			</div>
			<div class="span2" style="border:1px solid gray; background-color: #ffff00;">入れ子４(span2)</div>
			<div class="span1" style="border:1px solid gray; background-color: #00ffff;">入れ子５(span1)</div>
		</div>
	</div>
	<div class="span1"  style="border:1px solid gray; background-color: #ffffff;">右(span1)</div>
</div><!-- contents-->

<hr style="height:4px; border-width:1px;"/>

<!-- contents2固定-->
<div class="row" style="padding-top:10px">
	<div class="span12">
		<blockquote class="well">class="row"は固定。 幅は940px固定。この枠の幅が940px。入れ子にした場合は入れ子の中の合計が元と同じになるようにする。</blockquote>
	</div>
</div>
<div class="row" style="padding-top:5px; border:1px solid gray;">
	<div class="span12" style="border:1px solid gray;">
		<div>
			<hr style=" height: 4px; background-color: #ad3140;">
			<center><h1>ログイン画面</h1></center>
			<hr style=" height: 4px; background-color: #ad3140;">
		</div>
	</div>
</div>
<div class="row" style="padding-top:20px; border:1px solid gray;">
	<div class="span1" style="background-color: #ff00ff;">固定左(span1)</div>
	<div class="span10" style="border:1px solid gray;">
		<div style="border:1px solid gray; background-color: #cccccc;">
			span10の親(固定なのでこの中の合計は「10」としなければならない)
		</div>
		<div class="row">
			<div class="span3" style="background-color: #ff0000;">入れ子１(span3)</div>
			<div class="span4" style="background-color: #0000ff;">
				<div class="container"><!-- information-->
					<span style="color:white;">入れ子２(span4)</span>
				</div><!-- /information-->
			</div>
			<div class="span3" style="background-color: #00ff00;">入れ子３(span3)</div>
		</div>
	</div>
	<div class="span1"  style="border:1px solid gray; background-color: #ffffff;">固定右(span1)</div>
</div><!-- contents-->

</body>
</html>