package pti.sb_treasurehunter_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_treasurehunter_mvc.dto.UserDTO;
import pti.sb_treasurehunter_mvc.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/")
	public String loadLoginPage()
	{
		
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(Model model,
						@RequestParam("username") String name,
						@RequestParam("pwd") String pwd
						)
	{
		String targetPage = "login.html";
		
		UserDTO userDTO = service.login(name,pwd);
		model.addAttribute("userDTO", userDTO);
		
		if (userDTO != null)
		{
			targetPage= "treasurehunter.html";
		}
		
		return targetPage;
	}
	
	@PostMapping("/save")
	public String save(	Model model,
						@RequestParam("userid") int id,
						@RequestParam("win") boolean win,
						@RequestParam("clicked") int clicked
						)
	{
		UserDTO userDTO = service.saveById(id,win,clicked);
		model.addAttribute("userDTO" ,userDTO);
		
		return "result.html";
	}
}
