package entidad;

public class Alumno {
	//atributos privados
	private int codigoAlumno;
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	private int celular;
	private int estado;
	//constructor
	public Alumno(int codigoAlumno, String nombres, String apellidos, String dni, int edad,int celular, int estado) {
		super();
		this.codigoAlumno = codigoAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}
	public Alumno()
	{
		
	}
	//métodos get and set
	public int getCodigoAlumno() {
		return codigoAlumno;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {
		return dni;
	}
	public int getEdad() {
		return edad;
	}
	public int getCelular() {
		return celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
