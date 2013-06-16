package sugiim.struts2sample.blogic;

import java.util.Date;
import java.util.List;

import sugiim.struts2sample.dao.JoinSampleDao;
import sugiim.struts2sample.entity.JoinDataEntity;
import sugiim.struts2sample.entity.JoinDataInputEntity;


/**
 * @author nttdbs_sugiim
 *
 */
public class JoinSampleBLogic {


	/**
	 * JoinDataを取得する
	 *
	 * @param id 検索ID
	 * @return 取得したJoinDataEntity
	 */
	public List<JoinDataEntity> selectJoinData(String id) throws Exception {

		// JoinDataを取得する
		JoinSampleDao dao = new JoinSampleDao();
		return dao.selectJoinData(id);

	}

	/**
	 * JoinDataを登録する
	 *
	 * @param tdInputEntity 登録したい入力値
	 * @return 入力値
	 */
	public JoinDataEntity registData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを登録する
		JoinSampleDao dao = new JoinSampleDao();
		JoinDataEntity tdEntity = new JoinDataEntity();

		// 入力BeanからEntityに詰替え
		tdEntity.setEvent_id(tdInputEntity.getEvent_id());
		tdEntity.setUser_name(tdInputEntity.getUser_name());
		tdEntity.setMailaddress(tdInputEntity.getMailaddress());
		tdEntity.setKey(tdInputEntity.getKey());
		tdEntity.setComment(tdInputEntity.getComment());
		tdEntity.setCancel_flg(tdInputEntity.getCancel_flg());
		//tdEntity.setUpdt_date(tdInputEntity.getUpdt_date());

		// 更新日付は本日とする
		tdEntity.setUpdt_date(new Date());

		// 登録処理の呼び出し
		dao.registJoinData(tdEntity);

		// 入力値を返却
		return tdEntity;
	}

	/**
	 * TestDataを更新する
	 *
	 * @param tdInputEntity 更新したい入力値
	 * @return 入力値
	public TestDataEntity updateData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを取得する
		SampleDao dao = new SampleDao();

		// 入力BeanからEntityに詰替え
		TestDataEntity tdEntity = new TestDataEntity();
		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());
		tdEntity.setLocation(tdInputEntity.getLocation());

		// 更新日付は本日とする
		tdEntity.setUpdt_date(new Date());

		// 更新処理の呼び出し
		dao.updateTestData(tdEntity);

		// 入力値を返却
		return tdEntity;
	}
	 */

	/**
	 * TestDataを削除する
	 *
	 * @param tdInputEntity 削除対象の入力値
	 * @return 処理結果
	public int deleteData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		// TestDataを取得する
		SampleDao dao = new SampleDao();

		// 更新処理の呼び出し
		int result = dao.deleteTestData(tdInputEntity.getPerson_id());

		// 処理結果を返却
		return result;
	}
	 */

}
