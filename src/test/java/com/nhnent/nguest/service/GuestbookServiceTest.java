package com.nhnent.nguest.service;

import junit.framework.Assert;

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
public class GuestbookServiceTest {
	@Autowired
	GuestbookService guestbookService;
	
	@Autowired
	private SqlSessionTemplate sql;
	
	@Before
	public void 초기화() {
		sql.delete("test.delete");
	}
	
	@Test
	public void 서비스_테스트() {
		GuestbookVO guestbookVo = new GuestbookVO();

		guestbookVo.setEmail("test");
		guestbookVo.setPasswd("test");
		guestbookVo.setText("Testing");
		
		Assert.assertTrue(guestbookService.createGuestbook(guestbookVo));
		
		guestbookVo.setText("Change!");
		Assert.assertTrue(guestbookService.updateGuestbook(guestbookVo));
		
		Assert.assertTrue(guestbookService.deleteGuestbook(guestbookVo));
	}
}
