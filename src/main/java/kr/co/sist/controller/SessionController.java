package kr.co.sist.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;
@SessionAttributes("modelName")
@Controller
public class SessionController {
	@GetMapping("/day0610/set_session.do")
	   public String setSession(HttpServletRequest request, HttpSession session, Model model) {
	      
	      WebUtils.setSessionAttribute(request, "webUtils", "이명화");
	      session.setAttribute("sesName", "정명호");
	      model.addAttribute("modelName","박시현");
	      
	      return "day0610/set_session_result";   
	   }//setSession
	   
	@GetMapping("/day0610/get_session.do")
	   public String getSession(HttpServletRequest request, HttpSession session, Model model) {
	         System.out.println("session:"+ session.getAttribute("sesName"));
	         System.out.println("model:"+ model.getAttribute("modelName"));
	         
	         String name=(String)WebUtils.getSessionAttribute(request, "sesName");
	         String name2=(String)WebUtils.getSessionAttribute(request, "modelName");
	         String name3=(String)WebUtils.getSessionAttribute(request, "webUtils");
	         
	         System.out.println("WebUtils : " + name + "," + name2 + "," + name3);
	         return "day0610/session_result";
	      }//getSession

	@GetMapping("/day0610/remove_session.do")
	public String removeSession(HttpSession session) {
		session.removeAttribute("sesName");
		session.removeAttribute("modelName");//Model을 통해서 설정된 값은 삭제되지 않는다.
		
		return "day0610/set_session_result";
	}//removeSession
	
	@GetMapping("/day0610/remove_session2.do")
	public String removeSession2(SessionStatus ss) {
		System.out.println(ss.isComplete());
		ss.setComplete();//세션 사용 종료 (Model에 설정된 세션이 삭제된다.)
		System.out.println(ss.isComplete());
		
		return "day0610/set_session_result";
		
		//return "redirect:/index.do";	
		//redirect:로 이동하면 SessionAttribute로 설정한 세션명과 값이 QueryString으로 생성되는 현상이 생길수 있다. 
		//=> 해결 redirect:를 직접 사용하지 않는다.
	}//removeSession2
	
	@GetMapping("/day0611/add_cookie.do")
	public String addCookie(HttpServletResponse response) {
		//1.쿠키생성
		Cookie cookie= new Cookie("name", "박시현");
		Cookie cookieAge= new Cookie("age", "25");
		//2.생존시간 설정
		cookie.setMaxAge(60*1);
		cookieAge.setMaxAge(60*1);
		//3.쿠키심기
		response.addCookie(cookie);
		response.addCookie(cookieAge);
		return "day0611/add_cookie_result";
	}//addCookie
	
	@GetMapping("/day0611/cookie_annotation.do")
	public String getCookieAnnotation(
			@CookieValue(name="name",defaultValue="정명호") String name,
			@CookieValue (name="age",defaultValue="24")int age,
			Model model) {
		model.addAttribute("msg","@CookieValue annotation");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		System.out.println("쿠키 값:"+name+"/"+ age);
		
		return "day0611/get_cookie";
	}//getCookieAnnotation
	
	@GetMapping("/day0611/web_utils.do")
	public String useWebUtils(HttpServletRequest request, Model model) {
//		String name=WebUtils.getCookie(request, "name").getValue();
//		String age =WebUtils.getCookie(request, "age").getValue();

		Cookie nameCookie=WebUtils.getCookie(request, "name");
		Cookie ageCookie =WebUtils.getCookie(request, "age");
		
		String name="";
		if(nameCookie != null) {
			name=nameCookie.getValue();
		}//end if
		
		String age="";
		if(ageCookie != null) {
			age=ageCookie.getValue();
		}//end if
		
		model.addAttribute("msg", "WebUtils");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		System.out.println("WebUtils 쿠키 값:"+name+"/"+ age);
		
		return "day0611/get_cookie";
	}//addCookie
}
