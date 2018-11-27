package br.com.bordeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.PodcastDAO;
import br.com.bordeau.model.Podcast;

@Controller
@RequestMapping("/podcast")
public class PodcastController {

	@Autowired
	private PodcastDAO dao;
	private Podcast podcast;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Long id) {
		this.podcast = dao.findById(id);

		ModelAndView modelAndView = new ModelAndView("podcast/paginaPodcast");
		modelAndView.addObject("podcast", podcast);
		modelAndView.addObject("episodios", podcast.getEpisodios());
		return modelAndView;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("podcast/formularioPodcast");
		modelAndView.addObject("podcast", new Podcast());
		return modelAndView;
	}

}
