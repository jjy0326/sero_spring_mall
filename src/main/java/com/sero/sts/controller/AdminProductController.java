package com.sero.sts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.ProductVO;

@RequestMapping("/admin/product")
@RestController
public class AdminProductController {

	@Autowired
	private AdminService adminService;
	
	static Logger logger = LoggerFactory.getLogger(AdminMainController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ProductVO> productList() {
		List<ProductVO> productList = adminService.listProduct();
		return productList;

	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String productDetail() {
		return null;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct() {
		return null;

	}

}
