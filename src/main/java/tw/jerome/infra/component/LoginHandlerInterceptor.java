package tw.jerome.infra.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
/*
 * 攔截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
	//目標方法執行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		Object user = request.getSession().getAttribute("loginUser");
		if(user == null){
			//未登入，返回登入頁面
			request.setAttribute("msg", "沒有權限請先登錄");
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
		return true;
	}
}
