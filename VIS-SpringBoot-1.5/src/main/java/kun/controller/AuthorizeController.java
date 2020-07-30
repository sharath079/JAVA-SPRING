package kun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kun.command.AdminCommand;
import kun.command.UserAuthCommand;
import kun.service.UserAuthService;

@Controller
@SessionAttributes({"adminCmd","UsrAuthCmd"})
public class AuthorizeController {
	
	@Autowired
	UserAuthService uAutServ;
	
	@ModelAttribute("adminCmd")
	public AdminCommand  getAdminCommand() {
		System.out.println("getAdminCommand()");
		return new AdminCommand();
	}

	@ModelAttribute("UsrAuthCmd")
	public UserAuthCommand  getUserCommand() {
		System.out.println("getUserAuthCommand()");
		return new UserAuthCommand();
	}
	
	@GetMapping("/admin.htm")
	public String AdminHome(HttpSession ses,@ModelAttribute("adminCmd") AdminCommand aCmd) {
		return "adminLogin";
	}
	
	@PostMapping("/admin.htm")
	public String AdminOperations(HttpSession ses,@ModelAttribute("adminCmd") AdminCommand aCmd) 
	{
	    String name=aCmd.getName();
	    String password=aCmd.getPassword();
	    
	    if(name.equalsIgnoreCase("nataraz")&& password.equalsIgnoreCase("spring"))
		return "adminHome";
	    else
	    	System.out.println("Invalid Credentails...");
	    	return "adminLogin";
	}
	
	@GetMapping("/user.htm")
	public String UserHome(HttpSession ses,@ModelAttribute("UsrAuthCmd") UserAuthCommand usrAuthCmd)
	{
		return "userLogin";
	}
	
	@PostMapping("/user.htm")
	public String UserOperations(HttpSession ses,@ModelAttribute("UsrAuthCmd") UserAuthCommand usrAuthCmd) 
	{
		System.out.println("user auth post-mapping...");
		boolean val;
		val=uAutServ.userAuth(usrAuthCmd);
		
		System.out.println("boolean val :: "+val);
		if(val)
		return "userHome";
		else
			return "userLogin";
	}
}
