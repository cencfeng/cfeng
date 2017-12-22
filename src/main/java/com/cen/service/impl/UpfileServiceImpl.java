package com.cen.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cen.entity.Upfile;
import com.cen.mapper.UpfileMapper;
import com.cen.service.UpfileService;
@Service
public class UpfileServiceImpl implements UpfileService {

	@Autowired
	UpfileMapper upfileMapper;
	@Override
	@Transactional
	public void saveFile(MultipartFile upfile, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String path=null;
		String parentpath=null;
		Date date = new Date();
		Upfile enfile =new Upfile();
		//List<Upfile> list=new ArrayList<Upfile>();
		if(!upfile.isEmpty())
		{	
			String filename=upfile.getOriginalFilename();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		    String strdate = sdf.format(date);
		    String fileno=strdate+filename.hashCode();
		    String prefix=filename.substring(filename.lastIndexOf(".")+1);
			parentpath = "D:/file/";
			path=parentpath+fileno+"."+prefix;
			File f=new File(parentpath);
			enfile.setFileno(fileno);
			enfile.setFilename(filename);
			enfile.setFilepath(path);
			if(!f.exists())
			{
				f.mkdirs();
			}
			upfile.transferTo(new File(path));
			upfileMapper.saveFile(enfile);
			//list.add(upfile);
			//throw new NullPointerException("±àºÅÎª¿Õ");
		}
	}
	@Override
	public List<Upfile> getFile() throws Exception {
		// TODO Auto-generated method stub
		List<Upfile> list = upfileMapper.getFile();
	    	
		return list;
	}

}
