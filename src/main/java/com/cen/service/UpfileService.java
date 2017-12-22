package com.cen.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cen.entity.Upfile;

public interface UpfileService {

	void saveFile(MultipartFile upfile,HttpServletRequest request) throws Exception;
	
	List<Upfile> getFile() throws Exception;
	
}
