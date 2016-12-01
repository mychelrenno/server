package br.univel.trabalho.controller;

import br.univel.trabalho.dao.LoginDAO;
import br.univel.trabalho.model.Login;

public class LoginController {

	private static LoginController loginController;

	public static synchronized LoginController getInstance() {
		if (loginController == null) {
			loginController = new LoginController();
		}
		return loginController;
	}

	public Login loginValidation(Login login) {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.getLogin(login);

	}
}
