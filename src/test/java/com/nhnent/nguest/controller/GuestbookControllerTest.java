package com.nhnent.nguest.controller;

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
public class GuestbookControllerTest {
	@Autowired
	GuestbookController guestbookController;

	@Autowired
	private SqlSessionTemplate sql;

	@Before
	public void 초기화() {
		sql.delete("test.delete");
	}

	@Test
	public void 컨트롤러_테스트() {
		GuestbookVO guestbookVo = new GuestbookVO();

		guestbookVo.setEmail("test");
		guestbookVo.setPasswd("test");
		guestbookVo.setText("Testing");
		
		Assert.assertSame("redirect:/", guestbookController.add(guestbookVo));
		
		guestbookVo.setText("Change!");
		Assert.assertSame("redirect:/", guestbookController.modify(guestbookVo));
		Assert.assertSame("redirect:/", guestbookController.remove(guestbookVo));
		
		Assert.assertSame("error", guestbookController.error());
		
		Assert.assertNotNull(guestbookController.home());
	}
}
