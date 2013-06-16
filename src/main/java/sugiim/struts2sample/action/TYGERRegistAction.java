package sugiim.struts2sample.action;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.postgresql.util.PSQLException;

import sugiim.struts2sample.blogic.JoinSampleBLogic;
import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.entity.JoinDataEntity;
import sugiim.struts2sample.entity.JoinDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


/**
 * sample用登録Actionクラス
 *
 * @author iiyamatk
 *
 */
public class TYGERRegistAction extends ActionSupport {

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = -6647201572693844224L;

	/**
	 * ログ
	 */
	private Log log = LogFactory.getLog(TYGERRegistAction.class);

	/**
	 * 表示用TestDataEntity
	 */
	private JoinDataEntity joinDataEntityTarget;

	/**
	 *  検索条件
	 */
	private JoinDataInputEntity joinDataInputEntity;

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

		JoinSampleBLogic blogic = new JoinSampleBLogic();
		try {
			joinDataEntityTarget = blogic.registData(joinDataInputEntity);
		} catch (PSQLException e) {
			addActionError(getText("invalid.regist.duplicate_id",
					new String[] { joinDataInputEntity.getEvent_id() }));
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
		JoinSampleBLogic blogic = new JoinSampleBLogic();
		List<JoinDataEntity> resultList = blogic.selectJoinData(joinDataInputEntity.getEvent_id());
		joinDataEntityTarget = resultList.get(0);

		log.debug("**** selectResultData End ****");

		return SUCCESS;
	}


	/**
	 * 入力条件をチェックする
	 */
	public void validateRegistData() {

		log.debug("****  validateRegistData START  ****");
		log.debug("testDataInputEntit\n"
				+ joinDataInputEntity.toString());

		// 名前チェック
		if (Common.IsNullOrEmpty(joinDataInputEntity.getUser_name())) {

			addActionError(getText("invalid.fieldvalue.user_name"));
		}

		// メールアドレスチェック
		if (Common.IsNullOrEmpty(joinDataInputEntity.getMailaddress())) {

			addActionError(getText("invalid.fieldvalue.mailaddress"));
		}

		// 数字キーチェック
		if (Common.IsNullOrEmpty(joinDataInputEntity.getKey())) {

			addActionError(getText("invalid.fieldvalue.key"));
		}

		// コメントチェック
		if (Common.IsNullOrEmpty(joinDataInputEntity.getComment())) {

			addActionError(getText("invalid.fieldvalue.comment"));
		}

		// 年齢チェック
		//if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

		//	addActionError(getText("invalid.fieldvalue.age"));
		//}

		log.debug("****  validateRegistData END  ****");
	}

	////////////////////////////////////
	// Setter / Getter

	/**
	 * joinDataEntityのgetter
	 *
	 * @return joinDataEntityTarget
	 */
	public JoinDataEntity getJoinDataEntityTarget() {
		return joinDataEntityTarget;
	}

	/**
	 * joinDataEntityのsetter
	 *
	 * @param joinDataEntityTarget 設定するJoinDataEntity
	 */
	public void setJoinDataEntityTarget(JoinDataEntity joinDataEntity) {
		this.joinDataEntityTarget = joinDataEntity;
	}

	/**
	 * joinDataInputEntityのgetter
	 *
	 * @return joinDataInputEntity
	 */
	public JoinDataInputEntity getJoinDataInputEntity() {
		return joinDataInputEntity;
	}

	/**
	 * joinDataInputEntityのsetter
	 *
	 * @param joinDataInputEntity 設定するjoinDataInputEntity
	 */
	public void setJoinDataInputEntity(JoinDataInputEntity joinDataInputEntity) {

		this.joinDataInputEntity = joinDataInputEntity;
	}

}
