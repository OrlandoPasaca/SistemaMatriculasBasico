package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumnos;
import entidad.Alumno;
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
import java.util.Arrays;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Component;

@SuppressWarnings("unused")
public class FrmMantenimientoAlumno extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoDeAlumnos;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblEstado;
	private JComboBox<?> cboEstado;
	private JTable tblAlumnos;
	private JScrollPane scrollPane;

	// Clase modelo para determinar las columnas y filas de la tabla
	DefaultTableModel modeloAlumnos = new DefaultTableModel();

	// creando nuevo objeto de ArregloAlumnos
	ArregloAlumnos arAlumnos = new ArregloAlumnos();

	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JLabel lblNewLabel;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoAlumno frame = new FrmMantenimientoAlumno();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmMantenimientoAlumno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMantenimientoAlumno.class.getResource("/img/bootloader_users_person_people_6080.png")));
		setTitle("Mantenimiento | Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoDeAlumnos = new JLabel("MANTENIMIENTO DE ALUMNO(A)");
		lblMantenimientoDeAlumnos.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
		lblMantenimientoDeAlumnos.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblMantenimientoDeAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMantenimientoDeAlumnos.setBackground(new Color(0, 0, 128));
		lblMantenimientoDeAlumnos.setForeground(UIManager.getColor("Button.highlight"));
		lblMantenimientoDeAlumnos.setOpaque(true);
		lblMantenimientoDeAlumnos.setBounds(10, 16, 710, 51);
		contentPane.add(lblMantenimientoDeAlumnos);

		lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setForeground(new Color(245, 255, 250));
		lblCdigo.setBackground(new Color(0, 0, 0));
		lblCdigo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setOpaque(true);
		lblCdigo.setFont(new Font("Arial", Font.BOLD, 17));
		lblCdigo.setBounds(10, 74, 146, 30);
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Arial", Font.BOLD, 17));
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(163, 74, 146, 30);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(20, 124, 96, 20);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(114, 122, 346, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblApellido.setBounds(20, 154, 96, 20);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		txtApellido.addKeyListener(this);
		txtApellido.setBounds(114, 153, 346, 26);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		lblDni = new JLabel("DNI        :");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDni.setBounds(20, 188, 96, 20);
		contentPane.add(lblDni);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(114, 185, 119, 26);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);

		lblEdad = new JLabel("Edad      :");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdad.setBounds(20, 218, 96, 20);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 17));
		txtEdad.addKeyListener(this);
		txtEdad.setBounds(114, 216, 119, 26);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		lblCelular = new JLabel("Celular   :");
		lblCelular.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCelular.setHorizontalAlignment(SwingConstants.LEFT);
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCelular.setBounds(20, 249, 96, 20);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCelular.addKeyListener(this);
		txtCelular.setBounds(114, 248, 119, 26);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		lblEstado = new JLabel("Estado    :");
		lblEstado.setAlignmentY(Component.TOP_ALIGNMENT);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEstado.setBounds(20, 280, 96, 20);
		contentPane.add(lblEstado);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 710, 180);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		tblAlumnos.setFont(new Font("Arial", Font.PLAIN, 15));
		tblAlumnos.addKeyListener(this);
		tblAlumnos.addMouseListener(this);
		tblAlumnos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumnos);

		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setAlignmentY(Component.TOP_ALIGNMENT);
		cboEstado.setFont(new Font("Arial", Font.BOLD, 17));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "registrado", "matriculado", "retirado" }));
		cboEstado.setBounds(114, 279, 119, 26);
		contentPane.add(cboEstado);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(new Color(112, 128, 144));
		btnNuevo.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnNuevo.setBackground(UIManager.getColor("activeCaption"));
		btnNuevo.setFocusable(false);
		btnNuevo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 325, 175, 55);
		contentPane.add(btnNuevo);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/img/adicionar_curso.png")));
		btnAdicionar.setForeground(new Color(112, 128, 144));
		btnAdicionar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnAdicionar.setBackground(UIManager.getColor("activeCaption"));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(188, 325, 175, 55);
		contentPane.add(btnAdicionar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/img/eliminar_curso.png")));
		btnEliminar.setForeground(new Color(112, 128, 144));
		btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnEliminar.setBackground(UIManager.getColor("activeCaption"));
		btnEliminar.setFocusable(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(366, 325, 175, 55);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/img/modificar_curso.png")));
		btnModificar.setForeground(new Color(112, 128, 144));
		btnModificar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnModificar.setBackground(UIManager.getColor("activeCaption"));
		btnModificar.setFocusable(false);
		btnModificar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(545, 325, 175, 55);
		contentPane.add(btnModificar);

		// ============================================================================
		// determinar las columnas de la tabla
		modeloAlumnos.addColumn("CÓDIGO");
		modeloAlumnos.addColumn("NOMBRES");
		modeloAlumnos.addColumn("APELLIDOS");
		modeloAlumnos.addColumn("DNI");
		modeloAlumnos.addColumn("EDAD");
		modeloAlumnos.addColumn("CELULAR");
		modeloAlumnos.addColumn("ESTADO");

		tblAlumnos.setModel(modeloAlumnos);// Enviar el objeto "modeloAlumnos" al JTable "tblAlumno"
		listado();
		nuevoAlumno();
		
		soloNumeros(txtDNI);
		soloNumeros(txtEdad);
		soloNumeros(txtCelular);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/img/AlumnosPortal.png")));
		lblNewLabel.setBackground(UIManager.getColor("textHighlight"));
		lblNewLabel.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 116, 710, 204);
		contentPane.add(lblNewLabel);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/img/cerrar.png")));
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerrar.setFocusable(false);
		btnCerrar.setBounds(574, 71, 146, 41);
		contentPane.add(btnCerrar);
		
	}
	/*============= MÉTODO LISTADO==================*/
	void listado() {
		modeloAlumnos.setRowCount(0);// Limpiar las filas del objeto
										// "modeloAlumnos"
		for (int i = 0; i < arAlumnos.tamaño(); i++) {
			Alumno a = arAlumnos.obtener(i);// Declarando un objeto de la clase
											// Alumno
			// Creando arrreglo lineal de clase object
			Object data[] = { a.getCodigoAlumno(), a.getNombres(), a.getApellidos(), a.getDni(), a.getEdad(),
					a.getCelular(), a.getEstado() };
			// Agregando fila al modelo "modeloAlumnos"
			modeloAlumnos.addRow(data);
		}
	}
	/*================== MÉTODO MOSTRAR DATOS =======================*/
	private void mostrarDatos(int fila) {
		if(fila != -1){
			String cod,nom,ape,dni,edad,cel,estad;
			cod=tblAlumnos.getValueAt(fila, 0).toString();
			nom=tblAlumnos.getValueAt(fila, 1).toString();
			ape=tblAlumnos.getValueAt(fila, 2).toString();
			dni=tblAlumnos.getValueAt(fila, 3).toString();
			edad=tblAlumnos.getValueAt(fila, 4).toString();
			cel=tblAlumnos.getValueAt(fila, 5).toString();
			estad=tblAlumnos.getValueAt(fila, 6).toString();
			//mostrando en interfaz
			txtCodigo.setText(cod);
			txtNombre.setText(nom);
			txtApellido.setText(ape);
			txtDNI.setText(dni);
			txtEdad.setText(edad);
			txtCelular.setText(cel);
			cboEstado.setSelectedIndex(Integer.valueOf(estad));
			txtDNI.setEnabled(false);
			cboEstado.setEnabled(false);
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
		nuevoAlumno();
	}
	private void nuevoAlumno() {
		txtCodigo.setText("" + arAlumnos.generarCodigo());
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		// activando el cursor
		txtNombre.requestFocus();
		txtDNI.setEnabled(true);
		cboEstado.setSelectedIndex(0);
		cboEstado.setEnabled(false);
	}

	/* ================================= BOTÓN ADICIONAR ======================================== */
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		adicionarAlumno();
	}
	private void adicionarAlumno() {
		// Paso 1: Declarando variables
		String nombre, apellido, dni;
		int codigo, edad, celular;

		codigo = getCodigo();
		nombre = getNombre();
		apellido = getApellido();
		dni = getDNI();
		edad = getEdad();
		celular = getCelular();
		//
		if (nombre == null || apellido == null || dni == null || edad == -1 || celular == -1) {
			return;
		}	
		else {
			// Confirmar proceso de adición
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "Desea adicionar", "SISTEMA", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				//restringiendo almacenamiento DNI
				Alumno bean = arAlumnos.buscarDNI(dni);
				if(bean == null){//El DNI no existe
					
				// Paso 2: crear un objeto
				Alumno a = new Alumno(codigo, nombre, apellido, dni, edad, celular, 0);

				// Paso 3: Adicionar a la tabla
				arAlumnos.addAlumnoTxt(Arrays.asList(a));
				arAlumnos.adicionar(a);

				// Paso 4: refrescar
				listado();
				}else{
					mensaje("Error DNI esta registrado");
				}
			}	
		}
	}
	private int getCelular() {
		int celular = -1;
		if(txtCelular.getText().length() ==0){
			mensaje("Ingresar número celular");
		}else{
			celular = Integer.parseInt(txtCelular.getText());
		}
		return celular;
	}
	private int getEdad() {
		int edad = -1;
		if(txtEdad.getText().length() ==0){
			mensaje("Ingresar edad");
		}
		else{
			edad = Integer.parseInt(txtEdad.getText());;
		}
		return edad;
	}
	private String getDNI() {
		String dni = null;
		if (!(txtDNI.getText().trim().length() == 8)) {
			mensaje("Ingresar DNI, debiendo contener 8 dígitos");
		}
		else {
			dni = txtDNI.getText();
		}
		return dni;
	}
	private String getApellido() {
		String ape = null;
		if (txtApellido.getText().trim().length() == 0) {
			mensaje("Ingresar Apellido");
		}
		else {
			ape = txtApellido.getText();
		}
		return ape;
	}
	private String getNombre() {
		String nom = null;
		if (txtNombre.getText().trim().length() == 0) {
			mensaje("Ingresar Nombre");
		}
		else {
			nom = txtNombre.getText();
		}
		return nom;
	}
	private int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	private int getEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	/* ========================================= BOTÓN ELIMINAR ======================================== */
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarAlumno();
	}
	private void eliminarAlumno() {
		Alumno a = arAlumnos.buscar(getCodigo());
		if(a==null)
		{
			mensaje("No existe un alumno con el codigo ".concat(txtCodigo.getText()));
			return;
		}
		if(a.getEstado() == 0){
			if(a != null ){//Alumno existe por código
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this,"Seguro de eliminar","Sistema",JOptionPane.YES_NO_OPTION);
					if( opcion == 0){
						arAlumnos.eliminar(a);
						arAlumnos.crearTxt(ArregloAlumnos.getLista());
						listado();
					}
			}
		}else{
			mensaje("Solo puede eliminar cuando su estado es 0 (registrado)");
		}
	}

	/* ============================================ BOTÓN MODIFICAR ============================================== */
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		//Paso 1: Buscar alumno por codigo
		Alumno a = arAlumnos.buscar(getCodigo());
		//Paso 2: Validar si el alumno existe
		if(a != null){//Alumno existe por código
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this,"Seguro de modificar","Sistema",JOptionPane.YES_NO_OPTION);
			if(opcion == 0){
				a.setNombres(getNombre());
				a.setApellidos(getApellido());
				a.setDni(getDNI());
				a.setEdad(getEdad());
				a.setCelular(getCelular());
				a.setEstado(getEstado());
				arAlumnos.crearTxt(ArregloAlumnos.getLista());
				listado();
			}
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
		if (arg0.getSource() == tblAlumnos) {
			mouseClickedTblAlumnos(arg0);
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
	protected void mouseClickedTblAlumnos(MouseEvent arg0) {
		int fila;
		fila = tblAlumnos.getSelectedRow();
		mostrarDatos(fila);
	}
	public void keyPressed(java.awt.event.KeyEvent arg0) {
	}
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == tblAlumnos) {
			keyReleasedTblAlumnos(arg0);
		}
	}
	protected void keyReleasedTblAlumnos(java.awt.event.KeyEvent arg0) {
		int fila;
		fila = tblAlumnos.getSelectedRow();
		mostrarDatos(fila);
	}
				
	/*================== EVENTOS DE JTextField ==================*/
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == txtCelular) {
			keyTypedTxtCelular(arg0);
		}
		if (arg0.getSource() == txtEdad) {
			keyTypedTxtEdad(arg0);
		}
		if (arg0.getSource() == txtDNI) {
			keyTypedTxtDNI(arg0);
		}
		if (arg0.getSource() == txtApellido) {
			keyTypedTxtApellido(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			keyTypedTxtNombre(arg0);
		}
	}
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
	protected void keyTypedTxtNombre(java.awt.event.KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if (Character.isDigit(c)) {
			arg0.consume();
			mensaje("Ingresar solo caracteres");
		}
	}
	protected void keyTypedTxtApellido(java.awt.event.KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if (Character.isDigit(c)) {
			arg0.consume();
			mensaje("Ingresar solo caracteres");
		}
	}
	protected void keyTypedTxtDNI(java.awt.event.KeyEvent arg0) {
		if (txtDNI.getText().length() >= 8) {
			arg0.consume();
		}
	}
	protected void keyTypedTxtEdad(java.awt.event.KeyEvent arg0) {
		if (txtEdad.getText().length() >= 2) {
			arg0.consume();
		}
	}
	protected void keyTypedTxtCelular(java.awt.event.KeyEvent arg0) {
		if (txtCelular.getText().length() >= 9) {
			arg0.consume();
		}
	}
	
}
