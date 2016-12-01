package br.univel.trabalho.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import br.univel.trabalho.controller.ServidorController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaServidor extends JFrame {
	public TelaServidor() {
		setTitle("Monitoramento do servidor");
		setSize(360, 160);
		setLocationRelativeTo(null);

		JLabel lblServidor = new JLabel("Servidor on-line ?");

		JLabel lblVerificarACada = new JLabel("Verificar a cada (segundtos) ?");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Reiniciar servidor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServidorController servidorController = new ServidorController();
				servidorController.reiniciar();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblServidor)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblVerificarACada).addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField).addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addContainerGap(174, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblServidor).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblVerificarACada)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnNewButton).addContainerGap(157, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}

	private static final long serialVersionUID = 1L;
	private JTextField textField;
}
