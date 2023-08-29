package com.sero.sts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sero.sts.service.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminMainController {

	@Autowired
	private AdminService adminService;
	
//	@Autowired
//	private HttpServletRequest request;
	
//	HttpSession session = request.getSession();
	static Logger logger = LoggerFactory.getLogger(AdminMainController.class);

	/**
	 * 관리자 로그인 페이지로 이동
	 * @author 명원식
	 * @return "admin/main"
	 **/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminIndex() {
		return "/admin/main";
	}

	/**
	 * 관리자 로그인 액션 수행 
	 * @author 명원식
	 * @return "admin/product/productList" 로그인 성공 시
	 * @return "admin/login" 로그인 실패 시
	 **/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(HttpServletRequest request, HttpSession session) {
		String workerId = request.getParameter("workerId").trim();
		String workerPwd = request.getParameter("workerPwd").trim();
		
		session.setAttribute("workerId", workerId);

		if (adminService.checkWorker(workerId, workerPwd)) {
			session.setAttribute("workerId", workerId);
			return "redirect:admin/product/productList";
		} else {
			String msg = "아이디/비밀번호 다시 확인해주세요.";
			request.setAttribute("message", msg);
			return "admin/main";
		}

	}

	/**
	 * 관리자 로그아웃 액션 수행
	 * @author 명원식
	 * @return "admin/main"
	 **/
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String adminLogout() {
//	    HttpSession sessionCheck = request.getSession(false);
//		if (sessionCheck != null) {
//			session.invalidate();
//		}
//		return "admin/main";
//	}


}
