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
@RequestMapping("/tool")
public class OutilController {

	private static final Logger LOGGER = Logger
			.getLogger(OutilController.class);

	@Autowired
	private OutilService toolService;

	@RequestMapping(value="/tools", method = RequestMethod.GET)
	@ResponseBody
	public Outils loadTools() {

		Outils tools = new Outils();
		tools.setOutils(toolService.getAll());
		LOGGER.info("--- user list retrieved ---");
		return tools;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Outil addTool(@RequestBody Outil tool) {

		Outil newOutil = toolService.create(tool);

		LOGGER.info("--- New tool saved ---");
		return newOutil;
	}

	@RequestMapping(value = "/{toolId}", method = RequestMethod.GET)
	@ResponseBody
	public Outil findTool(@PathVariable(value = "toolId") Integer toolId) {

		Outil userFound = toolService.find(toolId);

		LOGGER.info("--- tool found ---");
		return userFound;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public Outil updateTool(@RequestBody Outil tool) {

		Outil newOutil = toolService.update(tool);

		LOGGER.info("--- update made ---");
		return newOutil;
	}
	
	@RequestMapping(value="/delete/{toolId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTool(@PathVariable(value = "toolId") Integer toolId) {
		toolService.delete(toolId);

		LOGGER.info("--- tool deleted ---");
	}
}
