package kun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kun.command.UserAuthCommand;
import kun.dao.UserAuth;

@Service("UserAutServImpl")
public class UserAuthServImpl implements UserAuthService {

	@Autowired
	UserAuth UsrAut;
	
	@Override
	public boolean userAuth(UserAuthCommand autCmd) {
		
		boolean res=UsrAut.auth(autCmd);
		return res;
	}

}
