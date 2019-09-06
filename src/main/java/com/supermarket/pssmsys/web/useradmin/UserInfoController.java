package com.supermarket.pssmsys.web.useradmin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.pssmsys.entity.UserInfo;
import com.supermarket.pssmsys.service.UserInfoService;
import com.supermarket.pssmsys.util.HttpServletRequestUtil;



@Controller
@RequestMapping("/userinfoadmin")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/getuserinfolist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getUserInfoListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<UserInfo> userInfoList=userInfoService.getUserInfoAll();
		modelMap.put("userInfoList", userInfoList);
		return modelMap;
	}
	/**
	 * 根据ID更新个人信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateUserInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserInfo someone = null;
		// 接收前端参数的变量的初始化
		ObjectMapper mapper = new ObjectMapper();
		try {
			String userInfoStr = HttpServletRequestUtil.getString(request, "userInfoStr");
			// 尝试获取前端传过来的表单string流并将其转换成UserInfo实体类
			someone = mapper.readValue(userInfoStr, UserInfo.class);
			Date aimTDate = (new Date());
			Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
			// 设置编辑时间
			someone.setEditTime(aimTimestamp);
			if (userInfoService.updateUserInfo(someone)) {
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	/**
	 * 添加一个用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adduserinfostr", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addUserInfoStr(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserInfo someone = null;
		// 接收前端参数的变量的初始化
		ObjectMapper mapper = new ObjectMapper();
		try {
			//前端传的用户信息对象
			String userInfoStr = HttpServletRequestUtil.getString(request, "userInfoStr");
			// 尝试获取前端传过来的表单string流并将其转换成UserInfo实体类
			someone = mapper.readValue(userInfoStr, UserInfo.class);
			Date aimTDate = (new Date());
			Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
			// 设置创建时间
			someone.setCreateTime(aimTimestamp);
			// 设置编辑时间
			someone.setEditTime(aimTimestamp);
			if (userInfoService.addUserInfo(someone)) {
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	/**
	 * 通过ID删除用户信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteuserinfobyid", method = RequestMethod.GET)
	private String deleteUserInfoById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer userId =Integer.parseInt(HttpServletRequestUtil.getString(request, "userId")) ;
		Boolean result = userInfoService.deleteUserInfo(userId);
		modelMap.put("result", result);
		return "user/list";
	}
}
