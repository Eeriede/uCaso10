package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import common.Sensor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Buscar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Controlador controlador;

	/**
	 * Create the frame.
	 * @param controlador2 
	 */
	public Buscar(Controlador pControlador) {
		this.controlador = pControlador;
		setTitle("Buscar");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(151, 69, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 72, 48, 14);
		contentPane.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(151, 151, 89, 23);
		contentPane.add(btnBuscar);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ArrayList<Sensor> lista = controlador.buscarSensor(Integer.parseInt(textField.getText()));
		textField.setText("");
		String mensajeAMostrar="";
		if(lista!=null) {
			int contador = 0;
			mensajeAMostrar+=lista.get(contador).toString();
			contador++;
			mensajeAMostrar+="\nPadre:\t";
			mensajeAMostrar+=lista.get(contador).toString();
			mensajeAMostrar+="\nHijos:\t";
			for(int contadorHijos = 2; contadorHijos<lista.size();contadorHijos++) {
				mensajeAMostrar+=lista.get(contador).toString();
				mensajeAMostrar+="\n";
			}
		}else {
			mensajeAMostrar="No se encontraron resultados para tu búsqueda";
		}
		JOptionPane.showMessageDialog(this, mensajeAMostrar);
	}

}
