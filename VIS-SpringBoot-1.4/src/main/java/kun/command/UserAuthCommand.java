package kun.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthCommand {
	private String name;
	private String password;

}
