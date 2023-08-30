package com.sero.sts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sero.sts.vo.CartVO;
import com.sero.sts.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;


	public List<Integer> selectSeqOrderIng(String id) throws DataAccessException {
		List<Integer> oseqList = new ArrayList<Integer>();
		System.out.println(id);
		oseqList = sqlSession.selectList("mapper.user.selectSeqOrderIng", id);
		return oseqList;
	}
	
	
	public List<OrderVO> listOrderById(String id, int oseq) {
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("id", id);
		orderMap.put("result", "%");
		orderMap.put("oseq", oseq);
		orderList = sqlSession.selectList("mapper.user.listOrderById", orderMap);

		return orderList;
	}
	
	@Transactional
	public int insertOrder(List<CartVO> cartList, String id) {
		int maxOseq = 0;

		maxOseq = sqlSession.selectOne("mapper.user.selectMaxOseq");
		int insertOrder = sqlSession.insert("mapper.user.insertOrder", id);

		for (CartVO cartVO : cartList) {
			insertOrderDetail(cartVO, maxOseq);
		}
		return maxOseq;
	}
	
	@Transactional
	public void insertOrderDetail(CartVO cartVO, int maxOseq) {
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("oseq", maxOseq);
		orderMap.put("pseq", cartVO.getPseq());
		orderMap.put("quantity", cartVO.getQuantity());
				
		int insertOrderDetail = sqlSession.insert("mapper.user.insertOrderDetail", orderMap);
		int updateCartResult = sqlSession.update("mapper.user.updateCartResult", cartVO.getCseq());
		}
	
	
	

}
