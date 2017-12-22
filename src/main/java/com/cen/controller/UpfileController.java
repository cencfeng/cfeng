package com.cen.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.cen.entity.Upfile;
import com.cen.service.UpfileService;

@Controller
@RequestMapping("/fileupload")
public class UpfileController {

	@Autowired
	UpfileService upfileService;
	@RequestMapping("/uploadpage")
	public String uploadPage() {
		return "uploadpage";
	}
	
	@RequestMapping("/Upload")
	public String fileUpLoad(HttpServletRequest request,@RequestParam("upfile") MultipartFile upfile,Model m) throws Exception
	{
	    upfileService.saveFile(upfile, request);
		//m.addAttribute("myfile", list);
		return "uploadpage";
	}
	@RequestMapping("/searchFile")
	public String searchFile(Model m) throws Exception {
		List<Upfile> list = upfileService.getFile();
		m.addAttribute("upfiles", list);
		return "searchUpfile";
	}
	@RequestMapping("/outputexcel")
	public void outputExcel(HttpServletResponse response,HttpServletRequest request) throws Exception {
		List<Upfile> list = upfileService.getFile();
		  StringBuffer sb = new StringBuffer("<table><tr>");
		 
		        sb.append("<th nowrap='nowrap'>序号</th>");
		        sb.append("<th nowrap='nowrap'>文件名称</th>");
		        sb.append("<th nowrap='nowrap'>文件编号</th>");
		        sb.append("</tr>");
		        int index = 1;
		        for(Upfile upfile : list) {
		        	sb.append("<tr><td nowrap='nowrap'>"+index+"</td>");
		        	sb.append("<td nowrap='nowrap'>"+ upfile.getFilename() +"</td>");
		        	sb.append("<td nowrap='nowrap' style=\"mso-number-format:'\\@';\">"+ upfile.getFileno() +"</td>");
		        	sb.append("</tr>");
		        	index++;
		        }	
		        sb.append("</table>");
		    response.setContentType("application/octet-stream;charset=UTF-8");  
            response.setHeader("Content-Disposition", "attachment;filename=testfile.xls");       
		    //HSSFWorkbook excel = new HSSFWorkbook();
		    //HSSFSheet hssfSheet = excel.createSheet();
		    //HSSFRow hssfRow = hssfSheet.createRow(0);
	        //第一行创建第一个单元格
	        //HSSFCell hssfCell = hssfRow.createCell(0);
	        //设置第一个单元格的值
	        //hssfCell.setCellValue("poi");
	        //OutputStream fout = response.getOutputStream();
	        
	        //FileOutputStream fout = null;
	        try{
	            //用流将其写到D盘
	            //fout = new FileOutputStream("D:/file/testfile.xls");
	            //excel.write(fout);
	            //fout.close();
	        	response.getWriter().println(sb.toString());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		
	}
}
