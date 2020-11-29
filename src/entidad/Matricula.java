package entidad;

import java.io.Serializable;

public class Matricula implements Serializable {
	
	
	//atributos privados
	private int numMatricula;
	private Alumno alumno;
	private Curso curso;
	private String fecha;
	private String hora;
	//constructor 
	public Matricula(int numMatricula, Alumno alumno, Curso curso, String fecha,String hora) {
		super();
		this.numMatricula = numMatricula;
		this.alumno = alumno;
		this.curso = curso;
		this.fecha = fecha;
		this.hora= hora;
	}
	//métodos get and set
	public int getNumMatricula() {
		return numMatricula;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
