package org.sbac.web;

import org.sbac.sql.RepoJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ControllerMessage {

	@Autowired private RepoJDBC repoJDBC;

//	@PostMapping("/ajouter")
//	public @ResponseBody String ajouterMessage(@RequestBody String message) {
//		System.out.println("MessageBoard : ajouter message");
//		repoJDBC.addMessage3(message);
//		return "";
//	}

	@PostMapping("/ajouterform")
	public RedirectView ajouterMessageForm(String message) {
		System.out.println("MessageBoard form : ajouter message");
		repoJDBC.addMessage3(message);
		return new RedirectView("nouveau");
	}


	@GetMapping("/home")
	public @ResponseBody String home() {
		String result = "<html>";
		result += "<body>";

		for(String msg : repoJDBC.allMessages()) {
			result += "<div>";
			result += "yo " + msg;
			result += "</div>";
		}

		result += "</body>";
		result += "</html>";
		return result;
	}

	@GetMapping("/nouveau")
	public String nouveau() {
		return "nouveau";
	}

}
