package com.ped.myneightool.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ped.myneightool.dto.wrapper.Utilisateurs;
import com.ped.myneightool.model.Utilisateur;
import com.ped.myneightool.service.UtilisateurService;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private static final Logger LOGGER = Logger
			.getLogger(UtilisateurController.class);

	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping(value="/utilisateurs", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateurs loadUsers() {

		Utilisateurs utilisateurs = new Utilisateurs();
		utilisateurs.setUtilisateurs(utilisateurService.getAll());
		LOGGER.info("--- user list retrieved ---");
		return utilisateurs;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Utilisateur addUser(@RequestBody Utilisateur utilisateur) {

		Utilisateur newUtilisateur = utilisateurService.create(utilisateur);

		LOGGER.info("--- New user saved ---");
		return newUtilisateur;
	}

	@RequestMapping(value = "/{utilisateurId}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur findUser(@PathVariable(value = "utilisateurId") Integer utilisateurId) {

		Utilisateur userFound = utilisateurService.find(utilisateurId);

		LOGGER.info("--- user found ---");
		return userFound;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public Utilisateur updateUser(@RequestBody Utilisateur utilisateur) {

		Utilisateur newUtilisateur = utilisateurService.update(utilisateur);

		LOGGER.info("--- update made ---");
		return newUtilisateur;
	}
	
	@RequestMapping(value="/delete/{utilisateurId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteUser(@PathVariable(value = "utilisateurId") Integer utilisateurId) {
		utilisateurService.delete(utilisateurId);

		LOGGER.info("--- user deleted ---");
	}
}
