package sugiim.struts2sample.common;

/**
 * 定数定義用クラス
 *
 * @author iiyamatk
 *
 */
public class Consts {

	/////////////////////////////////////////////
	//
	// SESSION_KEY Sessionのkey
	//
	/////////////////////////////////////////////
	/**
	 * セッションキー：従業員
	 */
	public static final String SESSION_KEY_EMPLOYEE = "employee";


	/////////////////////////////////////////////
	//
	// ACTION_RESULT ActionのResult定義
	//
	/////////////////////////////////////////////
	/**
	 * /** ACTIONのresult：ログイン
	 */
	public static final String ACTION_RESULT_LOGIN = "login";

	/**
	 * ACTIONのresult：ログイン失敗
	 */
	public static final String ACTION_RESULT_LOGIN_FAILED = "loginFailed";

	/**
	 * ACTIONのresult：メインメニュー
	 */
	public static final String ACTION_RESULT_MENU = "menu";
	/**
	 * ACTIONのresult：ダウンロード
	 */
	public static final String ACTION_RESULT_DOWNLOAD = "download";

	/////////////////////////////////////////////
	//
	// ERROR_MESSAGE エラーメッセージ用文字列定義
	//
	/////////////////////////////////////////////
	// login
	/**
	 * ERROR_MESSAGE : ログインに入力なし
	 */
	public static final String ERROR_MESSAGE_LOGIN_EMPTY = "empty.fieldvalue.employee";

	/**
	 * ERROR_MESSAGE : ログイン対象が存在しない
	 */
	public static final String ERROR_MESSAGE_LOGIN_TARGET_NOT_FOUND = "login.targetNotFound";


	/////////////////////////////////////////////
	//
	// 設定用名称
	//
	/////////////////////////////////////////////
	/**
	 * datepickerのminDate
	 */
	public static final String DATEPICKER_MIN_DATE = "datepicker.minDate";

	/**
	 * datepickerのmaxDate
	 */
	public static final String DATEPICKER_MAX_DATE = "datepicker.maxDate";


	/////////////////////////////////////////////
	//
	// 文字コード
	//
	/////////////////////////////////////////////
	/**
	 * コードSHIFT_JIS
	 */
	public static final String CHARSET_SHIFT_JIS = "SHIFT-JIS";

	/**
	 * コード8859_1
	 */
	public static final String CHARSET_8859_1 = "8859_1";

	/**
	 * コードUTF-8
	 */
	public static final String CHARSET_UTF_8 = "UTF-8";

	/**
	 * 文字セット：Windows-31J
	 */
	public static final String CHARSET_WINDOWS_31J = "Windows-31J";

	/**
	 *  データベース接続情報
	 */
	public static final String JDBC_CONNECT_STRING = "java:/comp/env/jdbc/sample";



}
