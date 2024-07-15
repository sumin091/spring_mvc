package kr.co.sist.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AjaxService {

	public String jsonData() {
		JSONObject jsonObj= new JSONObject();
		
		jsonObj.put("msg", "기분좋은 박시현");
		jsonObj.put("msg2", "기분좋은 이명화");
		
		return jsonObj.toJSONString();
	}//jsonData
	
	public String jsonData2() {
		JSONObject jsonObj= new JSONObject();
		
		jsonObj.put("name", "이명화");

		JSONArray jsonArr= new JSONArray();
		String[] lunchList="황상,김천,새마을식당,제주은희네,탄,연탄마을,명동칼국수,원당감자탕,도야짬뽕".split(",");
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
