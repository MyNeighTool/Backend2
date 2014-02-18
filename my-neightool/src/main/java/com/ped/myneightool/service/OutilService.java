package com.ped.myneightool.service;

import java.util.List;

import com.ped.myneightool.model.Outil;

public interface OutilService {

	public Outil create(Outil outil);

	public void delete(Integer id);

	public Outil update(Outil outil);

	public Outil find(Integer id);

	public List<Outil> getAll();
}
