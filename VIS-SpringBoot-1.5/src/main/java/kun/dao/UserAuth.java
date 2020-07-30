package kun.dao;

import kun.command.UserAuthCommand;

public interface UserAuth {
	
	public boolean auth(UserAuthCommand autCmd);

}
