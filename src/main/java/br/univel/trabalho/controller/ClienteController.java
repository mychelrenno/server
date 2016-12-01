package br.univel.trabalho.controller;

import java.util.ArrayList;

import br.univel.trabalho.dao.ClienteDAO;
import br.univel.trabalho.model.Cliente;

public class ClienteController {

	private static ClienteController clienteController;

	public static synchronized ClienteController getInstance() {
		if (clienteController == null) {
			clienteController = new ClienteController();
		}
		return clienteController;
	}
	
	public ArrayList<Cliente> listaCliente(){
		return ClienteDAO.getInstance().getListaCliente();
	}
}
