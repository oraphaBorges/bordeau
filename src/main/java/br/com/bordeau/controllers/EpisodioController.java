package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.DAOS.EpisodioDAO;
import br.com.bordeau.DAOS.UsuarioDAO;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Episodio;
import br.com.bordeau.model.Podcast;
import br.com.bordeau.model.Usuario;

@Controller
@RequestMapping("/podcast/episodio")
public class EpisodioController {
	
	@Autowired	private EpisodioDAO epsiodioDAO;
	@Autowired  private UsuarioDAO usuarioDAO;
	@Autowired	private FileSaver fileSaver;
	
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(@PathVariable("id") Long id) {
		Episodio episodio = epsiodioDAO.findById(id);
		ModelAndView mv = new ModelAndView("podcast/paginaEpisodio");
		List<Episodio> recomendados = epsiodioDAO.recomendacoes();
		mv.addObject("recomendados", recomendados);
		mv.addObject("episodio", episodio);
		return mv;
	}
	
	@RequestMapping(value = "/novo" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario(Podcast podcast) {
		ModelAndView mv = new ModelAndView("podcast/formularioEpisodio");
		mv.addObject("episodio", new Episodio());
		mv.addObject("podcast", podcast);
		return mv;
	}

	@RequestMapping(value = "/novo" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario(String htmlComplementar,MultipartFile[] files,Episodio episodio) {
		try {
			String path;
			path = fileSaver.write("capas", files[0]);
			episodio.setCapa(path);
			path = fileSaver.write("audios", files[1]);
			episodio.setAudio(path);
			episodio.setHtmlComplementar(htmlComplementar);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = usuarioDAO.findByEmail(authentication.getName());
			
			usuario.getPodcast().getEpisodios().add(episodio);
			epsiodioDAO.gravar(episodio);
			usuarioDAO.update(usuario);
			
		} catch (Exception e) {
			System.out.println("não gravou o epsiodio");
			
		}
		return new ModelAndView("redirect:/");
	}


}
