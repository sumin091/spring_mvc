package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	@GetMapping("/day0611/test_exception.do")
	public String testException()throws RuntimeException {
		
		if(new Random().nextBoolean()) {
			throw new RuntimeException("예외가 발생쒀 좋아쒀~");
		}//end if
		
		return "day0611/exception_result";
	}//testException
	
	@GetMapping("/day0611/test_exception2.do")
	public String testException2()throws RuntimeException {
		
		if(new Random().nextBoolean()) {
			throw new RuntimeException("예외발생");
		}//end if
		
		return "day0611/exception_result";
	}//testException2
	
	//이 Controller에서 발생한 모든 RuntimeException은 exceptionProcess method로 들어간다.
	@ExceptionHandler(RuntimeException.class)
	//1.@ExceptionHandler에 정의한 Exception을 매개변수로 선언, 반환형을 M.A.V 설정
	public ModelAndView exceptionProcess(RuntimeException re) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("day0611/exception_process");
		mav.addObject("msg",re.getMessage());
		mav.addObject("msg2",re.toString());
		return mav;
	}//exceptionProcess
}
