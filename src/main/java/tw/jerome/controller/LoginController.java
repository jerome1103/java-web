package tw.jerome.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@PostMapping(value = "/user/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						Map<String,Object> map,HttpSession session) {
		
		if(StringUtils.hasText(username) && "1234".equals(password)) {
			//登入成功
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		}
		//登入失敗
		map.put("msg", "登入失敗");
		return "login";
	}
	
}
