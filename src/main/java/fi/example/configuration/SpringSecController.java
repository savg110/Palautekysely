package fi.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringSecController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("Tämä on kysely appi");
		model.addObject("Tämä on etusivu");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = {"/admin**" , "/lomakejson"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("Tämä on addmin sivu");
		model.addObject("pystyt lisäämään ja poistamaan kyselytä");
		model.setViewName("lomakejson");

		return model;

	}
	
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("Tämä on yleiskatsatus sivu");
		model.addObject("Pystyt katsomaan vastauksia kyselyhin ja niiten vatauksiin");
		model.setViewName("admin");

		return model;

	}
	
	

}