package br.univel.trabalho.controller;

import br.univel.trabalho.view.TelaServidor;

public class ServidorController {

	private TelaServidor telaServidor;

	public void reiniciar() {
	}

	public void abreTelaServidor() {
		telaServidor = new TelaServidor();
		telaServidor.setVisible(true);
	}
}
