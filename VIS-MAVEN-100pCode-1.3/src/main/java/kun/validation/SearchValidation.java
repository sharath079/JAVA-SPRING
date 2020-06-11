package kun.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kun.command.SearchCommand;

@Component("userSearchValidator")
public class SearchValidation implements Validator {

	@Override  // To check whether correct command class is passed or not..
	public boolean supports(Class<?> clazz) {
	    System.out.println("SearchValidation.supports()");
// return true or false based on passed command class is valid or not	    
		return clazz.isAssignableFrom(SearchCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SearchCommand Scmd=null;
		//type casting
		Scmd=(SearchCommand) target;
		
		// server side validations
if(Scmd.getUsername()==null || Scmd.getUsername().equalsIgnoreCase("") || Scmd.getUsername().length()==0)
	errors.rejectValue("username", "search.username.required");
if(Scmd.getUsername().length()>30)
	errors.rejectValue("username", "search.username.range");
if(Scmd.getLicenseno()==null || Scmd.getLicenseno().equalsIgnoreCase("") || Scmd.getLicenseno().length()==0)
    errors.rejectValue("licenseno", "search.licenseno.required");
if(Scmd.getPlateno()==null || Scmd.getPlateno().equalsIgnoreCase("") || Scmd.getPlateno().length()==0)
    errors.rejectValue("plateno", "search.plateno.required");		
		
	}

}
