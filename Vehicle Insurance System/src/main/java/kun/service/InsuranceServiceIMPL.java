package kun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.InsuranceBO;
import kun.dao.InsuranceDAO;

@Service("insService")
public class InsuranceServiceIMPL implements InsuranceService {

	InsuranceBO insbo;
	
	@Autowired
	InsuranceDAO insdao;
	
	int count;
	@Override
	public String InsInsert(int id, String provider, String insurance_number, String validity_date, int user_id)
			throws Exception {
		
		insbo=new InsuranceBO();
		insbo.setId(id);
		insbo.setProvider(provider);
		insbo.setInsurance_number(insurance_number);
		insbo.setValidity_date(validity_date);
		insbo.setUser_id(user_id);
		
		System.out.println("InsuranceBO..."+insbo);
		
		// use insdao obj
		
		count=insdao.insInsert(insbo);
		
		if(count==0)
			return "Record not inserted into Insurance table...";
		else
		return "Record inserted into Insurance table...";
	}
	@Override
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception {
	List<InsuranceBO> list_ins =new ArrayList<InsuranceBO>();
	list_ins=insdao.findByInsuranceId(id);
		return list_ins;
	}
	@Override
	public boolean delete(int id) throws Exception {
		
		boolean count;
		count=insdao.delete(id);
		return count;
	}

}
