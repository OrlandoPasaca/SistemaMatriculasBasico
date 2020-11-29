package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumnos;
import controlador.ArregloCursos;
import controlador.ArregloMatrículas;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
//import javafx.scene.input.KeyEvent;
//import jdk.nashorn.internal.scripts.JO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Component;

@SuppressWarnings("unused")
public class FrmRegistroMatriculas extends JFrame implements ActionListener, MouseListener {

	private static final String UNCHECKED = "unchecked";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoDeAlumnos;
	private JLabel lblNumeroMatricula;
	private JTextField txtNumeroMatricula;
	private JLabel lblCodAlumno;
	private JTextField txtCodAlumno;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblAlumno;
	private JTextField txtAlumno;
	private JTable tblMatriculas;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCerrar;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;

	// Clase modelo para determinar las columnas y filas de la tabla
	DefaultTableModel modeloMatriculas = new DefaultTableModel();

	// creando nuevo objeto de ArregloAlumnos
	ArregloMatrículas arMatriculas = new ArregloMatrículas();
	ArregloAlumnos arrAlumnos=new ArregloAlumnos();
	ArregloCursos arrCursos=new ArregloCursos();
	private JButton btnBuscarCodAlumno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroMatriculas frame = new FrmRegistroMatriculas();
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
		public FrmRegistroMatriculas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmRegistroMatriculas.class.getResource("/img/registrar.png")));
		setTitle("Registro | Matr\u00EDculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoDeAlumnos = new JLabel("REGISTRO DE MATR\u00CDCULAS");
		lblMantenimientoDeAlumnos.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
		lblMantenimientoDeAlumnos.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblMantenimientoDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setBackground(new Color(0, 0, 128));
		lblMantenimientoDeAlumnos.setForeground(UIManager.getColor("Button.highlight"));
		lblMantenimientoDeAlumnos.setOpaque(true);
		lblMantenimientoDeAlumnos.setBounds(10, 16, 827, 51);
		contentPane.add(lblMantenimientoDeAlumnos);

		lblNumeroMatricula = new JLabel("N\u00FAmero Matr\u00EDcula");
		lblNumeroMatricula.setForeground(new Color(245, 255, 250));
		lblNumeroMatricula.setBackground(new Color(0, 0, 0));
		lblNumeroMatricula.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNumeroMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroMatricula.setOpaque(true);
		lblNumeroMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroMatricula.setBounds(10, 80, 146, 30);
		contentPane.add(lblNumeroMatricula);

		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroMatricula.setFont(new Font("Arial", Font.BOLD, 17));
		txtNumeroMatricula.setEnabled(false);
		txtNumeroMatricula.setBounds(163, 81, 146, 30);
		contentPane.add(txtNumeroMatricula);
		txtNumeroMatricula.setColumns(10);

		lblCodAlumno = new JLabel("C\u00F3digo Alumno:");
		lblCodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodAlumno.setBounds(20, 149, 136, 20);
		contentPane.add(lblCodAlumno);

		txtCodAlumno = new JTextField();
		txtCodAlumno.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodAlumno.setBounds(163, 147, 146, 26);
		contentPane.add(txtCodAlumno);
		txtCodAlumno.setColumns(10);

		lblCodCurso = new JLabel("C\u00F3digo Curso:");
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodCurso.setBounds(20, 189, 136, 20);
		contentPane.add(lblCodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodCurso.setBounds(163, 188, 146, 26);
		contentPane.add(txtCodCurso);
		txtCodCurso.setColumns(10);

		lblAlumno = new JLabel("Alumno:");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlumno.setBounds(20, 230, 146, 20);
		contentPane.add(lblAlumno);

		txtAlumno = new JTextField();
		txtAlumno.setEnabled(false);
		txtAlumno.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAlumno.setBounds(164, 227, 377, 26);
		contentPane.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAsignatura.setBounds(20, 269, 146, 20);
		contentPane.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEnabled(false);
		txtAsignatura.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAsignatura.setBounds(163, 266, 378, 26);
		contentPane.add(txtAsignatura);
		txtAsignatura.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 827, 180);
		contentPane.add(scrollPane);

		tblMatriculas = new JTable();
		tblMatriculas.setFont(new Font("Arial", Font.PLAIN, 15));
		tblMatriculas.addMouseListener(this);
		tblMatriculas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatriculas);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(new Color(112, 128, 144));
		btnNuevo.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnNuevo.setBackground(UIManager.getColor("activeCaption"));
		btnNuevo.setFocusable(false);
		btnNuevo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 319, 175, 55);
		contentPane.add(btnNuevo);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setIcon(new ImageIcon(FrmRegistroMatriculas.class.getResource("/img/adicionar_curso.png")));
		btnAdicionar.setForeground(new Color(112, 128, 144));
		btnAdicionar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnAdicionar.setBackground(UIManager.getColor("activeCaption"));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(227, 319, 175, 55);
		contentPane.add(btnAdicionar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmRegistroMatriculas.class.getResource("/img/eliminar_curso.png")));
		btnEliminar.setForeground(new Color(112, 128, 144));
		btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnEliminar.setBackground(UIManager.getColor("activeCaption"));
		btnEliminar.setFocusable(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(447, 319, 175, 55);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmRegistroMatriculas.class.getResource("/img/modificar_curso.png")));
		btnModificar.setForeground(new Color(112, 128, 144));
		btnModificar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnModificar.setBackground(UIManager.getColor("activeCaption"));
		btnModificar.setFocusable(false);
		btnModificar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(662, 319, 175, 55);
		contentPane.add(btnModificar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(FrmRegistroMatriculas.class.getResource("/img/cerrar.png")));
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerrar.setFocusable(false);
		btnCerrar.setBounds(691, 75, 146, 41);
		contentPane.add(btnCerrar);

		// ============================================================================
		// determinar las columnas de la tabla
		modeloMatriculas.addColumn("NÚMERO");
		modeloMatriculas.addColumn("COD_ALUMNO");
		modeloMatriculas.addColumn("COD_CURSO");
		modeloMatriculas.addColumn("ALUMNO");
		modeloMatriculas.addColumn("ASIGNATURA");
		modeloMatriculas.addColumn("FECHA ");
		modeloMatriculas.addColumn("HORA ");
		
		tblMatriculas.setModel(modeloMatriculas);
		
		btnBuscarCodAlumno = new JButton("Buscar");
		
		btnBuscarCodAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				Alumno alumno=getCodAlumno();
				if(alumno!=null)
				{
					txtAlumno.setText(alumno.getNombres().concat(" ").concat(alumno.getApellidos()));
					
				}
				else
				{
					txtAlumno.setText("");
					JOptionPane.showMessageDialog(null, "No existe el alumno");
				}
			}
		});
		btnBuscarCodAlumno.setBounds(313, 146, 77, 27);
		contentPane.add(btnBuscarCodAlumno);
		
		JButton btnBuscarCodCurso = new JButton("Buscar");
		btnBuscarCodCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Curso curso=getCodCurso();
				if(curso!=null)
				{
					txtAsignatura.setText(curso.getAsignatura());
					
				}
				else
				{
					txtAsignatura.setText("");
					JOptionPane.showMessageDialog(null, "No existe el curso");
				}
			}
		});
		btnBuscarCodCurso.setBounds(313, 189, 77, 27);
		contentPane.add(btnBuscarCodCurso);
		listado();
		nuevaMatricula();
		
		//soloNumeros(txtAlumno);
		
	}
	void resetForm()
	{
		txtAlumno.setText("");
		txtCodAlumno.setText("");
		txtAsignatura.setText("");
		txtCodCurso.setText("");
	}
	/*============= MÉTODO LISTADO==================*/
	void listado() {
		modeloMatriculas.setRowCount(0);
		for (int i = 0; i < arMatriculas.tamaño(); i++) {
			Matricula m = arMatriculas.obtener(i);
			Object data[] = { m.getNumMatricula(),m.getAlumno().getCodigoAlumno(),m.getCurso().getCodCurso(),
							  m.getAlumno().getNombres().concat(" ").concat(m.getAlumno().getApellidos()),
							  m.getCurso().getAsignatura(),m.getFecha(),m.getHora()};
			// Agregando fila al modelo "modeloAlumnos"
			modeloMatriculas.addRow(data);
		}
	}
	/*================== MÉTODO MOSTRAR DATOS =======================*/
	private void mostrarDatos(int fila) {
		if(fila != -1){
			String codMat,codAlu,codCurso,alumno,asignatura,fecha,hora;
			codMat=tblMatriculas.getValueAt(fila, 0).toString();
			codAlu=tblMatriculas.getValueAt(fila, 1).toString();
			codCurso=tblMatriculas.getValueAt(fila, 2).toString();
			alumno=tblMatriculas.getValueAt(fila, 3).toString();
			asignatura=tblMatriculas.getValueAt(fila, 4).toString();
			fecha=tblMatriculas.getValueAt(fila, 5).toString();	
			
			//mostrando en interfaz
			txtNumeroMatricula.setText(codMat);
			txtCodAlumno.setText(codAlu);
			txtCodCurso.setText(codCurso);
			txtAlumno.setText(alumno);
			txtAsignatura.setText(asignatura);
			
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	}
		
	/* ==================================== BOTÓN NUEVO ======================================= */
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		nuevaMatricula();
	}
	private void nuevaMatricula() {
		txtNumeroMatricula.setText("" + arMatriculas.generarCodigo());
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		txtAlumno.setText("");
		txtAsignatura.setText("");
		
		// activando el cursor
		txtCodAlumno.requestFocus();
		
	}

	/* ================================= BOTÓN ADICIONAR ======================================== */
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		adicionarMatricula();
	}
	private void adicionarMatricula() {
		// Paso 1: Declarando variables
		LocalDateTime hoy=LocalDateTime.now();
		int numMatricula;
		Alumno alumno; 
		Curso curso;
		String fecha;
		String hora;

		numMatricula = getNumMatricula();
		alumno = getCodAlumno();
		curso = getCodCurso();
		fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(hoy);
		hora = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH).format(hoy);
		//
		if ( fecha == null || numMatricula == -1 || alumno == null || curso == null) {
			return;
		}	
		else {
			if(arMatriculas.buscar(numMatricula)!=null)
			{
				mensaje("El numero de matricula ya esta registrado debe generar uno nuevo");
			}
			else if(arMatriculas.findAlumnoByCodigo(alumno.getCodigoAlumno())!=null)
			{
				mensaje("El alumno ya se encuentra matriculado");
			}
			else
			{
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this, "Desea adicionar", "SISTEMA", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					alumno.setEstado(1);
					Matricula newMatricula=new Matricula(numMatricula, alumno, curso, fecha,hora);
					arMatriculas.adicionar(newMatricula);
					arMatriculas.crearDat(ArregloMatrículas.getMat());
					listado();
					nuevaMatricula();
				}
			}
			
		}
	}
	private int getNumMatricula() {
		return  Integer.parseInt(txtNumeroMatricula.getText());
	}
	private Alumno getCodAlumno() {
		Alumno alumno=null;
		if(txtCodAlumno.getText().length() ==0){
			mensaje("Ingresar código Alumno");
		}
		else{
			int cod=Integer.parseInt(txtCodAlumno.getText());
			alumno =arrAlumnos.buscar(cod);
		}
		return alumno;
	}
	private Curso getCodCurso() {
		Curso curso = null;
		if(txtCodCurso.getText().length() ==0){
			mensaje("Ingresar código Curso");
		}
		else{
			int cod=Integer.parseInt(txtCodCurso.getText());
			curso = arrCursos.buscarCodigo(cod);
		}
		return curso;
	}
	private String getFecha(){
		return arMatriculas.buscar(getCodigo()).getFecha();
	}
	private String getHora() {
		String nom = null;
		if (txtCodAlumno.getText().trim().length() == 0) {
			mensaje("Ingresar Nombre");
		}
		else {
			nom = txtCodAlumno.getText();
		}
		return nom;
	}
	private int getCodigo() {
		return Integer.parseInt(txtNumeroMatricula.getText());
	}
	
	
	/* ========================================= BOTÓN ELIMINAR ======================================== */
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarAlumno();
	}
	private void eliminarAlumno() {
		int numMatricula;
		Alumno alumno; 
		Curso curso;

		numMatricula = getNumMatricula();
		alumno = getCodAlumno();
		curso = getCodCurso();
		
		//
		if (numMatricula == -1 || alumno == null || curso == null) {
			return;
		}
		else
		{
			if(arMatriculas.buscar(numMatricula)==null)
			{
				mensaje("No existe la matricula");
			}
			else if(alumno.getEstado()==2)
			{
				mensaje("No puedes cancelar la matricula porque el alumno esta retirado");
			}
			else
			{
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this,"Seguro eliminar la matricula con codigo ".concat(String.valueOf(numMatricula)),"Sistema",JOptionPane.YES_NO_OPTION);
				if(opcion == 0){
					Matricula matricula=arMatriculas.findMatriculaByCodigo(numMatricula);
					matricula.getAlumno().setEstado(0);
					ArregloMatrículas.getMat().remove(matricula);
					arMatriculas.crearDat(ArregloMatrículas.getMat());
					listado();
					nuevaMatricula();
				}
			}
		}
	}

	/* ============================================ BOTÓN MODIFICAR ============================================== */
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		Alumno alumno=getCodAlumno();
		Curso curso=getCodCurso();
		Integer codMatricula=getCodigo();
		Matricula matricula=null;
		if(arMatriculas.buscar(codMatricula)==null)
		{
			mensaje("El numero de matricula no existe");
			return;
		}
		else
		{
			matricula=arMatriculas.buscar(codMatricula);
			if(alumno==null)
			{
				mensaje("El alumno no existe");
				return;
			}
			else if(matricula.getAlumno().getCodigoAlumno()!=alumno.getCodigoAlumno())
			{
				mensaje("Solo puede modificar el curso");
				return;
			}
			if(curso==null)
			{
				mensaje("El curso no existe");
				return;
			}
		}
		
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,"Seguro de modificar","Sistema",JOptionPane.YES_NO_OPTION);
		if(opcion == 0){
			matricula.setCurso(curso);
			arMatriculas.crearDat(ArregloMatrículas.getMat());
			listado();
			nuevaMatricula();
		}
		
	}
	
	/* ============================================ BOTÓN CERRAR ============================================== */
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	/* ================ MÉTODO MENSAJE ================= */
	private void mensaje(String string) {
		JOptionPane.showMessageDialog(this, string, "Alerta", 2);
	}
	
	/*============ EVENTOS MOUSECLICKED =================*/
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblMatriculas) {
			mouseClickedTblMatriculas(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblMatriculas(MouseEvent arg0) {
		int fila;
		fila = tblMatriculas.getSelectedRow();
		mostrarDatos(fila);
	}
	public void keyPressed(java.awt.event.KeyEvent arg0) {
	}
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == tblMatriculas) {
			keyReleasedTblMatriculas(arg0);
		}
	}
	protected void keyReleasedTblMatriculas(java.awt.event.KeyEvent arg0) {
		int fila;
		fila = tblMatriculas.getSelectedRow();
		mostrarDatos(fila);
	}
}
