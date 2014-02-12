/*
 * Copyright (C) 2013 Christophe Bouygues, Olivier Braïk, Alexandre Delesse,
 *                    Matthieu Douris, Thibaut Thomas. 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ped.myneightool.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDao<T extends Serializable> {

	private Class<T> type;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@PersistenceContext
	protected EntityManager em;

	public long count() {
		String entity = type.getSimpleName();
		final StringBuffer queryString = new StringBuffer(
				"select count(ent) from " + entity + " ent");
		final Query query = this.em.createQuery(queryString.toString());

		return (Long) query.getSingleResult();
	}

	public T create(final T t) {
		em.persist(t);
		return t;
	}

	public void delete(final Object id) {
		em.remove(em.getReference(type, id));
	}

	public T find(final Object id) {
		return em.find(type, id);
	}

	public T update(final T t) {
		return em.merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = em.createQuery("from " + type.getName());
		return query.getResultList();
	}
}