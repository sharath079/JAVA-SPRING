package kun.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kun.command.VehicleCommand;

@Component("VehRegValidator")
public class VehRegValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(VehicleCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VehicleCommand vcmd=null;
		vcmd=(VehicleCommand) target;
		
if(vcmd.getId()==0)
  errors.rejectValue("id", "veh.id.required");

if(vcmd.getSource()==null || vcmd.getSource().toString()=="" | vcmd.getSource().length()==0)
  errors.rejectValue("source", "veh.source.required");
if(vcmd.getSource().length()>30)
  errors.rejectValue("source","veh.source.range");

if(vcmd.getCategory()==null || vcmd.getCategory().toString()=="" | vcmd.getCategory().length()==0)
  errors.rejectValue("category", "veh.category.required");
if(vcmd.getCategory().length()>15)
  errors.rejectValue("category","veh.category.range");

if(vcmd.getPlate_number()==null || vcmd.getPlate_number().toString()=="" | vcmd.getPlate_number().length()==0)
  errors.rejectValue("plate_number", "veh.plate_number.required");
if(vcmd.getPlate_number().length()>15)
  errors.rejectValue("plate_number", "veh.plate_number.range");

if(vcmd.getManufacture()==null || vcmd.getManufacture().toString()=="" | vcmd.getManufacture().length()==0)
  errors.rejectValue("manufacture","veh.manufacture.required");
if(vcmd.getManufacture().length()>30)
  errors.rejectValue("manufacture","veh.manufacture.range");

if(vcmd.getType()==null || vcmd.getType().toString()=="" | vcmd.getType().length()==0)
   errors.rejectValue("type","veh.type.required");
if(vcmd.getType().length()>15)
   errors.rejectValue("type","veh.type.range");

if(vcmd.getColor()==null || vcmd.getColor().toString()=="" | vcmd.getColor().length()==0)
  errors.rejectValue("color","veh.color.required");
if(vcmd.getColor().length()>20)
  errors.rejectValue("color","veh.color.range");

if(vcmd.getRegistration_date()==null || vcmd.getRegistration_date().toString()=="" | vcmd.getRegistration_date().length()==0)
   errors.rejectValue("registration_date", "veh.registration_date.required");
if(vcmd.getRegistration_date().length()>15)
   errors.rejectValue("registration_date","veh.registration_date.range");

if(vcmd.getPending_fines()==null || vcmd.getPending_fines().toString()=="" | vcmd.getPending_fines().length()==0)
   errors.rejectValue("pending_fines","veh.pending_fines.required");
if(vcmd.getPending_fines().length()>5)
   errors.rejectValue("pending_fines","veh.pending_fines.range");

if(vcmd.getUser_id()==0)
   errors.rejectValue("user_id", "veh.user_id.required");
}

}
