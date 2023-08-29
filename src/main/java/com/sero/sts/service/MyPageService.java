package com.sero.sts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sero.sts.dao.AdminDAO;
import com.sero.sts.dao.CartDAO;
import com.sero.sts.dao.OrderDAO;
import com.sero.sts.vo.CartVO;
import com.sero.sts.vo.MemberVO;
import com.sero.sts.vo.OrderVO;

@Service("myPageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MyPageService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	public List<OrderVO> mypage(MemberVO loginUser) throws DataAccessException {

		List<Integer> oseqList = orderDAO.selectSeqOrderIng(loginUser.getId());
		List<OrderVO> orderList = new ArrayList<OrderVO>();

		for (int oseq : oseqList) {	
			List<OrderVO> orderListIng = orderDAO.listOrderById(loginUser.getId(), oseq);

			OrderVO orderVO = orderListIng.get(0);
			orderVO.setPname(orderVO.getPname() + " 외 " + orderListIng.size() + "건");

			int totalPrice = 0;
			for (OrderVO ovo : orderListIng) {
				totalPrice += ovo.getPrice2() * ovo.getQuantity();
			}
			orderVO.setPrice2(totalPrice);
			orderList.add(orderVO);
		}

		return orderList;

	}
	
		public List<OrderVO> orderDetail(MemberVO loginUser, int oseq) throws DataAccessException {
		
			List<OrderVO> orderList = orderDAO.listOrderById(loginUser.getId(), oseq);

		return orderList;
	}
		
		public List<OrderVO> orderAll(MemberVO loginUser) throws DataAccessException {
		
		List<Integer> oseqList = orderDAO.selectSeqOrderIng(loginUser.getId());

		List<OrderVO> orderList = new ArrayList<OrderVO>();

		for (int oseq : oseqList) {
			List<OrderVO> orderListIng = orderDAO.listOrderById(loginUser.getId(), oseq);

			OrderVO orderVO = orderListIng.get(0);
			orderVO.setPname(orderVO.getPname() + " 외 " + orderListIng.size() + "건");
			System.out.println(orderVO.getIndate());

			int totalPrice = 0;
			for (OrderVO ovo : orderListIng) {
				totalPrice += ovo.getPrice2() * ovo.getQuantity();
			}
			orderVO.setPrice2(totalPrice);
			orderList.add(orderVO);
		}
		return orderList;
	}
		
		public int orderInsert (List<CartVO> cartList, String id) {
			return orderDAO.insertOrder(cartList, id);
		}
		
		public List<CartVO> cartList (String id) {
			return cartDAO.listCart(id);
		}
		
		public void cartInsert (CartVO cartVO) {
			cartDAO.insertCart(cartVO);
				
		}
		
		public void cartDelete (String cseq) {
			cartDAO.deleteCart(Integer.parseInt(cseq));
		}
	

}
