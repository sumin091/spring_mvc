package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TestController {

	@GetMapping("/index.do")
	public String main() {
		return "index";//view 페이지명 prefix로 WEB-INF/views/index.jsp를 찾는다.
	}//main
	
	//@RequestMapping("/get.do")
	//@RequestMapping(value="/get.do", method=RequestMethod.GET)
	@GetMapping("/get.do")
	public String get(HttpServletRequest request, Model model) {
		model.addAttribute("method", request.getMethod());
		
		return "day0604/result";//WEB-INF/views/day0604/get.jsp
	}//get
	
	//@RequestMapping(value="/post.do", method=RequestMethod.POST)
	@PostMapping("/post.do")
	public String post(HttpServletRequest request, Model model) {
		model.addAttribute("method", request.getMethod());

		return "day0604/result";
	}
	
	/**
	 * 요청방식이 GET방식이든 POST방식이든 모든 방식으로 요청을 처리해야한다면
	 * @requestMapping을 사용한다.
	 * 
	 * @param request
	 * @param model
	 * return
	 */
	
	@RequestMapping(value="/get_post.do",method= /* static import 전{RequestMethod.GET, RequestMethod.POST}*/ {GET,POST})
	public String getpost(HttpServletRequest request, Model model) {
		model.addAttribute("method", request.getMethod());

		return "day0604/result";
	}
	/**
	 * 여러 요청을 모아서 처리할때
	 * @return
	 */
	
	@RequestMapping(value={"/a.do","/b.do","/yana.do"}, method=GET)
	public String integratedUrl(Model model) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
		model.addAttribute("date",sdf.format(new Date()));
		return "day0605/integrated";
	}
	
}//class
