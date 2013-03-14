package sugiim.struts2sample.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * TestData用Entryクラス
 *
 * @author 杉井
 *
 */
public class TestDataEntity implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  ID
	 */
	private String person_id;

	/**
	 *  name
	 */
	private String name;

	/**
	 *  age
	 */
	private Integer age;

	/**
	 *  update date
	 */
	private Date updt_date;

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestDataEntity ["
				+ (person_id != null ? "person_id=" + person_id + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age + ", " : "")
				+ (updt_date != null ? "updt_date=" + updt_date : "") + "]";
	}

	/**
	 * IDを取得する
	 *
	 * @return ID
	 */
	public String getPerson_id() {
		return person_id;
	}


	/**
	 * IDを設定する
	 *
	 * @param person_id 設定ID
	 */
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	/**
	 * nameを取得する
	 *
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	/**
	 * nameを設定する
	 *
	 * @param name 設定名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ageを取得する
	 *
	 * @return 年齢
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * ageを設定する
	 *
	 * @param age 設定年齢
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * updt_dateを取得する
	 *
	 * @return 更新日時
	 */
	public Date getUpdt_date() {
		return updt_date;
	}
	/**
	 * updt_dateを設定する
	 *
	 * @param updt_date 設定更新日時
	 */
	public void setUpdt_date(Date updt_date) {
		this.updt_date = updt_date;
	}


}
