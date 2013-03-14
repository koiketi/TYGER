package sugiim.struts2sample.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import sugiim.struts2sample.blogic.LoginBLogic;
import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.common.Consts;
import sugiim.struts2sample.entity.Employee;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ログイン用Actionクラス
 *
 * @author iiyamatk
 *
 */
public class LoginAction extends ActionSupport {

	/**
	 * ログ
	 */
	private Log log = LogFactory.getLog(LoginAction.class);

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 従業員
	 */
	private Employee employee;


	/**
	 * 初期表示処理
	 *
	 * @return success
	 */
	public String execute() {

		return SUCCESS;
	}

	/**
	 * ログイン処理
	 *
	 * @return ログイン処理の結果
	 */
	public String login() throws Exception {

		// ログインできるか
		LoginBLogic loginBL = new LoginBLogic();
		employee = loginBL.getLoginUser(employee);

		// IDとパスで対象が取得できなかった
		if (employee == null) {

			addActionError(getText(Consts.ERROR_MESSAGE_LOGIN_TARGET_NOT_FOUND));
			return  Consts.ACTION_RESULT_LOGIN_FAILED;

		} else {

			// IDとパスで対象が取得できた
			if (log.isInfoEnabled()) {

				// ログインしたIDをINFOログ出力する。
				log.info("login by: " + employee.getEmployeeId());
			}

			// Session格納し、ヘッダーで表示、LoginInterceptorで従業員のチェックを出来るようにする
			HttpSession newsession = ServletActionContext.getRequest()
					.getSession(true);

			// sessionに従業員＆店舗名オブジェクトを設定
			newsession.setAttribute(Consts.SESSION_KEY_EMPLOYEE, employee);

			return Consts.ACTION_RESULT_LOGIN;
		}

	}

	/**
	 * ログインの入力チェック
	 */
	public void validateLogin() {

		// IDとPASSWORDが未入力の場合、エラーメッセージを表示
		if ((Common.IsNullOrEmpty(employee.getEmployeeId()))
				|| (Common.IsNullOrEmpty(employee.getPassword()))) {
			addActionError(getText(Consts.ERROR_MESSAGE_LOGIN_EMPTY));
		}

	}


	// getter, setter
	/**
	 * 従業員を取得する
	 *
	 * @return employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * 従業員を設定する
	 *
	 * @param employee セットする employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	////////////////////////////////////
	// Setter / Getter


}
