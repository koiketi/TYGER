package sugiim.struts2sample.entity;

import java.io.Serializable;

/**
 * TestData用Entryクラス
 *
 * @author 杉井
 *
 */
public class TestDataInputEntity implements Serializable {


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
	 *  point
	 */
	private String point;
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("person_id:").append(this.person_id);
		sb.append("\nname:").append(this.name);
		sb.append("\nage:").append(this.age);
		sb.append("\npoint:").append(this.point);

		return sb.toString();

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
	 * 名称を取得する
	 *
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称を設定する
	 *
	 * @param name 設定名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 年齢を取得する
	 *
	 * @return 年齢
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 年齢を設定する
	 *
	 * @param age 設定年齢
	 */
	public void setAge(Integer age) {
		this.age = age;
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
