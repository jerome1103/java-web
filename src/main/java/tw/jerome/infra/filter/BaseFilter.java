package tw.jerome.infra.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BaseFilter implements Filter{
	//初始化
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	//過濾
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter");
		chain.doFilter(request, response);
	}
	
	//銷毀
	@Override
	public void destroy() {
	}


}
