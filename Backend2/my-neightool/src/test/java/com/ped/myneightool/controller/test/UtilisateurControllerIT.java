package com.ped.myneightool.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ped.myneightool.dto.wrapper.Utilisateurs;
import com.ped.myneightool.model.Utilisateur;

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

	/*@Test
	public void addUtilisateurTest() {

		Utilisateur newUtilisateur = createNewUtilisateur();
		Utilisateur utilisateur = restTemplate.postForObject(REST_SERVICE_URL, newUtilisateur, Utilisateur.class);

		Assert.assertNotNull(utilisateur);
		Assert.assertNotNull(utilisateur.getTelephone());
	}*/

	@Test
	public void findAllUsersTest() {

		Utilisateurs users = restTemplate.getForObject(REST_SERVICE_URL + "/utilisateurs", Utilisateurs.class);
		int cpt = 0;

		for (int i=0; i<users.getUtilisateurs().size();i++) {
			cpt++;
		}
		Assert.assertEquals(users.getUtilisateurs().size(), cpt);
	}

	/*@Test
	public void findUtilisateurTest() {

		Utilisateur newUtilisateur = createNewUtilisateur();
		Utilisateur utilisateurCreated = restTemplate.postForObject(REST_SERVICE_URL, newUtilisateur, Utilisateur.class);
		/*Utilisateur utilisateurCreated = restTemplate.postForObject(REST_SERVICE_URL + "/utilisateur", 
				newUtilisateur, Utilisateur.class); */
		
		//Assert.assertEquals(utilisateurCreated.getId(), 19);
		/*String restServiceUrlFind = REST_SERVICE_URL + "/" + utilisateurCreated.getId();
		Utilisateur utilisateurFound = restTemplate.getForObject(restServiceUrlFind, Utilisateur.class);

		Assert.assertNotNull(utilisateurFound);
		Assert.assertEquals(utilisateurFound.getId(), utilisateurCreated.getId());
	/*}*/
}
