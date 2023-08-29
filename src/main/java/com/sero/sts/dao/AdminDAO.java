package com.sero.sts.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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

}
