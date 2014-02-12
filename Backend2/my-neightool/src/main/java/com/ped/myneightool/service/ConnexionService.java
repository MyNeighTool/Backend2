package com.ped.myneightool.service;

import java.util.List;

import com.ped.myneightool.model.Connection;

public interface ConnexionService {

	public Connection create(Connection connection);

	public void delete(Integer id);

	public Connection update(Connection connection);

	public Connection find(Integer id);

	public List<Connection> getAll();
}
