package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	@Autowired
	private JdbcTemplate jTemp;
	
	public SearchDAOIMPL(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

    /*
     * Retrieves SeacrhResults By passing name,license,plate_no
     * Using JDBC Template obj
     * 
     * */
	@Override
	public List<UserBO> resultTest(SearchBO sbo) throws Exception {
		 
		UserBO ubo;
		List<UserBO> list_ubo = null;
		list_ubo=jTemp.query(sqlQuery, new ResultSetExtractor<List<UserBO>>() {

			@Override
			public List<UserBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        
				UserBO ubo;
				VehicleBO vbo;
				InsuranceBO ibo;
				
				List<UserBO> list_ubo = new ArrayList<UserBO>();
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
	                
					// adding ubo obj to list_ubo
					list_ubo.add(ubo);
				}// while
				
				return list_ubo;
			}// ExtractData()
			
		}//anonyomous inner class
		,sbo.getUsername(),sbo.getLicenseno(),sbo.getPlateno());// method call
		return list_ubo;
	}
}


