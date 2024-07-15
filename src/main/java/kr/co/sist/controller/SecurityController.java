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
		//���񽺸� ����Ͽ� �Էµ� ���̵�� ��й�ȣ�� �������� �־� �����ϰ� �ȴ�.
		PasswordEncoder pe= new BCryptPasswordEncoder();
		//2.��ȣȭ
		String dbPass="test1234";
		String cipherPass=pe.encode(dbPass);
		
		boolean loginFlag=pe.matches(lv.getPass(), cipherPass);
		model.addAttribute("loginResult",loginFlag);
		return "day0614/login_result";
	}//loginProcess
	
	@GetMapping("/day0614/plain_text.do")
	public String searchUser(Model model) {
		//DBMS���� ��ȸ�� ���
		String name="431990f38badda8f74279286080ac7ddb85f21f46e4b1b9e3da034783e7504c8";
		String email="f7a6f6e52eca6011f913031f1427352596e7d0de7a5ee926d23c83c9666c7f3b";
		
		String key="test1234";
		String salt="123456";
		
		//1.��ȣȭ ��ü����
		TextEncryptor te= Encryptors.text(key, salt);
		//2.��ȣȭ
		model.addAttribute("name",te.decrypt(name));
		model.addAttribute("email",te.decrypt(email));
		
		
		return"day0614/plain_text";
	}//searchUser
	
	public static void main(String[] args) {
//		
//		//1.��ȣȭ ��ü ����
//		PasswordEncoder pe= new BCryptPasswordEncoder();
//		//2.��ȣȭ
//		String plainPass="test1234";
//		String cipherPass=pe.encode(plainPass);//ȸ�����Խ� insert
//		System.out.println("�� ���:"+plainPass);
//		System.out.println("��ȣȭ ���:"+cipherPass);
//		
//		//3.
//		String inputPass="test1234";
//		String cipherPass2=pe.encode(plainPass);
//		System.out.println("��ȣȭ ���:"+cipherPass2);
//		boolean flag=pe.matches(inputPass, cipherPass2);
//		System.out.println(flag);
		
//		��ȣȭ,��ȣȭ
		String name="�̸�ȭ";
		String email="lee@test.com";
		
		String key="test1234";
		String salt="123456";
		
		//1.��ȣȭ ��ü����
		TextEncryptor te= Encryptors.text(key, salt);
		
		//2.��ȣȭ (DB insert)
		String cipherName= te.encrypt(name);
		String cipherEmail= te.encrypt(email);
		System.out.println("��ȣȭ�� �̸�:"+cipherName);
		System.out.println("��ȣȭ�� �̸���:"+cipherEmail);
		
		//3.��ȣȭ (����ڿ��� ��������)
		String pName=te.decrypt(cipherName);
		String pEmail=te.decrypt(cipherEmail);
		System.out.println("��ȣȭ �̸�:"+pName);
		System.out.println("��ȣȭ �̸���:"+pEmail);
		
	}//main
}
