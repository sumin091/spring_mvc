package kr.co.sist.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AjaxService {

	public String jsonData() {
		JSONObject jsonObj= new JSONObject();
		
		jsonObj.put("msg", "������� �ڽ���");
		jsonObj.put("msg2", "������� �̸�ȭ");
		
		return jsonObj.toJSONString();
	}//jsonData
	
	public String jsonData2() {
		JSONObject jsonObj= new JSONObject();
		
		jsonObj.put("name", "�̸�ȭ");

		JSONArray jsonArr= new JSONArray();
		String[] lunchList="Ȳ��,��õ,�������Ĵ�,���������,ź,��ź����,��Į����,���簨����,����«��".split(",");
		JSONObject jsonTemp=null;
		for(String temp: lunchList) {
			jsonTemp= new JSONObject();
			jsonTemp.put("lunch", temp);
			jsonArr.add(jsonTemp);
		}//end for
		jsonObj.put("lunchList", jsonArr);
		return jsonObj.toJSONString();
	}//jsonData2
	

}
