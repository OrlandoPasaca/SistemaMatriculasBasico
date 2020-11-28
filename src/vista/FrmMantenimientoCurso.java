package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCursos;
import controlador.ArregloMatrículas;
import controlador.ArregloRetiros;
import entidad.Alumno;
import entidad.Curso;
//import javafx.scene.input.KeyEvent;
//import jdk.nashorn.internal.scripts.JO;
import entidad.Retiro;

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
import javax.naming.directory.ModificationItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Component;

@SuppressWarnings("unused")
public class FrmMantenimientoCurso extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoDeCursos;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblAsignatura;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblCiclo;
	private JComboBox<?> cboCiclo;
	private JTable tblCursos;
	private JScrollPane scrollPane;

	// Clase modelo para determinar las columnas y filas de la tabla
	DefaultTableModel modeloCursos = new DefaultTableModel();

	// creando nuevo objeto de ArregloAlumnos
	ArregloCursos arCursos = new ArregloCursos();
	ArregloRetiros arrRetiros= new ArregloRetiros();
	ArregloMatrículas arrMatriculas= new ArregloMatrículas();

	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCerrar;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoCurso frame = new FrmMantenimientoCurso();
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
	public FrmMantenimientoCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMantenimientoCurso.class.getResource("/img/Books_icon-icons.com_76879.png")));
		setTitle("Mantenimiento | Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoDeCursos = new JLabel("MANTENIMIENTO DE CURSOS");
		lblMantenimientoDeCursos.setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
		lblMantenimientoDeCursos.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblMantenimientoDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeCursos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMantenimientoDeCursos.setBackground(new Color(0, 0, 128));
		lblMantenimientoDeCursos.setForeground(UIManager.getColor("Button.highlight"));
		lblMantenimientoDeCursos.setOpaque(true);
		lblMantenimientoDeCursos.setBounds(10, 16, 710, 51);
		contentPane.add(lblMantenimientoDeCursos);

		lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setForeground(new Color(245, 255, 250));
		lblCdigo.setBackground(new Color(0, 0, 0));
		lblCdigo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setOpaque(true);
		lblCdigo.setFont(new Font("Arial", Font.BOLD, 17));
		lblCdigo.setBounds(10, 74, 120, 30);
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.addKeyListener(this);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Arial", Font.BOLD, 17));
		txtCodigo.setBounds(137, 74, 136, 30);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblAsignatura = new JLabel("Asignatura :");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAsignatura.setBounds(30, 134, 108, 20);
		contentPane.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.addKeyListener(this);
		txtAsignatura.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAsignatura.setBounds(137, 131, 439, 26);
		contentPane.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCiclo.setBounds(30, 170, 108, 20);
		contentPane.add(lblCiclo);
		
		cboCiclo = new JComboBox();
		cboCiclo.setAlignmentY(Component.TOP_ALIGNMENT);
		cboCiclo.setFont(new Font("Arial", Font.BOLD, 17));
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"primero", "segundo", "tercero", "cuarto", "quinto", "sexto"}));
		cboCiclo.setBounds(137, 170, 136, 26);
		contentPane.add(cboCiclo);

		lblCreditos = new JLabel("N\u00B0 Cr\u00E9ditos:");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCreditos.setBounds(30, 208, 108, 20);
		contentPane.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCreditos.addKeyListener(this);
		txtCreditos.setBounds(137, 205, 136, 26);
		contentPane.add(txtCreditos);
		txtCreditos.setColumns(10);

		lblHoras = new JLabel("Cant. Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHoras.setBounds(30, 257, 108, 20);
		contentPane.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Arial", Font.PLAIN, 17));
		txtHoras.addKeyListener(this);
		txtHoras.setBounds(137, 254, 136, 26);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 385, 710, 180);
		contentPane.add(scrollPane);

		tblCursos = new JTable();
		tblCursos.setFont(new Font("Arial", Font.PLAIN, 15));
		tblCursos.addKeyListener(this);
		tblCursos.addMouseListener(this);
		tblCursos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCursos);
		
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
		btnAdicionar.setIcon(new ImageIcon(FrmMantenimientoCurso.class.getResource("/img/adicionar_curso.png")));
		btnAdicionar.setForeground(new Color(112, 128, 144));
		btnAdicionar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnAdicionar.setBackground(UIManager.getColor("activeCaption"));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(188, 325, 175, 55);
		contentPane.add(btnAdicionar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoCurso.class.getResource("/img/eliminar_curso.png")));
		btnEliminar.setForeground(new Color(112, 128, 144));
		btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnEliminar.setBackground(UIManager.getColor("activeCaption"));
		btnEliminar.setFocusable(false);
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(366, 325, 175, 55);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmMantenimientoCurso.class.getResource("/img/modificar_curso.png")));
		btnModificar.setForeground(new Color(112, 128, 144));
		btnModificar.setBorder(new LineBorder(new Color(192, 192, 192), 3, true));
		btnModificar.setBackground(UIManager.getColor("activeCaption"));
		btnModificar.setFocusable(false);
		btnModificar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(545, 325, 175, 55);
		contentPane.add(btnModificar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(FrmMantenimientoCurso.class.getResource("/img/cerrar.png")));
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCerrar.setFocusable(false);
		btnCerrar.setBounds(574, 73, 146, 41);
		contentPane.add(btnCerrar);

		// ============================================================================
		// determinar las columnas de la tabla
		modeloCursos.addColumn("CÓDIGO");
		modeloCursos.addColumn("ASIGNATURA");
		modeloCursos.addColumn("CICLO");
		modeloCursos.addColumn("CRÉDITOS");
		modeloCursos.addColumn("HORAS");
		
		tblCursos.setModel(modeloCursos);// Enviar el objeto "modeloCursos" al JTable "tblCursos"
		listado();
		nuevoCurso();
		
		soloNumeros(txtCodigo);
		soloNumeros(txtCreditos);
		soloNumeros(txtHoras);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(FrmMantenimientoCurso.class.getResource("/img/curso5.png")));
		label.setOpaque(true);
		label.setBackground(UIManager.getColor("textHighlight"));
		label.setBounds(10, 120, 710, 180);
		contentPane.add(label);
				
	}
	/*============= MÉTODO LISTADO==================*/
	void listado() {
		modeloCursos.setRowCount(0);// Limpiar las filas del objeto
										// "modeloCursos"
		for (int i = 0; i < arCursos.tamaño(); i++) {
			Curso cur = arCursos.obtener(i);// Declarando un objeto de la clase Curso
			// Creando arrreglo lineal de clase object
			Object data[] = { cur.getCodCurso(),cur.getAsignatura(),cur.getCiclo(),cur.getCreditos(),cur.getHoras() };
			// Agregando fila al modelo "modeloCursos"
			modeloCursos.addRow(data);
		}
	}
	/*================== MÉTODO MOSTRAR DATOS =======================*/
	private void mostrarDatos(int fila) {
		if(fila != -1){
			String cod,asig,ciclo,cred,hora;
			cod=tblCursos.getValueAt(fila, 0).toString();
			asig=tblCursos.getValueAt(fila, 1).toString();
			ciclo=tblCursos.getValueAt(fila, 2).toString();
			cred=tblCursos.getValueAt(fila, 3).toString();
			hora=tblCursos.getValueAt(fila, 4).toString();
			
			//mostrando en interfaz
			txtCodigo.setText(cod);
			txtAsignatura.setText(asig);
			cboCiclo.setSelectedItem(ciclo);
			txtCreditos.setText(cred);
			txtHoras.setText(hora);
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
		Integer codCurso=getCodigo();
		Curso curso=arCursos.buscarCodigo(codCurso);
		if(curso==null)
		{
			mensaje("No existe el codigo de retiro"+codCurso);
			return;
		}
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el curso con codigo ".concat(String.valueOf(codCurso)), "SISTEMA", JOptionPane.YES_NO_OPTION);
		if (opcion == 0){
			boolean isPosibleDelete=true;
			List<Alumno> listAlumno=new ArrayList<>();
			listAlumno=arrMatriculas.findMatriculaAlumnoByCurso(curso);
			for(Alumno alumno:listAlumno)
			{
				if(alumno.getEstado()==1)
				{
					mensaje("Hay un alumno que esta matriculado en este curso, por lo tanto no puede eliminar este curso");
					isPosibleDelete=false;
					break;
				}
			}
			if(!isPosibleDelete)
			{
				return;
			}
			ArregloCursos.getC().remove(curso);
			listado();
			nuevoCurso();
		}
		
		
		
		
	}
	/* ==================================== BOTÓN NUEVO ======================================= */
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		nuevoCurso();
	}
	private void nuevoCurso() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		// activando el cursor
		txtCodigo.requestFocus();
		txtCodigo.setEnabled(true);
	}

	/* ================================= BOTÓN ADICIONAR ======================================== */
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		adicionarCurso();
	}
	private void adicionarCurso() {
		// Paso 1: Declarando variables
		String asignatura;
		int codigo, credito, hora,ciclo;

		codigo = getCodigo();
		if(codigo==-1)
		return;
		asignatura = getAsignatura();
		ciclo = getCiclo();
		credito = getCredito();
		hora = getHora();
		//
		if (asignatura == null ||  credito == -1 || hora == -1) {
			return;
		}else {
			// Confirmar proceso de adición
			Curso asig=arCursos.findByAsignatura(txtAsignatura.getText().trim());
			if(asig!=null)
			{
				mensaje("La asignatura ya fue registrada");
				return;
			}
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "Desea adicionar", "SISTEMA", JOptionPane.YES_NO_OPTION);
			if (opcion == 0){
				//restringiendo almacenamiento DNI
				Curso bean = arCursos.buscarCodigo(codigo);
				if(bean == null){//El DNI no existe
				//Paso 2: crear un objeto
				Curso a = new Curso(codigo, asignatura, ciclo, credito,hora);
				// Paso 3: Adicionar a la tabla
				arCursos.adicionar(a);
				// Paso 4: refrescar
				listado();
				}else{
					mensaje("Error CÓDIGO esta registrado");
				}
			}	
		}
	}
	private int getHora() {
		int h = -1;
		if(txtHoras.getText().length() ==0){
			mensaje("Ingresar cantidad de hora");
		}else{
			h = Integer.parseInt(txtHoras.getText());
		}
		return h;
	}
	private int getCredito() {
		int cred = -1;
		if(txtCreditos.getText().length() ==0){
			mensaje("Ingresar número de créditos");
		}
		else{
			cred = Integer.parseInt(txtCreditos.getText());;
		}
		return cred;
	}
	private String getAsignatura() {
		String asig = null;
		if (txtAsignatura.getText().trim().length() == 0) {
			mensaje("Ingresar Asignatura");
		}
		else {
			asig = txtAsignatura.getText();
		}
		return asig;
	}
	private int getCodigo() {
		try
		{
		return Integer.parseInt(txtCodigo.getText());
		}
		catch (Exception e) {
			mensaje("Ingrese Codigo");
		}
		return -1;
	}
	private int getCiclo() {
		return cboCiclo.getSelectedIndex();
	}
	
	/* ========================================= BOTÓN ELIMINAR ======================================== */
	/*protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarCurso();
	}
	private void eliminarCurso() {
		
		
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
		modificarCurso();
	}
	private void modificarCurso() {
		//Paso 1: Buscar curso por codigo
		Curso c = arCursos.buscarCodigo(getCodigo());
		//Paso 2: Validar si curso existe
		if(c != null){//Curso existe por código
			
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this,"Seguro de modificar","Sistema",JOptionPane.YES_NO_OPTION);
			if(opcion == 0){
					c.setCodCurso(getCodigo());
					c.setAsignatura(getAsignatura());
					c.setCiclo(getCiclo());
					c.setCreditos(getCredito());
					c.setHoras(getHora());
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
		if (arg0.getSource() == tblCursos) {
			mouseClickedTblCursos(arg0);
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
	protected void mouseClickedTblCursos(MouseEvent arg0) {
		int fila;
		fila = tblCursos.getSelectedRow();
		txtCodigo.setEnabled(false);
		mostrarDatos(fila);
	}
	public void keyPressed(java.awt.event.KeyEvent arg0) {
	}
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == tblCursos) {
			keyReleasedTblCursos(arg0);
		}
	}
	protected void keyReleasedTblCursos(java.awt.event.KeyEvent arg0) {
		int fila;
		fila = tblCursos.getSelectedRow();
		mostrarDatos(fila);
	}

	/*================== EVENTOS DE JTextField ==================*/
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		if (arg0.getSource() == txtHoras) {
			keyTypedTxtHoras(arg0);
		}
		if (arg0.getSource() == txtCreditos) {
			keyTypedTxtCreditos(arg0);
		}
		if (arg0.getSource() == txtAsignatura) {
			keyTypedTxtAsignatura(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}
	
	public void soloNumeros(JTextField c){
		c.addKeyListener(new KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent arg0){
				char c = arg0.getKeyChar();
				if(!Character.isDigit(c)){
					arg0.consume();
				}
			}
		});
	}
	protected void keyTypedTxtCodigo(java.awt.event.KeyEvent arg0) {
		if(txtCodigo.getText().length() >= 4){
			arg0.consume();
		}
	}
	protected void keyTypedTxtCreditos(java.awt.event.KeyEvent arg0) {
		if(txtCreditos.getText().length() >= 1){
			arg0.consume();
		}
	}
	protected void keyTypedTxtHoras(java.awt.event.KeyEvent arg0) {
		if(txtHoras.getText().length() >= 2){
			arg0.consume();
		}
	}
	protected void keyTypedTxtAsignatura(java.awt.event.KeyEvent arg0) {
		char c = arg0.getKeyChar();
		if (Character.isDigit(c)) {
			arg0.consume();
			mensaje("Ingresar solo caracteres");
		}
	}
}
