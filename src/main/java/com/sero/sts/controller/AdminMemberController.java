package com.sero.sts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.MemberVO;
import com.sero.sts.vo.ProductVO;

@RequestMapping("/admin/member")
@Controller
public class AdminMemberController {
	
	@Autowired
	private AdminService adminService;

	static Logger logger = LoggerFactory.getLogger(AdminMainController.class);

	@RequestMapping(value="/memberList", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberList(Model model, @RequestParam(value = "key", required = false) String key) throws Exception {
	    List<MemberVO> memberList = adminService.showMemberList(key);
	    System.out.println(key);
	    model.addAttribute("memberList", memberList);

	    return "admin/member/memberList";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removeMember(@RequestParam("useyn") String id) throws Exception {
		logger.info("id" + id);
		adminService.removeMember(id);
		return "redirect:/admin/member/memberList/";

	}
}
