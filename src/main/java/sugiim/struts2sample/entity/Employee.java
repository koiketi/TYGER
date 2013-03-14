/**
 *
 */
package sugiim.struts2sample.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 従業員クラス
 *
 * @author iiyamatk
 *
 */
public class Employee implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 従業員ID
	 */
	private String employeeId;

	/**
	 * 従業員名称
	 */
	private String employeeName;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 更新日時
	 */
	private Date updtDate;

	/**
	 * デフォルトコンストラクタ
	 */
	public Employee() {
	}

	/**
	 * コンストラクタ
	 *
	 * @param employeeId 従業員ID
	 * @param password パスワード
	 */
	public Employee(String employee_id, String employeeName, String password) {
		this.employeeId = employee_id;
		this.employeeName = employeeName;
		this.password = password;
	}


	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee ["
				+ (employeeId != null ? "employeeId=" + employeeId + ", " : "")
				+ (employeeName != null ? "employeeName=" + employeeName + ", "
						: "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (updtDate != null ? "updtDate=" + updtDate : "") + "]";
	}

	// 以下、getter, setter
	/**
	 * 従業員IDを取得する
	 *
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * 従業員IDを設定する
	 *
	 * @param employeeId セットする employeeId
	 */
	public void setEmployeeId(String employee_id) {
		this.employeeId = employee_id;
	}

	/**
	 * パスワードを取得する
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する
	 *
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 更新日時を取得する
	 *
	 * @return updtDate
	 */
	public Date getUpdtDate() {
		return updtDate;
	}

	/**
	 * 更新日時を設定する
	 *
	 * @param updtDate セットする updtDate
	 */
	public void setUpdtDate(Date updt_date) {
		this.updtDate = updt_date;
	}

	/**
	 * 従業員名称を取得する
	 *
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 従業員名称を設定する
	 *
	 * @param employeeName セットする employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


}
