package kun.service;

import java.util.List;

import kun.bo.VehicleBO;

public interface VehicleService {
	
	public String vInsert(int id,String source,String category,String plate_number,
		String manufacture,String type,String color,
		String registration_date,String pending_fines,int user_id) throws Exception;
	
	public List<VehicleBO> findByVehicleId(int id) throws Exception;
	
	 public boolean delete(int vid) throws Exception;
}
