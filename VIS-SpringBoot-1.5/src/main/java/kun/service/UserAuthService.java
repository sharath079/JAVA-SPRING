package kun.service;

import kun.command.UserAuthCommand;

public interface UserAuthService {
	
	public boolean userAuth(UserAuthCommand autCmd);

}
