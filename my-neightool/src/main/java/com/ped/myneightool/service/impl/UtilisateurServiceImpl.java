package com.ped.myneightool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ped.myneightool.dao.UtilisateurDao;
import com.ped.myneightool.model.Utilisateur;
import com.ped.myneightool.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	@Transactional
	public Utilisateur create(Utilisateur utilisateur) {
		return utilisateurDao.create(utilisateur);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		utilisateurDao.delete(id);

	}

	@Override
	@Transactional
	public Utilisateur update(Utilisateur utilisateur) {
		return utilisateurDao.update(utilisateur);
	}

	@Override
	@Transactional
	public Utilisateur find(Integer id) {
		return utilisateurDao.find(id);
	}

	@Override
	@Transactional
	public List<Utilisateur> getAll() {
		return utilisateurDao.getAll();
	}
}
