package com.viki.service.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.viki.business.interfaces.File_Location_Business_Interfaces;
import com.viki.exception.CustomGenericException;

@Controller
public class Home_Contoller {

	@Autowired
	File_Location_Business_Interfaces file_Location_Business_Interfaces;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView model, HttpSession session) throws IOException {
		try {
			model = new ModelAndView("index");
			return model;
		} catch (Exception ex) {
			throw new CustomGenericException("" + ex.hashCode(), ex.getMessage());
		}
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploaduploadFile(ModelAndView model, HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

		model = new ModelAndView("success.jsp");

		file_Location_Business_Interfaces.save_File(fileUpload);

		return model;
	}

	@RequestMapping(value = "/complete")
	public ModelAndView complete_list(ModelAndView model, HttpServletRequest request) throws Exception {

		model = new ModelAndView("index.jsp");

		return model;
	}
}