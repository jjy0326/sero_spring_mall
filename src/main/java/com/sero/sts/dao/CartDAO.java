package com.sero.sts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sero.sts.vo.CartVO;

@Repository("cartDAO")
public class CartDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CartVO> listCart(String userId) {
		List<CartVO> cartList = new ArrayList<CartVO>();
		cartList = sqlSession.selectList("mapper.user.listCart", userId);
		return cartList;
	}
	
	public void insertCart(CartVO cartVO) {
		Map<String, Object> cartMap = new HashMap<String, Object>();
		cartMap.put("id", cartVO.getId());
		cartMap.put("pseq", cartVO.getPseq());
		cartMap.put("quantity", cartVO.getQuantity());
		
		int cartInsert = sqlSession.update("mapper.user.insertCart", cartMap);
	}
	
	public void deleteCart(int cseq) {
		
		int cartDelete = sqlSession.delete("mapper.user.deleteCart", cseq);

	}

}
