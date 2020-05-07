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

import kun.bo.ByNameBO;
import kun.bo.UserBO;
import kun.service.InsuranceService;
import kun.service.VehicleService;
import kun.test.InsuranceClient;
import kun.test.VehicleDeleteClient;

@Repository("userDAOImpl")
public class UserDAOIMPL implements UserDAO {

	public static final String INSERT_QUERY="INSERT INTO TBL_USER(ID,NAME,PASSWORD,GENDER,NATIONALITY,LICENSE,AUTHORITY_ID) VALUES(?,?,?,?,?,?,?)";
	
	public static final String RETRIEVAL_USER ="SELECT ID,NAME,PASSWORD,GENDER,NATIONALITY,LICENSE,AUTHORITY_ID FROM TBL_USER WHERE NAME= ?";
	
	public static final String DELETE_USER="DELETE FROM TBL_USER WHERE ID=?";
	
	public static final String SELECT_VEH="SELECT ID,USER_ID FROM TBL_VEHICLES WHERE USER_ID=?";
	
	public static final String SELECT_INS="SELECT ID,USER_ID FROM TBL_INSURANCE WHERE USER_ID=?";

	@Autowired(required = true)
	private HikariDataSource hkds;
	
	@Autowired
	private JdbcTemplate jTemp;
	
	/*
	 * JDBCTemplate Injection through constructor-Injection
	 * 
	 * */
	public UserDAOIMPL(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

	/*
	 * Inserting Records into tbl_user table By passing userbo as arguments to 
	 * JDBC-Template
	 *  
	 * */
	@Override
	public int insert(UserBO userbo) throws Exception {
		int result=jTemp.update(INSERT_QUERY, userbo.getId(),userbo.getName(),userbo.getPassword(),userbo.getGender(),userbo.getNationality(),userbo.getLicense(),userbo.getAuthority_id());
		return result;
	}
	
	/*
	 * Retrieves List of Details based on UserName
	 * Using jdbc Template and resultSetExtracter
	 * */
	@Override
	public List<UserBO> findUserByName(ByNameBO nbo) throws SQLException {
	    
		UserBO ubo=null;
		List<UserBO> listbo = null;
		
		listbo=jTemp.query(RETRIEVAL_USER,new ResultSetExtractor<List<UserBO>>() {

			@Override
			public List<UserBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			    
				UserBO ubo=null;
				List<UserBO> listbo = null;
				listbo=new ArrayList<UserBO>();
				
				while(rs.next()) {
					
					ubo=new UserBO();
					
					ubo.setId(rs.getInt(1));
					ubo.setName(rs.getString(2));
					ubo.setPassword(rs.getNString(3));
					ubo.setGender(rs.getString(4));
					ubo.setNationality(rs.getString(5));
					ubo.setLicense(rs.getString(6));
					ubo.setAuthority_id(rs.getInt(7));
					
					listbo.add(ubo);
				}// while
				return listbo;
			} // extractData
			
		}// annoyomous inner class
		,nbo.getName()); //method call
		return listbo;
	}
	
	/**
	 * Delete the user object
	 * @throws SQLException 
	 * */
	@Override
	public boolean delete(int id) 
	{
		int user_id=id;
		int v_id = 0;
		int ins_id=0;
		
		// get vehService Bean
		VehicleDeleteClient vdc=new VehicleDeleteClient();
		VehicleService veh_ser=vdc.service();
		//get insService Bean;
		InsuranceClient ic=new InsuranceClient();
		InsuranceService insSer=ic.service();
		
		Connection con=null;
		
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		
		ResultSet rs,rs1;
		int val=0;
		//get pooled jdbc con object
		
		try {
		con=hkds.getConnection();
		
		/*
		 * create PreparedStatement obj having SQL Query
		 * Getting ResultSet obj and retrieving Vehicle ID
		 * 
		 */
		ps1=con.prepareStatement(SELECT_VEH);
		ps1.setInt(1, user_id);
		rs=ps1.executeQuery();
		
		while(rs.next()) {
		
			v_id=rs.getInt(1);
		}
		
		System.out.println("Vehicle ID ::"+v_id);
		veh_ser.delete(v_id);
		
		/*
		 * create PreparedStatement obj having SQL Query
		 * Getting ResultSet obj and retrieving Insurance ID
		 * 
		 */
		
		ps2=con.prepareStatement(SELECT_INS);
		ps2.setInt(1, user_id);
		rs1=ps2.executeQuery();
		
		while(rs1.next()) {
			
			ins_id=rs1.getInt(1);
		}
		
		System.out.println("Insurance ID ::"+ins_id);
		insSer.delete(ins_id);
		
		/*
		 * create PreparedStatement obj having SQL Query
		 * Deleting the UserRecord Based on the User-ID
		 * 
		 */
		ps=con.prepareStatement(DELETE_USER);
		ps.setInt(1, user_id);
		val=ps.executeUpdate();
	    System.out.println("User Record Deleted.."+val);
   }//try
   catch(Exception e)  
		{
			e.printStackTrace();
			
		}
		if(val==1) 
		{
		   return true;
		}
		else
			return false;
	}//delete()

}
