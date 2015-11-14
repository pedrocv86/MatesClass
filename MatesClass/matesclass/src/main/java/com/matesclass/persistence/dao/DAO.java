package com.matesclass.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, V extends Serializable> {
	
	T loadById(V v);

	void persist(T t);

	void update(T t);

	void delete(T t);

	List<T> loadAll();

	void persistSinFlush(T entity);
}
