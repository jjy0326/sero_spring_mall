package com.sero.sts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.sero.sts.vo.ProductVO;

@Repository("mainDAO")
public class MainDAO  {

	@Autowired
	private SqlSession sqlsession;
	
	public MainDAO() {
	   System.out.println("DAO");
	}
	
	// 신상품
	public List<ProductVO> selectNewList() throws DataAccessException{
		List<ProductVO> newList = null;
		newList = sqlsession.selectList("mapper.mall.newProduct");		
		return newList;		
	}
	
	// 베스트 상품
	public List<ProductVO> selectBestList() throws DataAccessException{
		List<ProductVO> bestList = null;
		bestList = sqlsession.selectList("mapper.mall.bestProduct");		
		return bestList;		
	}
	
}
