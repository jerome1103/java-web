package tw.jerome.infra.component;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tw.jerome.infra.component.exception.UserNotExistException;

@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e,HttpServletRequest req) {
		Map<String,Object> map = new HashMap<>();
		req.setAttribute("javax.error.status_code", 400);
		map.put("code", "user.noteexts");
		map.put("message", e.getMessage());	
		req.setAttribute("ext", map);
		return "forward:/error";
	}
}
