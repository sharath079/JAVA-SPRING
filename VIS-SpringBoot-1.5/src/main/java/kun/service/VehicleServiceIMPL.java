package kun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.VehicleBO;
import kun.dao.VehicleDAO;
import kun.dto.VehicleDTO;

@Service("vehService")
public class VehicleServiceIMPL implements VehicleService {

	VehicleBO vehbo;
	
	@Autowired
	VehicleDAO vehdao;
	int count;
	@Override
	public String vInsert(VehicleDTO vehdto) throws Exception {
		
		vehbo =new VehicleBO();
		
		BeanUtils.copyProperties(vehdto, vehbo);
		
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
