package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Curso;

public class ArregloCursos {
	private static List<Curso> c;
	static
	{
		c = new ArrayList<>();
	}
	//constructor
	public ArregloCursos(){

		File txtFile = new File("C:\\archivos\\cursos.txt");
		if(txtFile.exists())
		getTxt();
		else
		{
			c.add(new Curso(1814, "Algoritmos y Estructura de Datos", 2, 4, 72));
			c.add(new Curso(2349, "Base de Datos", 3, 3, 72));
			c.add(new Curso(2317, "Fundamentos de Gestión Empresarial", 4, 2, 60));
			c.add(new Curso(2924, "Introducción a la Algoritmia", 1, 3, 72));
			crearTxt(c);
			
		}
	}
	public void crearTxt(List<Curso> cursos)
	{
		FileWriter flwriter=null;
		try
		{
		File dir = new File("C:\\archivos");
		dir.mkdir();
		flwriter = new FileWriter("C:\\archivos\\cursos.txt");
		BufferedWriter bfwriter = new BufferedWriter(flwriter);
		for(Curso curso:cursos)
		{
			bfwriter.write(curso.getCodCurso()+","+curso.getAsignatura()+","+curso.getCreditos()+","+curso.getCiclo()+","+curso.getHoras()+"\n");
		}
		bfwriter.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}}
	}
	public void getTxt()
	{
		c=new ArrayList<>();
		File file = new File("C:\\archivos\\cursos.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);			
				delimitar.useDelimiter("\\s*,\\s*");
				Curso curso=new Curso();
				curso.setCodCurso(Integer.valueOf(delimitar.next()));
				curso.setAsignatura(delimitar.next());
				curso.setCreditos(Integer.valueOf(delimitar.next()));
				curso.setCiclo(Integer.valueOf(delimitar.next()));
				curso.setHoras(Integer.valueOf(delimitar.next()));
				c.add(curso);
				delimitar.close();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void addCursoTxt(List<Curso> cursos)
	{
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("C:\\archivos\\cursos.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Curso curso : cursos) {
				bfwriter.write(curso.getCodCurso()+","+curso.getAsignatura()+","+curso.getCreditos()+","+curso.getCiclo()+","+curso.getHoras()+"\n");
			}
			bfwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	public static List<Curso> getC() {
		return c;
	}
	public static void setC(List<Curso> c) {
		ArregloCursos.c = c;
	}
	//métodos básicos
	public void adicionar(Curso x){
		c.add(x);
	}
	public int tamaño(){
		return c.size();
	}
	public Curso obtener(int i){
		return c.get(i);
	}
	//Operaciones públicas
	public Curso buscarCodigo(int cod){
		for(int i = 0 ; i < c.size() ; i++){
			if(c.get(i).getCodCurso()==cod)
				return c.get(i);
		}
		return null;
	}
	public Curso findByAsignatura(String asignatura)
	{
		Curso curso=null;
		for(Curso curs:c)
		{
			if(curs.getAsignatura().equals(asignatura))
			{
				curso=curs;
			}
		}
		return curso;
	}
}
