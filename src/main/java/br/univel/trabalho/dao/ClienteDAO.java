package br.univel.trabalho.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.trabalho.controller.ClienteController;
import br.univel.trabalho.model.Cliente;

public class ClienteDAO extends Conexao {

	private static ClienteDAO clienteDAO;

	public static synchronized ClienteDAO getInstance() {
		if (clienteDAO == null) {
			clienteDAO = new ClienteDAO();
		}
		return clienteDAO;
	}
	
	public ArrayList<Cliente> getListaCliente(){
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		String sql = "select * from cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setNascimento(rs.getString("nascimento"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				listaCliente.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCliente;
	}
}
