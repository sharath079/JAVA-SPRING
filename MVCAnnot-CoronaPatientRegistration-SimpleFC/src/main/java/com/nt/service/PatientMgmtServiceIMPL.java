package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.PatientBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDTO;

@Service("patService")
public class PatientMgmtServiceIMPL implements PatientMgmtService {

	@Autowired
	private PatientDAO pdao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(PatientDTO dto) {
		
		int count=0;
		PatientBO pbo=null;
		
		pbo=new PatientBO();
		//copy dto obj to bo object
		
		BeanUtils.copyProperties(dto, pbo);
		// use dao obj
		count=pdao.insert(pbo);
		return count==0?"Patient Registration Failed":"Patient Registration Succeeded";
	}

}
