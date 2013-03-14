<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>

<script type="text/javascript">
<!--
	$(document).ready(function() {

		$('a[name="eventModal"]').click(function() {

			alert('eventModal呼び出し');
		});

		// JSONパラメータ
		SCHEDULE = [

			{
				ID: 1,
				NAME: '週次定例会',
				DATE_FROM: '2012/12/21 15:00',
				DATE_TO: '2012/12/21 16:00',
				VENUE: 'UBGビル2F 中会議室',
				MAP_URI: 'http://maps.google.co.jp/maps?hl=ja&ie=UTF8&ll=35.73073051430368,139.72137387868193&q=35.73107017830139,139.7217654811981%28UBG%E3%83%93%E3%83%AB2F%E4%B8%AD%E4%BC%9A%E8%AD%B0%E5%AE%A4%29&z=17&output=embed',
				CONTENT: '週次の定例会',
				DETAIL: '週次で定例会を行います。',
				REGISTRANT: '鈴木　一郎',
				MEMBER_ID : [
					1,2,3,4
				]
			},

			{
				ID: 2,
				NAME: '週次勉強会',
				DATE_FROM: '2012/12/21 16:00',
				DATE_TO: '2012/12/21 16:30',
				VENUE: 'UBGビル2F 中会議室',
				CONTENT: '週次の勉強会',
				DETAIL: '週次で勉強会を行います。',
				REGISTRANT: '鈴木　一郎',
				MEMBER_ID : [
					1
				]
			},

			{
				ID: 3,
				NAME: '納会',
				DATE_FROM: '2012/12/28 16:00',
				DATE_TO: '2012/12/29 00:00',
				VENUE: 'UBGビル2F 大会議室',
				MAP_URI: 'http://maps.google.co.jp/maps?hl=ja&ie=UTF8&ll=35.73073051430368,139.72137387868193&q=35.73107017830139,139.7217654811981%28UBG%E3%83%93%E3%83%AB2F%E5%A4%A7%E4%BC%9A%E8%AD%B0%E5%AE%A4%29&z=17&output=embed',
				CONTENT: '2012年の納会',
				DETAIL: '2012年の納会を行います。休暇を取らない方は全員参加です。',
				REGISTRANT: '鈴木　一郎',
			},

			{
				ID: 4,
				NAME: '発会',
				DATE_FROM: '2013/01/06 10:00',
				DATE_TO: '2013/01/06 12:00',
				VENUE: 'UBGビル2F 大会議室',
				CONTENT: '2013年の発会',
				DETAIL: '2013年の発会を行います。休暇を取らない方は全員参加です。',
				REGISTRANT: '鈴木　一郎',
			},

		];

		MEMBER = [

				{
					ID : 1,
					NAME : '鈴木　一郎',
					JOB : 'PM',
					AUTHORITY : '主任',
					AGE : '30',
					SKILL : 'プロマネ, Java',
					NOTE : '8年目'
				},

				{
					ID : 2,
					NAME : '佐藤　太郎',
					JOB : '総務',
					AUTHORITY : '社員',
					AGE : '21',
					SKILL : 'Office',
					NOTE : '2年目'
				},

				{
					ID : 3,
					NAME : '佐藤　次郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '22',
					SKILL : 'DBA',
					NOTE : '新人'
				},

				{
					ID : 4,
					NAME : '佐藤　三郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '23',
					SKILL : 'C#',
					NOTE : '中途'
				},

				{
					ID : 5,
					NAME : '佐藤　四朗',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '24',
					SKILL : 'C++',
					NOTE : ''
				},

				{
					ID : 6,
					NAME : '佐藤　五郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '25',
					SKILL : 'VB',
					NOTE : ''
				},

				{
					ID : 7,
					NAME : '佐藤　六郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '26',
					SKILL : 'PHP',
					NOTE : ''
				},

				{
					ID : 8,
					NAME : '佐藤　七郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '27',
					SKILL : 'Perl',
					NOTE : ''
				},

				{
					ID : 9,
					NAME : '佐藤　八郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '28',
					SKILL : 'FORTLAN',
					NOTE : ''
				},

				{
					ID : 10,
					NAME : '佐藤　九郎',
					JOB : 'PG',
					AUTHORITY : '社員',
					AGE : '29',
					SKILL : 'COBOL',
					NOTE : ''
				}

		];

		// JSON読み出し＆書き出し
		if (SCHEDULE.length > 0) {

			for (var i = 0; i < SCHEDULE.length; i++) {

				$('#eventTable > tbody').append('<tr>');

				var linkText = '<a name="eventModal" onClick="modalShow(\'' + SCHEDULE[i].ID + '\')" data-toggle="modal">' + SCHEDULE[i].NAME + '</a>'

				addTr = $('#eventTable > tbody > tr:last');

				addTr.append('<td>' + linkText + '</td>');
				addTr.append('<td>' + SCHEDULE[i].DATE_FROM + '</td>');
				addTr.append('<td>' + SCHEDULE[i].DATE_TO + '</td>');
				addTr.append('<td>' + SCHEDULE[i].CONTENT + '</td>');

				memberIdList = SCHEDULE[i].MEMBER_ID;

				if (memberIdList == null) {
					addTr.append('<td />');
					continue;
				}

				for (var memIdCount = 0; memIdCount < memberIdList.length; memIdCount++) {

					if (memIdCount == 0) {
						addTr.append('<td />');
					}

					for (var memCount = 0; memCount < MEMBER.length; memCount++) {

						if (memberIdList[memIdCount] == MEMBER[memCount].ID) {

							content = $('#eventTable > tbody > tr:last > td:last');
							contentText = content.text();
							content.text(contentText + ' ' + MEMBER[memCount].NAME);
							break;
						}
					}
				}

			}
		}

		for (var i = 0; i < MEMBER.length; i++) {

			$('#memberTable > tbody').append('<tr>');

			addTr = $('#memberTable > tbody > tr:last');

			addTr.append('<td style="text-align: right;">' + MEMBER[i].ID + '</td>');
			addTr.append('<td>' + MEMBER[i].NAME + '</td>');
			addTr.append('<td>' + MEMBER[i].JOB + '</td>');
			addTr.append('<td>' + MEMBER[i].AUTHORITY + '</td>');
			addTr.append('<td style="text-align: right;">' + MEMBER[i].AGE + '</td>');
			addTr.append('<td>' + MEMBER[i].SKILL + '</td>');
			addTr.append('<td>' + MEMBER[i].NOTE + '</td>');
		}

	});

	function modalShow(eventId) {

		for (var i = 0; i < SCHEDULE.length; i++) {

			if (SCHEDULE[i].ID == eventId) {

				$('#eventName').text(SCHEDULE[i].NAME);
				$('#dlEvent > dd:eq(0)').text(SCHEDULE[i].DATE_FROM + ' - ' + SCHEDULE[i].DATE_TO);

				if (SCHEDULE[i].MAP_URI != undefined) {
					$('#dlEvent > dd:eq(1)').html('<a onclick=\'window.open("' + SCHEDULE[i].MAP_URI + '", "", "width=600px,height=480px")\'" target="_blank">' + SCHEDULE[i].VENUE + '</a>');
				} else {
					$('#dlEvent > dd:eq(1)').text(SCHEDULE[i].VENUE);
				}

				$('#dlEvent > dd:eq(2)').text(SCHEDULE[i].CONTENT);
				$('#dlEvent > dd:eq(3)').text(SCHEDULE[i].DETAIL);
				$('#dlEvent > dd:eq(4)').text(SCHEDULE[i].REGISTRANT);

				// 以前<li>タグ作成済みの場合に残ってしまうので削除を行う
				$('#memberList').children().remove();

				memberIdList = SCHEDULE[i].MEMBER_ID;

				if (memberIdList == null) {
					$('#ddMemberList > p').text('計 0名');
					$('#eventModal').modal('show');
					continue;
				}

				for (var memIdCount = 0; memIdCount < memberIdList.length; memIdCount++) {

					$('#memberList').append('<li />');

					for (var memCount = 0; memCount < MEMBER.length; memCount++) {

						if (memberIdList[memIdCount] == MEMBER[memCount].ID) {

							$('#memberList > li:last').text(MEMBER[memCount].NAME);
							break;
						}
					}
				}

				$('#ddMemberList > p').text('計 ' + memberIdList.length + '名');
				$('#eventModal').modal('show');

				break;
			}

		}

	}

