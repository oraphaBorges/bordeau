package br.com.bordeau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.PodcastDao;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Podcast;

@Controller
@RequestMapping("/podcast")
public class PodcastController {//implements pagina {
	
	private FileSaver fileSaver;
	
//	@Autowired
	private PodcastDao dao;

	// Página inicial do podcast
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("podcast/home");
		Podcast podcast = dao.findById(id);
		modelAndView.addObject("produto", podcast);
		// Aqui retornará o modelandview criado q será direcionado para a página do episódio
		return new ModelAndView("podcast/home");
	}
	
	// Página formulario do podcast
	@RequestMapping(value = "/submit" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario(){
		return new ModelAndView("podcast/formulario");
	}
	
	// envio do formulario do podcast para o banco
//	@MultipartConfig(maxFileSize=1L)
	@RequestMapping(value = "/submit" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulari(Podcast podcast) {
		try {
		dao.gravar(podcast);
		}catch(Exception e) {
			System.out.println("Não deu!");
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
	

}
