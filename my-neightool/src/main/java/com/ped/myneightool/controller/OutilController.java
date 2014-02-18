package com.ped.myneightool.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ped.myneightool.dto.wrapper.Outils;
import com.ped.myneightool.model.Outil;
import com.ped.myneightool.service.OutilService;

@Controller
@RequestMapping("/outil")
public class OutilController {

	private static final Logger LOGGER = Logger
			.getLogger(OutilController.class);

	@Autowired
	private OutilService outilService;

	@RequestMapping(value="/outils", method = RequestMethod.GET)
	@ResponseBody
	public Outils loadUsers() {

		Outils outils = new Outils();
		outils.setOutils(outilService.getAll());
		LOGGER.info("--- user list retrieved ---");
		return outils;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Outil addUser(@RequestBody Outil outil) {

		Outil newOutil = outilService.create(outil);

		LOGGER.info("--- New user saved ---");
		return newOutil;
	}

	@RequestMapping(value = "/{outilId}", method = RequestMethod.GET)
	@ResponseBody
	public Outil findUser(@PathVariable(value = "outilId") Integer outilId) {

		Outil userFound = outilService.find(outilId);

		LOGGER.info("--- user found ---");
		return userFound;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public Outil updateUser(@RequestBody Outil outil) {

		Outil newOutil = outilService.update(outil);

		LOGGER.info("--- update made ---");
		return newOutil;
	}
}
