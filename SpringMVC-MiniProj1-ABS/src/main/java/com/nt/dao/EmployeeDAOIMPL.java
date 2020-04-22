package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOIMPL implements EmployeeDAO{
	
public static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP1";

private JdbcTemplate jt;

EmployeeBO empbo;


public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}



public class EmpExtractor implements ResultSetExtractor<List<EmployeeBO>>{

	public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<EmployeeBO> listbo=null;
		listbo=new ArrayList<EmployeeBO>();
		while(rs.next()) {
			empbo=new EmployeeBO();
			empbo.setEmpno(rs.getInt(1));
			empbo.setEname(rs.getString(2));
			empbo.setJob(rs.getString(3));
			empbo.setSal(rs.getFloat(4));
			
		listbo.add(empbo);
		}//while
		return listbo;
	}

}



@Override
public List<EmployeeBO> getAllEmps() {
	List<EmployeeBO> listbo=null;
	listbo=jt.query(GET_ALL_EMPS, new EmpExtractor());
	
	return listbo;
}


}
