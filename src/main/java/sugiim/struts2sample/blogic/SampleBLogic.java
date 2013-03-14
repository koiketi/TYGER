package sugiim.struts2sample.blogic;

import java.util.Date;
import java.util.List;

import sugiim.struts2sample.dao.SampleDao;
import sugiim.struts2sample.entity.TestDataEntity;
import sugiim.struts2sample.entity.TestDataInputEntity;


/**
 * @author nttdbs_sugiim
 *
 */
public class SampleBLogic {


	/**
	 * TestDataを取得する
	 *
	 * @param id 検索ID
	 * @return 取得したTestDataEntity
	 */
	public List<TestDataEntity> selectTestData(String id) throws Exception {

		// TestDataを取得する
		SampleDao dao = new SampleDao();
		return dao.selectTestData(id);

	}

	/**
	 * TestDataを登録する
	 *
	 * @param tdInputEntity 登録したい入力値
	 * @return 入力値
	 */
	public TestDataEntity registData(TestDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを登録する
		SampleDao dao = new SampleDao();
		TestDataEntity tdEntity = new TestDataEntity();

		// 入力BeanからEntityに詰替え
		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());

		// 更新日付は本日とする
		tdEntity.setUpdt_date(new Date());

		// 登録処理の呼び出し
		dao.registTestData(tdEntity);

		// 入力値を返却
		return tdEntity;
	}

	/**
	 * TestDataを更新する
	 *
	 * @param tdInputEntity 更新したい入力値
	 * @return 入力値
	 */
	public TestDataEntity updateData(TestDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを取得する
		SampleDao dao = new SampleDao();

		// 入力BeanからEntityに詰替え
		TestDataEntity tdEntity = new TestDataEntity();
		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());

		// 更新日付は本日とする
		tdEntity.setUpdt_date(new Date());

		// 更新処理の呼び出し
		dao.updateTestData(tdEntity);

		// 入力値を返却
		return tdEntity;
	}

	/**
	 * TestDataを削除する
	 *
	 * @param tdInputEntity 削除対象の入力値
	 * @return 処理結果
	 */
	public int deleteData(TestDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを取得する
		SampleDao dao = new SampleDao();

		// 更新処理の呼び出し
		int result = dao.deleteTestData(tdInputEntity.getPerson_id());

		// 処理結果を返却
		return result;
	}

}
