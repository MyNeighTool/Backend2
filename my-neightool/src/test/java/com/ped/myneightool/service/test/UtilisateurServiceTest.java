package com.ped.myneightool.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ped.myneightool.model.Utilisateur;
import com.ped.myneightool.service.ConnexionService;
import com.ped.myneightool.service.UtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-beans-test.xml",
		"/applicationContext-servlet-test.xml" })
public class UtilisateurServiceTest {
	
	@Autowired
	private UtilisateurService service;
	@Autowired
	private ConnexionService cnService;

	public Utilisateur createNewUtilisateur() {

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("toto");
		utilisateur.setPrenom("titi");
		utilisateur.setMail("toto.titi@gmail.com");
		//utilisateur.setConnexion(new Connection());
		utilisateur.setTelephone("x");

		return utilisateur;
	}
	
	@Test
	public void createTest() {
		Utilisateur utilisateur = createNewUtilisateur();
		Utilisateur utilisateurSaved = service.create(utilisateur);
		
		assertNotNull(utilisateurSaved);
		assertEquals("toto", utilisateurSaved.getNom());
		
		/*Connection cn = new Connection("login", "");
		Connection cnSaved = cnService.create(cn); 
		assertNotNull(cnSaved);
		assertEquals("login", cnSaved.getLogin());*/
	}
}
