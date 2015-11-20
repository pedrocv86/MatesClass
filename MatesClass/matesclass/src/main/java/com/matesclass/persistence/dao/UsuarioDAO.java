package com.matesclass.persistence.dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO extends GenericDAO {

	public UsuarioDAO() {

	}

	public void insertarUsuario() {
		try {
			String nombre = "Pedro Coronado";
			String pass = "pass";
			String email = "pedro@gmail.com";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date now = Calendar.getInstance().getTime();
			String nowDate = df.format(now);
			String consulta = "INSERT INTO \"MATESCLASS\".\"USUARIO\""
					+ " (ID_USUARIO, PASSWORD, EMAIL, FH_ALTA)"
					+ " VALUES ('" + nombre + "', '" + pass + "', '" + email + "', '" + nowDate + "')";
			consultaDB().executeUpdate(consulta);

			// java.sql.Date date = new
			// java.sql.Date(Calendar.getInstance().getTime().getTime());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
