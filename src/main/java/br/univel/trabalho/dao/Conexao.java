package br.univel.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection connection;
	private static String url = "jdbc:postgresql://localhost/trabalho_java";
	private static String usuario = "postgres";
	private static String senha = "admin";

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
