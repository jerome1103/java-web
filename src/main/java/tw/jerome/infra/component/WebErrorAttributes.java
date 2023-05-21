package tw.jerome.infra.component;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

// 給容器中加入自定義的ErrorAttributes
@Component
public class WebErrorAttributes extends DefaultErrorAttributes{
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> map = super.getErrorAttributes(webRequest, options);
		map.put("jerome", "jerome");
		// 異常處理器攜帶的數據
		// getAttribute(String,int)  int SCOPE_REQUEST = 0  int SCOPE_SESSION = 1;
		Object ext = webRequest.getAttribute("ext", 0);
		map.put("ext", ext);
		return map;
	}
	
}
