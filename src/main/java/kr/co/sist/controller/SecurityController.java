package kr.co.sist.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sist.vo.LoginVO;
import lombok.Getter;
import lombok.Setter;

@Controller

public class SecurityController {

	@PostMapping("/day0614/login_process.do")
	public String loginProcess(LoginVO lv,Model model) {
		//서비스를 사용하여 입력된 아이디와 비밀번호를 쿼리문에 넣어 실행하게 된다.
		PasswordEncoder pe= new BCryptPasswordEncoder();
		//2.암호화
		String dbPass="test1234";
		String cipherPass=pe.encode(dbPass);
		
		boolean loginFlag=pe.matches(lv.getPass(), cipherPass);
		model.addAttribute("loginResult",loginFlag);
		return "day0614/login_result";
	}//loginProcess
	
	@GetMapping("/day0614/plain_text.do")
	public String searchUser(Model model) {
		//DBMS에서 조회된 결과
		String name="431990f38badda8f74279286080ac7ddb85f21f46e4b1b9e3da034783e7504c8";
		String email="f7a6f6e52eca6011f913031f1427352596e7d0de7a5ee926d23c83c9666c7f3b";
		
		String key="test1234";
		String salt="123456";
		
		//1.암호화 객체생성
		TextEncryptor te= Encryptors.text(key, salt);
		//2.복호화
		model.addAttribute("name",te.decrypt(name));
		model.addAttribute("email",te.decrypt(email));
		
		
		return"day0614/plain_text";
	}//searchUser
	
	public static void main(String[] args) {
//		
//		//1.암호화 객체 생성
//		PasswordEncoder pe= new BCryptPasswordEncoder();
//		//2.암호화
//		String plainPass="test1234";
//		String cipherPass=pe.encode(plainPass);//회원가입시 insert
//		System.out.println("평문 비번:"+plainPass);
//		System.out.println("암호화 비번:"+cipherPass);
//		
//		//3.
//		String inputPass="test1234";
//		String cipherPass2=pe.encode(plainPass);
//		System.out.println("암호화 비번:"+cipherPass2);
//		boolean flag=pe.matches(inputPass, cipherPass2);
//		System.out.println(flag);
		
//		암호화,복호화
		String name="이명화";
		String email="lee@test.com";
		
		String key="test1234";
		String salt="123456";
		
		//1.암호화 객체생성
		TextEncryptor te= Encryptors.text(key, salt);
		
		//2.암호화 (DB insert)
		String cipherName= te.encrypt(name);
		String cipherEmail= te.encrypt(email);
		System.out.println("암호화된 이름:"+cipherName);
		System.out.println("암호화된 이메일:"+cipherEmail);
		
		//3.복호화 (사용자에게 보여질때)
		String pName=te.decrypt(cipherName);
		String pEmail=te.decrypt(cipherEmail);
		System.out.println("복호화 이름:"+pName);
		System.out.println("복호화 이메일:"+pEmail);
		
	}//main
}
