/*
 * GuestbookDaoImpl.java 2014. 9. 9
 *
 * Copyright 2014 Bverdori. All rights Reserved. 
 * Use is subject to license terms.
 */

package com.nhnent.nguest.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nhnent.nguest.vo.GuestbookVO;

/**
 * GuestbookDaoImpl
 * 
 * @author Bverdori
 */
@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired
	private SqlSessionTemplate sql;

	@Override
	public int insert(GuestbookVO guestbookVo) {
		return sql.insert("nguest.insert", guestbookVo);
	}

	@Override
	public int update(GuestbookVO guestbookVo) {
		return sql.update("nguest.update", guestbookVo);
	}

	@Override
	public int delete(GuestbookVO guestbookVo) {
		return sql.delete("nguest.delete", guestbookVo);
	}

	@Override
	public List<GuestbookVO> selectList() {
		return sql.selectList("nguest.selectList");
	}

	@Override
	public int selectOne(GuestbookVO guestbookVo) {
		return sql.selectOne("nguest.selectOne", guestbookVo);
	}
}
