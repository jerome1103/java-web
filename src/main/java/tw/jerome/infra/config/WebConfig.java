package tw.jerome.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tw.jerome.infra.component.LoginHandlerInterceptor;
import tw.jerome.infra.component.WebLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 註冊首頁
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/main.html").setViewName("dashboard");
	}

	// 註冊攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new LoginHandlerInterceptor())
    			//要攔截的路徑
    			.addPathPatterns("/**")
    			//這個攔截器例外的路徑
    			.excludePathPatterns(
    					"/index.html","/","/user/login",
    					"/**/*.css","/**/*.js",
    					"/**/*.svg","/**/*.png","/**/*.jpg");
	}

	// 語系設定
	@Bean
	LocaleResolver localeResolver() {
		return new WebLocaleResolver();
	}

}
