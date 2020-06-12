package kun.dao;

import java.util.List;

import kun.bo.VehicleBO;

public interface VehicleDAO {
	public int insert(VehicleBO vehiclebo) throws Exception;
    public List<VehicleBO> findByVehicleId(int id) throws Exception;
    public boolean delete(int vid) throws Exception;
}
