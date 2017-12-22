package com.cen.mapper;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cen.entity.Upfile;

public interface UpfileMapper {

	void saveFile(Upfile enfile);
	List<Upfile> getFile();
}
