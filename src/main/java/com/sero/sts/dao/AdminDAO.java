package com.sero.sts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sero.sts.vo.MemberVO;
import com.sero.sts.vo.ProductVO;

@Repository("adminDAO")
public class AdminDAO  {
	
	static Logger logger = LoggerFactory.getLogger(AdminDAO.class);

    @Autowired
	private SqlSession sqlSession;
    
	/**
	 * @param id
	 * @return selectOne 결과
	 * @author 명원식
	 **/
    public int checkWorker(String id, String pwd) throws DataAccessException {
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("id", id);
    	params.put("pwd", pwd);
    	return sqlSession.selectOne("checkWorker", params);
    }
    
    public List<ProductVO> showProductList() throws DataAccessException {
    	List<ProductVO> productList = sqlSession.selectList("mapper.mall.showProductList");
    	return productList;
    }

    public ProductVO selectProduct(int pseq) throws DataAccessException {
    	ProductVO productView = null;
    	productView = sqlSession.selectOne("mapper.mall.selectProduct", pseq);
    	return productView;
    }
 
    public int updateProduct(ProductVO product) throws DataAccessException {
    	System.out.println("얄루얄루야루랴"+product.toString());
    	int result = sqlSession.update("mapper.mall.updateProduct", product);
    	return result;
    }

	public int addProduct(ProductVO product) throws DataAccessException {
		int result = sqlSession.insert("mapper.mall.addProduct", product);
		return result;
	}

    public List<MemberVO> showMemberList() throws DataAccessException {
    	List<MemberVO> memberList = sqlSession.selectList("mapper.mall.showMemberList");
    	return memberList;
    }

	public int removeMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.mall.removeMember", id);
		return result;
	}
}
