package kr.co.sist.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.dao.test.TestEmpDAO;
import kr.co.sist.domain.EmpDomain;

@Service
public class MybatisService {
	@Autowired(required = false)
	private TestEmpDAO teDAO;
	
	public List<EmpDomain> searchEmp(int deptno){
		List<EmpDomain> list=null;
		try {
		list=teDAO.selectEmp(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		return list;
	}
}
