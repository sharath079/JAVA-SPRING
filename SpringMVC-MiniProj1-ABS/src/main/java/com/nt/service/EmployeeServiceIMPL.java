package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceIMPL implements EmployeeService {

	EmployeeDAO dao;
	
	public EmployeeServiceIMPL(EmployeeDAO dao) {
		this.dao = dao;
	}

	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeDTO> listdto=null;
		List<EmployeeBO> listbo;
		listdto= new ArrayList<EmployeeDTO>();
		
		//use dao object
		listbo=dao.getAllEmps();
		
		//copy listbo to listdto 
		//enhanced for-loop
		for(EmployeeBO bo:listbo) {
			EmployeeDTO empdto= new EmployeeDTO();
			BeanUtils.copyProperties(bo, empdto);
			listdto.add(empdto);
		}
		
		return listdto;
	}

}
