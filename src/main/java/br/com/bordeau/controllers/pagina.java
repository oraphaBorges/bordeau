package br.com.bordeau.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface pagina {
	public ModelAndView exibirPagina(@PathVariable("id") Integer id);
	public ModelAndView exibirFormulario();
	public ModelAndView enviarFormulario(MultipartFile file);
}
