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

import kun.bo.InsuranceBO;

@Repository("insDAO")
public class InsuranceDAOIMPL implements InsuranceDAO{
	
public static final String INS_INSERT_QUERY="INSERT INTO TBL_INSURANCE VALUES(?,?,?,?,?)";
public static final String INS_SEARCH_BY_ID= "SELECT ID,PROVIDER,INSURANCE_NUMBER,VALIDITY_DATE,USER_ID FROM TBL_INSURANCE WHERE ID=?";	

public static final String DELETE_INS="DELETE FROM TBL_INSURANCE WHERE ID=?";

    @Autowired(required = true)
	private HikariDataSource hkds;
    
    @Autowired
    private JdbcTemplate jTemp;

	public InsuranceDAOIMPL(JdbcTemplate jTemp) {
		super();
		this.jTemp = jTemp;
	}
    
	/*
	 * Inserting Records into tbl_insurance table using insurance object as arguments
	 * for JDBC-Template jTemp.update(query,args..);
	 * */
	@Override
	public int insInsert(InsuranceBO insbo) throws Exception {
	    int result=jTemp.update(INS_INSERT_QUERY, insbo.getId(),insbo.getProvider(),insbo.getInsurance_number(),insbo.getValidity_date(),insbo.getUser_id());	
		return result;
	}
	
	/*
	 * Retrieves List of Insurance Details By ID
	 * Using JDBC template obj.
	 * 
	 * */
	@Override
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception {
		
		InsuranceBO ibo;
		List<InsuranceBO> list_ins = null;
		list_ins=jTemp.query(INS_SEARCH_BY_ID, new ResultSetExtractor<List<InsuranceBO>>() {

			@Override
			public List<InsuranceBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        
				InsuranceBO ibo;
				List<InsuranceBO> list_ins;
				
				ibo= new InsuranceBO();
				list_ins=new ArrayList<InsuranceBO>();
				
				// getting resultset obj and assign to "ibo" & list_ins
				while(rs.next()) {
					ibo.setId(rs.getInt(1));
					ibo.setProvider(rs.getString(2));
					ibo.setInsurance_number(rs.getString(3));
					ibo.setValidity_date(rs.getString(4));
					ibo.setUser_id(rs.getInt(5));
					
					list_ins.add(ibo);
				}//while
				return list_ins;
			}// extracted Data
			
		}// anonomous inner class
		,id); // method call
		return list_ins;
	}
	
	@Override
	public boolean delete(int id) throws Exception {
		
		int ins_id=id;
		Connection con=null;
		PreparedStatement ps=null;
		boolean value = false;
		//get pooled jdbc con object
		try {
		con=hkds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(DELETE_INS);
		ps.setInt(1, ins_id);
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
