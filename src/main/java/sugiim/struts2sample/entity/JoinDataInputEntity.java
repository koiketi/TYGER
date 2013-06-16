package sugiim.struts2sample.entity;

import java.io.Serializable;

/**
 * JoinData用Entryクラス
 *
 * @author 杉井
 *
 */
public class JoinDataInputEntity implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  event_ID
	 */
	private String event_id;

	/**
	 *  user_name
	 */
	private String user_name;

	/**
	 *  mailaddress
	 */
	private String mailaddress;

	/**
	 *  key
	 */
	private String key;

	/**
	 *  comment
	 */
	private String comment;

	/**
	 *  cancel_flg
	 */
	private Boolean cancel_flg;

	/**
	 *  point
	 */
	private String point;
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("event_id:").append(this.event_id);
		sb.append("\nuser_name:").append(this.user_name);
		sb.append("\nmailaddress:").append(this.mailaddress);
		sb.append("\nkey:").append(this.key);
		sb.append("\ncomment:").append(this.comment);
		sb.append("\ncancel_flg:").append(this.cancel_flg);
		sb.append("\npoint:").append(this.point);

		return sb.toString();

	}

	/**
	 * IDを取得する
	 *
	 * @return ID
	 */
	public String getEvent_id() {
		return event_id;
	}
	/**
	 * IDを設定する
	 *
	 * @param event_id イベントID
	 */
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	/**
	 * 名称を取得する
	 *
	 * @return 名称
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * 名称を設定する
	 *
	 * @param user_name 設定名称
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * mailaddressを取得する
	 *
	 * @return mailaddress
	 */
	public String getMailaddress() {
		return mailaddress;
	}
	/**
	 * mailaddressを設定する
	 *
	 * @param mailaddress メールアドレス
	 */
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	/**
	 * keyを取得する
	 *
	 * @return ID
	 */
	public String getKey() {
		return key;
	}
	/**
	 * keyを設定する
	 *
	 * @param key 数字キー
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * commentを取得する
	 *
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * commentを設定する
	 *
	 * @param comment コメント
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * キャンセルフラグを取得する
	 *
	 * @return キャンセルフラグ
	 */
	public Boolean getCancel_flg() {
		return cancel_flg;
	}

	/**
	 * キャンセルフラグを設定する
	 *
	 * @param age キャンセルフラグ
	 */
	public void setCancel_flg(Boolean cancel_flg) {
		this.cancel_flg = cancel_flg;
	}

	/**
	 * Pointを取得する
	 *
	 * @return point
	 */
	public String getPoint() {
		return point;
	}

	/**
	 * pointを設定する
	 *
	 * @param point
	 */
	public void setPoint(String point) {
		this.point = point;
	}


}
