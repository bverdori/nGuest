package com.nhnent.nguest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhnent.nguest.service.GuestbookService;
import com.nhnent.nguest.vo.GuestbookVO;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("guestbooks", guestbookService.readGuestbooks());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(GuestbookVO guestbookVo) {
		guestbookService.createGuestbook(guestbookVo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(GuestbookVO guestbookVo) {
		guestbookService.updateGuestbook(guestbookVo);
		return "redirect:/";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(GuestbookVO guestbookVo) {
		guestbookService.deleteGuestbook(guestbookVo);
		return "redirect:/";
	}
}
