package kun.bo;

public class SearchBO {
	
	private String licenseno;
	private String username;
	private String plateno;
	
	
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlateno() {
		return plateno;
	}
	public void setPlateno(String plateno) {
		this.plateno = plateno;
	}
	
	@Override
	public String toString() {
		return "SearchBO [licenseno=" + licenseno + ", username=" + username + ", plateno=" + plateno + "]";
	}
}
