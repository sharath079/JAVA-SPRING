package kun.command;

import lombok.Data;

@Data
public class VehicleCommand {
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
}
