package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloMatrículas;
import entidad.Alumno;
import entidad.Matricula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public class FrmConsultaMatriculas extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConsultaDeAlumnos;
	private JPanel panel;
	private JLabel lblCdigoAlumno;
	private JTextField txtCodMatricula;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	//
	ArregloAlumnos arAlu = new ArregloAlumnos();
	ArregloMatrículas arrMatriculas= new ArregloMatrículas();
	private JButton btnLimpiar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaMatriculas frame = new FrmConsultaMatriculas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConsultaMatriculas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaMatriculas.class.getResource("/img/people_114360.png")));
		setTitle("Consulta | Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaDeAlumnos = new JLabel("CONSULTA DE MATRICULAS");
		lblConsultaDeAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAlumnos.setForeground(UIManager.getColor("text"));
		lblConsultaDeAlumnos.setBackground(new Color(112, 128, 144));
		lblConsultaDeAlumnos.setOpaque(true);
		lblConsultaDeAlumnos.setFont(new Font("Britannic Bold", Font.BOLD, 24));
		lblConsultaDeAlumnos.setBounds(15, 0, 705, 58);
		contentPane.add(lblConsultaDeAlumnos);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("textHighlight"));
		panel.setBounds(15, 62, 705, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCdigoAlumno = new JLabel("C\u00F3digo Matricula");
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoAlumno.setBounds(15, 16, 157, 20);
		panel.add(lblCdigoAlumno);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.addKeyListener(this);
		txtCodMatricula.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCodMatricula.setBounds(150, 14, 146, 26);
		panel.add(txtCodMatricula);
		txtCodMatricula.setColumns(11);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 125, 705, 383);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFocusable(false);
		btnConsultar.setIcon(new ImageIcon(FrmConsultaMatriculas.class.getResource("/img/buscar4.png")));
		btnConsultar.setBounds(81, 516, 170, 60);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmConsultaMatriculas.class.getResource("/img/borrador2.png")));
		btnLimpiar.setFocusable(false);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnLimpiar.setBounds(293, 516, 170, 60);
		contentPane.add(btnLimpiar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFocusable(false);
		btnCerrar.setIcon(new ImageIcon(FrmConsultaMatriculas.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnCerrar.setBounds(503, 516, 170, 60);
		contentPane.add(btnCerrar);
		
		soloNumeros(txtCodMatricula);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	/*===================BOTÓN CONSULTAR ====================*/
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int codMatricula; 
		codMatricula= getCodMatricula();
		Matricula matricula = arrMatriculas.buscar(codMatricula);
		
		if(codMatricula == -1){
			return;
		}else{
				if(matricula != null){
					txtS.setText("");
					listado(matricula);
				}else{
					mensaje("Error código de MATRICULA  no existe");
				}
		}
	}
	private int getCodMatricula() {
		int cod = -1;
		if(txtCodMatricula.getText().length() == 0){
			mensaje("Ingresar código de Matricula");
		}else{
			cod = Integer.parseInt(txtCodMatricula.getText());
		}
		return cod;
	}
	/*===================BOTÓN LIMPIAR ====================*/
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiar();
	}
	/*===================BOTÓN CERRAR ====================*/
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	/*================ MÉTODO LIMPIAR ====================*/
	void limpiar(){
		txtCodMatricula.setText("");
		txtS.setText("");
		txtCodMatricula.requestFocus();
	}
	/*===================MÉTODO LISTADO ====================*/
	void listado(Matricula mat){
		imprimir(" Codigo Matricula: " + mat.getNumMatricula());
		imprimir(" Fecha de Registro: " + mat.getFecha());
		imprimir(" Fecha de Registro: " + mat.getHora());
		imprimir("\n");
		imprimir(" Codigo Alumno: " + mat.getAlumno().getCodigoAlumno());
		imprimir(" Nombres: " + mat.getAlumno().getNombres());
		imprimir(" Apellidos: " + mat.getAlumno().getApellidos());
		imprimir(" DNI: " +mat.getAlumno().getDni());
		imprimir(" Edad: " + mat.getAlumno().getEdad());
		imprimir(" Celular: " + mat.getAlumno().getCelular());
		imprimir(" Estado: " + mat.getAlumno().getEstado());
		imprimir("\n");
		imprimir(" Codigo Curso: ".concat(String.valueOf(mat.getCurso().getCodCurso())));
		imprimir(" Asignatura: ".concat(mat.getCurso().getAsignatura()));
		imprimir(" Ciclo del Curso: ".concat(String.valueOf(mat.getCurso().getCiclo())));
		imprimir(" Numero de Creditos del Curso: ".concat(String.valueOf(mat.getCurso().getCreditos())));
		imprimir(" Numero de horas del curso: ".concat(String.valueOf(mat.getCurso().getHoras())));
		
	}
	void imprimir(String s){
		txtS.append(s+"\n");
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this,s,"Alerta", 2);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodMatricula) {
			keyTypedTxtCodAlumno(arg0);
		}
	}
	/*============= MÉTODO VALIDANDO JTEXTFIELD ================*/
	public void soloNumeros(JTextField alu){
		alu.addKeyListener(new KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent arg0){
				char c = arg0.getKeyChar();
				if(!Character.isDigit(c)){
					arg0.consume();
				}
			}
		});
	}
	protected void keyTypedTxtCodAlumno(KeyEvent arg0) {
		if (txtCodMatricula.getText().length() >= 10) {
			arg0.consume();
		}
	}
}
