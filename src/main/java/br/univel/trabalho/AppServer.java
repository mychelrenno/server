package br.univel.trabalho;

import br.univel.trabalho.controller.ServidorController;
import br.univel.trabalho.serverSocket.ServidorServerSocket;

public class AppServer {

	public static void main(String[] args) {
		System.out.println("Aplicação servidor iniciada!");

		ServidorController servidorController = new ServidorController();
		servidorController.abreTelaServidor();

		ServidorServerSocket serverSocket = new ServidorServerSocket();
		serverSocket.reciver();
	}
}
