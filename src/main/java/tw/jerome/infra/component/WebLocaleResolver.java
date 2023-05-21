package tw.jerome.infra.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
/*
 * 語系
 */
public class WebLocaleResolver implements LocaleResolver {
	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		Locale local = Locale.getDefault();
		if(StringUtils.hasLength(l)) {
			String[] split = l.split("_");
			local = new Locale(split[0],split[1]);
		}
		return local;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
