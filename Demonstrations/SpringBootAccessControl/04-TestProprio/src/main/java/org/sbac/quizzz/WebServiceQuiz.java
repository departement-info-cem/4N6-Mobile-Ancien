package org.sbac.quizzz;

import org.sbac.model.MUtilisateur;

import org.sbac.transfert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebServiceQuiz {

	@Autowired
	private ServiceQuiz service;

	@PostMapping("/api/creer")
	public @ResponseBody String creerQuiz(@RequestBody CreerQuizReq request) throws ServiceQuiz.Existing {
		System.out.println("Quiz : ajouter Quiz");
		service.creerQuiz(request, utilisateurActuel());
		return "";
	}

	@PostMapping("/api/ajouter")
	public @ResponseBody String ajouterQuestion(@RequestBody AjouterQuestionReq req) throws IllegalAccessException {
		System.out.println("Quiz : ajouter question dans Quiz");
		service.ajouterQuestion(req, utilisateurActuel());
		return "";
	}

	@PostMapping("/api/modifier")
	public @ResponseBody String modifierQuestion(@RequestBody ModifierQuestionReq req) throws IllegalAccessException {
		System.out.println("Quiz : modifier question dans Quiz");
		service.modifierQuestion(req, utilisateurActuel());
		return "";
	}

	@GetMapping("/api/home")
	public @ResponseBody List<QuizResume> home() {
		System.out.println("Accueil" );
		MUtilisateur user = utilisateurActuel();
		return service.accueil(user.id);
	}

    @GetMapping("/api/detail/{id}")
    public @ResponseBody QuizDetail detail(@PathVariable long id) {
		System.out.println("Detail pour " + id);
		return service.detail(id, utilisateurActuel());
    }

	private MUtilisateur utilisateurActuel() {
		UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MUtilisateur utilisateur = service.utilisateurParSonNom(ud.getUsername());
		return utilisateur;
	}

}
