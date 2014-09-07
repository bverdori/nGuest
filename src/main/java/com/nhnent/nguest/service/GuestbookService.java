package com.nhnent.nguest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhnent.nguest.dao.GuestbookDao;
import com.nhnent.nguest.vo.GuestbookVO;

@Service
public class GuestbookService {
	@Autowired
	GuestbookDao guestbookDao;
	
	public void createGuestbook(GuestbookVO guestbookVo) {
		guestbookDao.insert(guestbookVo);
	}

	public void updateGuestbook(GuestbookVO guestbookVo) {
		guestbookDao.update(guestbookVo);
	}

	public void removeGuestbook(GuestbookVO guestbookVo) {
		guestbookDao.delete(guestbookVo);
	}

	public void readGuestbooks(GuestbookVO guestbookVo) {
		guestbookDao.selectList();
	}
}
