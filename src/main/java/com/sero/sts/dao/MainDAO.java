package com.sero.sts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.sero.sts.vo.ProductVO;

@Repository("mainDAO")
public class MainDAO  {

	@Autowired
	private SqlSession sqlsession;
	
	// 신상품
	public List<ProductVO> selectNewList() throws DataAccessException{
		List<ProductVO> newList = sqlsession.selectList("mapper.mall.newProduct");	
		return newList;		
	}
	
	// 베스트 상품
	public List<ProductVO> selectBestList() throws DataAccessException{
		List<ProductVO> bestList = sqlsession.selectList("mapper.mall.bestProduct");	
		return bestList;		
	}

	// 상세 페이지
	public ProductVO productDetail(int pseq) throws DataAccessException {	
	    ProductVO productDetail = sqlsession.selectOne("mapper.mall.selectPseq", pseq);
	    return productDetail;
	}

	// 상품 카테고리
	public List<ProductVO> productKind(int kind) throws DataAccessException{
		List<ProductVO> productKind = sqlsession.selectList("mapper.mall.selectKind", kind);
		return productKind;
	}
	
}
