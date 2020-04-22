package kun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.VehicleBO;
import kun.dao.VehicleDAO;

@Service("vehService")
public class VehicleServiceIMPL implements VehicleService {

	VehicleBO vehbo;
	
	@Autowired
	VehicleDAO vehdao;
	int count;
	@Override
	public String vInsert(int id, String source, String category, String plate_number,
			String manufacture, String type,
			String color, String registration_date, String pending_fines, int user_id) throws Exception {
		
		vehbo =new VehicleBO();
		
		vehbo.setId(id);
		vehbo.setSource(source);
		vehbo.setCategory(category);
		vehbo.setPlate_number(plate_number);
		vehbo.setManufacture(manufacture);
		vehbo.setType(type);
		vehbo.setColor(color);
		vehbo.setRegistration_date(registration_date);
		vehbo.setPending_fines(pending_fines);
		vehbo.setUser_id(user_id);
		
		System.out.println("Vehicle BO object ::"+vehbo);
		//use vehdao
		count=vehdao.insert(vehbo);
		
		if(count==0)
			return "Vehicle details not inserted....";
		else
		return "Vehicle details inserted...";
	}
	@Override
	public List<VehicleBO> findByVehicleId(int id) throws Exception {
		List<VehicleBO> list_veh=new ArrayList<VehicleBO>();
		list_veh= vehdao.findByVehicleId(id);
		return list_veh;
	}
	@Override
	public boolean delete(int vid) throws Exception {
		
		boolean count;
		count=vehdao.delete(vid);
		return count;
	}

}
