package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entities.Aluno;
import entities.Curso;
import service.AlunoService;
import service.CursoService;

import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

public class AlunoWindow {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtRegistroAcademico;
	private JTextField txtCoeficiente;
	private JTable tblAlunos;
	private JComboBox cbCurso;
	
	private MaskFormatter mascaraData;
	private ButtonGroup btnGrupoSexo;
	
	private CursoService cursoService;
	private AlunoService alunoService;
	
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
		this.criarMascaraData();
		this.initComponents();
		
		this.cursoService = new CursoService();
		this.alunoService = new AlunoService();
		
		this.buscarCurso();
		this.buscarAlunos();
	}
	
	private void buscarAlunos() {
		DefaultTableModel modelo = (DefaultTableModel) tblAlunos.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		
		List<Aluno> alunos = this.alunoService.buscarTodos();
		
		for(Aluno aluno : alunos) {
			modelo.addRow(new Object[] {
				aluno.getRegistroAcademico(),
				aluno.getNome(),
				aluno.getSexo(),
				aluno.getCurso().getNome(),
				aluno.getDataIngresso(),
				aluno.getPeriodo(),
				aluno.getCoeficiente()
			});
		}
	}
	
	
	private void buscarCurso() {
		List<Curso> cursos = this.cursoService.buscarTodos();
		
		for(Curso curso : cursos) {
			this.cbCurso.addItem(curso);
		}
	}
	
	private void criarMascaraData() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch(ParseException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 786, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem itemSair = new JMenuItem("Sair");
		menuArquivo.add(itemSair);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem itemSobre = new JMenuItem("Sobre");
		menuAjuda.add(itemSobre);
		
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
		txtNome.setBounds(112, 90, 481, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRegistroAcademico.setColumns(10);
		txtRegistroAcademico.setBounds(167, 47, 216, 19);
		frame.getContentPane().add(txtRegistroAcademico);
		
		JPanel painelSexo = new JPanel();
		painelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelSexo.setBounds(24, 162, 192, 144);
		frame.getContentPane().add(painelSexo);
		painelSexo.setLayout(null);
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(22, 27, 103, 21);
		painelSexo.add(rbMasculino);
		
		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(22, 62, 103, 21);
		painelSexo.add(rbFeminino);
		
		JRadioButton rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setBounds(22, 97, 103, 21);
		painelSexo.add(rbNaoInformar);
		
		btnGrupoSexo = new ButtonGroup();
		btnGrupoSexo.add(rbMasculino);
		btnGrupoSexo.add(rbFeminino);
		btnGrupoSexo.add(rbNaoInformar);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(226, 173, 49, 13);
		frame.getContentPane().add(lblCurso);
		
		cbCurso = new JComboBox();
		cbCurso.setBounds(285, 169, 308, 21);
		frame.getContentPane().add(cbCurso);
		
		JLabel lblDataIngresso = new JLabel("Data de Ingresso");
		lblDataIngresso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataIngresso.setBounds(226, 219, 108, 13);
		frame.getContentPane().add(lblDataIngresso);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodo.setBounds(476, 219, 67, 13);
		frame.getContentPane().add(lblPeriodo);
		
		JSpinner spPeriodo = new JSpinner();
		spPeriodo.setBounds(544, 215, 49, 20);
		frame.getContentPane().add(spPeriodo);
		
		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoeficiente.setBounds(226, 269, 108, 13);
		frame.getContentPane().add(lblCoeficiente);
		
		txtCoeficiente = new JTextField();
		txtCoeficiente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCoeficiente.setColumns(10);
		txtCoeficiente.setBounds(335, 266, 117, 19);
		frame.getContentPane().add(txtCoeficiente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 329, 569, 13);
		frame.getContentPane().add(separator);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(274, 352, 154, 42);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimparCampos.setBounds(439, 352, 154, 42);
		frame.getContentPane().add(btnLimparCampos);
		
		JPanel painelAlunos = new JPanel();
		painelAlunos.setBorder(new TitledBorder(null, "Alunos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelAlunos.setBounds(24, 404, 569, 259);
		frame.getContentPane().add(painelAlunos);
		painelAlunos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 549, 229);
		painelAlunos.add(scrollPane);
		
		tblAlunos = new JTable();
		scrollPane.setViewportView(tblAlunos);
		tblAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RA", "Nome", "Sexo", "Curso", "Data do Inicio", "Per\u00EDodo", "Coeficiente"
			}
		));
		
		JFormattedTextField txtDataIngresso = new JFormattedTextField(mascaraData);
		txtDataIngresso.setBounds(344, 218, 108, 19);
		frame.getContentPane().add(txtDataIngresso);
	}
}
