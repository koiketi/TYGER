/**
 * Test Class for DAO
 *
 * @author sugiims
 */
package sugiim.struts2sample.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
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

import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.entity.Employee;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;

/**
 *
 * EmployeeDaoTest
 *
 * @author iiyamatk
 *
 */
public class EmployeeDaoTest {

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
			file = File.createTempFile("EmployeeDaoTest", ".xml");
			FlatXmlDataSet.write(partialDataSet, new FileOutputStream(file));

			// テストデータを投入する
			IDataSet dataset = new XlsDataSet(new File(
					"src/test/resources/test_data/EmployeeDaoTest.xls"));
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
	 * Test Methods
	 *
	 */
	@Test
	public void testSelectById() throws Exception {
		EmployeeDao d = new EmployeeDao();
		List<Employee> retList = d.selectById("38000001");
		Employee ret = retList.get(0);

		assertThat(ret.getEmployeeId(), is("38000001"));
		assertThat(ret.getEmployeeName(), is("杉井　正克"));
		System.out.println(ret.getUpdtDate());
	}

	/**
	 * Test Methods Update 更新テスト
	 *
	 */
	@Test
	public void testUpdate() throws Exception {

		EmployeeDao dao = new EmployeeDao();
		String employeeId = "38000004";
		String employeePassword = "drowssap";

		List<Employee> retList = dao.selectById(employeeId);
		Employee ret = retList.get(0);

		String editName = "飯山　貴弘";

		// java.util.Date⇒java.sql.Dateの正しい変換処理
		// 参考:http://d.hatena.ne.jp/higayasuo/20090219/1235020303
		java.sql.Date editUpdtDate = Common.createNewDate();

		Employee employeeUpdate = new Employee();
		employeeUpdate.setEmployeeId(ret.getEmployeeId());
		employeeUpdate.setPassword(employeePassword);
		employeeUpdate.setEmployeeName(editName);
		employeeUpdate.setUpdtDate(editUpdtDate);

		dao.update(employeeUpdate);

		// 更新後のレコードを取得
		retList = dao.selectById(employeeId);
		ret = retList.get(0);

		assertThat(ret.getEmployeeId(), is(employeeId));
		assertThat(ret.getEmployeeName(), is(editName));
		System.out.println("入力したDateのTime:" + editUpdtDate.getTime()
				+ "\t更新後取得したDateのTime:" + ret.getUpdtDate().getTime());
		assertThat(ret.getUpdtDate().getTime(), is(editUpdtDate.getTime()));

	}

	/**
	 * 全件取得テスト
	 *
	 * @throws Exception
	 */
	@Test
	public void testSelectAll() throws Exception {

		EmployeeDao d = new EmployeeDao();
		List<Employee> retList = d.selectById("");

		for (Employee emp : retList) {

			System.out.println(emp);
		}

	}

	/**
	 * 登録テスト
	 *
	 * @throws Exception
	 */
	@Test
	public void testRegist() throws Exception {

		EmployeeDao d = new EmployeeDao();

		String employeeId = "38001234";
		String employeePassword = "12343800";
		String employeeName = "春日部　太郎";

		Employee employeeRegist = new Employee();
		employeeRegist.setEmployeeId(employeeId);
		employeeRegist.setPassword(employeePassword);
		employeeRegist.setEmployeeName(employeeName);

		d.regist(employeeRegist);

		List<Employee> resultList = d.selectById(employeeId);
		Employee emp = resultList.get(0);

		assertThat(emp.getEmployeeId(), is(employeeId));
		assertThat(emp.getEmployeeName(), is(employeeName));
		assertThat(emp.getPassword(), is(employeePassword));

		System.out.println(emp);

	}

	/**
	 * 削除テスト(１件)
	 *
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		EmployeeDao d = new EmployeeDao();
		String deleteId = "99999999";
		List<Employee> retList = d.selectById(deleteId);

		d.delete(retList.get(0).getEmployeeId());

		retList = d.selectById("99999999");

		assertThat(retList, is(nullValue()));

	}

	/**
	 * 削除テスト(全件)
	 *
	 * @throws Exception
	 */
	@Test
	public void testDeleteAll() throws Exception {

		EmployeeDao d = new EmployeeDao();
		List<Employee> retList = d.selectById("");

		for (Employee emp : retList) {

			d.delete(emp.getEmployeeId());
		}

		retList = d.selectById("");

		assertThat(retList, is(nullValue()));

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


}