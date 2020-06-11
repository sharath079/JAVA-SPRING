package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
    
    @Autowired
    private JdbcTemplate jTemp;

	public VehicleDAOIMPL(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

	/*
	 * Inserting Records into tbl_vehicles table using insurance object as arguments
	 * for JDBC-Template jTemp.update(query,args..);
	 * */
	@Override
	public int insert(VehicleBO vehiclebo) throws Exception {
		
		int result=jTemp.update(VEH_INSERT_QUERY, vehiclebo.getId(),vehiclebo.getSource(),
				vehiclebo.getCategory(),vehiclebo.getPlate_number(),vehiclebo.getManufacture(),
				vehiclebo.getType(),vehiclebo.getColor(),vehiclebo.getRegistration_date(),
				vehiclebo.getPending_fines(),vehiclebo.getUser_id());
		return result;
	}
	
    /*
     * Retrieve Vehicle Details based on Vehicle ID
     */
	@Override
	public List<VehicleBO> findByVehicleId(int id) throws Exception {
	    
		VehicleBO vbo;
		List<VehicleBO> list_veh = null;
		list_veh=jTemp.query(VEH_SEARCH_BY_VEH_ID, new ResultSetExtractor<List<VehicleBO>>() {

			@Override
			public List<VehicleBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				VehicleBO vbo;
				List<VehicleBO> list_veh = new ArrayList<VehicleBO>();
				
				while(rs.next()) {
					
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
				}// while
				return list_veh;
			}//ExtractData()
		}//anonomous inner class;
		,id);// method call
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
		}
}

