package com.ped.myneightool.dto.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ped.myneightool.model.Outil;

/**
 * @author cbouygues
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Outils {

	private List<Outil> outils;

	/**
	 * @return the outils
	 */
	@XmlElement(name = "Outil")
	public List<Outil> getOutils() {
		return outils;
	}

	/**
	 * @param outils
	 *            the outils to set
	 */
	public void setOutils(List<Outil> outils) {
		this.outils = outils;
	}
}
