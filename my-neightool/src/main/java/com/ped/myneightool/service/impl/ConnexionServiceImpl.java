package com.ped.myneightool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ped.myneightool.dao.ConnexionDao;
import com.ped.myneightool.model.Connection;
import com.ped.myneightool.service.ConnexionService;

@Service
public class ConnexionServiceImpl implements ConnexionService {

	@Autowired
	private ConnexionDao ConnectionDao;

	@Override
	@Transactional
	public Connection create(Connection Connection) {
		return ConnectionDao.create(Connection);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ConnectionDao.delete(id);

	}

	@Override
	@Transactional
	public Connection update(Connection Connection) {
		return ConnectionDao.update(Connection);
	}

	@Override
	@Transactional
	public Connection find(Integer id) {
		return ConnectionDao.find(id);
	}

	@Override
	@Transactional
	public List<Connection> getAll() {
		return ConnectionDao.getAll();
	}
}
