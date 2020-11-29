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
import controlador.ArregloRetiros;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import entidad.Retiro;
//import javafx.scene.input.KeyEvent;
//import jdk.nashorn.internal.scripts.JO;
//import sun.awt.AWTAccessor.SystemColorAccessor;

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
public class FrmRegistroRetiro extends JFrame implements ActionListener, MouseListener {

	private static final String UNCHECKED = "unchecked";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoDeAlumnos;
	private JLabel lblNumeroRetiro;
	private JTextField txtNumeroRetiro;
	private JLabel lblNumMatricula;
	private JTextField txtNumMatricula;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblAlumno;
	private JTextField txtAlumno;
	private JTable tblRetiros;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCerrar;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;

	// Clase modelo para determinar las columnas y filas de la tabla
	DefaultTableModel modeloRetiros = new DefaultTableModel();

	// creando nuevo objeto de ArregloAlumnos
	ArregloRetiros arRetiros = new ArregloRetiros();
	ArregloMatrículas arrMatriculas=new ArregloMatrículas();
	ArregloCursos arrCursos=new ArregloCursos();
	ArregloAlumnos arrAlumnos=new ArregloAlumnos();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroRetiro frame = new FrmRegistroRetiro();
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
		public FrmRegistroRetiro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmRegistroRetiro.class.getResource("/img/registrar.png")));
		setTitle("Registro | Retiros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoDeAlumnos = new JLabel("REGISTRO DE RETIROS");
		lblMantenimientoDeAlumnos.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
		lblMantenimientoDeAlumnos.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblMantenimientoDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setBackground(new Color(0, 0, 128));
		lblMantenimientoDeAlumnos.setForeground(UIManager.getColor("Button.highlight"));
		lblMantenimientoDeAlumnos.setOpaque(true);
		lblMantenimientoDeAlumnos.setBounds(10, 16, 827, 51);
		contentPane.add(lblMantenimientoDeAlumnos);

		lblNumeroRetiro = new JLabel("N\u00FAmero Retiro");
		lblNumeroRetiro.setForeground(new Color(245, 255, 250));
		lblNumeroRetiro.setBackground(new Color(0, 0, 0));
		lblNumeroRetiro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNumeroRetiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroRetiro.setOpaque(true);
		lblNumeroRetiro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroRetiro.setBounds(10, 80, 146, 30);
		contentPane.add(lblNumeroRetiro);

		txtNumeroRetiro = new JTextField();
		txtNumeroRetiro.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroRetiro.setFont(new Font("Arial", Font.BOLD, 17));
		txtNumeroRetiro.setEnabled(false);
		txtNumeroRetiro.setBounds(173, 81, 136, 30);
		contentPane.add(txtNumeroRetiro);
		txtNumeroRetiro.setColumns(10);

		lblNumMatricula = new JLabel("N\u00FAmero Matr\u00EDcula:");
		lblNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumMatricula.setBounds(20, 149, 146, 20);
		contentPane.add(lblNumMatricula);

		txtNumMatricula = new JTextField();
		txtNumMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNumMatricula.setBounds(173, 147, 136, 26);
		contentPane.add(txtNumMatricula);
		txtNumMatricula.setColumns(10);

		lblCodCurso = new JLabel("C\u00F3digo Curso:");
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodCurso.setBounds(20, 189, 136, 20);
		contentPane.add(lblCodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodCurso.setBounds(173, 188, 136, 26);
		contentPane.add(txtCodCurso);
		txtCodCurso.setColumns(10);

		lblAlumno = new JLabel("Alumno:");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlumno.setBounds(20, 230, 146, 20);
		contentPane.add(lblAlumno);

		txtAlumno = new JTextField();
		txtAlumno.setEnabled(false);
		txtAlumno.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAlumno.setBounds(173, 227, 368, 26);
		contentPane.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAsignatura.setBounds(20, 269, 146, 20);
		contentPane.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEnabled(false);
		txtAsignatura.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAsignatura.setBounds(173, 266, 368, 26);
		contentPane.add(txtAsignatura);
		txtAsignatura.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 827, 180);
		contentPane.add(scrollPane);

		tblRetiros = new JTable();
		tblRetiros.setFont(new Font("Arial", Font.PLAIN, 15));
		tblRetiros.addMouseListener(this);
		tblRetiros.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiros);
		
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
		btnAdicionar.setIcon(new ImageIcon(FrmRegistroRetiro.class.getResource("/img/adicionar_curso.png")));
		btnAdicionar.setForeground(new Color(112, 128, 144));
		btnAdicionar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnAdicionar.setBackground(UIManager.getColor("activeCaption"));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(227, 319, 175, 55);
		contentPane.add(btnAdicionar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmRegistroRetiro.class.getResource("/img/eliminar_curso.png")));
		btnEliminar.setForeground(new Color(112, 128, 144));
		btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnEliminar.setBackground(UIManager.getColor("activeCaption"));
		btnEliminar.setFocusable(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(447, 319, 175, 55);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmRegistroRetiro.class.getResource("/img/modificar_curso.png")));
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
		btnCerrar.setIcon(new ImageIcon(FrmRegistroRetiro.class.getResource("/img/cerrar.png")));
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerrar.setFocusable(false);
		btnCerrar.setBounds(691, 75, 146, 41);
		contentPane.add(btnCerrar);

		// ============================================================================
		// determinar las columnas de la tabla
		modeloRetiros.addColumn("NÚMERO");
		modeloRetiros.addColumn("MATRÍCULA");
		modeloRetiros.addColumn("FECHA");
		modeloRetiros.addColumn("HORA");
		
		tblRetiros.setModel(modeloRetiros);
		
		JButton btnBuscarNumMatric = new JButton("Buscar");
		btnBuscarNumMatric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Matricula matricula=getMatricula();
				if(matricula==null||arrMatriculas.buscar(matricula.getNumMatricula())==null)
				{
					mensaje("El numero de matricula no existe");
					nuevoRetiro();
				}	
				else
				{
					int numMatricula=matricula.getNumMatricula();
					txtNumMatricula.setText(String.valueOf(numMatricula));
					
					int codCurso=matricula.getCurso().getCodCurso();
					txtCodCurso.setText(String.valueOf(codCurso));
					
					String alumno=matricula.getAlumno().getNombres().concat(" ").concat(matricula.getAlumno().getApellidos());
					txtAlumno.setText(alumno);
					
					String asignatura=matricula.getCurso().getAsignatura();
					txtAsignatura.setText(asignatura);
					
				}
			}
		});
		btnBuscarNumMatric.setBounds(319, 147, 76, 25);
		contentPane.add(btnBuscarNumMatric);
		
		JButton btnBuscarCodCurso = new JButton("Buscar");
		btnBuscarCodCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codCurso=txtCodCurso.getText();
				if(codCurso.trim().length()==0){
					mensaje("Ingrese el codigo de Curso");
					return;
				}
				Curso curso=null;
				try
				{
				curso=arrCursos.buscarCodigo(Integer.parseInt(codCurso));
				}
				catch (Exception e) {
					mensaje(String.valueOf(e));
					txtCodCurso.setText("");
					return;
				}
				if(curso==null)
				{
					mensaje("El curso no existe");
					txtCodCurso.setText("");
					txtAsignatura.setText("");
					return;
				}
				txtAsignatura.setText(curso.getAsignatura());
				
			}
		});
		btnBuscarCodCurso.setBounds(319, 189, 76, 25);
		contentPane.add(btnBuscarCodCurso);
		listado();
		nuevoRetiro();
		//soloNumeros(txtAlumno);
		
	}
	/*============= MÉTODO LISTADO==================*/
	void listado() {
		modeloRetiros.setRowCount(0);
		for (int i = 0; i < arRetiros.tamaño(); i++) {
			Retiro r = arRetiros.obtener(i);
			Object data[] = { r.getNumRetiro(),r.getMatricula().getNumMatricula(),r.getFecha(),r.getHora()};
			modeloRetiros.addRow(data);
		}
	}
	/*================== MÉTODO MOSTRAR DATOS =======================*/
	private void mostrarDatos(int fila) {
		if(fila != -1){
			String codRet,codMat,fecha,hora,alumno,asignatura;
			int codCurso;
			Matricula matricula;
			codRet=tblRetiros.getValueAt(fila, 0).toString();
			codMat=tblRetiros.getValueAt(fila, 1).toString();
			fecha=tblRetiros.getValueAt(fila, 2).toString();
			
			matricula=arrMatriculas.buscar(Integer.valueOf(codMat));
			codCurso=matricula.getCurso().getCodCurso();
			alumno=matricula.getAlumno().getNombres().concat(" ").concat(matricula.getAlumno().getApellidos());
			asignatura=matricula.getCurso().getAsignatura();
			//mostrando en interfaz
			txtNumeroRetiro.setText(codRet);
			txtNumMatricula.setText(codMat);
			txtCodCurso.setText(String.valueOf(codCurso));
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
	protected void actionPerformedBtnEliminar(ActionEvent arg0)
	{
		String numRetiro=txtNumeroRetiro.getText();
		Retiro retiro=arRetiros.buscar(Integer.valueOf(numRetiro));
		if(retiro==null)
		{
			mensaje("No existe el numero de retiro");
			return;
		}
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,"Seguro eliminar el retiro con codigo ".concat(String.valueOf(numRetiro)),"Sistema",JOptionPane.YES_NO_OPTION);
		if(opcion == 0){
			Alumno alumno= arrAlumnos.buscar(retiro.getMatricula().getAlumno().getCodigoAlumno());
			alumno.setEstado(1);
			arrAlumnos.crearTxt(ArregloAlumnos.getLista());
			retiro.getMatricula().setAlumno(alumno);
			ArregloRetiros.getR().remove(retiro);
			arRetiros.crearDat(ArregloRetiros.getR());
			listado();
			nuevoRetiro();
		}
		
		
	}
	/* ==================================== BOTÓN NUEVO ======================================= */
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		nuevoRetiro();
	}
	private void nuevoRetiro() {
		txtNumeroRetiro.setText("" + arRetiros.generarCodigo());
		txtNumMatricula.setText("");
		txtCodCurso.setText("");
		txtAlumno.setText("");
		txtAsignatura.setText("");
				
		// activando el cursor
		txtNumMatricula.requestFocus();
		
	}

	/* ================================= BOTÓN ADICIONAR ======================================== */
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		adicionarMatricula();
	}
	private void adicionarMatricula() {
		// Paso 1: Declarando variables
		LocalDateTime hoy=LocalDateTime.now();
		int numRetiro, codAlumno, codCurso;
		Matricula matricula;
		String fecha;
		String hora;

		numRetiro = getNumRetiro();
		matricula = getMatricula();
		fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(hoy);
		hora = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH).format(hoy);
		
		//
		if (hora == null || fecha == null || matricula == null) {
			return;
		}	
		else {
			
			if(arRetiros.buscar(numRetiro)!=null)
			{
				mensaje("El numero de retiro ya existe debe generar uno nuevo");
			}
			else if(arRetiros.findMatriculaByNumMatricula(matricula.getNumMatricula())!=null)
			{
				mensaje("El alumno ya se retiro del curso");
			}
			else
			{
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this, "Desea adicionar", "SISTEMA", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					Alumno alumno=arrAlumnos.buscar(matricula.getAlumno().getCodigoAlumno());
					Retiro nuevoRetiro=new Retiro(numRetiro, matricula, fecha,hora);
					arRetiros.adicionar(nuevoRetiro);
					arRetiros.crearDat(ArregloRetiros.getR());
					alumno.setEstado(2);
					matricula.setAlumno(alumno);
					arrAlumnos.crearTxt(ArregloAlumnos.getLista());
					listado();
				}
			}
		}
	}
	private int getNumRetiro() {
		return  Integer.parseInt(txtNumeroRetiro.getText());
		
	}

	private Matricula getMatricula() {
		Matricula matricula = null;
		if(txtNumMatricula.getText().length() ==0){
			mensaje("Ingresar código Alumno");
		}
		else{
			int numMatricula=Integer.valueOf(txtNumMatricula.getText());
			matricula = arrMatriculas.findMatriculaByCodigo(numMatricula);
		}	
		return matricula;
	}
	
	private String getFecha() {
		String ape = null;
		if (txtCodCurso.getText().trim().length() == 0) {
			mensaje("Ingresar Apellido");
		}
		else {
			ape = txtCodCurso.getText();
		}
		return ape;
	}
	private String getHora() {
		String nom = null;
		if (txtNumMatricula.getText().trim().length() == 0) {
			mensaje("Ingresar Nombre");
		}
		else {
			nom = txtNumMatricula.getText();
		}
		return nom;
	}
		
	/* ========================================= BOTÓN ELIMINAR ======================================== */
	/*protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarAlumno();
	}
	private void eliminarAlumno() {
		Alumno a = arAlumnos.buscar(getCodigo());
		
		if(a.getEstado() == 0){
			if(a != null ){//Alumno existe por código
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this,"Seguro de eliminar","Sistema",JOptionPane.YES_NO_OPTION);
					if( opcion == 0){
						arAlumnos.eliminar(a);
						listado();
					}else{
						mensaje("Código de alumno no existe");
					}
			}
		}else{
			mensaje("Solo puede eliminar cuando su estado es 0 (registrado)");
		}
	}*/

	/* ============================================ BOTÓN MODIFICAR ============================================== */
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		Integer numRetiro=Integer.valueOf(txtNumeroRetiro.getText());
		Retiro retiro=null;
		Matricula matricula=getMatricula();
		Curso curso=arrCursos.buscarCodigo(Integer.valueOf(txtCodCurso.getText()));
		if(arRetiros.buscar(numRetiro)==null)
		{
			mensaje("El numero de retiro no existe");
			return;
		}
		else
		{
			retiro=arRetiros.buscar(numRetiro);
			if(matricula==null)
			{
				mensaje("No existe el numero de matricula");
				return;
			}
			else if(curso==null)
			{
				mensaje("No existe el curso");
				return;
			}
			else if(retiro.getMatricula().getNumMatricula()!=matricula.getNumMatricula())
			{
				mensaje("Solo puede modificar el curso");
				return;
			}
		}
		
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,"Seguro de modificar","Sistema",JOptionPane.YES_NO_OPTION);
		if(opcion == 0){
			matricula.setCurso(curso);
			retiro.setMatricula(matricula);;
			arrMatriculas.crearDat(ArregloMatrículas.getMat());
			arRetiros.crearDat(ArregloRetiros.getR());
			nuevoRetiro();
			listado();
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
		if (arg0.getSource() == tblRetiros) {
			mouseClickedTblRetiros(arg0);
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
	protected void mouseClickedTblRetiros(MouseEvent arg0) {
		int fila;
		fila = tblRetiros.getSelectedRow();
		mostrarDatos(fila);
	}
	public void keyPressed(java.awt.event.KeyEvent arg0) {
	}
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == tblRetiros) {
			keyReleasedTblRetiros(arg0);
		}
	}
	protected void keyReleasedTblRetiros(java.awt.event.KeyEvent arg0) {
		int fila;
		fila = tblRetiros.getSelectedRow();
		mostrarDatos(fila);
	}
}
