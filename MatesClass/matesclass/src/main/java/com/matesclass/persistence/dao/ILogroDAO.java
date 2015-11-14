package com.matesclass.persistence.dao;

import java.util.List;

import com.matesclass.persistence.model.Logro;
import com.matesclass.presentation.beans.LogroBean;

public interface ILogroDAO extends DAO<Logro, Long> {

	List<LogroBean> mostrarLogros();
}
