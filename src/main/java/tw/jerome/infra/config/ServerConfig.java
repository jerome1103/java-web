package tw.jerome.infra.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.jerome.infra.filter.BaseFilter;
import tw.jerome.infra.listener.BaseListener;
import tw.jerome.infra.servlet.BaseServlet;

@Configuration
public class ServerConfig {
	//註冊Servlet請求
    @Bean
    ServletRegistrationBean<BaseServlet> baseServlet() {
		ServletRegistrationBean<BaseServlet> servletRegBean = new ServletRegistrationBean<BaseServlet>(new BaseServlet(),"/myservlet");
		return servletRegBean;
	};
	
	//註冊過濾器
	@Bean
	FilterRegistrationBean<BaseFilter> baseFilter(){
		FilterRegistrationBean<BaseFilter> regBean = new FilterRegistrationBean<BaseFilter>();
		regBean.setFilter(new BaseFilter());
		regBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
		return regBean;
	}
	
	//註冊監聽器
	@Bean
	ServletListenerRegistrationBean<BaseListener> baseListener(){
		ServletListenerRegistrationBean<BaseListener> regBean = new ServletListenerRegistrationBean<BaseListener>(new BaseListener());
		return regBean;
	}
}
