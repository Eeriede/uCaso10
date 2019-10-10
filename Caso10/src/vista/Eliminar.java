package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Eliminar extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private Controlador controlador;

	/**
	 * Create the frame.
	 * @param controlador 
	 */
	public Eliminar(Controlador pControlador) {
		this.controlador = pControlador;
		setTitle("Eliminar");
		setBounds(100, 100, 447, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(156, 43, 172, 22);
		contentPane.add(textField);
		
		JLabel lblSensor = new JLabel("ID del Sensor");
		lblSensor.setBounds(26, 47, 90, 14);
		contentPane.add(lblSensor);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(156, 119, 89, 23);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		controlador.eliminarSensor(Integer.parseInt(textField.getText()));
		
	}
}