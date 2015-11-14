package com.matesclass.persistence.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matesclass.persistence.model.Logro;
import com.matesclass.presentation.beans.LogroBean;

@Repository
public class LogroDAO extends GenericDAO<Logro, Long> implements ILogroDAO {

	public LogroDAO(){}
	@Override
	public List<LogroBean> mostrarLogros() {
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT new com.matesclass.presentation.beans.LogroBean(l.idLogro,l.nombreLogro) "
				+ "FROM Logro l ORDER BY l.idLogro");

		TypedQuery<LogroBean> query = entityManager.createQuery(
				consulta.toString(), LogroBean.class);

		return query.getResultList();
	}

}