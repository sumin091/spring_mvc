package kr.co.sist.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class FileController {

	@GetMapping("/day0613/file_upload_frm.do")
	public String uploadFrm() {
	
		return "day0613/upload_frm";	//입력파일명과 반환파일명이 같다면 반환형 void여도
		
	}//uploadFrm
	
	@PostMapping("/day0613/upload_process.do")
	//1.HttpServletRequest받기
	public String uploadFrmProcess(HttpServletRequest request,String temp, Model model) throws IOException{
		File saveDir= new File("C:/dev/workspace_spring/spring_mvc/src/main/webapp/upload");
		
		int tempSize=100*1024*1024;
		System.out.println(System.getProperty("user.dir"));
		
		//2.파일업로드 클래스 생성
		MultipartRequest mr= new MultipartRequest(request, saveDir.getAbsolutePath(),
				tempSize,"UTF-8",new DefaultFileRenamePolicy());
		
		//업로더명 (web parameter)
		String uploader=mr.getParameter("uploader");
		String fsName=mr.getFilesystemName("upfile");
		String oriName=mr.getOriginalFileName("upfile");
		//최대크기 10Mybte
		int maxSize=10*1024*1024;
		
		File tempFile= new File(saveDir.getAbsolutePath()+"/"+fsName);
		
		boolean uploadFlag=false;
		if(tempFile.length() > maxSize) {//업로드 제한
			tempFile.delete();
			uploadFlag=true;
		}//end if
		
		model.addAttribute("uploader",uploader);
		model.addAttribute("fileName",oriName);
		model.addAttribute("uploadFlag",!uploadFlag);
		
		return "day0613/upload_result";
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIe(IOException ie) {
		ModelAndView mav= new ModelAndView("day0613/upload_err");
		mav.addObject("msg",ie.getMessage());
		
		return mav;
	}
}
