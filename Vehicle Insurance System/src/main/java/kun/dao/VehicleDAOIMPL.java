package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import kun.bo.VehicleBO;

@Repository("VehicleDAO")
public class VehicleDAOIMPL implements VehicleDAO {


public static final String VEH_INSERT_QUERY="INSERT INTO TBL_VEHICLES VALUES(?,?,?,?,?,?,?,?,?,?)";
public static final String VEH_SEARCH_BY_VEH_ID="SELECT ID,SOURCE,CATEGORY,PLATE_NUMBER,MANUFACTURE,TYPE,COLOR,REGISTRATION_DATE,PENDING_FINES,USER_ID FROM TBL_VEHICLES WHERE ID=?";	

public static final String DELETE_VEH="DELETE FROM TBL_VEHICLES WHERE ID=?";


@Autowired(required = true)
	private HikariDataSource hkds;

	@Override
	public int insert(VehicleBO vehiclebo) throws Exception {
	
		int count=0;
		//Authorities auth=new Authorities();
		Connection con=null;
		PreparedStatement ps=null;
		//get pooled jdbc con object
		con=hkds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(VEH_INSERT_QUERY);
		
		ps.setInt(1, vehiclebo.getId());
		ps.setString(2, vehiclebo.getSource());
		ps.setString(3, vehiclebo.getCategory());
		ps.setString(4, vehiclebo.getPlate_number());
		ps.setString(5, vehiclebo.getManufacture());
		ps.setString(6, vehiclebo.getType());
		ps.setString(7, vehiclebo.getColor());
		ps.setString(8, vehiclebo.getRegistration_date());
		ps.setString(9, vehiclebo.getPending_fines());
		ps.setInt(10, vehiclebo.getUser_id());
		
		//execute the SQL Query
				count=ps.executeUpdate();
				
				ps.close();
				con.close();
		return count;
	}

    /*
     * Retrieve Vehicle Details based on Vehicle ID
     */
	@Override
	public List<VehicleBO> findByVehicleId(int id) throws Exception {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		VehicleBO vbo;
		List<VehicleBO> list_veh = null;
		//get pooled jdbc con object
		con=hkds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(VEH_SEARCH_BY_VEH_ID);
		ps.setInt(1,id);
		rs=ps.executeQuery();
		
		try {
			while(rs.next()) {
				list_veh= new ArrayList<VehicleBO>();
				vbo= new VehicleBO();
				// setting resultset records to "vbo" object
				
				vbo.setId(rs.getInt(1));
				vbo.setSource(rs.getString(2));
				vbo.setCategory(rs.getString(3));
				vbo.setPlate_number(rs.getString(4));
				vbo.setManufacture(rs.getString(5));
				vbo.setType(rs.getString(6));
				vbo.setColor(rs.getString(7));
				vbo.setRegistration_date(rs.getString(8));
				vbo.setPending_fines(rs.getString(9));
				vbo.setUser_id(rs.getInt(10));
				
				//adding vbo to listvo object
				list_veh.add(vbo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list_veh;
	}

	/*
	 * Deletes Vehicle Record Based on ID
	 * 
	 * */
	@Override
	public boolean delete(int vid) throws Exception {
		
		int veh_id=vid;
		Connection con=null;
		PreparedStatement ps=null;
		boolean value = false;
		//get pooled jdbc con object
		try {
		con=hkds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(DELETE_VEH);
		ps.setInt(1, veh_id);
		value=ps.execute();
		}
		catch(Exception e)  {
			e.printStackTrace();
		}
		
		if(value==true) {
			return true;
		}
		else
			return false;
		//System.out.println("User with Id "+user_id+" is removed...");
	}
}

