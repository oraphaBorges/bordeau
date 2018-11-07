package br.com.bordeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.EpisodioDAO;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Episodio;

@Controller
@RequestMapping("/podcast/episodio")
public class EpisodioController {
	
	@Autowired
	private EpisodioDAO dao;
	
	@Autowired
	private FileSaver fileSaver;

	
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(Integer id) {
		return new ModelAndView("podcast/episodio");
	}
	

	@RequestMapping(value = "/novo" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		ModelAndView mv = new ModelAndView("podcast/formularioSpring");
		mv.addObject("episodio", new Episodio());
		return mv;
	}

	@RequestMapping(value = "/novo" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario(MultipartFile[] files,Episodio episodio) {
		try {
			String path;
			path = fileSaver.write("capas", files[0]);
			episodio.setCapa(path);
			path = fileSaver.write("audios", files[1]);
			episodio.setAudio(path);
			
			dao.gravar(episodio);
		} catch (Exception e) {
			System.out.println("Ops deu ruim");
		}
		return new ModelAndView("podcast/episodio");
	}


}
