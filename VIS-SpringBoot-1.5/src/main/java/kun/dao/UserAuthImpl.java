package kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public static final String Auth_Query="SELECT NAME,PASSWORD FROM TBL_USER WHERE NAME=?";
	
	@Autowired(required = true)
	private HikariDataSource hkds;
	
	@Autowired
	private JdbcTemplate jTemp;
	
	public UserAuthImpl(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}

	Connection con =null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
	@Override
	public boolean auth(UserAuthCommand autCmd) {
		
    
    boolean result = false;
    
    try {
    	con=hkds.getConnection();
    	
    	ps=con.prepareStatement(Auth_Query);
    	ps.setString(1, autCmd.getName());
    	rs=ps.executeQuery();
    	System.out.println("user auth dao-impl...");
    	
    	while(rs.next())
    	{
		String name = rs.getString("name");
		String password = rs.getString("password");
		
		System.out.println("name"+name);
       if(autCmd.getName().equalsIgnoreCase(name)&& autCmd.getPassword().equalsIgnoreCase(password))
       result=true;
       else 
       result=false;
       }
    	con.close();
    	ps.close();
    	rs.close();
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    System.out.println("result :: "+result);
	return result;			
}
}	