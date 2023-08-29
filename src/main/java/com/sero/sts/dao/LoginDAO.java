package com.sero.sts.dao;

import org.springframework.stereotype.Repository;

import com.sero.sts.vo.MemberVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

@Repository("loginDAO")
public class LoginDAO{

	@Autowired
	private SqlSession sqlSession;
		
	public int confirmID(String userid) {
		MemberVO memberVO = sqlSession.selectOne("mapper.mall.getMember", userid);
			
		if (memberVO == null)
			return -1;
		else
			return 1;
		}

	public MemberVO getMember(String userid) {		
		return sqlSession.selectOne("mapper.mall.getMember", userid);
	}

	public int insertMember(MemberVO memberVO) {
		return sqlSession.insert("mapper.mall.insertMember", memberVO);
	}

		/* 관리자 */
	public List<MemberVO> listMember(String name) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		List<MemberVO> memberList = sqlSession.selectList("mapper.mall.listMember", params);
		return memberList;
	}
		
	public String findId(String name, String email) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("email", email);
		return sqlSession.selectOne("mapper.mall.findId", params);
	}
		
	public String findPwd(String id, String name, String email) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("name", name);
		params.put("email", email);
		return sqlSession.selectOne("mapper.mall.findPwd", params);
	}
		
}
