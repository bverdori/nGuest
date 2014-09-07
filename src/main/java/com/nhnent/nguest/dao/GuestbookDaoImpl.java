package com.nhnent.nguest.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.nhnent.nguest.vo.GuestbookVO;

@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sql;

	@Override
	public int insert(GuestbookVO guestbookVo) {
		return sql.insert("nguest.insert", guestbookVo);
	}

}
