package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DeconnexionController {
	private final HttpSession httpSession;
	
	@GetMapping("/deconnexion")
	public ModelAndView deconnexion() {
		httpSession.invalidate();
		
		return new ModelAndView("redirect:/");
	}
}
