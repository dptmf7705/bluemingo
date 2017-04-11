package com.bluemingo.bluemingo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bluemingo.bluemingo.domain.UserVO;
import com.bluemingo.bluemingo.generic.GenericService;

public interface UserService extends GenericService<UserVO, Integer>, UserDetailsService{

}
