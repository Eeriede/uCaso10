package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	Controlador controlador;
        private JTree tree;

        public JTree getTree() {
            return tree;
        }

        public void setTree(JTree tree) {
            this.tree = tree;
        }
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		controlador = new Controlador();
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(36, 371, 77, 53);
		btnIngresar.addActionListener(this);
		contentPane.setLayout(null);
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnIngresar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(240, 371, 151, 53);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(582, 371, 65, 53);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		tree = new JTree();
		tree.setBounds(200, 103, 220, 181);
		contentPane.add(tree);
                tree.getSelectionModel().addTreeSelectionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonActual = (JButton)e.getSource();
		if(botonActual.getText().compareTo("Ingresar")==0) {
			Ingresar ventanaIngresar = new Ingresar(controlador,this.getTree());
		}else {
			if(botonActual.getText().compareTo("Eliminar")==0) {
				Eliminar ventanaEliminar = new Eliminar(controlador);
			}else {
				if(botonActual.getText().compareTo("Buscar")==0) {
					Buscar ventanaBuscar = new Buscar(controlador);
				}
			}
			
		}
	}

}
