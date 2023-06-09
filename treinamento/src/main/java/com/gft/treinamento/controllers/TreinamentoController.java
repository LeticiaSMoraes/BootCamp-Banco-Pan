package com.gft.treinamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.services.PersonService;

@Controller
public class TreinamentoController {

	@RequestMapping (method = RequestMethod.GET, path = "/index")
	public ModelAndView index(@RequestParam (name = "name")String firstName, @RequestParam Integer age) {
		
		//System.out.println(firstName);
		//System.out.println("Olá " +firstName +" de " + age + " cheguei aqui no index");
		
		ModelAndView mv = new ModelAndView("index.html");
		mv.addObject("name", firstName);
		return mv;
	}
	
	@RequestMapping (method = RequestMethod.GET, path = "/about")
	public ModelAndView about() {
		
		System.out.println("Agora estou no about!");
		
		return new ModelAndView("about.html");
	}
	
	
}
