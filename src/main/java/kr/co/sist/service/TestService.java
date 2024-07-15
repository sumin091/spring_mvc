package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public List<String> searchNames(){
		List<String> list= new ArrayList<String>();
		list.add("À±¿õÂù");
		list.add("±è¹«¿µ");
		list.add("±èµ¿¼·");
		list.add("ÀÌ¸íÈ­");
		list.add("¹Ú½ÃÇö");
		return list;
	}
	
	public String searchId() {
		String[] ids="kim,yoon,kimdong,lee,park".split(",");
		
		return ids[new Random().nextInt(ids.length)];
	}
}
