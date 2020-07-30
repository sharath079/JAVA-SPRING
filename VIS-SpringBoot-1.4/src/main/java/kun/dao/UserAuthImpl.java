package kun.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import kun.command.UserAuthCommand;

@Repository("UserAuthImpl")
public class UserAuthImpl implements UserAuth {

	public static final String Auth_Query="SELECT NAME,PASSWORD FROM TBL_USER";
	
	@Autowired(required = true)
	private HikariDataSource hkds;
	
	@Autowired
	private JdbcTemplate jTemp;
	
	
	public UserAuthImpl(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

	@Override
	public boolean auth(UserAuthCommand autCmd) {
		
		boolean res=jTemp.query(Auth_Query,new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				String name = null,password = null;
				boolean result = false;
				while(rs.next())
				{
				name=rs.getString("name");
				password=rs.getString("password");
				
	if(autCmd.getName().equalsIgnoreCase(name)&& autCmd.getPassword().equalsIgnoreCase(password))
	result=true;
	else 
		result=false;
				}
				return result;
			}
		});	
		return res;

	}
}