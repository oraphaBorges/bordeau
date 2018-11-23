package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bordeau.DAOS.PodcastDAO;
import br.com.bordeau.DAOS.UsuarioDAO;
import br.com.bordeau.infra.FileSaver;
import br.com.bordeau.model.Usuario;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired	private UsuarioDAO usuarioDAO;
	@Autowired	private PodcastDAO podcastDAO;
	@Autowired	private FileSaver fileSaver;

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value="usuarios", allEntries=true)
	public ModelAndView gravar(Usuario usuario, MultipartFile[] files, RedirectAttributes redirectAttributes) {
		try {
			if(usuario.getPodcast().getNome() != null) {
				String path = fileSaver.write("capas", files[0]);
				usuario.getPodcast().setCapaPath(path);
				usuario.getPodcast().setAtivo(true);
			}
			podcastDAO.gravar(usuario.getPodcast());
			usuarioDAO.gravar(usuario);
			redirectAttributes.addFlashAttribute("sucesso",	"usuario" + usuario.getNome() + " cadastrado com sucesso!");
		}catch(Exception e) {
			System.out.println("fim Ops deu ruim!");
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/cadastroCriadordeConteudo")
	public ModelAndView formCreator(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro_criadordeconteudo");
		modelAndView.addObject("criadordeconteudo", new Usuario());
		return modelAndView;
	}
	@RequestMapping("/cadastroOuvinte")
	public ModelAndView formOuvinte(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro_ouvinte");
		modelAndView.addObject("ouvinte", new Usuario());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	@Cacheable(value="usuarios")
	public ModelAndView lista() {
		List<Usuario> usuarios = usuarioDAO.lista();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista_usuarios");
		modelAndView.addObject("usuarios", usuarios);

		return modelAndView;
	}

}