package kun.bo;

import kun.service.Authorities;

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
	
	public InsuranceBO getIbo() {
		return ibo;
	}
	public void setIbo(InsuranceBO ibo) {
		this.ibo = ibo;
	}
	public VehicleBO getVbo() {
		return vbo;
	}
	public void setVbo(VehicleBO vbo) {
		this.vbo = vbo;
	}

	
	
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	@Override
	public String toString() {
		return "UserBO [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", nationality=" + nationality + ", license=" + license + ", authority_id=" + authority_id + ", ibo="
				+ ibo + ", vbo=" + vbo + "]";
	}
	
//	@Override
//	public String toString() {
//		return "UserBO [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender
//				+ ", nationality=" + nationality + ", license=" + license + ", authority_id=" + authority_id + "]";
//	}

}
