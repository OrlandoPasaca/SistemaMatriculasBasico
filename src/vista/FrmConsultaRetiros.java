package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloMatrículas;
import controlador.ArregloRetiros;
import entidad.Alumno;
import entidad.Matricula;
import entidad.Retiro;

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
public class FrmConsultaRetiros extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConsultaDeAlumnos;
	private JPanel panel;
	private JLabel lblCdigoAlumno;
	private JTextField txtCodRetiro;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	//
	ArregloAlumnos arAlu = new ArregloAlumnos();
	ArregloMatrículas arrMatriculas= new ArregloMatrículas();
	ArregloRetiros arrRetiros= new ArregloRetiros();
	private JButton btnLimpiar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaRetiros frame = new FrmConsultaRetiros();
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
	public FrmConsultaRetiros() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaRetiros.class.getResource("/img/people_114360.png")));
		setTitle("Consulta | Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaDeAlumnos = new JLabel("CONSULTA DE RETIROS");
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
		
		lblCdigoAlumno = new JLabel("C\u00F3digo Retiro");
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoAlumno.setBounds(15, 16, 157, 20);
		panel.add(lblCdigoAlumno);
		
		txtCodRetiro = new JTextField();
		txtCodRetiro.addKeyListener(this);
		txtCodRetiro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCodRetiro.setBounds(150, 14, 146, 26);
		panel.add(txtCodRetiro);
		txtCodRetiro.setColumns(11);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 125, 705, 383);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFocusable(false);
		btnConsultar.setIcon(new ImageIcon(FrmConsultaRetiros.class.getResource("/img/buscar4.png")));
		btnConsultar.setBounds(81, 516, 170, 60);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmConsultaRetiros.class.getResource("/img/borrador2.png")));
		btnLimpiar.setFocusable(false);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnLimpiar.setBounds(293, 516, 170, 60);
		contentPane.add(btnLimpiar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFocusable(false);
		btnCerrar.setIcon(new ImageIcon(FrmConsultaRetiros.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnCerrar.setBounds(503, 516, 170, 60);
		contentPane.add(btnCerrar);
		
		soloNumeros(txtCodRetiro);
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
		int codRetiro; 
		codRetiro= getCodMatricula();
		Retiro retiro = arrRetiros.buscar(codRetiro);
		
		if(codRetiro == -1){
			return;
		}else{
				if(retiro != null){
					txtS.setText("");
					listado(retiro);
				}else{
					mensaje("Error código de RETIRO  no existe");
				}
		}
	}
	private int getCodMatricula() {
		int cod = -1;
		if(txtCodRetiro.getText().length() == 0){
			mensaje("Ingresar código de Retiro");
		}else{
			cod = Integer.parseInt(txtCodRetiro.getText());
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
		txtCodRetiro.setText("");
		txtS.setText("");
		txtCodRetiro.requestFocus();
	}
	/*===================MÉTODO LISTADO ====================*/
	void listado(Retiro retiro){
		imprimir(" Codigo Matricula: " + retiro.getNumRetiro());
		imprimir(" Fecha de Registro: " + retiro.getFecha());
		imprimir(" Hora de Registro: " + retiro.getHora());
		imprimir("\n");
		imprimir(" Codigo Alumno: " + retiro.getMatricula().getAlumno().getCodigoAlumno());
		imprimir(" Nombres: " + retiro.getMatricula().getAlumno().getNombres());
		imprimir(" Apellidos: " + retiro.getMatricula().getAlumno().getApellidos());
		imprimir(" DNI: " +retiro.getMatricula().getAlumno().getDni());
		imprimir(" Edad: " + retiro.getMatricula().getAlumno().getEdad());
		imprimir(" Celular: " + retiro.getMatricula().getAlumno().getCelular());
		imprimir(" Estado: " + retiro.getMatricula().getAlumno().getEstado());
		imprimir("\n");
		imprimir(" Codigo Curso: ".concat(String.valueOf(retiro.getMatricula().getCurso().getCodCurso())));
		imprimir(" Asignatura: ".concat(retiro.getMatricula().getCurso().getAsignatura()));
		imprimir(" Ciclo del Curso: ".concat(String.valueOf(retiro.getMatricula().getCurso().getCiclo())));
		imprimir(" Numero de Creditos del Curso: ".concat(String.valueOf(retiro.getMatricula().getCurso().getCreditos())));
		imprimir(" Numero de horas del curso: ".concat(String.valueOf(retiro.getMatricula().getCurso().getHoras())));
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
		if (arg0.getSource() == txtCodRetiro) {
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
		if (txtCodRetiro.getText().length() >= 10) {
			arg0.consume();
		}
	}
}
