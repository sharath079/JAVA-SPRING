package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import kun.bo.InsuranceBO;
import kun.bo.VehicleBO;

@Repository("insDAO")
public class InsuranceDAOIMPL implements InsuranceDAO{
	
public static final String INS_INSERT_QUERY="INSERT INTO TBL_INSURANCE VALUES(?,?,?,?,?)";
public static final String INS_SEARCH_BY_ID= "SELECT ID,PROVIDER,INSURANCE_NUMBER,VALIDITY_DATE,USER_ID FROM TBL_INSURANCE WHERE ID=?";	

public static final String DELETE_INS="DELETE FROM TBL_INSURANCE WHERE ID=?";

    @Autowired(required = true)
	private HikariDataSource hkds;

	@Override
	public int insInsert(InsuranceBO insbo) throws Exception {
		
		int count=0;
		//Authorities auth=new Authorities();
		Connection con=null;
		PreparedStatement ps=null;
		//get pooled jdbc con object
		con=hkds.getConnection();
		//create PreparedStatement obj having SQL Query
		ps=con.prepareStatement(INS_INSERT_QUERY);
		
		ps.setInt(1, insbo.getId());
		ps.setString(2, insbo.getProvider());
		ps.setString(3, insbo.getInsurance_number());
		ps.setString(4, insbo.getValidity_date());
		ps.setInt(5, insbo.getUser_id());
		
		count=ps.executeUpdate();
		
		ps.close();
		con.close();
		return count;
	}

	@Override
	public List<InsuranceBO> findByInsuranceId(int id) throws Exception {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		InsuranceBO ibo;
		List<InsuranceBO> list_ins = null;
		//get pooled jdbc con object
		con=hkds.getConnection();
		
		//create PreparedStatement obj having SQL Query
				ps=con.prepareStatement(INS_SEARCH_BY_ID);
				ps.setInt(1,id);
				rs=ps.executeQuery();
				
				// getting resultset obj and assign to "ibo" & list_ins
				
				try {
					ibo= new InsuranceBO();
					list_ins=new ArrayList<InsuranceBO>();
					while(rs.next()) {
						ibo.setId(rs.getInt(1));
						ibo.setProvider(rs.getString(2));
						ibo.setInsurance_number(rs.getString(3));
						ibo.setValidity_date(rs.getString(4));
						ibo.setUser_id(rs.getInt(5));
						
						list_ins.add(ibo);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
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
