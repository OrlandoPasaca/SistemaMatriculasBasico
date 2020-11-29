package controlador;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

public class ArregloMatrículas {
	private static List<Matricula> mat;
	static
	{
		mat=new ArrayList<>();
	}
	//Constructor
	public ArregloMatrículas(){
		File datFile = new File("C:\\archivos\\arreglo-matriculas.dat");
		if(datFile.exists())
		getDat();
	}
	public void crearDat(List<Matricula> matriculas)
	{
		FileOutputStream fileOutputStream=null;
		try
		{
		fileOutputStream=new FileOutputStream("C:\\archivos\\arreglo-matriculas.dat");
		ObjectOutputStream ficheroMatriculas= new ObjectOutputStream(fileOutputStream);
		ficheroMatriculas.writeObject(mat);
		ficheroMatriculas.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}}
	}
	@SuppressWarnings("unchecked")
	public void getDat()
	{
		mat=new ArrayList<>();
	
		try {
			FileInputStream fileOutputStream=new FileInputStream("C:\\archivos\\arreglo-matriculas.dat");
			ObjectInputStream ficheroMatriculas= new ObjectInputStream(fileOutputStream);
			mat=(List<Matricula>)ficheroMatriculas.readObject();
			fileOutputStream.close();
			ficheroMatriculas.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
			if(matricula.getCurso().getCodCurso()==curso.getCodCurso())
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
