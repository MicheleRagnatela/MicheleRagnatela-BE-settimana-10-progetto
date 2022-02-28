package it.epicode.be.segreteria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.Segreteria;
import it.epicode.be.segreteria.model.Studente;

@Controller
public class SegreteriaController {

	@Autowired
	ApplicationContext ctx;

	public Segreteria getSegreteria() {
		return ctx.getBean(Segreteria.class);
	}

	public Corso getCorso() {
		return ctx.getBean(Corso.class);
	}

	@GetMapping("/visualizzastudenti")
	public ModelAndView visualizzaStudenti() {
		return new ModelAndView("visualizzaStudenti", "studentiLista", getSegreteria().visualizzaStudenti());

	}

	@GetMapping("/visualizzacorsi")
	public ModelAndView visualizzaCorsi() {
		return new ModelAndView("visualizzaCorsi", "corsiLista", getSegreteria().visualizzaCorsi());

	}

	@GetMapping("/mostraformstudente")
	public ModelAndView formStudente(Studente studente) {

		ModelAndView modelandview = new ModelAndView("aggiungiStudente", "corsiLista",
				getSegreteria().visualizzaCorsi());
		return modelandview;
	}

	@PostMapping("/aggiungistudente")
	public String aggiungiStudente(Studente studente, BindingResult result, Model model) {
		if(studente.getMatricola() <= 0) {
			return "errorFormStudente";
		}
		if(studente.getNome() == "") {
			return "errorFormStudente";		
			}
		if(studente.getCognome() == "") {
			return "errorFormStudente";		
			}
		if(studente.getDataDiNascita() == "") {
			return "errorFormStudente";		
			}
		if(studente.getCitta() == "") {
			return "errorFormStudente";		
			}
		
		else {
		getSegreteria().aggiungiStudente(studente);

		model.addAttribute("studentiLista", getSegreteria().visualizzaStudenti());

		return "visualizzaStudenti";
		}
	}

	@GetMapping("/formeliminastudente")
	public String formeliminaStudente(Studente studente) {
		return "eliminaStudente";
	}

	@GetMapping("/eliminastudente")
	public ModelAndView eliminaStudente(@ModelAttribute("matricola") int matricola, Model model) {
		getSegreteria().cancellaStudente(matricola);
		return new ModelAndView("index", "studenti", getSegreteria().visualizzaStudenti());

	}

	@GetMapping("/formaggiornastudente/{matricola}")
	public ModelAndView aggiornaStudente(@PathVariable("matricola") int matricola, Studente studente) {
		return new ModelAndView("aggiornaStudente", "corsiLista", getSegreteria().visualizzaCorsi());

	}

	@PostMapping("/aggiornastudente")
	public String aggiornaStudente(Studente studente, BindingResult result, Model model) {

		getSegreteria().aggiornaStudente(studente);

		model.addAttribute("studentiLista", getSegreteria().visualizzaStudenti());

		return "visualizzaStudenti";
	}

	@GetMapping("/mostraformcorso")
	public ModelAndView formCorso() {
		return new ModelAndView("aggiungiCorso", "corso", getCorso());
	}

	@PostMapping("/aggiungicorso")
	public String aggiungiCorso(@Valid @ModelAttribute("corso") Corso corso, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}
		getSegreteria().aggiungiCorso(corso);
		model.addAttribute("corsiLista", getSegreteria().visualizzaCorsi());
		return "visualizzaCorsi";
	}

	@GetMapping("/formaggiornacorso")
	public String aggiornaCorso(@RequestParam("codice") int codice, Corso corso) {
		return "aggiornaCorso";

	}

	@PostMapping("/aggiornacorso")
	public String aggiornaCorso(@ModelAttribute("corso") Corso corso, Model model) {

		getSegreteria().aggiornaCorso(corso);

		model.addAttribute("corsiLista", getSegreteria().visualizzaCorsi());

		return "visualizzaCorsi";
	}

	@GetMapping("/formeliminacorso")
	public String formCorso(Corso corso) {
		return "eliminaCorso";

	}

	@GetMapping("/eliminacorso")
	public String eliminaCorso(@ModelAttribute("codice") int codice, Corso corso, Model model) {
		getSegreteria().cancellaCorso(codice);
		model.addAttribute("corsiLista", getSegreteria().visualizzaCorsi());
		return "visualizzaCorsi";
	}

}