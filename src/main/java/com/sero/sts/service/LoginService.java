package com.sero.sts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sero.sts.dao.AddressDAO;
import com.sero.sts.dao.LoginDAO;
import com.sero.sts.vo.AddressVO;
import com.sero.sts.vo.MemberVO;


@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private AddressDAO addressDAO;
	

	public MemberVO login(String id, String pwd) {	
		MemberVO memberVO = loginDAO.getMember(id);
		if (loginDAO.getMember(id) != null) {
			if (memberVO.getPwd().equals(pwd))
				return memberVO;
		}
		return null;
	}

	public void join(MemberVO memberVO) {
		loginDAO.insertMember(memberVO);	
	}
	
	public int idCheckForm(String id) {
		return loginDAO.confirmID(id);
	}

	public List<AddressVO> findZipNum(String dong) {
		if (dong != null && dong.trim().equals("") == false) {
			return addressDAO.selectAddressByDong(dong.trim());
		}
		return null;		
	}
	
	public String findId(String name, String email) {
        return loginDAO.findId(name, email);
    }
    
    public String findPwd(String id, String name, String email) {
        return loginDAO.findPwd(id, name, email);
    }
	
}