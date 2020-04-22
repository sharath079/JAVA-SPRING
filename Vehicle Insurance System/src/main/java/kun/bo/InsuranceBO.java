package kun.bo;

import org.springframework.beans.factory.annotation.Autowired;

public class InsuranceBO {
	private int id;
	private String provider;
	private String insurance_number;
	private String validity_date;
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getInsurance_number() {
		return insurance_number;
	}
	public void setInsurance_number(String insurance_number) {
		this.insurance_number = insurance_number;
	}
	public String getValidity_date() {
		return validity_date;
	}
	public void setValidity_date(String validity_date) {
		this.validity_date = validity_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Autowired
	public InsuranceBO(String provider, String insurance_provider, String validity_date) {
		super();
		this.provider = provider;
		this.insurance_number = insurance_provider;
		this.validity_date = validity_date;
	}
	
	public InsuranceBO() {
		
	}
	
	@Override
	public String toString() {
		return "InsuranceBO [id=" + id + ", provider=" + provider + ", insurance_number=" + insurance_number
				+ ", validity_date=" + validity_date + ", user_id=" + user_id + "]";
	}

	
}
