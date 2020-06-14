package kun.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kun.command.UserCommand;

@Component("UserRegValditor")
public class UserRegValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("UserRegValidation.supports()");
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
	    UserCommand userCmd=null;
	    //type casting
	    userCmd=(UserCommand) target;
	    
// server side validations
if(userCmd.getId()==0)
	errors.rejectValue("id", "user.id.required");

if(userCmd.getName()==null || userCmd.getName().equalsIgnoreCase("") || userCmd.getName().length()==0)
	errors.rejectValue("name", "user.name.required");
if(userCmd.getName().length()>25)
	errors.rejectValue("name", "user.name.range");

if(userCmd.getPassword()==null || userCmd.getPassword().equalsIgnoreCase("") || userCmd.getPassword().length()==0)
	errors.rejectValue("password", "user.password.required");
if(userCmd.getPassword().length()>15)
	errors.rejectValue("password", "user.password.range");

if(userCmd.getGender()==null || userCmd.getGender().equalsIgnoreCase("") || userCmd.getGender().length()==0)
	errors.rejectValue("gender", "user.gender.required");
if(userCmd.getGender().length()>7)
	errors.rejectValue("gender", "user.gender.range");

if(userCmd.getNationality()==null || userCmd.getNationality().equalsIgnoreCase("") || userCmd.getNationality().length()==0)
	errors.rejectValue("nationality", "user.nationality.required");
if(userCmd.getNationality().length()>20)
	errors.rejectValue("nationality", "user.nationality.range");

if(userCmd.getLicense()==null || userCmd.getLicense().equalsIgnoreCase("") || userCmd.getLicense().length()==0)
	errors.rejectValue("license", "user.license.required");
if(userCmd.getLicense().length()>6)
	errors.rejectValue("license", "user.license.range");

if(userCmd.getAuthority_id()==0)
	errors.rejectValue("authority_id", "user.authority_id.required");

	}

}
