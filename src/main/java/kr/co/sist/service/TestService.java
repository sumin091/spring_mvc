package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public List<String> searchNames(){
		List<String> list= new ArrayList<String>();
		list.add("������");
		list.add("�蹫��");
		list.add("�赿��");
		list.add("�̸�ȭ");
		list.add("�ڽ���");
		return list;
	}
	
	public String searchId() {
		String[] ids="kim,yoon,kimdong,lee,park".split(",");
		
		return ids[new Random().nextInt(ids.length)];
	}
}
