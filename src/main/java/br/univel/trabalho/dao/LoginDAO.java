package br.univel.trabalho.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.univel.trabalho.model.Login;

public class LoginDAO extends Conexao {

	private static LoginDAO loginDAO;

	public static synchronized LoginDAO getInstance() {
		if (loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	public Login getLogin(Login login){
		String sql = "select * from login where usuario = ? and senha = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, login.getUsuario());
			ps.setString(2, login.getSenha());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				login.setId(rs.getInt("id"));
				login.setUsuario(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
}
