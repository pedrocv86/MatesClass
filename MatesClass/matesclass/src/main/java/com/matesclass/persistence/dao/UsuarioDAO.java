package com.matesclass.persistence.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Repository;

import com.matesclass.persistence.model.Usuario;

@Repository
public class UsuarioDAO extends GenericDAO {

	public String insertarUsuario(String idUsuario, String pass, String email) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yy");
			String nowDate = df.format(new Date());
			String consulta = "INSERT INTO USUARIO (ID_USUARIO, PASSWORD, EMAIL, FH_ALTA)"
					+ " VALUES ('" + idUsuario + "', '" + pass + "', '" + email + "', '" + nowDate + "')";
			consultaDB().executeUpdate(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String exito = "El usuario " + idUsuario;
		
		return exito;
	}
	
	public Usuario loginUsuario(String idUsuario, String pass) {
		Usuario usuario = new Usuario();
		try {
			String consulta = "SELECT * FROM USUARIO WHERE ID_USUARIO='"+ idUsuario +"' AND PASSWORD='"+ pass +"'";
			ResultSet rs = consultaDB().executeQuery(consulta);
			while (rs.next()) {
			usuario.setIdUsuario(rs.getString("ID_USUARIO"));
			usuario.setPassword(rs.getString("PASSWORD"));
			usuario.setEmail(rs.getString("EMAIL"));
			usuario.setFhAlta(rs.getDate("FH_ALTA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return usuario;
	}

	
}