// -->
</script>

	<div class="container">
		<div class="row-fluid" style="padding-top:60px"><%-- contents可変 --%>
			<div class="span12">
				<h2>tab</h2>
				<div class="tabbable"><!-- Only required for left/right tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tabEvent" data-toggle="tab">イベント</a></li>
						<li><a href="#tabCalendar" data-toggle="tab">カレンダー</a></li>
						<li><a href="#tabMember" data-toggle="tab">メンバー</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabEvent">
							<p>イベント一覧</p>
							<table id="eventTable" class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<td>名称</td>
										<td>日時(From)</td>
										<td>日時(To)</td>
										<td>内容</td>
										<td>参加者</td>
									</tr>
								</thead>
								<tbody />
							</table>
						</div>
						<div class="tab-pane" id="tabCalendar">
							<p>カレンダー</p>
						</div>
						<div class="tab-pane" id="tabMember">
							<p>メンバー</p>
							<table id="memberTable" class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<td>ID</td>
										<td>名称</td>
										<td>職業</td>
										<td>権限</td>
										<td>年齢</td>
										<td>スキル</td>
										<td>備考</td>
									</tr>
								</thead>
								<tbody />
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- Modal --%>
	<div id="eventModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="eventModalLabel" aria-hidden="true" >
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="eventModalLabel">イベント詳細</h3>
		</div>
		<div class="modal-body">
			<h3 id="eventName">週次定例会</h3>
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tabEventDetail" data-toggle="tab">詳細</a></li>
					<li><a href="#tabEventMember" data-toggle="tab">参加予定</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tabEventDetail">
						<dl id="dlEvent" class="dl-horizontal">
							<dt>開催日時</dt><dd>2012/12/21 15:00 - 2012/12/21 16:00</dd>
							<dt>開催場所</dt><dd>UBGビル2F 中会議室</dd>
							<dt>内容</dt><dd>週次の定例会</dd>
							<dt>詳細</dt><dd>週次の定例会を毎週やります。</dd>
							<dt>登録者</dt><dd>佐藤　一郎</dd>
						</dl>
					</div>
					<div class="tab-pane" id="tabEventMember">
						<dl class="dl-horizontal">
							<dt>参加予定</dt>
							<dd id="ddMemberList">
								<ul id="memberList" class="inline">
								</ul><p></p>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button id="btn_execute"  class="btn btn-primary" ><i class="icon-ok-sign icon-white"></i>&nbsp;変更する</button>
		</div>
	</div>
	</body>
</html>