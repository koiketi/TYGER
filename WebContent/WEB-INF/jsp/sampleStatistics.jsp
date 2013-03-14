<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.custom.js"></script>
<script type="text/javascript" src="./js/i18n/jquery.ui.datepicker-ja.js"></script>
<script type="text/javascript">
<!--

	// datepcikerの最小、最大値
	var datepickerMin = '2013/01/01';
	var datepickerMax = '2013/12/31';

	// 検索タイプ変更時の動作
	function changeSearchType() {

		// チェックされているradioの値を取得する
		var optRadioVal = $('input[name="statisticsInput.statisticsAggregateUnitEnum"]:checked').attr('value');

		// Radioボタンの値で判断
		if (optRadioVal == 'monthly') {
			// 月次は設定不可能なのでdisabledにし、アイコンを隠す
			$('div#dpStart > *').attr('disabled', 'disabled');
			$('div#dpEnd > *').attr('disabled', 'disabled');
		} else if (optRadioVal == 'daily') {
			// 日次は期間設定可能なのでdisabled要素を削除。アイコンを再表示
			$('div#dpStart > *').removeAttr('disabled');
			$('div#dpEnd > *').removeAttr('disabled');
		}
	}

	$(document).ready(function(){

		// datepickerの初期化
		$.datepicker.setDefaults($.datepicker.regional["ja"]); // 日本語化

		// From
		$('#statisticsForm_statisticsInput_startDate').datepicker(
				{
					showOn: "both", // ボタンとフィールドどちらも表示
					buttonImage: "./img/calendar.png",
					buttonImageOnly: true, // ボタンではなく画像のみ表示。
					buttonText: "",
					minDate: datepickerMin,
					maxDate: datepickerMax
				}
				);

		// To
		$('#statisticsForm_statisticsInput_endDate').datepicker(
				{
					showOn: "both", // ボタンとフィールドどちらも表示
					buttonImage: "./img/calendar.png",
					buttonImageOnly: true, // ボタンではなく画像のみ表示。
					buttonText: "",
					minDate: datepickerMin,
					maxDate: datepickerMax
				}
				);

		// 初期化後にRadioボタン状況判断を即実行
		changeSearchType();

		// radioが変更されたときに動作する
		$('input[name="statisticsInput.statisticsAggregateUnitEnum"]')
				.change(function() {

					changeSearchType();
				});

	});

// -->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/sysstyle.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap_United.css" rel="stylesheet"><!-- bootstrapのUnited -->
	<link href="./css/jquery-ui.custom.css" rel="stylesheet" type="text/css">
</head>
<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
	<div id="mainContainer" class="container">

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form id="statisticsForm" action="registSample" cssClass="form-horizontal" cssStyle="padding: 0px 5px" >
				<div id="div_actionerror">
					<font size="3px" color="#ff0000"><s:actionerror /></font>
				</div>
				<s:token/>
				<div class="label label-important">詳細</div>
				<div class="control-group">
					<label class="control-label">集計単位</label>
					<div class="controls">
						<input type="radio" name="statisticsInput.statisticsAggregateUnitEnum" id="optionsRadios1" value="daily" checked="checked">日別集計
						<input type="radio" name="statisticsInput.statisticsAggregateUnitEnum" id="optionsRadios2" value="monthly">月別集計
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">集計期間</label>
					<div class="input-append date" id="dpStart">
						<input class="input-small" id="statisticsForm_statisticsInput_startDate" name="statisticsInput.startDate" maxlength="10" type="text">
					</div>
					～
					<div class="input-append date" id="dpEnd" data-date="2012-12-31">
						<input class="input-small" id="statisticsForm_statisticsInput_endDate" name="statisticsInput.endDate" maxlength="10" type="text" value="2012-12-31">
					</div>
				</div>
				<div class="form-actions">
					<s:submit id="regist" value="登録" cssClass="btn btn-primary"  action="registSample" method="registData" />
					<s:reset cssClass="btn btn-danger" value="リセット" />
				</div>
			</s:form>
	    </div>
	</div><!-- /information-->

</div>
<div class="span1" ></div>


</div><!-- contents-->
</div><!-- container -->
</body>
</html>