package kr.co.sist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.EmpDomain;
import kr.co.sist.service.MybatisService;

@Controller
public class MyBatisController {
	
	@Autowired(required = false)
	private MybatisService mbs;
	
	@GetMapping("/day0613/mybatis_search.do")
	public String searchEmp(@RequestParam(required = false, defaultValue = "10") int deptno, Model model) {
		List<EmpDomain> list= mbs.searchEmp(deptno);
		model.addAttribute("listEmp",list);
		
		return "day0613/emp_result";
	}
}
