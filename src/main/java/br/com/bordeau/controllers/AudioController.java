package br.com.bordeau.controllers;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/audio")
public class AudioController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView mostrar(){
		return new ModelAndView("audio");
	}
	
//	@RequestMapping(value="/new", method=RequestMethod.POST)
//	public String newAudio(@RequestParam("file") MultipartFile file){
//		return file.getOriginalFilename();
//	}

}
