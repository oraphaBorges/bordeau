package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.IndexDAO;
import br.com.bordeau.model.Episodio;
import br.com.bordeau.model.Podcast;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView mostrar(){
		
		ModelAndView mv = new ModelAndView("index");
		
		List<Episodio> novosEpisodios = dao.novosEpisodios();
		List<Episodio> EpisodiosEmAlta = dao.EpisodiosEmAlta();
		mv.addObject("novosEpisodios", novosEpisodios);
		mv.addObject("EpisodiosEmAlta", EpisodiosEmAlta);

		List<Podcast> novosPodcasts = dao.novosPodcasts();
		List<Podcast> PodcastsEmAlta = dao.PodcastsEmAlta();
		mv.addObject("novosPodcasts", novosPodcasts);
		mv.addObject("PodcastsEmAlta", PodcastsEmAlta);
		
		return mv;
	}

}
