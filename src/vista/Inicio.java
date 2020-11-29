package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloCursos;
import controlador.ArregloMatrículas;
import controlador.ArregloRetiros;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Inicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmMatrcula;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCurso_1;
	private JMenuItem mntmMatrculas;
	private JMenuItem mntmRetiros;
	private JMenuItem mntmAlumnosMatrculaPendiente;
	private JMenuItem mntmAlumnosMatrculaPendiente_1;
	private JMenuItem mntmAlumnosMatrculadosPor;
	private JMenu mnSalir;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JMenuItem mntmExit;
	private JLabel lblInttegrantes;
	private JLabel lblGuillermoGustavoApolaya;
	private JLabel lblJuanJosHuiza;
	private JLabel lblManuelCalebCarbajal;
	private JLabel lblOrlandoEnriquePasaca;
	ArregloAlumnos alumnos=new ArregloAlumnos();
	ArregloCursos cursos=new ArregloCursos();
	ArregloMatrículas matriculas= new ArregloMatrículas();
	ArregloRetiros retiros= new ArregloRetiros();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/img/colegio.png")));
		setTitle("Sistema de Registro y Matr\u00EDcula de Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 580);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(Inicio.class.getResource("/img/system_maintenance_15367.png")));
		mnMantenimiento.setHorizontalTextPosition(SwingConstants.CENTER);
		mnMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		mnMantenimiento.setBorder(new LineBorder(SystemColor.control));
		mnMantenimiento.setPreferredSize(new Dimension(180, 65));
		mnMantenimiento.setForeground(SystemColor.menu);
		mnMantenimiento.setFont(new Font("Century Gothic", Font.BOLD, 17));
		mnMantenimiento.setBackground(SystemColor.textHighlight);
		mnMantenimiento.setOpaque(true);
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mntmAlumno.setPreferredSize(new Dimension(180, 35));
		mntmAlumno.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmAlumno.setOpaque(true);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mntmCurso.setPreferredSize(new Dimension(180, 35));
		mntmCurso.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmCurso.setOpaque(true);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon(Inicio.class.getResource("/img/safety_reader_card_10784.png")));
		mnRegistro.setBorder(new LineBorder(SystemColor.control));
		mnRegistro.setPreferredSize(new Dimension(180, 35));
		mnRegistro.setForeground(SystemColor.menu);
		mnRegistro.setFont(new Font("Century Gothic", Font.BOLD, 17));
		mnRegistro.setBackground(SystemColor.textHighlight);
		mnRegistro.setOpaque(true);
		menuBar.add(mnRegistro);
		
		mntmMatrcula = new JMenuItem("Matr\u00EDcula");
		mntmMatrcula.addActionListener(this);
		mntmMatrcula.setPreferredSize(new Dimension(180, 35));
		mntmMatrcula.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmMatrcula.setOpaque(true);
		mnRegistro.add(mntmMatrcula);
		
		mntmRegistro = new JMenuItem("Retiro");
		mntmRegistro.addActionListener(this);
		mntmRegistro.setPreferredSize(new Dimension(180, 35));
		mntmRegistro.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmRegistro.setOpaque(true);
		mnRegistro.add(mntmRegistro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(Inicio.class.getResource("/img/consultar.png")));
		mnConsulta.setBorder(new LineBorder(SystemColor.control));
		mnConsulta.setPreferredSize(new Dimension(180, 35));
		mnConsulta.setForeground(SystemColor.menu);
		mnConsulta.setFont(new Font("Century Gothic", Font.BOLD, 17));
		mnConsulta.setBackground(SystemColor.textHighlight);
		mnConsulta.setOpaque(true);
		menuBar.add(mnConsulta);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.addActionListener(this);
		mntmAlumnos.setPreferredSize(new Dimension(180, 35));
		mntmAlumnos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmAlumnos.setOpaque(true);
		mnConsulta.add(mntmAlumnos);
		
		mntmCurso_1 = new JMenuItem("Curso");
		mntmCurso_1.addActionListener(this);
		mntmCurso_1.setPreferredSize(new Dimension(180, 35));
		mntmCurso_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmCurso_1.setOpaque(true);
		mnConsulta.add(mntmCurso_1);
		
		mntmMatrculas = new JMenuItem("Matr\u00EDculas");
		mntmMatrculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaMatriculas consultMatr = new FrmConsultaMatriculas();
				consultMatr.setVisible(true);
			}
		});
		mntmMatrculas.setPreferredSize(new Dimension(180, 35));
		mntmMatrculas.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmMatrculas.setOpaque(true);
		mnConsulta.add(mntmMatrculas);
		
		mntmRetiros = new JMenuItem("Retiros");
		mntmRetiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaRetiros consultRetiros = new FrmConsultaRetiros();
				consultRetiros.setVisible(true);
			}
		});
		mntmRetiros.setPreferredSize(new Dimension(180, 35));
		mntmRetiros.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mntmRetiros.setOpaque(true);
		mnConsulta.add(mntmRetiros);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(Inicio.class.getResource("/img/reporte.png")));
		mnReporte.setBorder(new LineBorder(SystemColor.control));
		mnReporte.setPreferredSize(new Dimension(180, 35));
		mnReporte.setForeground(SystemColor.menu);
		mnReporte.setFont(new Font("Century Gothic", Font.BOLD, 17));
		mnReporte.setBackground(SystemColor.textHighlight);
		mnReporte.setOpaque(true);
		menuBar.add(mnReporte);
		
		mntmAlumnosMatrculaPendiente = new JMenuItem("Alumnos Matr\u00EDcula Pendiente");
		mntmAlumnosMatrculaPendiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 FrmReporteMatrPendiente frmreporteMatrPend= new FrmReporteMatrPendiente();
			 frmreporteMatrPend.setVisible(true);
			}
		});
		mntmAlumnosMatrculaPendiente.setPreferredSize(new Dimension(280, 35));
		mntmAlumnosMatrculaPendiente.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mnReporte.add(mntmAlumnosMatrculaPendiente);
		
		mntmAlumnosMatrculaPendiente_1 = new JMenuItem("Alumnos Matr\u00EDcula Vigente");
		mntmAlumnosMatrculaPendiente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmReporteMatrVigente frmReportMatrVig=new FrmReporteMatrVigente();
				frmReportMatrVig.setVisible(true);
				
			}
		});
		mntmAlumnosMatrculaPendiente_1.setPreferredSize(new Dimension(280, 35));
		mntmAlumnosMatrculaPendiente_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mnReporte.add(mntmAlumnosMatrculaPendiente_1);
		
		mntmAlumnosMatrculadosPor = new JMenuItem("Alumnos Matr\u00EDculados por Curso");
		mntmAlumnosMatrculadosPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmReporteMatrXCurso frmReporteMatrXCurso=new FrmReporteMatrXCurso();
				frmReporteMatrXCurso.setVisible(true);
			}
		});
		mntmAlumnosMatrculadosPor.setPreferredSize(new Dimension(280, 35));
		mntmAlumnosMatrculadosPor.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		mnReporte.add(mntmAlumnosMatrculadosPor);
		
		mnSalir = new JMenu("Salir");
		mnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/img/salir2.png")));
		mnSalir.setForeground(new Color(245, 255, 250));
		mnSalir.setOpaque(true);
		mnSalir.setBackground(new Color(0, 0, 0));
		mnSalir.setFont(new Font("Century Gothic", Font.BOLD, 17));
		mnSalir.setPreferredSize(new Dimension(180, 35));
		menuBar.add(mnSalir);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		mntmExit.setPreferredSize(new Dimension(175, 35));
		mntmExit.addActionListener(this);
		mnSalir.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Inicio.class.getResource("/img/titulo1-removebg-preview.png")));
		label.setBounds(321, 62, 299, 67);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Inicio.class.getResource("/img/titulo2.png")));
		label_1.setBounds(211, 112, 443, 56);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Inicio.class.getResource("/img/coollogo_com-280391327-removebg-preview.png")));
		label_2.setBounds(305, 169, 228, 56);
		contentPane.add(label_2);
		
		lblInttegrantes = new JLabel("INTEGRANTES: ");
		lblInttegrantes.setForeground(new Color(105, 105, 105));
		lblInttegrantes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInttegrantes.setBounds(232, 246, 164, 47);
		contentPane.add(lblInttegrantes);
		
		lblGuillermoGustavoApolaya = new JLabel("- Guillermo Gustavo, APOLAYA ROSALES");
		lblGuillermoGustavoApolaya.setForeground(new Color(105, 105, 105));
		lblGuillermoGustavoApolaya.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblGuillermoGustavoApolaya.setBounds(232, 274, 301, 47);
		contentPane.add(lblGuillermoGustavoApolaya);
		
		lblJuanJosHuiza = new JLabel("- Juan Jos\u00E9, HUIZA HUIZA");
		lblJuanJosHuiza.setForeground(new Color(105, 105, 105));
		lblJuanJosHuiza.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblJuanJosHuiza.setBounds(232, 295, 256, 47);
		contentPane.add(lblJuanJosHuiza);
		
		lblManuelCalebCarbajal = new JLabel("- Manuel Caleb, CARBAJAL VILLACORTA");
		lblManuelCalebCarbajal.setForeground(new Color(105, 105, 105));
		lblManuelCalebCarbajal.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblManuelCalebCarbajal.setBounds(232, 319, 301, 47);
		contentPane.add(lblManuelCalebCarbajal);
		
		lblOrlandoEnriquePasaca = new JLabel("- Orlando Enrique, PASACA ROJAS");
		lblOrlandoEnriquePasaca.setForeground(new Color(105, 105, 105));
		lblOrlandoEnriquePasaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOrlandoEnriquePasaca.setBounds(232, 346, 301, 47);
		contentPane.add(lblOrlandoEnriquePasaca);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCurso_1) {
			actionPerformedMntmCurso_1(e);
		}
		if (e.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(e);
		}
		if (e.getSource() == mntmRegistro) {
			actionPerformedMntmRegistro(e);
		}
		if (e.getSource() == mntmMatrcula) {
			actionPerformedMntmMatrcula(e);
		}
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmExit) {
			actionPerformedMntmExit(e);
		}
	}
	protected void actionPerformedMntmExit(ActionEvent e) {
	System.exit(0);
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		FrmMantenimientoAlumno manAlu = new FrmMantenimientoAlumno();
		manAlu.setLocationRelativeTo(this);
		manAlu.setVisible(true);
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		FrmMantenimientoCurso manCur = new FrmMantenimientoCurso();
		manCur.setLocationRelativeTo(this);
		manCur.setVisible(true);
	}
	protected void actionPerformedMntmMatrcula(ActionEvent e) {
		FrmRegistroMatriculas regMat = new FrmRegistroMatriculas();
		regMat.setLocationRelativeTo(this);
		regMat.setVisible(true);
	}
	protected void actionPerformedMntmRegistro(ActionEvent e) {
		FrmRegistroRetiro regRet = new FrmRegistroRetiro();
		regRet.setLocationRelativeTo(this);
		regRet.setVisible(true);
	}
	protected void actionPerformedMntmAlumnos(ActionEvent e) {
		FrmConsultaAlumnos conAlu = new FrmConsultaAlumnos();
		conAlu.setLocationRelativeTo(this);
		conAlu.setVisible(true);
	}
	protected void actionPerformedMntmCurso_1(ActionEvent e) {
		FrmConsultaCursos conCursos = new FrmConsultaCursos();
		conCursos.setLocationRelativeTo(this);
		conCursos.setVisible(true);
	}
}
