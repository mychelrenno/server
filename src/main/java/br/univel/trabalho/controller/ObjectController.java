package br.univel.trabalho.controller;

import br.univel.trabalho.model.Cliente;
import br.univel.trabalho.model.Login;

public class ObjectController {

	private static ObjectController objectController;

	public static synchronized ObjectController getInstance() {
		if (objectController == null) {
			objectController = new ObjectController();
		}
		return objectController;
	}

	public Object controller(Object object) {

		if (object.getClass().getName().equals(Login.class.getName())) {
			return LoginController.getInstance().loginValidation((Login) object);
		} else if (object.getClass().getName().equals(String.class.getName())) {
			String string = (String) object;
			if (string.equals("listaCliente")) {
				return ClienteController.getInstance().listaCliente();
			}
		} else if (object.getClass().getName().equals(Cliente.class.getName())) {
			System.out.println("");
		}

		return null;
	}
}
