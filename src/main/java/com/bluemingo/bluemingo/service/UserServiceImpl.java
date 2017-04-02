package com.bluemingo.bluemingo.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.RoleVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.domain.UserVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.UserDAO;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserVO, Integer> implements UserService, UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDao;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDao") GenericDAO<UserVO, Integer> genericDao) {
		super(genericDao);
		this.userDao = (UserDAO) genericDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("load user by username(ID) : " + username);
		
		SearchVO svo = new SearchVO();
		svo.setSearch_key(username);
		UserVO uvo = (UserVO) userDao.search(svo).get(0);
		
		List<RoleVO> roles = new ArrayList<RoleVO>();
		
		roles.add(new RoleVO(uvo.getRole_name()));
		uvo.setAuthorities(roles);
		
		return uvo;
	}
}
