package controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entidad.Matricula;
import entidad.Retiro;

public class ArregloRetiros {
	private static List<Retiro> r;
	//constructor
	static
	{
		LocalDateTime hoy=LocalDateTime.now();
		String fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(hoy);
		String hora = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH).format(hoy);
		r = new ArrayList<Retiro>();
		
		r.add(new Retiro(200001,ArregloMatrículas.getMat().get(0) ,fecha,hora));
		r.add(new Retiro(200002,ArregloMatrículas.getMat().get(1) ,fecha,hora));
		r.add(new Retiro(200003,ArregloMatrículas.getMat().get(2) ,fecha,hora));

		
	}
	public static List<Retiro> getR() {
		return r;
	}
	public static void setR(List<Retiro> r) {
		ArregloRetiros.r = r;
	}
	public ArregloRetiros(){
		
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
