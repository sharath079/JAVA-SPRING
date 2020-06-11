package kun.bo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class InsuranceBO {
	private int id;
	private String provider;
	private String insurance_number;
	private String validity_date;
	private int user_id;
	
		
	@Autowired
	public InsuranceBO(String provider, String insurance_provider, String validity_date) {
		super();
		this.provider = provider;
		this.insurance_number = insurance_provider;
		this.validity_date = validity_date;
	}
	
	public InsuranceBO() {
		
	}
	
}
