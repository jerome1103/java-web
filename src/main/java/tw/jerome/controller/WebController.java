package tw.jerome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import tw.jerome.infra.component.exception.UserNotExistException;

@Controller
public class WebController {
	@Autowired
	WebApplicationContext ApplicationContext;
	//從Java Bean裡面查詢已註冊的Mapping
	@ResponseBody
	@GetMapping("/webapi")
	public List<Map<String, String>> webapi() {
		RequestMappingInfoHandlerMapping bean = ApplicationContext.getBean(RequestMappingInfoHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = bean.getHandlerMethods();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		
        for (Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            Map<String, String> map1 = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();  
            
            PathPatternsRequestCondition p = info.getPathPatternsCondition();
            if(p!=null) {
            	for (String url : p.getPatternValues()) {  
            		map1.put("url", url);
            	}  
            }
            
            map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名  
            map1.put("method", method.getMethod().getName()); // 方法名
            
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            for (RequestMethod requestMethod : methodsCondition.getMethods()) {
                map1.put("type", requestMethod.toString());
            }
            
            list.add(map1);
        }
		
        return list;
	}
	
	@GetMapping("/getError")
	public void hello() throws Exception {
		throw new UserNotExistException();	
	}
	
	@GetMapping("/test")
	public String test(){
		return "login";	
	}
}
