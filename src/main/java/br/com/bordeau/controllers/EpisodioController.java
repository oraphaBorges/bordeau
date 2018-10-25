package br.com.bordeau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/podcast/episodio")
public class EpisodioController {
	
//	@Autowired
//	private EpisodioDao dao;
	
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(Integer id) {
		return new ModelAndView("podcast/episodio");
	}
	

	@RequestMapping(value = "/submit" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		ModelAndView mv = new ModelAndView("podcast/episodio");
//		mv.addObject("episodio", new Episodio());
		return mv;
	}

	@RequestMapping(value = "/submit" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario() {
		return new ModelAndView("podcast/episodio");
	}


}
