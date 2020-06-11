package kun.command;

import kun.bo.InsuranceBO;
import kun.bo.VehicleBO;
import lombok.Data;

@Data
public class UserCommand {
	
	private int id;
	private String name;
	private String password;
	private String gender;
	private String nationality;
	private String license;
	private int authority_id;
	
}
