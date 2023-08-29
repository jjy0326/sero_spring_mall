package com.sero.sts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.MyPageService;
import com.sero.sts.vo.CartVO;
import com.sero.sts.vo.MemberVO;
import com.sero.sts.vo.OrderVO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Controller
@RequestMapping("/userpages")
public class UserPageController {
	
	
	@Autowired
	private MyPageService myPageService;
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			
			List<OrderVO> orderList = myPageService.mypage(loginUser);
			model.addAttribute("title", "진행 중인 주문 내역");
			model.addAttribute("orderList", orderList);
			return "mypage/mypage";
		}
	
	}
	
	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	private String orderDetail(@RequestParam("oseq") Integer oseq, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			List<OrderVO> orderList = myPageService.orderDetail(loginUser, oseq);
			int totalPrice = 0;
			for (OrderVO ovo : orderList) {
				totalPrice += ovo.getPrice2() * ovo.getQuantity();
			}
			model.addAttribute("orderDetail", orderList.get(0));
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
			System.out.println(orderList);
		}
			return "mypage/orderDetail";
	}
	
	@RequestMapping(value = "/orderAll", method = RequestMethod.GET)
	public String orderAll(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			List<OrderVO> orderList = myPageService.orderAll(loginUser);
			model.addAttribute("title", "총 주문 내역");
			model.addAttribute("orderList", orderList);
		}
		return "mypage/mypage";
	}
	
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	private String orderList(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			List<OrderVO> orderList = myPageService.orderAll(loginUser);
			model.addAttribute("title", "총 주문 내역");
			model.addAttribute("orderList", orderList);
		}
		return "mypage/orderList";
	}
	
	@RequestMapping(value = "/orderInsert", method = RequestMethod.POST)
	private String orderInsert(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		} 

		List<CartVO> cartList = myPageService.cartList(loginUser.getId());
		int maxOseq = myPageService.orderInsert(cartList, loginUser.getId());
		return "redirect:/userpages/orderList?oseq=" + maxOseq;
	}
	
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	private String cartList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		} 
		
		List<CartVO> cartList = myPageService.cartList(loginUser.getId());
		model.addAttribute("cartList", cartList);
		for (CartVO c : cartList)
			System.out.println("test");
		
		return "mypage/cartList";
	}
	
	@RequestMapping(value = "/cartInsert", method = RequestMethod.POST)
	private String cartInsert(@RequestParam("pseq") String pseq, @RequestParam("quantity") String quantity, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		} 
		CartVO cartVO = new CartVO();
		cartVO.setId(loginUser.getId());	
		cartVO.setPseq(Integer.parseInt(pseq));
		cartVO.setQuantity(Integer.parseInt(quantity));
		myPageService.cartInsert(cartVO);
		
		return "redirect:/userpages/cartList";
	}
	
	@RequestMapping(value = "/cartDelete", method = RequestMethod.POST)
	private String cartDelete(@RequestParam("cseq") String[] cseqArr, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		}

		for (String cseq2 : cseqArr) {
			myPageService.cartDelete(cseq2);
		}
		return "redirect:/userpages/cartList";
	}
	
	@RequestMapping(value = "/orderNowInsert", method = RequestMethod.POST)
	private String orderNowInsert(HttpServletRequest request) {			
		HttpSession session = request.getSession();
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		} else {
			CartVO cartVO = new CartVO();
			String id = loginUser.getId();
			int pseq = Integer.parseInt(request.getParameter("pseq"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			cartVO.setId(id);
			cartVO.setPseq(pseq);
			cartVO.setQuantity(quantity);
			
			List<CartVO> cartList = new ArrayList<CartVO>();
			cartList.add(cartVO);
			int maxOseq = myPageService.orderInsert(cartList, id);
			
			return "redirect:/userpages/orderList?oseq=" + maxOseq;
		}
	} 



}
