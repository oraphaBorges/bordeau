package br.com.bordeau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/podcast")
public class PodcastController {
	
	// Página inicial do podcast
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView show(){
		return new ModelAndView("podcast/home");
	}
	
	// Página formulario do podcast
	@RequestMapping(value = "/submit" ,method=RequestMethod.GET)
	public ModelAndView form(){
		return new ModelAndView("podcast/formulario");
	}
	
	// envio do formulario do podcast para o banco
	@RequestMapping(value = "/submit" ,method=RequestMethod.POST)
	public ModelAndView send(){
		return new ModelAndView("podcast/home");
	}
	
//	// página do envio do podcast
//	@RequestMapping(method=RequestMethod.POST)
//	public String newAudio(@RequestParam("file") MultipartFile file){
//		return file.getOriginalFilename();
//	}
	
	

}
