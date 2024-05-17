package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class AlunoWindow {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtRegistroAcademico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoWindow window = new AlunoWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlunoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 786, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JLabel lblRegistroAcademico = new JLabel("Registro Acadêmico");
		lblRegistroAcademico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegistroAcademico.setBounds(41, 49, 135, 13);
		frame.getContentPane().add(lblRegistroAcademico);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(41, 91, 49, 13);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(112, 90, 432, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRegistroAcademico.setColumns(10);
		txtRegistroAcademico.setBounds(167, 47, 216, 19);
		frame.getContentPane().add(txtRegistroAcademico);
	}
}
