package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyBatisDAO {
	
//	private static  MyBatisDAO mbDAO;
	private static SqlSessionFactory ssf;	//singleton ������ => �������,�ϰ�������
	
//	private MyBatisDAO() {
//	}
	
//	public static MyBatisDAO getInstance() {
//		if(mbDAO == null) {
//			mbDAO= new MyBatisDAO();
//		}
//		return mbDAO;
//	}//getInstance()
	
	/**
	 * SqlSessionFactory�� �������, �ϰ�������, ������ ���̼��� ���ؼ� Singleton pattern ���� ���
	 * @return SqlSessionFactory
	 */
	
	static { //static ����: ȣ������ �ʰ� Ŭ������ �����Ǹ� �ڵ� ȣ��Ǵ� ����, ���α׷� ����� 1���� ȣ��, method�� ������� ���� �����
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	
//	private static SqlSessionFactory getSessionFactory() {
		
		if(ssf == null) {
			try {
				//1.�������ϰ� ����
				Reader reader= Resources.getResourceAsReader("kr/co/sist/dao/mybatis-config.xml");
				//2.Mybatis Framework ����
				ssf= new SqlSessionFactoryBuilder().build(reader);
				//3.��Ʈ�� �ݱ�
				if(reader != null) {reader.close();}//end if
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
	
		//return ssf;
		
	}// static ����  getSesseionFactory
	
	public SqlSession getMybatisHandler(boolean autoCommit) {
		
		//SqlSession ss= null;
		//ss=/*getSessionFactory()*/ssf.openSession(autoCommit);
		return ssf.openSession(autoCommit);
	}
	
	public void closeHandler(SqlSession ss) {
		if(ss != null) {ss.close();}
	}
	
	
}
