package com.supermarket.pssmsys.web.departmentadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pssmsys.entity.JobDepartment;
import com.supermarket.pssmsys.service.JobDepartmentService;

@Controller
@RequestMapping("/depadmin")
public class DepartmentController {
	@Autowired
	private JobDepartmentService jobDepartmentService;
	
	@RequestMapping(value = "/getdeplist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getJobDepartmentListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<JobDepartment> jobDepartmentList=jobDepartmentService.getJobDepartmentAll();
		modelMap.put("jobDepartmentList", jobDepartmentList);
		return modelMap;
	}
}
