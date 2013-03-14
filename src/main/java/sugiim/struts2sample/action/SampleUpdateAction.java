package sugiim.struts2sample.action;



import java.util.List;

import sugiim.struts2sample.blogic.SampleBLogic;
import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.entity.TestDataEntity;
import sugiim.struts2sample.entity.TestDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


/**
 * sample用更新Actionクラス
 *
 * @author iiyamatk
 *
 */
public class SampleUpdateAction extends ActionSupport {

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 表示用TestDataEntityのリスト
	 */
	private List<TestDataEntity> testDataEntityList;

	/**
	 * 対象となるtestDataEntity
	 */
	private TestDataEntity testDataEntityTarget;

	/**
	 *  検索条件
	 */
	private TestDataInputEntity testDataInputEntity;

	/**
	 * 初期表示する
	 *
	 * @return
	 */
	public String execute() throws Exception {

		return "init";
	}

	/**
	 * データ検索後、画面を遷移する
	 *
	 * @return search
	 */
	public String selectData() throws Exception {

		System.out.println("****  selectData  ****");

		// 検索一覧の情報を取得する
		SampleBLogic blogic = new SampleBLogic();
		testDataEntityList = blogic.selectTestData(testDataInputEntity.getPerson_id());

		System.out.println("****  selectData End ****");

		if (testDataEntityList == null) {
			addActionError(getText("person.notFound"));
			return "init";
		}

		// 画面遷移
		return "search";
	}

	/**
	 * 更新対象を取得し初期表示する
	 *
	 * @return updateDisplay
	 */
	public String updateDisplay() throws Exception {

		String person_id = testDataInputEntity.getPerson_id();

		System.out.println("**** SampleUpdateAction.execute person_id = " + person_id +  "  ****");

		SampleBLogic blogic = new SampleBLogic();
		List<TestDataEntity> resultList = blogic.selectTestData(person_id);

		if (resultList != null) {
			testDataEntityTarget = resultList.get(0);
		} else {
			addActionError("対象データなし");
			return "init";
		}

		return "updateDisplay";
	}

	/**
	 * データを更新し、画面を遷移する
	 *
	 * @return update
	 */
	public String updateData() throws Exception {

		System.out.println("****  updateData START ****");

		// 検索一覧の情報を取得する
		SampleBLogic blogic = new SampleBLogic();
		testDataEntityTarget = blogic.updateData(testDataInputEntity);

		System.out.println("****  updateData END ****");

		// 画面遷移
//		return "update";
		return "success";
	}

	/**
	 * データ更新時の入力条件をチェックする
	 */
	public void validateUpdateData() {

		System.out.println("****  validateUpdateData START  ****");
		System.out.println("testDataInputEntity\n" + testDataInputEntity.toString());

		// 名前チェック
		if (Common.IsNullOrEmpty(testDataInputEntity.getName())) {

			addActionError(getText("invalid.fieldvalue.name"));
		}

		// 年齢チェック
		if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

			addActionError(getText("invalid.fieldvalue.age"));
		}

		System.out.println("****  validateUpdateData END  ****");
	}

	/**
	 * データを削除し、画面を遷移する
	 *
	 * @return delete
	 */
	public String deleteData() throws Exception {

		System.out.println("****  deleteData START ****");

		// 検索一覧の情報を取得する
		SampleBLogic blogic = new SampleBLogic();
		int result = blogic.deleteData(testDataInputEntity);

		if (result == 0) {
			// 削除対象なし(削除件数=0)
			addActionError(getText("invalid.delete.id_not_found",
					new String[] { testDataInputEntity.getPerson_id() }));
			return "input";
		}

		System.out.println("****  deleteData END **** 結果:" + result);

		// 画面遷移
		return "delete";
	}


	////////////////////////////////////
	// Setter / Getter
	/**
	 * testDataEntityListのgetter
	 *
	 * @return testDataEntityList
	 */
	public List<TestDataEntity> getTestDataEntityList() {
		return testDataEntityList;
	}

	/**
	 * testDataEntityListのsetter
	 *
	 * @param testDataEntityList 設定するTestDataEntity
	 */
	public void setTestDataEntityList(List<TestDataEntity> testDataEntityList) {
		this.testDataEntityList = testDataEntityList;
	}

	/**
	 * testDataInputEntityのgetter
	 *
	 * @return testDataInputEntity
	 */
	public TestDataInputEntity getTestDataInputEntity() {
		return testDataInputEntity;
	}

	/**
	 * testDataInputEntityのsetter
	 *
	 * @param testDataInputEntity 設定するtestDataInputEntity
	 */
	public void setTestDataInputEntity(TestDataInputEntity testDataInputEntity) {

		this.testDataInputEntity = testDataInputEntity;
	}

	/**
	 * @return testDataEntityTarget
	 */
	public TestDataEntity getTestDataEntityTarget() {
		return testDataEntityTarget;
	}

	/**
	 * @param testDataEntityTarget セットする testDataEntityTarget
	 */
	public void setTestDataEntityTarget(TestDataEntity testDataTarget) {
		this.testDataEntityTarget = testDataTarget;
	}


}
