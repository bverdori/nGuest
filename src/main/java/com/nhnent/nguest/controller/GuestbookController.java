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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestbookVO guestbookVo) {
		return redirectUrl(guestbookService.createGuestbook(guestbookVo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(GuestbookVO guestbookVo) {
		return redirectUrl(guestbookService.updateGuestbook(guestbookVo));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(GuestbookVO guestbookVo) {
		return redirectUrl(guestbookService.deleteGuestbook(guestbookVo));
	}

	public String redirectUrl(boolean result) {
		if (result == true) {
			return "redirect:/";
		} else {
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
}
