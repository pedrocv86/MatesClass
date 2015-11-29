package com.matesclass.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class GenericDAO {
	
	Connection con;
	
	public GenericDAO () {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MATESCLASS", "pcvmatesclass");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Statement consultaDB() throws SQLException {

		Statement st = con.createStatement();

		return st;
	}

	public PreparedStatement consultaDBSP(String consulta)
			throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "MATESCLASS",
				"pcvmatesclass");

		PreparedStatement pst = con.prepareStatement(consulta);

		return pst;
	}

	public void closeConDB(PreparedStatement pst) {
		try {
			if (pst.getConnection() != null)
				pst.getConnection().close();
		} catch (SQLException SQLe) {
				SQLe.printStackTrace();
		}
	}

	public void closeConDB(Statement st) {
		try {
			if (st.getConnection() != null)
				st.getConnection().close();
		} catch (SQLException SQLe) {
				SQLe.printStackTrace();
		}
	}

}
