package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entidad.Matricula;
import entidad.Retiro;

public class ArregloRetiros {
	private static List<Retiro> r;
	//constructor
	static
	{
		r = new ArrayList<Retiro>();
	}
	public ArregloRetiros()
	{
		File datFile = new File("C:\\archivos\\arreglo-retiros.dat");
		if(datFile.exists())
		getDat();
	}
	public void crearDat(List<Retiro> retiros)
	{
		FileOutputStream fileOutputStream=null;
		try
		{
		fileOutputStream=new FileOutputStream("C:\\archivos\\arreglo-retiros.dat");
		ObjectOutputStream ficheroRetiros= new ObjectOutputStream(fileOutputStream);
		ficheroRetiros.writeObject(r);
		ficheroRetiros.close();
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
		r=new ArrayList<>();
	
		try {
			FileInputStream fileOutputStream=new FileInputStream("C:\\archivos\\arreglo-retiros.dat");
			ObjectInputStream ficheroRetiros= new ObjectInputStream(fileOutputStream);
			r=(List<Retiro>)ficheroRetiros.readObject();
			fileOutputStream.close();
			ficheroRetiros.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Retiro> getR() {
		return r;
	}
	public static void setR(List<Retiro> r) {
		ArregloRetiros.r = r;
	}
	
	//métodos básicos
		public void adicionar(Retiro x){
			r.add(x);
		}
		public int tamaño(){
			return r.size();
		}
		public Retiro obtener(int i){
			return r.get(i);
		}
		
		public int generarCodigo(){
			if(r.size() == 0){
				return 200001;
			}else{
				return r.get(r.size()-1).getNumRetiro()+1;
			}
		}
		
		public Retiro buscar(int cod){
			Retiro retiro=null;
			for(int i = 0 ; i < r.size() ; i++){
				if(r.get(i).getNumRetiro() == cod)
					retiro=r.get(i);
			}
			return retiro;
		}
		public Matricula findMatriculaByNumMatricula(int numMatricula)
		{
			Matricula matricula=null;
			for(Retiro retiro:r)
			{
				if(retiro.getMatricula().getNumMatricula()==numMatricula)
				{
					matricula=retiro.getMatricula();
				}
			}
			return matricula;
		}
}
