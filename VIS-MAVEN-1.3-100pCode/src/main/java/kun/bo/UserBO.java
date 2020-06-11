package kun.bo;

import lombok.Data;

@Data
public class UserBO {
	
	private int id;
	private String name;
	private String password;
	private String gender;
	private String nationality;
	private String license;
	private int authority_id;
	private VehicleBO vbo;
	private InsuranceBO ibo;
	
	//String provider=ibo.getProvider();
	//String insurance_number=ibo.getInsurance_number();
	//String validity_date=ibo.getValidity_date();
}
