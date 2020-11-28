package entidad;

public class Curso {
	//atributos privados
	private int codCurso;
	private String asignatura;
	private int ciclo;
	private int creditos;
	private int horas;
	//constructor
	public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas) {
		super();
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}
	//métodos get and set
	public int getCodCurso() {
		return codCurso;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public int getCiclo() {
		return ciclo;
	}
	public int getCreditos() {
		return creditos;
	}
	public int getHoras() {
		return horas;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
}
