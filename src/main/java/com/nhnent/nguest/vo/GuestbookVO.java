/*
 * GuestbookVO.java 2014. 9. 9
 *
 * Copyright 2014 Bverdori. All rights Reserved. 
 * Use is subject to license terms.
 */
package com.nhnent.nguest.vo;

import javax.validation.constraints.Size;

import com.nhnent.nguest.validator.GuestbookGroup;

/**
 * GuestbookVO
 * 
 * @author Bverdori
 */
public class GuestbookVO {
	@Size(min = 1, max = 30, groups = {GuestbookGroup.class})
	private String email;
	@Size(min = 1, max = 30, groups = {GuestbookGroup.class})
	private String passwd;
	@Size(min = 1, max = 300, groups = {GuestbookGroup.class})
	private String text;
	private String regdate;
	private String update;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
}