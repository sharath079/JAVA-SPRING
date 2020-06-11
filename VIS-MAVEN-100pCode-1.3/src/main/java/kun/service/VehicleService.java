package kun.service;

import java.util.List;

import kun.bo.VehicleBO;
import kun.dto.VehicleDTO;

public interface VehicleService {
	
	public String vInsert(VehicleDTO vehdto) throws Exception;
	
	public List<VehicleBO> findByVehicleId(int id) throws Exception;
	
	 public boolean delete(int vid) throws Exception;
}
