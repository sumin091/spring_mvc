package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class includeController {

	@GetMapping("/day0610/jsp_include.do")
	public String useInclude() {
		
		return "day0610/include_test";
	}
	
	@GetMapping("/day0610/temp.do")
	public String tempInclude() {
		
		return "common/jsp/temp";
	}
	
	@GetMapping("/day0610/do_include.do")
	public String doInclude() {
		
		return "day0610/do_includetemp";
	}
}
