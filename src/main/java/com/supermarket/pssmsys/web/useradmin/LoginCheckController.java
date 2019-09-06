package com.supermarket.pssmsys.web.useradmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pssmsys.entity.LocalAccount;
import com.supermarket.pssmsys.service.LocalAccountService;
import com.supermarket.pssmsys.util.CodeUtil;
import com.supermarket.pssmsys.util.HttpServletRequestUtil;


@Controller
@RequestMapping("/local")
public class LoginCheckController {
	@Autowired
	private LocalAccountService localAccountService;
	

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> loginCheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		// 获取输入的帐号
		String userName = HttpServletRequestUtil.getString(request, "accountString");
		// 获取输入的密码
		String password = HttpServletRequestUtil.getString(request, "passwrodString");
		// 非空校验
		if (userName != null && password != null) {
			
			// 传入帐号和密码去获取平台帐号信息
			LocalAccount taregtItem1 = localAccountService.getLocalAccountByAccountAndPassword(userName, password);
			if (taregtItem1 != null) {
				// 若能取到帐号信息则登录成功
				modelMap.put("success", true);
				// 同时在session里设置用户信息
				if(userName.equals("administrator")) {
					request.getSession().setAttribute("admin", taregtItem1.getAccountString());
					modelMap.put("usertype", "admin");
				}else {
					request.getSession().setAttribute("admin", taregtItem1.getAccountString());
					modelMap.put("usertype", "normal");
				}
				
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	/**
	 * 当用户点击登出按钮的时候注销session
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String logout(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 将用户session置为空
		request.getSession().setAttribute("admin", null);
		modelMap.put("success", true);
		return "comm/login";
	}
}
