package kun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kun.command.DeleteCommand;
import kun.command.InsuranceCommand;
import kun.command.UserCommand;
import kun.command.VehicleCommand;
import kun.dto.InsuranceDTO;
import kun.dto.UserDTO;
import kun.dto.VehicleDTO;
import kun.service.InsuranceService;
import kun.service.UserService;
import kun.service.VehicleService;

@Controller
@SessionAttributes("{UserCmd,InsCmd,VehCmd,DelCmd}")
public class InsertController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private InsuranceService insService;
	
	@Autowired
	private VehicleService vehService;
	
	@ModelAttribute("UserCmd")
	public UserCommand  getUserCommand() {
		System.out.println("getUserCommand()");
		return new UserCommand();
	}
	
	@ModelAttribute("InsCmd")
	public InsuranceCommand  getInsuranceCommand() {
		System.out.println("getInsuranceCommand()");
		return new InsuranceCommand();
	}
	
	@ModelAttribute("VehCmd")
	public VehicleCommand  getVehicleCommand() {
		System.out.println("getVehicleCommand()");
		return new VehicleCommand();
	}
	
	@ModelAttribute("DelCmd")
	public DeleteCommand  getDeleteCommand() {
		System.out.println("getDeleteCommand()");
		return new DeleteCommand();
	}
	
	@RequestMapping("/homepage.htm")
	public String Home() {
		return "home";
	}
    
	@GetMapping("/registration.htm")        //Initial Phase
	public String Home(@ModelAttribute("UserCmd") UserCommand uCmd) {
		
		System.out.println("InsertController.Home()...");
		return "user_registration";
		}
	
	@PostMapping("/registration.htm")
	public String process(HttpSession ses,@ModelAttribute("UserCmd") UserCommand uCmd,
			                              BindingResult br) {

		System.out.println("InsertController.process()...");
		UserDTO udto=null;
		
		String result=null;
		
		udto=new UserDTO();
	
		BeanUtils.copyProperties(uCmd, udto);
		
		
		try {
			result=service.insert(udto);
			
		} catch (Exception e) {
			result="Record insertion Failed....  ";
			e.printStackTrace();
		}
		ses.setAttribute("result", result);
		return "insert_result";
	}
	
	@GetMapping("/insurance.htm")
	public String InsHome(@ModelAttribute("InsCmd")InsuranceCommand insCmd) {
		
		return "ins_page";
	}
	
	@PostMapping("/insurance.htm")
	public String process1(HttpSession ses,
			@ModelAttribute("InsCmd")InsuranceCommand insCmd,BindingResult br) 
	{
		System.out.println("InsertController.process1()...");
		InsuranceDTO insdto=null;
		String result=null;
		
		insdto=new InsuranceDTO();
		
		BeanUtils.copyProperties(insCmd, insdto);
		
		try {
			
			result=insService.InsInsert(insdto);
			
		} catch (Exception e) {
			result="Record insertion Failed....  ";
			e.printStackTrace();
		}
		ses.setAttribute("result", result);
		return "insurance_result";
	}
	
	@GetMapping("/vehicle.htm")
	public String VehicleHome(@ModelAttribute("VehCmd")VehicleCommand vehCmd) {
		
		return "veh_page";
	}
	
	@PostMapping("/vehicle.htm")
	public String process2(HttpSession ses,
			@ModelAttribute("VehCmd")VehicleCommand vehCmd,BindingResult br) 
	{
		System.out.println("InsertController.process1()...");
		VehicleDTO vehdto=null;
		String result=null;
		
		vehdto=new VehicleDTO();
		
		BeanUtils.copyProperties(vehCmd, vehdto);
		
		try {
			
			result=vehService.vInsert(vehdto);
			
		} catch (Exception e) {
			result="Record insertion Failed....  ";
			e.printStackTrace();
		}
		ses.setAttribute("result", result);
		return "vehicle_result";
	}
	
	@GetMapping("/delete.htm")
	public String DeleteHome(@ModelAttribute("DelCmd")DeleteCommand dCmd) {
		
		return "user_delete";
	}
	
	@PostMapping("/delete.htm")
	public String process3(HttpSession ses,
			@ModelAttribute("DelCmd")DeleteCommand dCmd,BindingResult br) 
	{
		Boolean result = null;
		String resMsg;
		try {
			result=service.delete(dCmd.getId());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(result==true) {
			resMsg="User Record Deleted... ";
		}
		else
			resMsg="User Record Not Deleted...";
		
		ses.setAttribute("result", resMsg);
		return "delete_result";
	
	}
}
