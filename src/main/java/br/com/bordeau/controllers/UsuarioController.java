package br.com.bordeau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bordeau.DAOS.AuthenticationDAO;
import br.com.bordeau.DAOS.UsuarioDAO;
import br.com.bordeau.model.Usuario;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value="usuarios", allEntries=true)
	public ModelAndView grava(Usuario usuario, RedirectAttributes redirectAttributes) {

		usuarioDAO.adicionaUsuario(usuario);
		redirectAttributes.addFlashAttribute("sucesso", "Usuario " + usuario + " cadastrado com sucesso!");

		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/cadastro")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro_usuario");
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