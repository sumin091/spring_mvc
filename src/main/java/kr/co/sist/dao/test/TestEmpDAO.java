package kr.co.sist.dao.test;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.EmpDomain;

@Component
public class TestEmpDAO {

	@Autowired(required = false)
	private MyBatisDAO mbDAO;
	
	public List<EmpDomain> selectEmp(int deptno)throws PersistenceException{
		
		List<EmpDomain> list=null;
		
		SqlSession ss= mbDAO.getMybatisHandler(false);
		list=ss.selectList("kr.co.sist.exam.mcmr",deptno);
		mbDAO.closeHandler(ss);
		
		return list;
	}
}
