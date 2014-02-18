package com.ped.myneightool.controller.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ped.myneightool.dto.wrapper.Utilisateurs;
import com.ped.myneightool.model.Utilisateur;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-beans-test.xml", "/applicationContext-servlet-test.xml" })
public class UtilisateurControllerIT {

	private static final String REST_SERVICE_URL = "http://localhost:8080/services/utilisateur";
	private RestTemplate restTemplate = new RestTemplate();

	private Utilisateur createNewUtilisateur() {

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setMail("test.test@gmail.com");
		utilisateur.setNom("Test");
		utilisateur.setPrenom("Test");
		utilisateur.setTelephone("0643137451");

		return utilisateur;
	}

	@Test
	public void addUtilisateurTest() {

		Utilisateur newUtilisateur = createNewUtilisateur();
		Utilisateur utilisateur = restTemplate.postForObject(REST_SERVICE_URL, newUtilisateur, Utilisateur.class);

		Assert.assertNotNull(utilisateur);
		Assert.assertTrue("0643137451".equals(utilisateur.getTelephone()));
	}

	@Test
	public void findAllUsersTest() {

		Utilisateurs users = restTemplate.getForObject(REST_SERVICE_URL + "/utilisateurs", Utilisateurs.class);
		int cpt = 0;

		for (int i=0; i<users.getUtilisateurs().size();i++) {
			cpt++;
		}
		Assert.assertEquals(users.getUtilisateurs().size(), cpt);
	}

	@Test
	public void findUtilisateurTest() {

		Utilisateur newUtilisateur = createNewUtilisateur();
		Utilisateur utilisateurCreated = restTemplate.postForObject(REST_SERVICE_URL, newUtilisateur, Utilisateur.class);

		String restServiceUrlFind = REST_SERVICE_URL + "/" + utilisateurCreated.getId();
		Utilisateur utilisateurFound = restTemplate.getForObject(restServiceUrlFind, Utilisateur.class);

		Assert.assertNotNull(utilisateurFound.getId());
		Assert.assertEquals(utilisateurFound.getId(), utilisateurCreated.getId());		 
	}

	@Test
	public void updateUserTest() {
		Utilisateur user = createNewUtilisateur();
		Utilisateur userUpdated = user;
		userUpdated.setNom("Bouygues");
		userUpdated.setPrenom("Christophe");

		Utilisateur newUser = restTemplate.postForObject(REST_SERVICE_URL + "/update", userUpdated, Utilisateur.class);

		Assert.assertNotNull(newUser);
		Assert.assertTrue("Bouygues".equals(newUser.getNom()));
	}

	@Test
	public void deleteUtilisateurTest() {
		Utilisateur newUtilisateur = createNewUtilisateur();
		Utilisateur utilisateurCreated = restTemplate.postForObject(REST_SERVICE_URL, newUtilisateur, Utilisateur.class);
		
		String restServiceUrlFind = REST_SERVICE_URL + "/delete/" + utilisateurCreated.getId();
		restTemplate.delete(restServiceUrlFind);
	}
}
