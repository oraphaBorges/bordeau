package br.com.bordeau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.bordeau.model.Episodio;

@Controller
@RequestMapping("/podcast/episodio")
public class EpsodioController implements pagina {

	
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ModelAndView exibirPagina(Integer id) {
		return new ModelAndView("podcast/episodio");
	}
	
	private Episodio fakeEpisodio() {
		Episodio e = new Episodio();
		e.setHtmlComplementar("{&quot;ops&quot;:[{&quot;insert&quot;:&quot;teste\\n&quot;},{&quot;attributes&quot;:{&quot;bold&quot;:true},&quot;insert&quot;:&quot;texto negrito&quot;},{&quot;insert&quot;:&quot;\\n&quot;},{&quot;attributes&quot;:{&quot;bold&quot;:true},&quot;insert&quot;:&quot;oi&quot;},{&quot;attributes&quot;:{&quot;list&quot;:&quot;bullet&quot;},&quot;insert&quot;:&quot;\\n&quot;},{&quot;attributes&quot;:{&quot;italic&quot;:true},&quot;insert&quot;:&quot;tchau&quot;},{&quot;attributes&quot;:{&quot;list&quot;:&quot;bullet&quot;},&quot;insert&quot;:&quot;\\n&quot;}]}");
		return e;
	}

	@RequestMapping(value = "/submit" ,method=RequestMethod.GET)
	public ModelAndView exibirFormulario() {
		ModelAndView mv = new ModelAndView("podcast/episodio");
		mv.addObject("episodio", this.fakeEpisodio());
		return mv;
	}

	@RequestMapping(value = "/submit" ,method=RequestMethod.POST)
	public ModelAndView enviarFormulario(MultipartFile file) {
		return new ModelAndView("podcast/episodio");
	}

}
