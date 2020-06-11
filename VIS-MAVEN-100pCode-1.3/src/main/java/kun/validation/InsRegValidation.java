package kun.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kun.command.InsuranceCommand;

@Component("InsRegValidator")
public class InsRegValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("InsRegValidation.supports()");
		return clazz.isAssignableFrom(InsuranceCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("InsRegValidation.validate()");
		
		InsuranceCommand icmd=null;
		// type casting
		icmd=(InsuranceCommand) target;
		
if(icmd.getId()==0)
	errors.rejectValue("id", "ins.id.required");

if(icmd.getProvider()==null || icmd.getProvider().toString()=="" || icmd.getProvider().length()==0)
    errors.rejectValue("provider", "ins.provider.required");
if(icmd.getProvider().length()>15)
	errors.rejectValue("provider", "ins.provider.range");

if(icmd.getInsurance_number()==null || icmd.getInsurance_number().toString()=="" || icmd.getInsurance_number().length()==0)
    errors.rejectValue("insurance_number", "ins.insurance_number.required");
if(icmd.getInsurance_number().length()>20)
	errors.rejectValue("insurance_number", "ins.insurance_number.range");

if(icmd.getValidity_date()==null || icmd.getValidity_date().toString()=="" || icmd.getValidity_date().length()==0)
    errors.rejectValue("validity_date", "ins.validity_date.required");
if(icmd.getValidity_date().length()>15)
	errors.rejectValue("validity_date", "ins.validity_date.range");

if(icmd.getUser_id()==0)
	errors.rejectValue("user_id", "ins.user_id.required");

	}

}
