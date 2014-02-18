package com.ped.myneightool.controller.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ped.myneightool.dto.wrapper.Outils;
import com.ped.myneightool.model.Outil;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-beans-test.xml", "/applicationContext-servlet-test.xml" })
public class OutilControllerIT {

	private static final String REST_SERVICE_URL = "http://localhost:8080/services/outil";
	private RestTemplate restTemplate = new RestTemplate();

	private Outil createNewOutil() {

		Outil outil = new Outil();
		outil.setNom("Test");

		return outil;
	}

	@Test
	public void addOutilTest() {

		Outil newOutil = createNewOutil();
		Outil outil = restTemplate.postForObject(REST_SERVICE_URL, newOutil, Outil.class);

		Assert.assertNotNull(outil);
		Assert.assertTrue("Test".equals(outil.getNom()));
	}

	@Test
	public void findAllOutilsTest() {

		Outils outils = restTemplate.getForObject(REST_SERVICE_URL + "/outils", Outils.class);
		int cpt = 0;

		for (int i=0; i<outils.getOutils().size();i++) {
			cpt++;
		}
		Assert.assertEquals(outils.getOutils().size(), cpt);
	}
	
	@Test
	public void findOutilTest() {

		 Outil newOutil = createNewOutil();
		 Outil outilCreated = restTemplate.postForObject(REST_SERVICE_URL, newOutil, Outil.class);

		 Assert.assertNotSame(0, outilCreated.getId());
		 
		 String restServiceUrlFind = REST_SERVICE_URL + "/" + outilCreated.getId();
		 Outil outilFound = restTemplate.getForObject(restServiceUrlFind, Outil.class);
		
		 Assert.assertNotNull(outilFound.getId());
		 Assert.assertEquals(outilFound.getId(), outilCreated.getId());		 
	}
	
	@Test
	public void updateOutilTest() {
		Outil outil = createNewOutil();
		Outil outilUpdated = outil;
		outilUpdated.setNom("Outil");
		
		Outil newOutil = restTemplate.postForObject(REST_SERVICE_URL + "/update", outilUpdated, Outil.class);
		
		Assert.assertNotNull(newOutil);
		Assert.assertTrue("Outil".equals(newOutil.getNom()));
	}
}
