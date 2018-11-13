package br.com.bordeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.PodcastDAO;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Podcast;

@Controller
@RequestMapping("/podcast")
public class PodcastController {
	
	private Podcast podcast;
		
	@Autowired
	private PodcastDAO dao;
	
	@Autowired
	private FileSaver fileSaver;

	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Long id){
		this.podcast = dao.findById(id);
		ModelAndView mv = new ModelAndView("podcast/paginaPodcast");
		mv.addObject("podcast", podcast);
		return mv;
	}
	
	@RequestMapping(value = "/novo" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario(){
		ModelAndView mv = new ModelAndView("podcast/formularioPodcast");
		mv.addObject("podcast", new Podcast());
		return mv;
	}
	
	@RequestMapping(value = "/novo" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario(MultipartFile[] files,Podcast podcast) {
		ModelAndView mv = new ModelAndView("podcast/formularioPodcast");
		try {
			String path = fileSaver.write("capas", files[0]);
			podcast.setCapaPath(path);
			
			dao.gravar(podcast);
		}catch (Exception e) {
			System.out.println("fim Ops deu ruim!");
		}
		return exibirPagina(podcast.getId());
	}
 

}
