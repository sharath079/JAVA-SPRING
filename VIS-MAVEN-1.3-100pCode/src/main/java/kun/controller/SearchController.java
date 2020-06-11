package kun.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kun.bo.UserBO;
import kun.command.ByNameCommand;
import kun.command.SearchCommand;
import kun.dto.ByNameDTO;
import kun.dto.SearchDTO;
import kun.service.SearchService;
import kun.service.UserService;
import kun.validation.SearchValidation;

@Controller
@SessionAttributes("{Scmd,BNcmd}")
public class SearchController {

	@Autowired
	private SearchService sService;
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private SearchValidation srchV;
	
	@ModelAttribute("Scmd")
	public SearchCommand  getSearchCommand() {
		System.out.println("getSearchCommand()");
		return new SearchCommand();
	}
	
	@ModelAttribute("BNcmd")
	public ByNameCommand  getByNameCommand() {
		System.out.println("getByNameCommand()");
		return new ByNameCommand();
	}
	
	@GetMapping("/search.htm")
	public String showHome(@ModelAttribute("Scmd")SearchCommand srchCmd) {
		return"user_search";
	}
	
	@PostMapping("/search.htm")
	public String process(HttpSession ses,
			@ModelAttribute("Scmd")SearchCommand srchCmd,BindingResult br) {
		
		 SearchDTO sdto=null;
		 List<UserBO> list_user=null;
		 sdto=new SearchDTO();
		 
		 // call support() and validate(-,-)
		 
		 if(srchV.supports(SearchCommand.class))
			 srchV.validate(srchCmd, br);
		 if(br.hasErrors())
			 return"user_search";
		 
		 BeanUtils.copyProperties(srchCmd, sdto);
		 
		 list_user=new ArrayList<UserBO>();
		 
		 try 
		 {
			 list_user=sService.result(sdto);			 
		 } 
		 catch (Exception e) {
			
			e.printStackTrace();
		}
		 System.out.println("Result :: "+list_user);
		 
		 ses.setAttribute("list",list_user);
		 return "search_result";
	   }
	
	@GetMapping("/searchbyname.htm")
	public String showHome(@ModelAttribute("BNcmd")ByNameCommand bnCmd) {
		return"user_search_byname";
	}
	
	@PostMapping("/searchbyname.htm")
	public String process1(HttpSession ses,
			@ModelAttribute("BNcmd")ByNameCommand bnCmd,BindingResult br) {
		
		 ByNameDTO ndto=null;
		 List<UserBO> list_user=null;
		 ndto=new ByNameDTO();
		 
		 BeanUtils.copyProperties(bnCmd, ndto);
		 
		 list_user=new ArrayList<UserBO>();
		 
		 try 
		 {
			 list_user=uservice.retrievalByUserName(ndto);			 
		 } 
		 catch (Exception e) {
			
			e.printStackTrace();
		}
		 System.out.println("Result :: "+list_user);
		 
		 ses.setAttribute("list",list_user);
		 return "search_result_byname";
	   }
}
