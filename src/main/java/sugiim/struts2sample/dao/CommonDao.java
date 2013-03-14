package sugiim.struts2sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.MissingResourceException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.common.Consts;


/**
 * DAO用共通クラス
 *
 * @author 杉井
 *
 */
public class CommonDao {


	/**
	 * データソース
	 */
	protected DataSource ds = null;

	/**
	 * コンストラクタ
	 */
	public CommonDao() throws NamingException {

		Context context = new InitialContext();
		ds = (DataSource) context.lookup(Consts.JDBC_CONNECT_STRING);

	}

	/**
	 * コネクションを取得
	 *
	 * @return コネクション
	 */
	public Connection getConnection() throws SQLException {
		return ds.getConnection();

	}


	/**
	 * DBデータがNULLか値を返す
	 *
	 * @param colName
	 *            列名
	 * @param rs
	 *            データセット
	 * @return NULLか値
	 */
	public static Integer getNullableInt(String colName, ResultSet rs)
			throws SQLException {

		int colValue = rs.getInt(colName);
		if (rs.wasNull()) {
			return null;
		}
		return colValue;
	}

	/**
	 * DBデータがNULLか値を返す
	 *
	 * @param colName
	 *            列名
	 * @param rs
	 *            データセット
	 * @return NULLか値
	 */
	public static Double getNullableDouble(String colName, ResultSet rs)
			throws SQLException {

		Double colValue = rs.getDouble(colName);
		if (rs.wasNull()) {
			return null;
		}
		return colValue;
	}

	/**
	 * SQL時間タイムアウト時間を取得する デフォルト：30秒 単位：秒
	 *
	 * @return SQL時間タイムアウト時間
	 */
	public static int getSqlExcuteTimeout() {

		int timeout = 30;

		try {
			timeout = Common.GetResourcesInteger("sql.timeout");
		} catch (MissingResourceException e) {
		}

		return timeout;
	}

}
