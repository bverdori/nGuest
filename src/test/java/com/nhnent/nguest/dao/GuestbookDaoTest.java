package com.nhnent.nguest.dao;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nhnent.nguest.vo.GuestbookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/test-servlet-context.xml",
	"file:src/test/resources/mybatisTest.xml"})
public class GuestbookDaoTest {
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sql;
	
	@Before
	public void 초기화() {
		sql.delete("test.delete");
	}
	
	@Test
	public void Dao_테스트() {
GuestbookVO guestbookVo = new GuestbookVO();
		
		guestbookVo.setId("test");
		guestbookVo.setPasswd("test");
		guestbookVo.setText("Testing");
	}
}
