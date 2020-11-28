package controlador;

import java.util.ArrayList;
import java.util.List;

import entidad.Curso;

public class ArregloCursos {
	private static List<Curso> c;
	static
	{
		c = new ArrayList<>();
		c.add(new Curso(1814, "Algoritmos y Estructura de Datos", 2, 4, 72));
		c.add(new Curso(2349, "Base de Datos", 3, 3, 72));
		c.add(new Curso(2317, "Fundamentos de Gestión Empresarial", 4, 2, 60));
		c.add(new Curso(2924, "Introducción a la Algoritmia", 1, 3, 72));
	}
	//constructor
	public ArregloCursos(){

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
