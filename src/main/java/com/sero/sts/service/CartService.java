package com.sero.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sero.sts.dao.CartDAO;
import com.sero.sts.vo.CartVO;

public class CartService  {
	
	@Autowired
	CartDAO cartDAO;
	
	public List<CartVO> listCarts(String userId) {
		
		return cartDAO.listCart(userId);
	}
}
