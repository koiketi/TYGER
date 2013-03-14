package sugiim.struts2sample.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import sugiim.struts2sample.action.LoginAction;
import sugiim.struts2sample.blogic.LoginBLogic;
import sugiim.struts2sample.common.Common;
import sugiim.struts2sample.common.Consts;
import sugiim.struts2sample.entity.Employee;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ログイン用Interceptorクラス
 *
 * @author iiyamatk
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * ログ
	 */
	private Log log = LogFactory.getLog(LoginInterceptor.class);


	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * intercept処理
	 *
	 * @param actioninvocation ActionInvocation
	 * @return invoke
	 */
	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {

		System.out.println("*** LoginInterceptor START ***");

		// Sessionから値を取得
		HttpSession session = ServletActionContext.getRequest().getSession();
		Employee employee = (Employee) session
				.getAttribute(Consts.SESSION_KEY_EMPLOYEE);

		if (log.isInfoEnabled()) {
			// ログイン情報をINFOログ出力する
			log.info("logged in by:"
					+ (employee == null ? "null" : employee.getEmployeeId()));
		}

		Object action = actioninvocation.getAction();

		if (log.isDebugEnabled()) {

			// DEBUG用に呼び出し情報をDEBUG出力する
			StringBuffer sb = new StringBuffer();
			sb.append("call by :").append(action.getClass().getSimpleName());
			sb.append(" methods:").append(actioninvocation.getInvocationContext().getName());

			log.debug(sb.toString());
		}

		// LoginActionとそれ以外では動作が異なるので、LoginActionかどうかのフラグを持つ
		boolean bLoginAction = false;
		if (action instanceof LoginAction) {
			bLoginAction = true;
		}

		// セッションから値が取得できたかどうか判断
		if (employee == null || Common.IsNullOrEmpty(employee.getEmployeeId())
				|| Common.IsNullOrEmpty(employee.getPassword())) {

			if (bLoginAction) {

				if (log.isDebugEnabled()) {
					log.debug("1.session not found. loginAction continue.");
				}

				// ログイン画面はそのままログインを実行
				return actioninvocation.invoke();
			} else {

				if (log.isDebugEnabled()) {
					log.debug("2.session not found. foward loginAction.");
				}

				// ログイン画面以外はログイン画面に遷移
				return Consts.ACTION_RESULT_LOGIN;
			}

		} else {

			// セッションのIDとパスで再度検索し、存在チェックを行う
			LoginBLogic loginBL = new LoginBLogic();
			Employee emp = loginBL.getLoginUser(employee);

			if (emp == null) {

				if (log.isDebugEnabled()) {
					log.debug("3.session exists. Employee is not found. forward loginAction.");
				}

				// 偽のセッションか削除されたIDなので、ログアウトと同様にセッションから値を削除する
				session.removeAttribute(Consts.SESSION_KEY_EMPLOYEE);

				// 取得できない場合はログインに遷移させる
				return Consts.ACTION_RESULT_LOGIN;

			} else {

				// 取得できた場合はログインを維持し、処理を継続する
				// sessionに従業員＆店舗名オブジェクトを設定
				session.setAttribute(Consts.SESSION_KEY_EMPLOYEE, emp);

				if (bLoginAction) {

					if (log.isDebugEnabled()) {
						log.debug("4.session exists. Employee exists. forward Menu.");
					}

					// ログイン済みでログインに遷移しようとした場合はメインメニューに遷移する
					return Consts.ACTION_RESULT_MENU;
				} else {

					if (log.isDebugEnabled()) {
						log.debug("5.session exists. Employee exists. forward targetAction.");
					}

					// ログイン済みでログイン以外に遷移しようとした場合は	そのまま遷移する
					return actioninvocation.invoke();
				}
			}

		}
	}
}