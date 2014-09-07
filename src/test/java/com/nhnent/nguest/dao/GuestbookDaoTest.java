package com.nhnent.nguest.dao;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nhnent.nguest.vo.GuestbookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/test/resources/mybatisTest.xml"})
public class GuestbookDaoTest {
	@Autowired
	GuestbookDao guestbookDao;
	
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sql;

	@Before
	public void 초기화() {
		sql.delete("test.delete");
	}

	@Test
	public void 방명록_입력_테스트() {
		GuestbookVO guestbookVo = new GuestbookVO();

		guestbookVo.setEmail("test");
		guestbookVo.setPasswd("test");
		guestbookVo.setText("Testing");
		
		guestbookDao.insert(guestbookVo);
	}
}
