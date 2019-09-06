package com.supermarket.pssmsys.web.positionadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pssmsys.entity.JobPosition;
import com.supermarket.pssmsys.service.JobPositionService;

@Controller
@RequestMapping("/posadmin")
public class PositionController {
	@Autowired
	private JobPositionService jobPositionService;
	
	@RequestMapping(value = "/getposlist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getJobPositionListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<JobPosition> jobPositionList=jobPositionService.getJobPositionListAll();
		modelMap.put("jobPositionList", jobPositionList);
		return modelMap;
	}
}
