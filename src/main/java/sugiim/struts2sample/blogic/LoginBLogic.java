package sugiim.struts2sample.blogic;

import sugiim.struts2sample.dao.EmployeeDao;
import sugiim.struts2sample.entity.Employee;


/**
 *ログイン画面のBusinessLogicクラス
 *
 * @author iiyamatk
 *
 */
public class LoginBLogic {

	/**
	 * Employee のIDとPasswordを元に取得する。
	 *
	 * @param employee IDとPasswordが格納された従業員オブジェクト
	 * @return IDとPasswordに対応した従業員データ
	 * @throws Exception
	 */
	public Employee getLoginUser(Employee employee)throws Exception{
		EmployeeDao empdao = new EmployeeDao();

		return empdao.selectByIdAndPassword(employee);

	}

}
