package com.bluemingo.bluemingo.persistence;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.UserVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

@Repository("userDao")
public class UserDAOImpl extends GenericDAOImpl<UserVO, Integer> implements UserDAO{

	public UserDAOImpl() {
		super(UserVO.class);
	}

}
