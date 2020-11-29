package entidad;

import java.io.Serializable;

public class Retiro implements Serializable {
	
	
	//Atributos privados
	private int numRetiro;
	private Matricula matricula;
	private String fecha;
	private String hora;
	//constructor
	public Retiro(int numRetiro, Matricula matricula, String fecha,String hora) {
		super();
		this.numRetiro = numRetiro;
		this.matricula = matricula;
		this.fecha = fecha;
		this.hora=hora;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	//métodos get and set
	public int getNumRetiro() {
		return numRetiro;
	}
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}
	
	
}
