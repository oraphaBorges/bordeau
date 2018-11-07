package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.IndexDAO;
import br.com.bordeau.model.Episodio;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView mostrar(){
		ModelAndView mv = new ModelAndView("index");
		List<Episodio> novos = dao.novos();
		List<Episodio> emAlta = dao.emAlta();
		mv.addObject("novos", novos);
		mv.addObject("emAlta", emAlta);
		
		return mv;
	}

}
