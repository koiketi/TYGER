<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%>		<script type="text/javascript">
		<!--
			$(document).ready(function()
			{
				// 初期表示時にもリサイズ処理を呼ぶ
				autoResize();
			});

			// リサイズ時のpadding値調整処理
			var timer = false;

			$(window).resize(function(){

				// リサイズのイベントは短い周期で連続して発生する。
				// リサイズし終わった場合に動作するようにtimerを使う。
				// 時間差になるので、一瞬動くのが気になるようならば「autoRersize()」を呼ぶだけにすれば良い。
				if (timer != false) {
					clearTimeout(timer);
				}

				// 設定したミリ秒毎だけ待つ
				timer = setTimeout(function() {

					autoResize();

				}, 150);

			});

			// navbarの高さによってpadding-topを変更し、リサイズに対応する
			function autoResize() {

				// navbarの高さを取得
				var navHeight = $('#navbar').height();

				// navbarの高さを機能名領域のcss、「padding-top」に設定
				$('#mainContainer').css("padding-top", navHeight);
			}

		// -->
		</script>
		<div id="navbar" class="navbar navbar-fixed-top"><%-- /navbar --%>
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="brand" href="./">Sample system</a>
				</div>
			</div>
		</div><%-- navbar/ --%>