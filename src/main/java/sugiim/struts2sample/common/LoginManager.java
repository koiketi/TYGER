package sugiim.struts2sample.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * ログイン認証管理用クラス
 *
 * @author 杉井
 *
 */
public class LoginManager {

	/**
	 * ログイン結果Enum
	 */
	public static enum LOGIN_RESULT {
		/**
		 * チェックなし
		 */
		NOT_CHECKED,

		/**
		 * 成功
		 */
		SUCCESS,

		/**
		 * ID存在せず
		 */
		ID_NOT_EXIST,

		/**
		 * パスワードエラー
		 */
		PASSWORD_ERROR,

		/**
		 * ファイル存在せず
		 */
		FILE_NOT_EXIST,

		/**
		 * ファイル形式エラー
		 */
		FILE_FORMAT_ERROR,
	};

	/**
	 * ログイン情報を確認する
	 *
	 * @param userid
	 *            ユーザID
	 * @param password
	 *            パスワード
	 * @return 認証結果
	 */
	public static LOGIN_RESULT certifyLoginInfo(String userid, String password)
			throws Exception {

		BufferedReader br = null;
		String path = null;
		path = Common.GetResourcesString("loginfile");
		LOGIN_RESULT result = LOGIN_RESULT.NOT_CHECKED;
		// try {
		File csv = new File(path); // CSVデータファイル

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					csv), Consts.CHARSET_SHIFT_JIS));

			// 最終行まで読み込む
			String line;

			while ((line = br.readLine()) != null) {
				// カンマ存在チェック
				if (!line.contains(",")) {
					// カンマ存在しない場合、エラー
					result = LOGIN_RESULT.FILE_FORMAT_ERROR;
					break;
				}

				// カンマの場所を検索
				int commaIndex = line.indexOf(",");
				// ユーザIDとパスワードを取得
				String file_userid = line.substring(0, commaIndex).trim();
				String file_password = line.substring(commaIndex + 1).trim();

				// ユーザ管理ファイル.ユーザIDがNULL
				if (file_userid.length() == 0) {
					// ユーザ管理ファイル.ユーザIDがNULLの場合、エラー
					result = LOGIN_RESULT.FILE_FORMAT_ERROR;
					break;
				}
				// ユーザIDチェック
				if (userid.equals(file_userid)) {

					// パスワードチェック
					if (password.equals(file_password)) {
						// ログイン許可
						result = LOGIN_RESULT.SUCCESS;
						break;
					} else {
						// ログイン失敗
						result = LOGIN_RESULT.PASSWORD_ERROR;
						break;
					}
				}
			}
			// ユーザ存在チェック
			if (result == LOGIN_RESULT.NOT_CHECKED) {
				result = LOGIN_RESULT.ID_NOT_EXIST;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (FileNotFoundException e) {
			// ユーザ管理ファイルが存在しない場合、エラー
			e.printStackTrace();
			result = LOGIN_RESULT.FILE_NOT_EXIST;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				// ファイルを閉じる
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
			}
		}
		// 結果を返す
		return result;
	}

}
