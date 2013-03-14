<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="css/sysstyle.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap_custom.css" rel="stylesheet">

<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui-1.9.1.custom.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--



$(document).ready(function() {


	jQuery( function() {
	    $('#myModal').draggable();
	} );

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
					if(testDataEntity!=null){
						$('#disp_person_id').text(testDataEntity.person_id);
						$('#disp_name').text(testDataEntity.name);
						$('#disp_age').text(testDataEntity.age);
						$('#disp_upate_date').text(testDataEntity.update_date);
					}else{

					}
					$("#loading").fadeOut(function() {
						$("#disp_out").show();
					});
									},
				'json'
		);
		return false;
	});

	// btn_modalボタン押下
	// $.ajaxでの同期通信
	$('#btn_modal').click(function() {

		$("#errorField").hide();
		$("#errorStr").text("");
		var retText = $.ajax({

			async: false,
			url: "/Sample/selectSample3.action",
			type: "POST",
			data: "testDataInputEntity.point="+$('#pointchange_testDataInputEntity_point').val()+"&method:inputCheck="+$('#search').val(),
			dataType: 'json',
			timeout: 1000,
			error: function(){
				$("#errorStr").text("システムが正常に動作していません。システム管理者にお問い合わせ下さい。");
				$("#errorField").show();
				return false;
 			}
		}).responseText;

		if(JSON.parse(retText)=="success"){
			$("#errorStr").text("");
			$("#errorField").hide();
			return true;

		}else{
			$("#errorStr").text(JSON.parse(retText));
			$("#errorField").show();
			return false;
		}

	});



	// btn_executeボタン押下
	// $.postでの非同期通信
	$('#btn_execute').click(function() {
		$('#myModal').modal('hide');
		document.pointchange.submit();

	});

});

// -->
</script>
</head>
<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
	<div id="mainContainer" class="container">

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid">
		<div class="well well-large">
			<s:form action="selectSample2" cssClass="form-search" cssStyle="padding: 0px 5px" >
				<s:token/>
				<span class="label label-important">ID</span>
				<s:textfield type="text"  name="testDataInputEntity.person_id"  cssClass="input-medium search-query" placeholder="ID?"  ></s:textfield>
				<s:submit id="search" value="検索" cssClass="btn btn-primary"  method="selectData2"  />

			</s:form>
		</div>
	</div><!-- /information-->

	<div class="container-fluid">
		<div id="loading" style="display:none;text-align:center;"><img src="img/loading.gif" /></div>
	</div>
	<div class="container-fluid" id="disp_out">
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

	<div class="container"><!-- error表示領域 -->
		<div class="row">
			<div class="control-group" id="errorField"  style="display:none;text-align:center;">
					<div class="alert alert-error"><span id="errorStr"></span></div>
			</div>
		</div>
	</div><!-- error表示領域 -->

	<div class="container-fluid">
		<s:form action="pointchange" cssClass="form-horizontal " >
		<div class="control-group" style="vertical-align:middle;">
			<div class="span6" style="text-align: left;">
				<s:textfield value="%{testDataInputEntity.point}" cssStyle="text-align: right;" cssClass="input-large " name="testDataInputEntity.point" />
				<span style=" font-size: 80%; vertical-align: middle; font-weight:bold;">P</span>
			</div>
		</div>
		<div class="control-group" style="vertical-align:middle;">
			<div class="span6" style="vertical-align:middle; text-align: left;">
				<s:textarea  name="customerUpdate.customerNoteUpdate" rows="3"  />
			</div>
		</div>
		<s:token/>
		<input type="hidden" name="method:pointChange" value="" />
		<div class="row">
			<div class="span8" style="text-align: center;">
				<a href="#myModal" role="button" class="btn" data-toggle="modal" id ="btn_modal" >ポイント減算</a>
			</div>
		</div>
		</s:form>

		<!-- Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">Confirm Message</h3>
			</div>
			<div class="modal-body">
				<p>ポイントの変更を行います。よろしいですか？</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
				<button id="btn_execute"  class="btn btn-primary" ><i class="icon-ok-sign icon-white"></i>&nbsp;変更する</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<table>
			<tr><td>
				<table class="t_csll">
					<tbody>
						<tr>
							<td><span></span></td>
							<td><span></span></td>
							<td><span></span></td>
						</tr>
					</tbody>
				</table>
			</td>
			<td>
				―
			</td>
			<td>
				<table class="t_csll">
					<tbody>
						<tr>
							<td><span></span></td>
							<td><span></span></td>
							<td><span></span></td>
						</tr>
					</tbody>
				</table>
			</td></tr>
		</table>
	</div>



	<div class="form-horizontal noprint">
		<div class="control-group">
			<label class="control-label" for="inputEmail">Email :</label>
			<div class="controls">
				<span class="control-label" id="inputEmail" style="text-align: left;">会員番号</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">日付 :</label>
			<div class="controls">
				<span class="control-label" id="inputPassword" style="text-align: left;">2012年6月15日</span>
			</div>
		</div>
	</div>


</div>
<div class="span1" ></div>


</div><!-- contents-->

<style type="text/css">

	table.t_csll td {
		width: 40px;
		height: 40px;
		border: 2px #000000 solid;
		border-width: 1px;
	}

</style>
<style  type="text/css" media="print">
	.noprint {
		display:none
	}
</style>
</div><!-- container -->
</body>
</html>