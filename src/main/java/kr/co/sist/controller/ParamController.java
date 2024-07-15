package kr.co.sist.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

@Controller
public class ParamController {
	
// 요청 URI와 JSP명이 같다면 반환형을 void로 해도된다.
//	@GetMapping("/day0604/param_frm.do")
//	public void paramFrm() {
//		
//	}
	
	@GetMapping("/day0604/param_frm.do")
	public String paramFrm() {
		
		return "day0604/param_frm";//WEB-INF/views/day0604/param_frm.jsp
	}
	
	/**
	 * HTML Form Control의 name 속성에 이름과 method의 parameter명이 같아야한다.
	 * String이 아닌 경우에 Framework에서 동일형으로 변환해준다. (int -> Integer.parseInt) 
	 * => 장 : VO를 만들지 않아도 된다.
	 * => 단 : 값을 전달하기 불편(묶여있음을 표현하기 어렵)고 코드가 지저분하다.
	 * @return
	 */
	
	@GetMapping("/day0604/single_param.do")
	public String singleDataType(@RequestParam(name="name") String name2, @RequestParam(defaultValue="0") int age, String email, Model model) {
		//int같은 경우 null이면 error, String은 null을 저장할 수 있다.
		model.addAttribute("msg","get방식의 요청");
		//web parameter의 유효성검증, service객체로 전달, 관계유지객체 설정
		System.out.println(name2+" "+age+" "+email);
		
		return "day0604/single_param";
	}
	
	@PostMapping("/day0604/post_single_param.do")
	public String postSingleDataType(String name, int age, String email, Model model) {
		model.addAttribute("msg","POST방식의 요청");
		//web parameter의 유효성검증, service객체로 전달, 관계유지객체 설정
		System.out.println("POST방식: "+name+" "+age+" "+email);
		//POST방식일때 Filter를 사용하지 않으면 각각의 한글을 encoding하여 사용한다. 
		//System.out.println(new String(name.getBytes("8859_1"),"UTF-8") );
		//System.out.println(URLDecoder.decode(URLEncoder.encode(name,"8859_1"),"UTF-8"));
		return "day0604/single_param";
	}
	
	@GetMapping("/day0605/vo_param.do")
	public String voParam(ParamVO pVO, Model model) {
		model.addAttribute("msg","GET방식의 VO를 사용한 요청 값 처리");
		return "day0604/single_param";
	}
	

	@PostMapping("/day0605/post_vo_param.do")
	public String postvoParam(ParamVO pVO, Model model) {
		model.addAttribute("msg","POST방식의 VO를 사용한 요청 값 처리");
		return "day0604/single_param";
	}
	
	@GetMapping("/day0605/hsr_param.do")
	public String hsrParam(HttpServletRequest request) {//model을 사용하지않고 httpservletrequest만 사용
		request.setAttribute("msg","HttpServletRequest를 사용한 요청 값 처리");
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		System.out.println(name+"/"+age);
		//접속자의 정보를 얻을수 있다.
		System.out.println("접속자IP "+request.getRemoteAddr()+"/ 접속자 port"+
				request.getRemotePort());
		
		Enumeration<String> en= request.getHeaderNames();
		String headerName="";
		String referer="";
		while(en.hasMoreElements()) {
			headerName=en.nextElement();
			System.out.println(headerName+":"+request.getHeader(headerName));
			if("referer".equals(headerName)) {
				referer=request.getHeader(headerName);
			}
		}
		System.out.println("이 페이지를 요청한 URL: "+ referer);
		return "day0604/single_param";
	}//hsrParam
	
	@PostMapping("/day0605/post_hsr_param.do")
	public String postHsrParam(HttpServletRequest request) {//model을 사용하지않고 httpservletrequest만 사용
		request.setAttribute("msg","HttpServletRequest를 사용한 POST 요청 값 처리");
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		System.out.println(name+"/"+age);
		
		//접속자의 정보를 얻을수 있다.
		System.out.println("접속자IP "+request.getRemoteAddr()+"/ 접속자 port"+
				request.getRemotePort());
		
		String referer=request.getHeader("referer");
		String accept_language=request.getHeader("accept-language");
		System.out.println("이 페이지를 요청한 URL: "+ referer);
		System.out.println("이 페이지를 요청한 lang: "+ accept_language);
		if( !accept_language.contains("ko-KR")) {
			System.out.println("한국이 아님");
		}
		return "day0604/single_param";
	}//postHsrParam
	
	@GetMapping("/day0605/btn_rp.do")
	public String useRequestParam(@RequestParam(name="name", required=false, defaultValue="윤웅찬") String myName, 
			@RequestParam(defaultValue = "0")int age, 
			@RequestParam(defaultValue = "1")String currentPage,
			Model model) {
		model.addAttribute("msg","RequestParam사용");
		System.out.println("이름: "+myName+", 나이: "+age);
		
		return "day0604/single_param";
	}//useRequestParam
	
	@GetMapping("/day0605/btn_rp_vo.do")
	public String useRequestParamVO(ParamVO pVO, Model model) {
		model.addAttribute("msg","RequestParam사용");
		System.out.println("------"+pVO);
		
		return "day0604/single_param";
	}
	
}
