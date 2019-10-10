package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import common.Sensor;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class Ingresar extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Controlador controlador;
        private JCheckBox chckbxConectarAUn;
        private JTree tree;

	/**
	 * Create the frame.
	 */
	public Ingresar(Controlador pControlador, JTree pTree) {
                tree = pTree;
		this.controlador = pControlador;
		setTitle("Ingresar");
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 40, 40);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(113, 21, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantn = new JLabel("Cant\u00F3n");
		lblCantn.setBounds(10, 74, 48, 14);
		contentPane.add(lblCantn);
		
		JLabel lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(10, 137, 48, 14);
		contentPane.add(lblDistrito);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 71, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 134, 200, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setBounds(10, 188, 48, 14);
		contentPane.add(lblBarrio);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 185, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox<Sensor> comboBox = new JComboBox<Sensor>();
		comboBox.setEnabled(false);
		comboBox.setBounds(113, 228, 92, 22);
		contentPane.add(comboBox);
		
		chckbxConectarAUn = new JCheckBox("Conectar a un sensor existente");
		chckbxConectarAUn.setBounds(234, 228, 214, 23);
		contentPane.add(chckbxConectarAUn);
		
		JLabel lblSensor = new JLabel("Sensor");
		lblSensor.setBounds(10, 232, 48, 14);
		contentPane.add(lblSensor);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(113, 285, 89, 23);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(chckbxConectarAUn.isSelected()){
                    if(textField_3.getText().equals(null)){
                        JOptionPane.showMessageDialog(this, "Debe digitar un sensor al cual agregar");
                    }else{
                        controlador.agregarSensor(Integer.parseInt(textField_1.getText()), textField_2.getText());
                        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(textField_1.getText());
                        contentPane.add(tree);
                    }
                }
        }
	
}
