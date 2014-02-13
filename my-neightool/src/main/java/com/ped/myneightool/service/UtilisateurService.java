package com.ped.myneightool.service;

import java.util.List;

import com.ped.myneightool.model.Utilisateur;

public interface UtilisateurService {

	public Utilisateur create(Utilisateur utilisateur);

	public void delete(Integer id);

	public Utilisateur update(Utilisateur utilisateur);

	public Utilisateur find(Integer id);

	public List<Utilisateur> getAll();
}
