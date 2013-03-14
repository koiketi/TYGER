<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
<script type="text/javascript" src="./js/jquery-ui.custom.js"></script><%-- modalのdraggable用 --%>
<script type="text/javascript">


$(document).ready(function() {

	// modalダイアログをdraggableに設定。親オブジェクトより外には出ない。
	$('#myModal').draggable({ containment: "parent", scroll: false });

	// btn_modalボタン押下
	$('#btn_modal').click(function() {

		var errText="success";

		// ID
		var inId = $('#registForm_testDataInputEntity_person_id').val();
		// 名前
		var inName = $('#registForm_testDataInputEntity_name').val();
		// 年齢
		var inAge = $('#registForm_testDataInputEntity_age').val();


		//IDがnullかどうか。
		if (inId == ""){
			errText = 'IDが未入力です';

		// IDの文字種別チェック（数値であること）
		} else if (!inId.match( /^[0-9]*$/ ) ){
			errText = 'IDは整数で入力してください';


			//名前が20文字以内かどうかチェック
		} else if ( ((inName == "") || (inName.length > 20) )){
			errText = '名前は20文字以内で入力してください';

		//年齢の文字種別チェック（数値）
		} else if ( !inAge.match( /^[0-9]*$/ ) ){
			errText = '年齢は整数で入力してください';

		//年齢の上限値チェック（0<= age <= 99）
		} else if ( (parseInt(inAge) < 0) && (parseInt(inAge) > 100) ){
			errText = '年齢は0～99の値を入力してください';

		} else {
			errText="success";

		}

		if (errText == "success") {
			$("#errorStr").text("");
			$("#errorField").hide();
			return true;

		} else {
			$("#errorStr").text(errText);
			$("#errorField").show();
			return false;
		}
	});

	// btn_executeボタン押下
	$('#btn_execute').click(function() {
		$('#myModal').modal('hide');
		document.registForm.submit();

		//$('PointForm').submit();
	});

	// モーダル表示処理完了後の動作
	$('#myModal').on('shown', function() {

		// setTimeoutで時間差処理しないとIEではfocusが当たらない。
		setTimeout(function() {
			$('#btn_execute').focus();
		}, 10);

	});

});
</script>



<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
	<div id="mainContainer" class="container">

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form action="registSample!registData" cssClass="form-horizontal" id="registForm" cssStyle="padding: 0px 5px" >

			<div class="row"><!-- error表示領域 -->
				<div class="offset2 span8">
			<s:if test="hasActionErrors()"><%-- ActionErrorsがある時だけにする --%>
					<div class="control-group" >
						<div class="alert alert-error"><s:actionerror /></div>
					</div></s:if>
			<s:else>
					<div class="control-group" id="errorField"  style="display:none;text-align:center;">
							<div class="alert alert-error">
								<ul class="errorMessage">
									<li><span id="errorStr"></span></li>
								</ul>
							</div>
					</div></s:else>
				</div>
				<div class="offset2"></div>
			</div><!-- error表示領域 -->


				<s:token/>

				<div class="control-group">
					<label class="control-label" for="registForm_testDataInputEntity_person_id"><span class="label label-important">ID</span></label>
					<div class="controls">
						<s:textfield type="text"  name="testDataInputEntity.person_id"  cssClass="input-medium" placeholder="ID?"  ></s:textfield>
					</div>
				</div>


				<div class="control-group">
					<label class="control-label" for="registForm_testDataInputEntity_name"><span class="label label-important">名前</span></label>
					<div class="controls">
						<s:textfield type="text"  name="testDataInputEntity.name"  cssClass="input-xlarge" placeholder="NAME?"  ></s:textfield>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="registForm_testDataInputEntity_age"><span class="label label-important">年齢</span></label>
					<div class="controls">
						<s:textfield type="text"  name="testDataInputEntity.age"  cssClass="input-mini" placeholder="AGE?"  ></s:textfield>
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<a href="#myModal" role="button" class="btn btn-primary" data-toggle="modal" id ="btn_modal">登録</a>
						<s:reset cssClass="btn btn-danger" value="リセット" />
					</div>
				</div>
			</s:form>




		</div>
	</div><!-- /information-->



</div>
<div class="span1" ></div>
</div><!-- contents-->
</div>

			<!-- Modal -->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">Attenssion！</h3>
				</div>
				<div class="modal-body">
					<p>データを登録します。よろしいですか？</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
					<button id="btn_execute"  class="btn btn-primary" ><i class="icon-ok-sign icon-white"></i>&nbsp;登録する</button>
				</div>
			</div>


</body>
</html>