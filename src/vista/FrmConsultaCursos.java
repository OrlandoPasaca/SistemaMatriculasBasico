package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloCursos;
import entidad.Alumno;
import entidad.Curso;

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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class FrmConsultaCursos extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConsultaDeCursos;
	private JPanel panel;
	private JLabel lblCodigoCurso;
	private JTextField txtCodCurso;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnLimpiar;
	private JButton btnCerrar;
	
	//
	ArregloCursos arCur = new ArregloCursos();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaCursos frame = new FrmConsultaCursos();
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
	public FrmConsultaCursos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultaCursos.class.getResource("/img/Books_icon-icons.com_76879.png")));
		setTitle("Consulta | Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaDeCursos = new JLabel("CONSULTA DE CURSOS");
		lblConsultaDeCursos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCursos.setForeground(UIManager.getColor("text"));
		lblConsultaDeCursos.setBackground(new Color(112, 128, 144));
		lblConsultaDeCursos.setOpaque(true);
		lblConsultaDeCursos.setFont(new Font("Britannic Bold", Font.BOLD, 24));
		lblConsultaDeCursos.setBounds(15, 0, 700, 58);
		contentPane.add(lblConsultaDeCursos);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("textHighlight"));
		panel.setBounds(15, 62, 700, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCodigoCurso = new JLabel("C\u00F3digo Curso:");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoCurso.setBounds(15, 16, 157, 20);
		panel.add(lblCodigoCurso);
		
		txtCodCurso = new JTextField();
		txtCodCurso.addKeyListener(this);
		txtCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCodCurso.setBounds(150, 14, 146, 26);
		panel.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 125, 700, 398);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(FrmConsultaCursos.class.getResource("/img/buscar4.png")));
		btnConsultar.setBounds(56, 530, 170, 60);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmConsultaCursos.class.getResource("/img/borrador2.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnLimpiar.setBounds(274, 530, 170, 60);
		contentPane.add(btnLimpiar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmConsultaCursos.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnCerrar.setBounds(490, 530, 170, 60);
		contentPane.add(btnCerrar);
		
		soloNumeros(txtCodCurso);
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
		int codigoCurso;
		codigoCurso= getCodigoCurso();
		Curso  c= arCur.buscarCodigo(codigoCurso);
		
		if(codigoCurso == -1){
			return;
		}else{
				if(c != null){
					txtS.setText("");
					listado(c);
				}else{
					mensaje("Error código de CURSO no existe");
				}
		}
	}
	private int getCodigoCurso() {
		int cod = -1;
		if(txtCodCurso.getText().length() == 0){
			mensaje("Ingresar código de Curso");
		}else{
			cod = Integer.parseInt(txtCodCurso.getText());
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
		txtCodCurso.setText("");
		txtS.setText("");
		txtCodCurso.requestFocus();
	}
	/*================ MÉTODO LISTADO ====================*/
	void listado(Curso c){
		imprimir(" Código de Curso : "+c.getCodCurso());
		imprimir(" Asignatura : "+c.getAsignatura());
		imprimir(" Ciclo: "+c.getCiclo());
		imprimir(" Cant. créditos: "+c.getCreditos());
		imprimir(" Horas:  "+c.getHoras());
	}
	void imprimir(String s){
		txtS.append(s+"\n");
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this,s,"Alerta", 2);
	}
		
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodCurso) {
			keyTypedTxtCodCurso(e);
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
	protected void keyTypedTxtCodCurso(KeyEvent e) {
		if (txtCodCurso.getText().length() >= 4) {
			e.consume();
		}
	}
}
