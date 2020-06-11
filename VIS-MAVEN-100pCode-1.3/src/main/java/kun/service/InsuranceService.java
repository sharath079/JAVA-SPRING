package kun.service;

import java.util.List;

import kun.bo.InsuranceBO;
import kun.dto.InsuranceDTO;

public interface InsuranceService {

	public String InsInsert(InsuranceDTO insdto) throws Exception;
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception;
	public boolean delete(int id) throws Exception;
}
