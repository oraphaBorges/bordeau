package br.com.bordeau.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bordeau.DAOS.PodcastDao;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Podcast;

@Controller
@RequestMapping("/podcast")
public class PodcastController {
	
	@Autowired
	private FileSaver fileSaver;
	private PodcastDao dao;

	// Página inicial do podcast
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("podcast/home");
		Podcast podcast = dao.findById(id);
		modelAndView.addObject("produto", podcast);
		return new ModelAndView("podcast/home");
	}
	
	// Página formulario do podcast
	@RequestMapping(value = "/submit" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario(){
		return new ModelAndView("podcast/formulario");
	}
	
	// envio do formulario do podcast para o banco
	@RequestMapping(value = "/submit" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario(@RequestParam("file") MultipartFile file, @Valid Podcast podcast, BindingResult results,
			RedirectAttributes redirectAttributes) {

//		if (results.hasErrors()) {
//			return form(podcast);
//		}
		Long idPodcast = 335L;
		String path = fileSaver.write("episodios/"+idPodcast, file);
		System.out.println(path);
		return new ModelAndView("podcast/home");
	}
	
	
	
	

}
