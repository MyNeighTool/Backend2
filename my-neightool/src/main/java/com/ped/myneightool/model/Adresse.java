package com.ped.myneightool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	
	private String rue;
	private String codePostale;
	private String ville;
	private String pays;
		
	@Column(nullable = true)
	private float longitude;
		
	@Column(nullable = true)
	private float latitude;
	
	public Adresse() { }
	
	public Adresse(String rue, String codePostale, String ville, String pays,
			float longitude, float latitude) {
		super();
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.pays = pays;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getcodePostale() {
		return codePostale;
	}
	
	public void setcodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getPays() {
		return pays;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
}