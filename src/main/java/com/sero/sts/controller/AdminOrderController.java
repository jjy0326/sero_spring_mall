package com.sero.sts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.OrderVO;

@RequestMapping("/admin")
@Controller
public class AdminOrderController {

	public AdminOrderController() {
		System.out.println("관리자 오더 시작");
	}

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public String OrderList(Model model, @RequestParam(value = "key", required = false) String key) throws Exception {

		List<OrderVO> orderList = adminService.orderList(key);
		model.addAttribute("orderList", orderList);

		return "admin/order/orderList";
	}

	@RequestMapping(value = "/orderSave", method = RequestMethod.GET)
	public String orderSave(@RequestParam(value = "result", required = false) String[] resultArr, Model model) throws Exception {	 
	    for (String oseq : resultArr) {
	        System.out.println("주문 번호 처리: " + oseq);
	        int oseqs = Integer.parseInt(oseq);
	        adminService.orderUpdate(oseqs);

	    }
	    return "redirect:/admin/orderList";
	}

}
