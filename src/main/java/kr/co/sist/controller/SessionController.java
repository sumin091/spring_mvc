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
	      
	      WebUtils.setSessionAttribute(request, "webUtils", "�̸�ȭ");
	      session.setAttribute("sesName", "����ȣ");
	      model.addAttribute("modelName","�ڽ���");
	      
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
		session.removeAttribute("modelName");//Model�� ���ؼ� ������ ���� �������� �ʴ´�.
		
		return "day0610/set_session_result";
	}//removeSession
	
	@GetMapping("/day0610/remove_session2.do")
	public String removeSession2(SessionStatus ss) {
		System.out.println(ss.isComplete());
		ss.setComplete();//���� ��� ���� (Model�� ������ ������ �����ȴ�.)
		System.out.println(ss.isComplete());
		
		return "day0610/set_session_result";
		
		//return "redirect:/index.do";	
		//redirect:�� �̵��ϸ� SessionAttribute�� ������ ���Ǹ�� ���� QueryString���� �����Ǵ� ������ ����� �ִ�. 
		//=> �ذ� redirect:�� ���� ������� �ʴ´�.
	}//removeSession2
	
	@GetMapping("/day0611/add_cookie.do")
	public String addCookie(HttpServletResponse response) {
		//1.��Ű����
		Cookie cookie= new Cookie("name", "�ڽ���");
		Cookie cookieAge= new Cookie("age", "25");
		//2.�����ð� ����
		cookie.setMaxAge(60*1);
		cookieAge.setMaxAge(60*1);
		//3.��Ű�ɱ�
		response.addCookie(cookie);
		response.addCookie(cookieAge);
		return "day0611/add_cookie_result";
	}//addCookie
	
	@GetMapping("/day0611/cookie_annotation.do")
	public String getCookieAnnotation(
			@CookieValue(name="name",defaultValue="����ȣ") String name,
			@CookieValue (name="age",defaultValue="24")int age,
			Model model) {
		model.addAttribute("msg","@CookieValue annotation");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		System.out.println("��Ű ��:"+name+"/"+ age);
		
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
		
		System.out.println("WebUtils ��Ű ��:"+name+"/"+ age);
		
		return "day0611/get_cookie";
	}//addCookie
}
