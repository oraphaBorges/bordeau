package br.com.bordeau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.PodcastDAO;
import br.com.bordeau.DAOS.UsuarioDAO;
import br.com.bordeau.model.Podcast;
import br.com.bordeau.model.Usuario;

@Controller
@RequestMapping("/podcast")
public class PodcastController {

	@Autowired
	private PodcastDAO podcastDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	private Podcast podcast;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Long id) {
		this.podcast = podcastDAO.findById(id);

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
	
	@RequestMapping("/meusEpisodios")
	public ModelAndView meusEpisodios() {
		ModelAndView modelAndView = new ModelAndView("podcast/meusEpisodios");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioDAO.findByEmail(authentication.getName());
		
		modelAndView.addObject("podcast", usuario.getPodcast());
		modelAndView.addObject("episodios", usuario.getPodcast().getEpisodios());
		return modelAndView;
	}
	@RequestMapping("/meuPodcast")
	public ModelAndView meuPodcast() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioDAO.findByEmail(authentication.getName());
		return exibirPagina(usuario.getPodcast().getId());		
	}

}
