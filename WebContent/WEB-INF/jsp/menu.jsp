<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include><%-- /共通Header呼び出し/ --%>
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include><%-- /共通navbar呼び出し/--%>
	<div id="mainContainer" class="container">
		<div class="row">
			<div class="span3">
				<ul class="nav nav-list bs-docs-sidenav">
					<li><a href="sample"><i class="icon-chevron-right"></i>Select sample</a></li>
					<li><a href="sample2"><i class="icon-chevron-right"></i>Select Sample(ajax/json)</a></li>
					<li><a href="registSample"><i class="icon-chevron-right"></i>registSample</a></li>
					<li><a href="updateSample"><i class="icon-chevron-right"></i>updateSample</a></li>
					<li><a href="sampleTab"><i class="icon-chevron-right"></i>（おまけ）タブの使い方</a></li>
				</ul>
			</div>
			<div class="span9">
				<div style="margin-top:30px">
					<div class="page-header">
					  <h1>Contents <small>sample... </small></h1>
					</div>

					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="sample">Select Sample</a>
								<div class="caption">
								<p>検索処理のサンプルです</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="sample2">Select Sample(ajax/json)</a>
								<div class="caption">
								<p>検索処理を非同期に行うサンプルです。</p>
								<p>ajax, jsonを使って、非同期に検索結果を取得する処理を行います。</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="registSample">registSample</a>
								<div class="caption">
								<p>新規登録のサンプルです。</p>
								<p>入力チェック→確認ダウアログ→DB登録→登録完了画面</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="updateSample">updateSample</a>
								<div class="caption">
								<p>更新、削除処理のサンプルです。</p>
								<p>検索→更新（または削除）</p>
								</div>
							</div>
						</li>
					</ul>


				</div>
			</div>
		</div>
	</div>
	</body>
</html>