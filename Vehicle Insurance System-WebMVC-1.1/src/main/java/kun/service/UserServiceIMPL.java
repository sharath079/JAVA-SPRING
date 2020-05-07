package kun.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.bo.ByNameBO;
import kun.bo.UserBO;
import kun.dao.UserDAO;
import kun.dto.ByNameDTO;
import kun.dto.UserDTO;

@Service("userService")

public class UserServiceIMPL implements UserService{
	
    UserBO userbo;
    
	@Autowired
	UserDAO userdao;
	
	int count;
    
	/*
	 * Inserting Records into Table tbl_user using "userbo" as arguments
	 * 
	 * */
	public String insert(UserDTO userdto) throws Exception 
	{
		
		userbo=new UserBO();
		BeanUtils.copyProperties(userdto, userbo);
		
		
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
	public List<UserBO> retrievalByUserName(ByNameDTO ndto) throws SQLException {
		
		List<UserBO> list = new ArrayList<UserBO>();
		ByNameBO nbo= new ByNameBO();
		BeanUtils.copyProperties(ndto, nbo);
		list=userdao.findUserByName(nbo);
		return list;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean count;
		count=userdao.delete(id);
		return count;
	}
}
