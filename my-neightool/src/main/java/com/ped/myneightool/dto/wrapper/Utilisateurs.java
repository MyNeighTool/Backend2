package com.ped.myneightool.dto.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ped.myneightool.model.Utilisateur;

/**
 * @author cbouygues
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Utilisateurs {

	private List<Utilisateur> utilisateurs;

	/**
	 * @return the utilisateurs
	 */
	@XmlElement(name = "Utilisateur")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs
	 *            the utilisateurs to set
	 */
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
