package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView gravar(Usuario usuario, MultipartFile[] files) {
		try {
			podcastAtivo(usuario, files);

			podcastDAO.gravar(usuario.getPodcast());
			usuarioDAO.gravar(usuario);
		} catch (Exception e) {
			System.out.println("Usuário não criado");
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/painel", method = RequestMethod.POST)
	public ModelAndView atualiza(Usuario usuario, MultipartFile[] files) {
		try {
			podcastAtivo(usuario, files);

			podcastDAO.update(usuario.getPodcast());
			usuarioDAO.update(usuario);
		} catch (Exception e) {
			System.out.println("Usuário não atualizado");
		}
		return new ModelAndView("redirect:/");
	}

	private void podcastAtivo(Usuario usuario, MultipartFile[] files) {
		if (usuario.getPodcast().getAtivo() != false) {
			String path = fileSaver.write("capas", files[0]);
			usuario.getPodcast().setCapaPath(path);
			usuario.getPodcast().setAtivo(true);
		}
	}

	@RequestMapping("/cadastro")
	public ModelAndView cadastro(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro");
		return modelAndView;
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
	public ModelAndView lista() {
		List<Usuario> usuarios = usuarioDAO.lista();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista_usuarios");
		modelAndView.addObject("usuarios", usuarios);

		return modelAndView;
	}

	@RequestMapping(value = "/painel", method = RequestMethod.GET)
	public ModelAndView exibirPainelUsuario() {
		ModelAndView modelAndView = new ModelAndView("usuarios/painel");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioDAO.findByEmail(authentication.getName());

		modelAndView.addObject("perfil", usuario);
		modelAndView.addObject("podcast", usuario.getPodcast());

		return modelAndView;
	}

	@RequestMapping(value = "/deleteingAccount")
	public ModelAndView excluirConta() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioDAO.findByEmail(authentication.getName());
		usuarioDAO.removeConta(usuario);
		return new ModelAndView("redirect:/logout");
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public ModelAndView deleteAccoount() {
		return new ModelAndView("deleteAccount");
	}

}