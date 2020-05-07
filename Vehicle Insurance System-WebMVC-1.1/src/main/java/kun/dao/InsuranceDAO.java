package kun.dao;

import java.util.List;

import kun.bo.InsuranceBO;
import kun.bo.VehicleBO;

public interface InsuranceDAO {

	public int insInsert(InsuranceBO insbo) throws Exception;
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception;
	public boolean delete(int id) throws Exception;
}
