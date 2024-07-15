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
			throw new RuntimeException("���ܰ� �߻��� ���ƾ�~");
		}//end if
		
		return "day0611/exception_result";
	}//testException
	
	@GetMapping("/day0611/test_exception2.do")
	public String testException2()throws RuntimeException {
		
		if(new Random().nextBoolean()) {
			throw new RuntimeException("���ܹ߻�");
		}//end if
		
		return "day0611/exception_result";
	}//testException2
	
	//�� Controller���� �߻��� ��� RuntimeException�� exceptionProcess method�� ����.
	@ExceptionHandler(RuntimeException.class)
	//1.@ExceptionHandler�� ������ Exception�� �Ű������� ����, ��ȯ���� M.A.V ����
	public ModelAndView exceptionProcess(RuntimeException re) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("day0611/exception_process");
		mav.addObject("msg",re.getMessage());
		mav.addObject("msg2",re.toString());
		return mav;
	}//exceptionProcess
}
