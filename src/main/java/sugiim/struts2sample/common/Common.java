package sugiim.struts2sample.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 共通処理用クラス
 *
 * @author 杉井
 *
 */
public class Common {

	/**
	 * NULLか空文字をチェックする
	 *
	 * @param str NULLか空文字かをチェックしたい文字列
	 * @return チェック結果
	 */
	public static boolean IsNullOrEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * NULLか日付をチェックする(YYYYMMDD)
	 *
	 * @param str 日付の文字列
	 * @return 日付けかどうか
	 */
	public static boolean IsNullorDataYYYYMMDD(String str) {
		if (IsNullOrEmpty(str)) {
			return true;
		} else {
			return IsDataYYYYMMDD(str);
		}
	}

	/**
	 * 日付をチェックする(YYYYMMDD)
	 *
	 * @param str 日付の文字列
	 * @return 日付かどうか
	 */
	public static boolean IsDataYYYYMMDD(String str) {
		boolean result = false;
		if (str != null) {
			if (str.length() != 8 || str.getBytes().length != 8) {
				return result;
			}
			String strDate = String.format("%s/%s/%s", str.substring(0, 4),
					str.substring(4, 6), str.substring(6, 8));
			DateFormat format = DateFormat.getDateInstance();
			// 日付/時刻解析を厳密に行うかどうかを設定する。
			format.setLenient(false);
			try {
				format.parse(strDate);
				// SQLサーバの正しい日付と比較
				// 99991231と比較必要はないが、念のため
				if (str.compareTo("17530101") < 0
						|| 0 < str.compareTo("99991231")) {
					result = false;
				} else {
					result = true;
				}
			} catch (ParseException e) {
				result = false;
			}
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * スラッシュ入り日付をチェックする(YYYY/MM/DD)
	 *
	 * @param strDateWithSlash 日付の文字列
	 * @return 日付かどうか
	 */
	public static boolean isDataYYYYMMDDWithSlash(String strDateWithSlash) {

		boolean result = false;

		if (strDateWithSlash != null) {

			if (strDateWithSlash.length() != 10 || strDateWithSlash.getBytes().length != 10) {
				return result;
			}

			DateFormat format = DateFormat.getDateInstance();

			// 日付/時刻解析を厳密に行うかどうかを設定する。
			format.setLenient(false);

			try {
				format.parse(strDateWithSlash);

				String strDate = strDateWithSlash.replaceAll("/", "");

				// SQLサーバの正しい日付と比較
				// 99991231と比較必要はないが、念のため
				if (strDate.compareTo("17530101") < 0
						|| 0 < strDate.compareTo("99991231")) {
					result = false;
				} else {
					result = true;
				}
			} catch (ParseException e) {
				result = false;
			}
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 数字3桁ごとにカンマで区切る(double)
	 *
	 * @param dbl 数値
	 * @return カンマ区切りした文字列
	 */
	public static String CommaFormat(Double dbl) {
		String result = null;
		if (dbl != null) {
			DecimalFormat df1 = new DecimalFormat("#,###");
			result = df1.format(dbl);
		}
		return result;
	}

	/**
	 * 数字3桁ごとにカンマで区切る(int)
	 *
	 * @param intNumber 数値
	 * @return カンマ区切りした文字列
	 */
	public static String CommaFormat(int intNumber) {
		String result = null;
		DecimalFormat df1 = new DecimalFormat("#,###");
		result = df1.format(intNumber);
		return result;
	}

	/**
	 * カンマ区切りされた数値文字列をカンマ区切りなしの数値に戻す
	 *
	 * @param strNumber カンマ区切りされた数値文字列
	 * @return カンマなしの数値
	 */
	public static int decodeCommaFormat(String strNumber) {

		int intNumber = 0;

		try {
			// カンマを全て置き換える
			String decodeStrNumber = strNumber.replaceAll(",", "");
			intNumber = Integer.parseInt(decodeStrNumber);
		} catch (NumberFormatException e) {
		}

		return intNumber;
	}

	/**
	 * URLエンコードする
	 *
	 * @param str URLエンコード対象の文字列
	 * @return URLエンコード結果
	 */
	public static String URLEncode(String str) throws UnsupportedEncodingException {
		String result = str;
		result = URLEncoder.encode(str, Consts.CHARSET_UTF_8);
		return result;
	}

	/**
	 * @param str URLデコード対象の文字列
	 * @return URLデコード結果
	 */
	public static String URLDecode(String str) throws UnsupportedEncodingException {
		return URLDecoder.decode(str, Consts.CHARSET_UTF_8);
	}

	/**
	 * Like条件をエスケープする
	 *
	 * @param str
	 *            エスケープ文字列
	 * @return エスケープ結果
	 */
	public static String EscapeLike(String str) {
		return str.replaceAll("\\[", "\\[\\[\\]").replaceAll("%", "\\[%\\]")
				.replaceAll("_", "\\[_\\]");
	}

	/**
	 * CSVデータをエスケープする
	 *
	 * @param str
	 *            エスケープ文字列
	 *
	 * @return  エスケープ結果
	 */
	public static String CsvEscape(String str) {
		if (str == null) {
			return "\"\"";
		}
		return "\"" + str.trim().replace("\"", "\"\"") + "\"";
	}

	/**
	 * CSVデータをエスケープする(トリムなし)
	 *
	 * @param str エスケープ文字列
	 * @return  エスケープ結果
	 */
	public static String CsvEscapeNoTrim(String str) {
		if (str == null) {
			return "\"\"";
		}
		return "\"" + str.replace("\"", "\"\"") + "\"";
	}

	/**
	 * ダウンロード用文字列変換
	 *
	 * @param str
	 *            変換元文字列
	 * @return ダウンロード用文字列
	 */
	public static String ConvertDownloadString(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes(Consts.CHARSET_WINDOWS_31J),
				Consts.CHARSET_UTF_8);
//		return new String(str.getBytes(Consts.CHARSET_UTF_8),
//				Consts.CHARSET_MS932);
//		return new String(str.getBytes(Consts.CHARSET_UTF_8),
//				Consts.CHARSET_8859_1);
	}

	/**
	 * 日付を変換する(yyyy/MM/dd)
	 *
	 * @param date 日付
	 * @return 日付
	 */
	public static String ConvertToyyyy_MM_dd(Date date) {
		String result = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			result = df.format(date);
		}
		return result;
	}

	/**
	 * 日付を変換する
	 *
	 * @param date 日付
	 * @param format 変換形式
	 * @return 日付　（不正な形式の場合はブランクを返す）
	 */
	public static String dateFormat(Date date, String format) {
		String result = "";

		try{
			if (date != null) {
				SimpleDateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		}catch(Exception e){

		}
		return result;
	}

	/**
	 * CSV日付出力用
	 *
	 * @param date 日付
	 * @return CSVファイル出力用日付文字列
	 */
	public static String CsvGetDateData(Date date) {
		return "\"" + ConvertToyyyy_MM_dd(date) + "\"";
	}

	/**
	 * CSVDouble出力用
	 *
	 * @param dbl 数値
	 * @return フォーマット結果
	 */
	public static String CsvGetDoubleData(Double dbl) {
		if (dbl == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(dbl);
	}

	/**
	 * CSVDouble出力用
	 *
	 * @param bdc 数値
	 * @return フォーマット結果
	 */
	public static String CsvGetBigDecimalData(BigDecimal bdc) {
		if (bdc == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(bdc);
	}

	/**
	 * CSVInteger出力用
	 *
	 * @param itg 出力したいInteger
	 * @return フォーマット結果
	 */
	public static String CsvGetIntegerData(Integer itg) {
		if (itg == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("####"); // (1)
		return df.format(itg);
	}

	/**
	 * リソースファイルから指定情報を取得する(文字列)
	 *
	 * @param tagname キー
	 * @return 取得結果
	 */
	public static String GetResourcesString(String tagname) throws MissingResourceException {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("ApplicationResources");
		return resourceBundle.getString(tagname);
	}

	/**
	 * リソースファイルから指定情報を取得する
	 *
	 * @param tagname
	 *            キー
	 * @return 指定情報
	 */
	public static Integer GetResourcesInteger(String tagname) throws MissingResourceException {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("ApplicationResources");
		return Integer.parseInt(resourceBundle.getString(tagname));
	}

	/**
	 * 指定文字列をHTMLエンコードする
	 *
	 * @param html 指定文字列
	 * @return HTMLエンコード結果
	 */
	public static String HtmlEncodeWithCRLF(String html) {
		String result = null;

		if (html != null) {
			result = StringEscapeUtils.escapeHtml3(html)
					.replaceAll("&lt;br&gt;", "<br>")
					.replaceAll("\r\n", "<br>").replaceAll("\r", "<br>")
					.replaceAll("\n", "<br>");
		}
		return result;
	}

	/**
	 * 数値チェック
	 *
	 * @param str 指定文字列
	 * @return 数値かどうかの判定結果
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * yyyy/MM形式の年月文字列に対して、引数の月数を月に足した文字列を返す
	 *
	 * @param dateString yyyy/MM形式の年月文字列
	 * @param addCount 足す月数(負数も可能)
	 * @return 計算後のyyyy/MM形式文字列
	 */
	public static String addMonth(String dateString, int addCount) {

		if (dateString == null || dateString.trim().length() != 7) {
			return "";
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
		Date dateData = null;

		try {
			dateData = dateFormat.parse(dateString);
		} catch (ParseException e) {
			return "";
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(dateData);

		// 月を増す
		cal.add(Calendar.MONTH, addCount);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * java.sql.Dateを現在の日付から作成する
	 *
	 * @return 現在の日付で初期化されたjava.sql.Date
	 */
	public static java.sql.Date createNewDate() {

		java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

		return sqlDate;
	}
}


