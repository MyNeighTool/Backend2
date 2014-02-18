package com.ped.myneightool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ped.myneightool.dao.OutilDao;
import com.ped.myneightool.model.Outil;
import com.ped.myneightool.service.OutilService;

@Service
public class OutilServiceImpl implements OutilService {

	@Autowired
	private OutilDao outilDao;

	@Override
	@Transactional
	public Outil create(Outil outil) {
		return outilDao.create(outil);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		outilDao.delete(id);

	}

	@Override
	@Transactional
	public Outil update(Outil outil) {
		return outilDao.update(outil);
	}

	@Override
	@Transactional
	public Outil find(Integer id) {
		return outilDao.find(id);
	}

	@Override
	@Transactional
	public List<Outil> getAll() {
		return outilDao.getAll();
	}
}
