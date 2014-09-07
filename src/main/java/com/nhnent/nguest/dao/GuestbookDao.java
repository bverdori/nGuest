package com.nhnent.nguest.dao;

import java.util.List;

import com.nhnent.nguest.vo.GuestbookVO;

public interface GuestbookDao {
	public int insert(GuestbookVO guestbookVo);
	
	public int update(GuestbookVO guestbookVo);
	
	public int delete(GuestbookVO guestbookVo);
	
	public List<GuestbookVO> selectList();
}
