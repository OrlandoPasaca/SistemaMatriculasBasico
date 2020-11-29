package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Alumno;

public class ArregloAlumnos {
	//declarar un arreglo de objeto (ArrayList)
	private static List<Alumno> lista;
	static
	{
		lista = new ArrayList<>();
	}
	//constructor
	public ArregloAlumnos(){
		File txtFile = new File("C:\\archivos\\estudiantes.txt");
		if(txtFile.exists())
		{
		getTxt();
		}
		else
		{
			System.out.print("No existe");
			lista.add(new Alumno(2020101010,"Juan José", "Huiza Huiza", "10625474", 43, 953659803, 0));
			lista.add(new Alumno(2020101011,"Marcos", "Herrera Tavero", "10629888", 34, 889598031, 0));
			lista.add(new Alumno(2020101012,"Lucia", "Perez Tarrillo", "10626789", 12, 779590031, 0));
			crearTxt(lista);
		}
		
	}
	public void crearTxt(List<Alumno> alumnos)
	{
		FileWriter flwriter=null;
		try
		{
		File dir = new File("C:\\archivos");
		dir.mkdir();
		flwriter = new FileWriter("C:\\archivos\\estudiantes.txt");
		BufferedWriter bfwriter = new BufferedWriter(flwriter);
		for(Alumno alumno:alumnos)
		{
			bfwriter.write(alumno.getCodigoAlumno()+","+alumno.getNombres()+","+alumno.getApellidos()+","+alumno.getDni()+","+alumno.getCelular()
			+","+alumno.getEdad()+","+alumno.getEstado()+"\n");
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
		lista=new ArrayList<>();
		File file = new File("C:\\archivos\\estudiantes.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);			
				delimitar.useDelimiter("\\s*,\\s*");
				Alumno alumno=new Alumno();
				alumno.setCodigoAlumno(Integer.valueOf(delimitar.next()));
				alumno.setNombres(delimitar.next());
				alumno.setApellidos(delimitar.next());
				alumno.setDni(delimitar.next());
				alumno.setCelular(Integer.valueOf(delimitar.next()));
				alumno.setEdad(Integer.valueOf(delimitar.next()));
				alumno.setEstado(Integer.valueOf(delimitar.next()));
				lista.add(alumno);
				delimitar.close();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void addAlumnoTxt(List<Alumno> alumnos)
	{
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("C:\\archivos\\estudiantes.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Alumno alumno : alumnos) {
				bfwriter.write(alumno.getCodigoAlumno()+","+alumno.getNombres()+","+alumno.getApellidos()+","+alumno.getDni()+","+alumno.getCelular()
				+","+alumno.getEdad()+","+alumno.getEstado());
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
	public static List<Alumno> getLista() {
		return lista;
	}
	public static void setLista(List<Alumno> lista) {
		ArregloAlumnos.lista = lista;
	}
	//método add: recibe un parámetro u objeto de la clase Alumno y lo adiciona
	public void adicionar(Alumno x){
		lista.add(x);
	}
	//método size: permite retornar la cantidad de objetos del arreglo
	public int tamaño(){
		return lista.size();
	}
	//método que recibe como parametros una posición y retorna el objeto que se encuentra en dicha posición 
	public Alumno obtener(int i){
		return lista.get(i);
	}
	//generar código correlativo 202010001
	public int generarCodigo(){
		if(lista.size() == 0){
			return 202020001;
		}else{
			return lista.get(lista.size()-1).getCodigoAlumno()+1;
		}
	}
	//método para buscar, que recibe un parámetro del código de un alumno que existe donde retorna al alumno.
	public Alumno buscar(int cod){
		for(int i = 0 ; i < lista.size() ; i++){
			if(lista.get(i).getCodigoAlumno() == cod)
				return lista.get(i);
		}
		return null;
	}
	//método eliminar que recibe como parámetro un objeto de la clase Alumno y lo elimine
	public void eliminar(Alumno a){
		lista.remove(a);
	}
	//método buscar DNI que recibe como parámetro el DNI de un alumno, si existe retorna el Alumno, caso contrario retorna null
	public Alumno buscarDNI(String dni){
		for(int i = 0 ; i < lista.size() ; i++){
			if(lista.get(i).getDni().equals(dni))
				return lista.get(i);
		}
		return null;
	}
	public List<Alumno> findAlumnoByEstado(int estado)
	{
		List<Alumno> alumnos=new ArrayList<>();
		for(Alumno alum:lista)
		{
			if(alum.getEstado()==estado)
			alumnos.add(alum);
		}
		return alumnos;
	}
}
