package com.nhnent.nguest.vo;

import junit.framework.Assert;

import org.junit.Test;

public class GuestbookVoTest {
	@Test
	public void vo_테스트() {
		GuestbookVO guestbookVo = new GuestbookVO();
		
		guestbookVo.setEmail("test@test.com");
		guestbookVo.setPasswd("1234");
		guestbookVo.setText("Test!");
		guestbookVo.setRegdate("regdate time");
		guestbookVo.setUpdate("update time");
		
		Assert.assertSame("test@test.com", guestbookVo.getEmail());
		Assert.assertSame("1234", guestbookVo.getPasswd());
		Assert.assertSame("Test!", guestbookVo.getText());
		Assert.assertSame("regdate time", guestbookVo.getRegdate());
		Assert.assertSame("update time", guestbookVo.getUpdate());
	}
}
