package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import kun.bo.InsuranceBO;
import kun.bo.SearchBO;
import kun.bo.UserBO;
import kun.bo.VehicleBO;

@Repository("searchDAO")
public class SearchDAOIMPL implements SearchDAO {


	@Autowired(required = true)
	private HikariDataSource hkds;
	
	public final static String sqlQuery = "select tbl_user.name, tbl_user.gender, tbl_user.nationality, tbl_user.license, tbl_insurance.provider, tbl_insurance.insurance_number, tbl_insurance.validity_date, tbl_vehicles.source, tbl_vehicles.category, tbl_vehicles.plate_number, tbl_vehicles.manufacture, tbl_vehicles.type, tbl_vehicles.color, tbl_vehicles.registration_date, tbl_vehicles.pending_fines from tbl_user, tbl_insurance, tbl_vehicles where tbl_user.id = tbl_insurance.user_id and tbl_user.id = tbl_vehicles.user_id and tbl_insurance.user_id = tbl_vehicles.user_id and tbl_user.name=? and tbl_user.license=? and tbl_vehicles.plate_number=?";
	
	
	// retrieves the search results
	

	@Override
	public List<UserBO> resultTest(String name,String license,String plate_no) throws Exception {
		
		String name1=name;
		String license1=license;
		String plate_no1=plate_no;
		
		UserBO ubo=null;
		List<UserBO> list_ubo = null;
		VehicleBO vbo;
		InsuranceBO ibo;
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		
		// get datasource connection
		con=hkds.getConnection();
		//System.out.println("connected...."+hkds.getClass());
		ps=con.prepareStatement(sqlQuery);
		ps.setString(1, name1);
		ps.setString(2, license1);
		ps.setString(3, plate_no1);
		rs=ps.executeQuery();
		ResultSetMetaData rsm=rs.getMetaData();
		int count=rsm.getColumnCount();

		System.out.println("=============================================");
		System.out.println("::::::"+count);
		try {
			
			list_ubo=new ArrayList<UserBO>();
			
			while(rs.next()) {
				ubo=new UserBO();
				
				ubo.setName(rs.getString(1));
				ubo.setGender(rs.getString(2));
				ubo.setNationality(rs.getString(3));
				ubo.setLicense(rs.getString(4));
				
				ibo=new InsuranceBO();
				ibo.setProvider(rs.getString(5));
				ibo.setInsurance_number(rs.getString(6));
				ibo.setValidity_date(rs.getString(7));
				// setting insuranceBO obj to UserBO obj
				ubo.setIbo(ibo);
				
				vbo=new VehicleBO();
				vbo.setSource(rs.getString(8));
				vbo.setCategory(rs.getString(9));
				vbo.setPlate_number(rs.getString(10));
				vbo.setManufacture(rs.getString(11));
				vbo.setType(rs.getString(12));
				vbo.setColor(rs.getString(13));
				vbo.setRegistration_date(rs.getString(14));
				vbo.setPending_fines(rs.getString(15));
				// setting vehiclesBO obj to UserBO obj
				ubo.setVbo(vbo);
                	
			}// while
			// adding ubo obj to list_ubo
			list_ubo.add(ubo);	
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		return list_ubo;
	}
}


