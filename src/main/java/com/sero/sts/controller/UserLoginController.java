package com.sero.sts.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.LoginService;
import com.sero.sts.vo.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/members")
public class UserLoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String pwd, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (loginService.login(id, pwd) != null) {
			session.removeAttribute("id");
			session.setAttribute("loginUser", loginService.login(id, pwd));
			return "redirect:/mall/mainPage";
		}
		return "redirect:/members/login_fail";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();

		return "redirect:/product";
	}

	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		return "member/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("id", memberVO.getId());

		String address = request.getParameter("addr1") + request.getParameter("addr2");
		memberVO.setAddress(address);
		loginService.join(memberVO);
		return "member/join";
	}

	@RequestMapping(value = "/contract", method = { RequestMethod.GET, RequestMethod.POST })
	public String contract() {
		return "member/contract";
	}

	@RequestMapping(value = "/idCheckForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String idCheckForm(@RequestParam String id, Model model) {
		int message = loginService.idCheckForm(id);
		model.addAttribute("message", message);
		model.addAttribute("id", id);

		return "member/idcheck";
	}

	@RequestMapping(value = "/findZipNum", method = { RequestMethod.GET, RequestMethod.POST })
	public String findZipNum(@RequestParam(defaultValue = "") String dong, Model model) {
		model.addAttribute("addressList", loginService.findZipNum(dong));
		return "member/findZipNum";
	}

	@RequestMapping(value = "/findIdForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String findIdForm(@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String email, Model model) {
		String memberId = "";
		if (name != null && !name.trim().equals("") && email != null && !email.trim().equals("")) {

			memberId = loginService.findId(name, email);
			model.addAttribute("memberId", memberId);
		}
		return "member/idfind";
	}

	@RequestMapping(value = "/findPwdForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String findPwdForm(@RequestParam(defaultValue = "") String id, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String email, Model model) {
		String memberPwd = "";
		if (id != null && !id.trim().equals("") && name != null && !name.trim().equals("") && email != null
				&& !email.trim().equals("")) {

			memberPwd = loginService.findPwd(id, name, email);
			model.addAttribute("id", id);
			model.addAttribute("email", email);
			model.addAttribute("memberPwd", memberPwd);
		}
		return "member/pwdfind";
	}

}