package com.bluemingo.bluemingo.service;

import javax.servlet.http.HttpServletRequest;

import com.bluemingo.bluemingo.domain.ImageVO;
import com.bluemingo.bluemingo.generic.GenericService;

public interface ImageService extends GenericService<ImageVO, Integer> {
	
	public ImageVO imageInsert(HttpServletRequest request) throws Exception;
	
}
