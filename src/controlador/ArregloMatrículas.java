package controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

public class ArregloMatrículas {
	private static List<Matricula> mat;
	static
	{
		LocalDateTime hoy=LocalDateTime.now();
		String fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(hoy);
		String hora = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH).format(hoy);
		mat = new ArrayList<>();
		mat.add(new Matricula(10001,ArregloAlumnos.getLista().get(0) ,ArregloCursos.getC().get(0), fecha, hora));
		mat.add(new Matricula(10002,ArregloAlumnos.getLista().get(1) ,ArregloCursos.getC().get(1), fecha, hora));
		mat.add(new Matricula(10003,ArregloAlumnos.getLista().get(2) ,ArregloCursos.getC().get(2), fecha, hora));
	}
	//Constructor
	public ArregloMatrículas(){
		
	}
	
	public static List<Matricula> getMat() {
		return mat;
	}

	public static void setMat(List<Matricula> mat) {
		ArregloMatrículas.mat = mat;
	}

	//métodos básicos
	public void adicionar(Matricula x){
		mat.add(x);
	}
	public int tamaño(){
		return mat.size();
	}
	public Matricula obtener(int i){
		return mat.get(i);
	}
	
	public int generarCodigo(){
		if(mat.size() == 0){
			return 100001;
		}else{
			return mat.get(mat.size()-1).getNumMatricula()+1;
		}
	}
	
	public Matricula buscar(int cod){
		for(int i = 0 ; i < mat.size() ; i++){
			if(mat.get(i).getNumMatricula() == cod)
				return mat.get(i);
		}
		return null;
	}
	public Alumno findAlumnoByCodigo(int cod)
	{
		Alumno alumno=null;
		for(Matricula matricula:mat)
		{
			if(matricula.getAlumno().getCodigoAlumno()==cod)
			{
				alumno=matricula.getAlumno();
			}
		}
		return alumno;
	}
	public Matricula findMatriculaByCodigo(int cod)
	{
		Matricula matricula=null;
		for(int x=0;x<mat.size();x++)
		{
			if(mat.get(x).getNumMatricula()==cod)
			{
				matricula=mat.get(x);
			}
		}
		return matricula;
	}
	public List<Alumno> findMatriculaAlumnoByCurso(Curso curso)
	{
		List<Alumno> listAlumno=new ArrayList<>();
		for(Matricula matricula:mat)
		{
			if(matricula.getCurso()==curso)
			{
				listAlumno.add(matricula.getAlumno());
			}
		}
		return listAlumno;
	}
	public Matricula findMatriculaByAlumno(Alumno alumno)
	{
		Matricula matricula=null;
		for(Matricula matr:mat)
		{
			if(matr.getAlumno()==alumno)
			{
				matricula=matr;
			}
		}
		return matricula;
	}
}
