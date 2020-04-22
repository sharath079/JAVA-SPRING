package kun.bo;

public class VehicleBO {
	private int id;
	private String source;
	private String category;
	private String plate_number;
	private String manufacture;
	private String type;
	private String color;
	private String registration_date;
	private String pending_fines;
	private int user_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPlate_number() {
		return plate_number;
	}
	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getPending_fines() {
		return pending_fines;
	}
	public void setPending_fines(String pending_fines) {
		this.pending_fines = pending_fines;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "VehicleBO [id=" + id + ", source=" + source + ", category=" + category + ", plate_number="
				+ plate_number + ", manufacture=" + manufacture + ", type=" + type + ", color=" + color
				+ ", registration_date=" + registration_date + ", pending_fines=" + pending_fines + ", user_id="
				+ user_id + "]";
	}
	
}
