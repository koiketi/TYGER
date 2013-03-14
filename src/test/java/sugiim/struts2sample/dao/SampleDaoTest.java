/**
 * Test Class for DAO
 *
 * @author sugiims
 */
package sugiim.struts2sample.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sugiim.struts2sample.entity.TestDataEntity;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;

/**
 *
 * SampleDaoTest
 *
 * @author sugiim
 *
 */
public class SampleDaoTest {

	/**
	 * ファイル
	 */
	static private File file = null;

	/**
	 * テスト前の準備
	 *
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// JNDI設定
		JNDIUnitTestHelper.init("src/test/resources/jndi_unit_test_helper.properties");
		// Connection
		Connection conn = null;
		IDatabaseConnection connection = null;

		try {

			// Connection
			CommonDao cDao = new CommonDao();
			conn = cDao.getConnection();
			connection = new DatabaseConnection(conn);

			// 現状のバックアップを取得
			QueryDataSet partialDataSet = new QueryDataSet(
					(IDatabaseConnection) connection);
			partialDataSet.addTable("t_person");
			file = File.createTempFile("SampleDaoTest", ".xml");
			// file = new File("tmp/SampleDaoTest.xml");
			FlatXmlDataSet.write(partialDataSet, new FileOutputStream(file));

			// テストデータを投入する
			IDataSet dataset = new XlsDataSet(new File(
					"src/test/resources/test_data/SampleDaoTest.xls"));
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (connection != null) {
				connection.close();
			}

		}

	}

	/**
	 * テスト後の設定
	 *
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		// JNDI設定
		JNDIUnitTestHelper.init("src/test/resources/jndi_unit_test_helper.properties");

		// Connection
		Connection conn = null;
		IDatabaseConnection connection = null;

		try {
			CommonDao cDao = new CommonDao();
			conn = cDao.getConnection();
			connection = new DatabaseConnection(conn);

			IDataSet dataSet = new FlatXmlDataSetBuilder().build(file);
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}

	/**
	 * Test Methods
	 *
	 */
	@Test
	public void test() throws Exception {
		SampleDao d = new SampleDao();
		List<TestDataEntity> retList = d.selectTestData("1");
		TestDataEntity ret = retList.get(0);

		assertEquals("1", ret.getPerson_id());
		assertEquals("Okada", ret.getName());
		assertEquals(new Integer(57), ret.getAge());
		System.out.println(ret.getUpdt_date());
	}

	/**
	 * Test Methods Update 更新テスト
	 *
	 */
	@Test
	public void testUpdate() throws Exception {

		SampleDao dao = new SampleDao();
		List<TestDataEntity> retList = dao.selectTestData("1");
		TestDataEntity ret = retList.get(0);

		String editName = "岡田";
		Integer editAge = ret.getAge() - 20;

		// java.util.Date⇒java.sql.Dateの正しい変換処理
		// 参考:http://d.hatena.ne.jp/higayasuo/20090219/1235020303
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date editUpdtDate = new java.sql.Date(cal.getTimeInMillis());

		TestDataEntity testDataEntityUpdate = new TestDataEntity();
		testDataEntityUpdate.setPerson_id(ret.getPerson_id());
		testDataEntityUpdate.setName("岡田");
		testDataEntityUpdate.setAge(editAge);
		testDataEntityUpdate.setUpdt_date(editUpdtDate);

		dao.updateTestData(testDataEntityUpdate);

		// 更新後のレコードを取得
		retList = dao.selectTestData("1");
//		ret = dao.selectTestData("1");
		ret = retList.get(0);

		assertEquals("1", ret.getPerson_id());
		assertEquals(editName, ret.getName());
		assertEquals(editAge, ret.getAge());
		System.out.println("入力したDateのTime:" + editUpdtDate.getTime()
				+ "\t更新後取得したDateのTime:" + ret.getUpdt_date().getTime());
		assertEquals(editUpdtDate.getTime(), ret.getUpdt_date().getTime());

	}

	/**
	 * 全件取得テスト
	 *
	 * @throws Exception
	 */
	@Test
	public void testAll() throws Exception {

		SampleDao d = new SampleDao();
		List<TestDataEntity> retList = d.selectTestData("");

		for (TestDataEntity tde : retList) {

//			String id = tde.getPerson_id();
//			String name = tde.getName();
//			Integer age = tde.getAge();
//			Date updt_date = tde.getUpdt_date();

			System.out.println(tde);
		}

	}

	// @Test
	// public void test2() throws Exception {
	// SampleDao d = new SampleDao();
	// TestDataEntity ret = d.selectTestData("1");
	//
	// assertEquals("1", ret.getPerson_id());
	// assertEquals("Sugii", ret.getName());
	// assertEquals(35, ret.getAge());
	// }

}
