package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class EmployeeController extends AbstractController {
	
	EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmployeeDTO> listdto=service.fetchAllEmps();
		
		return new ModelAndView("show_emps", "listdto", listdto);
	}

}
