package sugiim.struts2sample.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;

/**
 * ExceptionMappingInterceptorの拡張クラス
 *
 * @author iiyamatk
 *
 */
public class SampleExceptionMappingInterceptor extends ExceptionMappingInterceptor {

	/**
	 * シリアル値
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * intercept処理
	 *
	 * @param invocation ActionInvocation
	 * @return invoke
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("*** SampleExceptionMappingInterceptor ***");

		String result = "";

		try {
			result = invocation.invoke();
		} catch (Exception e) {

			// Exception発生時、こちらに入る

			if (isLogEnabled()) {
				handleLogging(e);
			}

			List<ExceptionMappingConfig>  exceptionMappings = invocation
					.getProxy().getConfig().getExceptionMappings();

			String mappedResult = this.findResultFromExceptions(
					exceptionMappings, e);


			if (mappedResult != null) {

				Exception ex = e;

				result = mappedResult;
				publishException(invocation, new ExceptionHolder(ex));

			} else {
				throw e;
			}
		}

		return result;
	}

}