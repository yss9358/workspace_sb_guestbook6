package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	// 리스트 가져오기
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<GuestbookVo> gbList = guestbookService.exeList();
		model.addAttribute("gbList",gbList);
		return "addList";
	}
	
	// 등록
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		int count = guestbookService.exeAdd(guestbookVo);
		System.out.println(count);
		return "redirect:/list";
	}
	
	// 삭제폼 
	@RequestMapping(value="/deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		return "deleteForm";
	}
	
	// 삭제
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		int count = guestbookService.exeDelete(guestbookVo);
		if(count==1) {
			return "redirect:/list";
		} else {
			return "redirect:/deleteform?no="+guestbookVo.getNo();
		}
	}
}