package sugiim.struts2sample.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sugiim.struts2sample.common.Consts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウト用Actionクラス
 *
 * @author iiyamatk
 *
 */
public class LogoutAction extends ActionSupport {
	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 画面を遷移する
	 *
	 * @return success
	 */
	public String execute() {

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute(Consts.SESSION_KEY_EMPLOYEE);
		return SUCCESS;
	}
}
