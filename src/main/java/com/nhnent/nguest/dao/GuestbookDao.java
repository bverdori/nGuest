/*
 * GuestbookDao.java 2014. 9. 9
 *
 * Copyright 2014 Bverdori. All rights Reserved. 
 * Use is subject to license terms.
 */

package com.nhnent.nguest.dao;

import java.util.List;

import com.nhnent.nguest.vo.GuestbookVO;

/**
 * GuestbookDao
 * 
 * @author Bverdori
 */
public interface GuestbookDao {
	public int insert(GuestbookVO guestbookVo);

	public int update(GuestbookVO guestbookVo);

	public int delete(GuestbookVO guestbookVo);

	public List<GuestbookVO> selectList();

	public int selectOne(GuestbookVO guestbookVo);
}
