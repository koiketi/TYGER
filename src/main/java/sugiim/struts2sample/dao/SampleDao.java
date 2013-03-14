package sugiim.struts2sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.entity.TestDataEntity;

/**
 * SampleDAOクラス
 *
 * @author 杉井
 *
 */
public class SampleDao extends CommonDao {

	/**
	 * ログ
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * Constructor
	 *
	 */
	public SampleDao() throws NamingException {

		//log.debug("Testデータを取得する");
		super();

	}


	/**
	 * Testデータを取得する
	 *
	 * @param id 検索条件id
	 * @return Testデータ
	 */
	public List<TestDataEntity> selectTestData(String id)
			throws Exception {

		log.debug("Testデータを取得する");

		boolean idIsExist = false;

		if (!Common.IsNullOrEmpty(id)) {
			idIsExist = true;
		}

		// 接続コネクション
		Connection con = super.getConnection();
		// Statementオブジェクト
		PreparedStatement pstmt = null;
		// ResultSetオブジェクト
		ResultSet rs = null;

		// Testデータ
		List<TestDataEntity> list = null;

		try {
			// String SQL = "select person_id, name, age, updt_date from T_Test; ";
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select person_id, name, age, updt_date from T_PERSON");

			if (idIsExist) {
				sbSQL.append(" where person_id = ? ");
			}

			pstmt = con.prepareStatement(sbSQL.toString());
			//pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			if (idIsExist) {
				pstmt.setString(1, id);
			}

			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				if (list == null) {
					list = new ArrayList<TestDataEntity>();
				}

				TestDataEntity tdEntitiy = null;
				tdEntitiy = new TestDataEntity();
				tdEntitiy.setPerson_id(rs.getString("person_id"));
				tdEntitiy.setName(rs.getString("name"));
				tdEntitiy.setAge(rs.getInt("age"));
				tdEntitiy.setUpdt_date(rs.getDate("updt_date"));
				list.add(tdEntitiy);
			}
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		// 結果を返す
		return list;
	}

	/**
	 * Testデータを登録する
	 *
	 * @param tdEntity 登録内容
	 * @return INSERT結果
	 */
	public int registTestData(TestDataEntity tdEntity)
			throws Exception {

		log.debug("Testデータを登録する");

		// 接続コネクション
		Connection con = super.getConnection();
		// Statementオブジェクト
		PreparedStatement pstmt = null;
		// ResultSetオブジェクト
		int rs = 0;

		try {

			String SQL = "INSERT INTO T_PERSON (person_id, name, age, updt_date) VALUES (?, ?, ?, ?);";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getPerson_id());
			pstmt.setString(2, tdEntity.getName());
			pstmt.setInt(3, tdEntity.getAge());
			pstmt.setDate(4, new java.sql.Date(tdEntity.getUpdt_date().getTime())); // 暫定対応

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		System.out.println("**** SampleDAO.registTestData 実行結果:" + rs + " ****");

		// 結果を返す
		return rs;
	}

	/**
	 * Testデータを更新する
	 *
	 * @param tdEntity 更新内容
	 * @return UPDATE結果
	 */
	public int updateTestData(TestDataEntity tdEntity)
			throws Exception {

		log.debug("Testデータを更新する");

		// 接続コネクション
		Connection con = super.getConnection();
		// Statementオブジェクト
		PreparedStatement pstmt = null;
		// ResultSetオブジェクト
		int rs = 0;

		try {

			String SQL = "UPDATE T_PERSON SET name = ?, age = ?, updt_date = ? WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getName());
			pstmt.setInt(2, tdEntity.getAge());
			pstmt.setDate(3, new java.sql.Date(tdEntity.getUpdt_date().getTime())); // 暫定対応
			pstmt.setString(4, tdEntity.getPerson_id());

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		System.out.println("**** SampleDAO.updateTestData 実行結果:" + rs + " ****");

		// 結果を返す
		return rs;
	}

	/**
	 * Testデータを削除する
	 *
	 * @param person_id 削除対象ID
	 * @return 削除結果
	 */
	public int deleteTestData(String person_id)
			throws Exception {

		log.debug("Testデータを削除する");

		// 接続コネクション
		Connection con = super.getConnection();
		// Statementオブジェクト
		PreparedStatement pstmt = null;
		// ResultSetオブジェクト
		int rs = 0;

		try {

			String SQL = "DELETE FROM T_PERSON WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, person_id);

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		System.out.println("**** SampleDAO.deleteTestData 実行結果:" + rs + " ****");

		// 結果を返す
		return rs;
	}

}
