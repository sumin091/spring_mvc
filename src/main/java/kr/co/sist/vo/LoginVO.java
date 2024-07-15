package kr.co.sist.vo;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginVO {
	
	private String pass,id;
	
}
