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
import java.util.List;
import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public class FrmReporteMatrPendiente extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConsultaDeAlumnos;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	//
	ArregloAlumnos arAlu = new ArregloAlumnos();
	ArregloMatrículas arrMatriculas= new ArregloMatrículas();
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteMatrPendiente frame = new FrmReporteMatrPendiente();
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
	public FrmReporteMatrPendiente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteMatrPendiente.class.getResource("/img/people_114360.png")));
		setTitle("Consulta | Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaDeAlumnos = new JLabel("Reporte alumnos con matricula pendiente");
		lblConsultaDeAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeAlumnos.setForeground(UIManager.getColor("text"));
		lblConsultaDeAlumnos.setBackground(new Color(112, 128, 144));
		lblConsultaDeAlumnos.setOpaque(true);
		lblConsultaDeAlumnos.setFont(new Font("Britannic Bold", Font.BOLD, 24));
		lblConsultaDeAlumnos.setBounds(15, 0, 705, 58);
		contentPane.add(lblConsultaDeAlumnos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 80, 705, 425);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFocusable(false);
		btnCerrar.setIcon(new ImageIcon(FrmReporteMatrPendiente.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnCerrar.setBounds(257, 516, 170, 60);
		contentPane.add(btnCerrar);
		listado();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}

	/*===================BOTÓN CERRAR ====================*/
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}

	/*===================MÉTODO LISTADO ====================*/
	void listado(){
		imprimir(" Alumnos registrados: ");
		List<Alumno> alumnos=arAlu.findAlumnoByEstado(0);
		txtS.append("\n");
		for(Alumno alumno:alumnos)
		{
			imprimir(" Codigo Alumno: " + alumno.getCodigoAlumno());
			imprimir(" Nombres: " + alumno.getNombres());
			imprimir(" Apellidos: " + alumno.getApellidos());
			imprimir(" DNI: " +alumno.getDni());
			imprimir(" Edad: " +alumno.getEdad());
			imprimir(" Celular: " +alumno.getCelular());
			imprimir(" Estado: " +alumno.getEstado());
			txtS.append("\n");
		}
		
		
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
	}
	/*============= MÉTODO VALIDANDO JTEXTFIELD ================*/
	public void soloNumeros(JTextField alu){
	}
	
}
