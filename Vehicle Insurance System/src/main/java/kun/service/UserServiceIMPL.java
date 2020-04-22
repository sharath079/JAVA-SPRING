package kun.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.UserBO;
import kun.dao.UserDAO;
import kun.dao.UserDAOIMPL;

@Service("userService")

public class UserServiceIMPL implements UserService{
	

	UserBO userbo;
	@Autowired
	UserDAO userdao;
	int count;

	public String insert(int id, String name, String password, String gender, String nationality, String license,int authority_id) throws Exception 
	{
		userbo=new UserBO();
		userbo.setId(id);
		userbo.setName(name);
		userbo.setPassword(password);
		userbo.setGender(gender);
		userbo.setNationality(nationality);
		userbo.setLicense(license);
		userbo.setAuthority_id(authority_id);
		
		System.out.println("userBO object "+userbo);
		// use UserDAO
        count=userdao.insert(userbo);	
        if(count==0)
        {
        	System.out.println("Record not inserted....");
        	return "Record not inserted....";
        }
        else
        {
        System.out.println("Record inserted into user table....");
		return "record inserted into User table....";
        }
	}

	@Override
	public List<UserBO> retrievalByUserName(String name) throws SQLException {
		
		List<UserBO> list = new ArrayList<UserBO>();
		list=userdao.findUserByName(name);
		return list;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean count;
		count=userdao.delete(id);
		return count;
	}
}
