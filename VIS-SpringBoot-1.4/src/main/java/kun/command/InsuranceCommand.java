package kun.command;

import lombok.Data;

@Data
public class InsuranceCommand {

	private int id;
	private String provider;
	private String insurance_number;
	private String validity_date;
	private int user_id;
}
