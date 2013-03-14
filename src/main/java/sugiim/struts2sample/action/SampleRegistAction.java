package sugiim.struts2sample.action;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.postgresql.util.PSQLException;

import sugiim.struts2sample.blogic.SampleBLogic;
import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.entity.TestDataEntity;
import sugiim.struts2sample.entity.TestDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


/**
 * sample用登録Actionクラス
 *
 * @author iiyamatk
 *
 */
public class SampleRegistAction extends ActionSupport {

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = -6647201572693844224L;

	/**
	 * ログ
	 */
	private Log log = LogFactory.getLog(SampleRegistAction.class);

	/**
	 * 表示用TestDataEntity
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
	 * データを登録する
	 *
	 * @return success
	 */
	public String registData() throws Exception {

		log.debug("**** registData Start ****");

		SampleBLogic blogic = new SampleBLogic();
		try {
			testDataEntityTarget = blogic.registData(testDataInputEntity);
		} catch (PSQLException e) {
			addActionError(getText("invalid.regist.duplicate_id",
					new String[] { testDataInputEntity.getPerson_id() }));
			return "input";
		}

		log.debug("**** registData End ****");

		return SUCCESS;
	}


	/**
	 * 登録したデータを取得する
	 *
	 * @return success
	 */
	public String selectResultData() throws Exception {

		log.debug("**** selectResultData Start ****");

		// 情報を取得する
		SampleBLogic blogic = new SampleBLogic();
		List<TestDataEntity> resultList = blogic.selectTestData(testDataInputEntity.getPerson_id());
		testDataEntityTarget = resultList.get(0);

		log.debug("**** selectResultData End ****");

		return SUCCESS;
	}


	/**
	 * 入力条件をチェックする
	 */
	public void validateRegistData() {

		log.debug("****  validateRegistData START  ****");
		log.debug("testDataInputEntit\n"
				+ testDataInputEntity.toString());

		// IDチェック
		if (Common.IsNullOrEmpty(testDataInputEntity.getPerson_id())) {

			addActionError(getText("invalid.fieldvalue.person_id"));
		}

		// 名前チェック
		if (Common.IsNullOrEmpty(testDataInputEntity.getName())) {

			addActionError(getText("invalid.fieldvalue.name"));
		}

		// 年齢チェック
		if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

			addActionError(getText("invalid.fieldvalue.age"));
		}

		log.debug("****  validateRegistData END  ****");
	}

	////////////////////////////////////
	// Setter / Getter

	/**
	 * testDataEntityのgetter
	 *
	 * @return testDataEntityTarget
	 */
	public TestDataEntity getTestDataEntityTarget() {
		return testDataEntityTarget;
	}

	/**
	 * testDataEntityのsetter
	 *
	 * @param testDataEntityTarget 設定するTestDataEntity
	 */
	public void setTestDataEntityTarget(TestDataEntity testDataEntity) {
		this.testDataEntityTarget = testDataEntity;
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

}
