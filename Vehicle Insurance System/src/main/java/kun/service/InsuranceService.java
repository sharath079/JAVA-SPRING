package kun.service;

import java.util.List;

import kun.bo.InsuranceBO;

public interface InsuranceService {

	public String InsInsert(int id,String provider,String insurance_number,String validity_date,int user_id) throws Exception;
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception;
	 public boolean delete(int id) throws Exception;
}
