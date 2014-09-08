package com.nhnent.nguest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhnent.nguest.dao.GuestbookDao;
import com.nhnent.nguest.vo.GuestbookVO;

@Service
public class GuestbookService {
	public static final int SUCCESS = 1;
	
	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVO> readGuestbooks() {
		return guestbookDao.selectList();
	}
	
	public boolean createGuestbook(GuestbookVO guestbookVo) {
		return resultService(guestbookDao.insert(guestbookVo));
		
	}

	public boolean updateGuestbook(GuestbookVO guestbookVo) {
		return resultService(guestbookDao.update(guestbookVo));
	}

	public boolean deleteGuestbook(GuestbookVO guestbookVo) {
		return resultService(guestbookDao.delete(guestbookVo));
	}

	public boolean resultService(int result) {
		if (result == SUCCESS) {
			return true;
		} else {
			return false;
		}
	}
}