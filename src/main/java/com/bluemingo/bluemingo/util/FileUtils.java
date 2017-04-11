package com.bluemingo.bluemingo.util;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bluemingo.bluemingo.domain.ImageVO;



@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "www/bluemingo/image";
	//private static final String filePath = "www/bluemingo/image/";
	
	public ImageVO parseInsertFileInfo(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
    	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
    	
    	MultipartFile multipartFile = null;
    	String originalFileName = null;
    	String originalFileExtension = null;
    	String storedFileName = null;
    	ImageVO cvo = new ImageVO();
    	/*
    	 * vo로 해야할 것
    	 * 이미지가 사용될 table_name과 key값이 저장 되어 있다.
    	 * 이를 이용하여 연결해야한다.
    	 */
        
        File file = new File(filePath);
        if(file.exists() == false){
        	file.mkdirs();
        }
        
        while(iterator.hasNext()){
        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        	if(multipartFile.isEmpty() == false){
        		originalFileName = multipartFile.getOriginalFilename();
        		originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        		storedFileName = CommonUtils.getRandomString() + originalFileExtension;
        		
        		file = new File(filePath + storedFileName);
        		multipartFile.transferTo(file);
        		
        		cvo.setOriginal_file_name(originalFileName);
        		cvo.setStored_file_name(storedFileName);
        		cvo.setFile_size(multipartFile.getSize());
        		
        	}
        }
        return cvo;
	}
	
	public void downloadFile(ImageVO ivo, HttpServletResponse response) throws Exception{
	    String storedFileName = ivo.getStored_file_name();
	    String originalFileName = ivo.getOriginal_file_name();
	     
	    //byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("www/bluemingo/image/"+storedFileName));
	    byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("www/bluemingo/image"+storedFileName));
	    
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
}