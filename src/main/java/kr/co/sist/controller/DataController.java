package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.service.TestService;

@SessionAttributes("id")//request�� session �Ѵ� ���� ����.
@Controller
public class DataController {
	@Autowired(required = false)
	private TestService ts;
	
	/**
	 * HttpServletRequest, HttpSession�� ����� View�� �� ����
	 * @return
	 */
	@GetMapping("/day0605/hsr_hs.do")
	public String hsrHs(HttpServletRequest request, HttpSession session) {
		
		request.setAttribute("names", ts.searchNames());
		session.setAttribute("id",  ts.searchId());
		
		return "day0605/hsr_hs";
	}//hsrHs
	
	@GetMapping("/day0605/model.do")
	public String useModel(Model model) {

		model.addAttribute("names", ts.searchNames());//requestScope.names
		model.addAttribute("id",  ts.searchId());//requestScope.id, sessionScope.id �Ѵ� ��밡��

		//model�� �� ����
		return "/day0605/model";
	}
	
	@GetMapping("/day0605/mav.do")
	public ModelAndView useModelAndView() {
		//ModelAndView ����
		ModelAndView mav= new ModelAndView();
		//view �������� ����
		mav.setViewName("/day0605/mav");
		//view�������� ������ ������ ����
		mav.addObject("names", ts.searchNames());//requestScope.names
		mav.addObject("id",  ts.searchId());//requestScope.id, sessionScope.id �Ѵ� ��밡��

		//model�� �� ����
		return mav;
	}
}
