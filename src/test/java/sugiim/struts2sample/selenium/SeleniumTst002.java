package sugiim.struts2sample.selenium;

/**
 * @author sugiim
 */

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;
import com.thoughtworks.selenium.SeleneseTestBase;

/**
 * Seleniumテスト002
 *
 * @author iiyamatk
 *
 */
public class SeleniumTst002 extends SeleneseTestBase  {


	/**
	 *  DBバックアップファイル
	 */
	static private File file = null;

	/**
	 * Set up method
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {


		//////////////////////////////////////////
		// DB Set up

		// JNDI設定
		JNDIUnitTestHelper.init("src/test/resources/jndi_unit_test_helper.properties");

		// Connection
//		Connection conn = null;
//		IDatabaseConnection connection = null;
//
//		try {
//
//			// Connection
//			CommonDao cDao = new CommonDao();
//			conn = cDao.getConnection();
//			connection = new DatabaseConnection(conn);
//
//			// 現状のバックアップを取得
//			QueryDataSet partialDataSet = new QueryDataSet(
//					(IDatabaseConnection) connection);
//			partialDataSet.addTable("T_Test");
//			file = File.createTempFile("SampleDaoTest", ".xml");
//			// file = new File("tmp/SampleDaoTest.xml");
//			FlatXmlDataSet.write(partialDataSet, new FileOutputStream(file));
//
//			// テストデータを投入する
//			IDataSet dataset = new XlsDataSet(new File(
//					"src/test/resources/test_data/SampleDaoTest.xls"));
//			DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//
//			if (connection != null) {
//				connection.close();
//			}
//
//		}

	}

	/**
	 * Set up method<br>
	 * 各テストケース実行前に毎回呼ばれる
	 */
	@Before
	public void setUp() throws Exception {

		//////////////////////////////////////////
		// WEB-Driverの設定
//		System.setProperty("webdriver.ie.driver", "test_data/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver",
				"src/test/resources/IEDriverServer.exe");
//				"test_data/IEDriverServer.exe");

//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new InternetExplorerDriver();
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	/**
	 * Test method
	 */
	@Test
	public void testU4B() throws Exception {

		String url = "/MavenSample/menu";
		System.out.println(url);
		selenium.open(url);
//		selenium.type("id=selectSample_testDataInputEntity_person_id", "1");
		selenium.click("link=Sampleタブ");
		selenium.waitForPageToLoad("30000");
//		assertEquals("Okada", selenium.getText("//table/tbody/tr[2]/td[2]"));
	}


	/**
	 * Test method
	 */
	@Test
	public void testU4C() throws Exception {

		String url = "/MavenSample/menu";
		System.out.println(url);
		selenium.open(url);
//		selenium.type("id=selectSample_testDataInputEntity_person_id", "1");
		selenium.click("link=Sampleタブ");
		selenium.waitForPageToLoad("30000");
//		assertEquals("57", selenium.getText("//table/tbody/tr[2]/td[3]"));
	}


	/**
	 * Tear Down method
	 */
	@After
	public void tearDown() throws Exception {


		//////////////////////////////////////////
		// Selenium stop
		selenium.stop();

	}

	/**
	 * テスト後の設定
	 *
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

//		//////////////////////////////////////////
//		// DB recovery
//		// JNDI設定
//		JNDIUnitTestHelper.init("src/test/java/jndi_unit_test_helper.properties");
//
//		// Connection
//		Connection conn = null;
//		IDatabaseConnection connection = null;
//
//		try {
//			CommonDao cDao = new CommonDao();
//			conn = cDao.getConnection();
//			connection = new DatabaseConnection(conn);
//
//			IDataSet dataSet = new FlatXmlDataSetBuilder().build(file);
//			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if (connection != null) {
//				connection.close();
//			}
//		}


	}
}
