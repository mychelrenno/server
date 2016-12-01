package br.univel.trabalho.serverSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.univel.trabalho.controller.ObjectController;

public class ServidorServerSocket {

	private ServerSocket server;

	public void reciver() {
		try {
			server = new ServerSocket(8080);
			while (true) {
				Socket connection = server.accept();
				// input entrada
				ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
				Object entrada = input.readObject();
				System.out.println("Entrada servidor: " + entrada.getClass().toString());

				Object saida = ObjectController.getInstance().controller(entrada);

				// output saida
				ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
				output.writeObject(saida);
				output.flush();
				System.out.println("Saída servidor: " + entrada.getClass().toString());

				input.close();
				output.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
