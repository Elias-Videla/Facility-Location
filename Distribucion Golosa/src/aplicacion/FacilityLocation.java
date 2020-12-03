package aplicacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.Semiverseno;


public class FacilityLocation implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Coordenadas> centros;
	ArrayList<Coordenadas> clientes;
	
	
	public static ArrayList<Coordenadas> obtenerCentrosCercanos
			(int k , ArrayList <Coordenadas> centros , ArrayList <Coordenadas> clientes)
	{
		irepParametroK(k, centros.size());
		
		int i = 0;
		
		while( centros.size() != k ) 
		{
			if( i == clientes.size())
				i = 0;
			
			int indice_centro_mayor_distancia = obtenerCentroMayorDistancia(clientes.get(i), centros);
			
			centros.remove(indice_centro_mayor_distancia);
			
			i++;
			
		}
		
		return centros;
	}
	
	
	//Metodos privados ------------------------------------------------------------------------------------------------
	
	private static int obtenerCentroMayorDistancia(Coordenadas cliente, ArrayList<Coordenadas> centros) 
	{
		int indiceDelMayor = 0;
		
		double mayorDistancia = Semiverseno.distancia(cliente.latitud(), cliente.longitud(),
				centros.get(0).latitud(), centros.get(0).longitud());
		
		for(int i = 1; i < centros.size(); i++) 
		{
			double distancia_centro = Semiverseno.distancia( cliente.latitud(), cliente.longitud(),
					centros.get( i ).latitud(), centros.get( i ).longitud() );
			
			if(mayorDistancia < distancia_centro) 
			{
				mayorDistancia = distancia_centro;
				indiceDelMayor = i;
			}
			
		}
		return indiceDelMayor;
	}
	
	
	
	private static void irepParametroK(int k, int cantidadCentros) 
	{
		if(k <= 0)
			throw new IllegalArgumentException("El parametro no puede ser menor igual a cero: " + cantidadCentros);
		if(k > cantidadCentros)
			throw new IllegalArgumentException("El parametro no puede ser mayor a la cantidad de centros: " + cantidadCentros);
	}
	
	
	

	
	 ArrayList<Coordenadas> lista_A;
	 ArrayList<Coordenadas> lista_B;
	 ArrayList<Coordenadas> lista_C;
	 ArrayList<Coordenadas> lista_D;
	
	@SuppressWarnings("unchecked")
	public void descargarArchivo() 
	{
		try 
		{
			FileInputStream fis  = new FileInputStream( "lista_clientes.txt" );
			ObjectInputStream in = new ObjectInputStream( fis );
			
			lista_A = ( ArrayList< Coordenadas > ) in.readObject();
			lista_B = ( ArrayList< Coordenadas > ) in.readObject();
			lista_C = ( ArrayList< Coordenadas > ) in.readObject();
			lista_D = ( ArrayList< Coordenadas > ) in.readObject();

			in.close();
		}
		catch( Exception ex ) 
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		//FacilityLocation.cargarClientes();
		//FacilityLocation.carcarCentros();
		FacilityLocation fl = new FacilityLocation();
		fl.descargarArchivo();
		System.out.println("latitud " + fl.lista_A.get(0).latitud());
		System.out.println("tamanio " + fl.lista_A.size());
		
		Cliente cliente1 = new Cliente(0, -34.431185, -58.713612); // puente alba
		Cliente cliente2 = new Cliente(1, -34.416600, -58.723226); // puente garin
		Cliente cliente3 = new Cliente(2, -34.395285, -58.740220); // puente mashwitz
		Cliente cliente4 = new Cliente(3, -34.430406, -58.757558); // fructuoso diaz / patricias argentinas
		Cliente cliente5 = new Cliente(4, -34.414193, -58.754382); // arroyito garin 7 vias
		Cliente cliente6 = new Cliente(5, -34.391991, -58.715029); // entrada dean funes
		
		Centro c0 = new Centro(0, -34.423167, -58.734405);		   // pte peron	        
		Centro c1 = new Centro(1, -34.407324, -58.770862);		   // savio vias
		Centro c2 = new Centro(2, -34.416990, -58.698946);		   // alvear / peron
		ArrayList<Coordenadas> centros = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> clientes = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> centros2 = new ArrayList<Coordenadas>();
		
		Centro c3 = new Centro(3, -34.393656, -58.774209); 		   // rotonda savio
		Centro c4 = new Centro(4, -34.417344, -58.798027);		   // circulo tordillo
		Centro c5 = new Centro(5, -34.428530, -58.795195);		   // highland park
		centros2.add(c3);
		centros2.add(c4);
		centros2.add(c5);
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
		centros.add(c0);
		centros.add(c1);
		centros.add(c2);
		centros.add(c3);
		centros.add(c4);
		centros.add(c5);
		
//		System.out.println(FacilityLocation.obtenerCentroMayorDistancia(cliente1, centros));
//		int indice = FacilityLocation.obtenerCentroMayorDistancia(cliente1, centros);
//		System.out.println(centros.get(indice).latitud());
//		
//		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos(3, centros, clientes);
//		System.out.println("numero de centro  " + resultado.get(0).identificacion());
//		System.out.println("numero de centro  " + resultado.get(1).identificacion());
//		System.out.println("numero de centro  " + resultado.get(2).identificacion());
//		System.out.println("tamano " + resultado.size());
//		ArrayList<Coordenadas> resultado2 = FacilityLocation.obtenerCentrosCercanos(1, centros2, clientes);
//		System.out.println("centros 2 " + resultado2.get(0).identificacion());
		
		
		Cliente cl0 = new Cliente(0, -34.398330, -58.788629); // ultima calle arrollo
		Cliente cl1 = new Cliente(1, -34.422902, -58.786998); // plaza lagomarsino
		Cliente cl2 = new Cliente(2, -34.394647, -58.751721); // rotonda san lucas
		Cliente cl3 = new Cliente(3, -34.432672, -58.726659); // mi casa
		Cliente cl4 = new Cliente(4, -34.408882, -58.714986); // club newman verde
		Cliente cl5 = new Cliente(5, -34.391035, -58.696875); // nariz osito
		
		ArrayList<Coordenadas> clientes2 = new ArrayList<Coordenadas>();
		clientes2.add(cl0);
		clientes2.add(cl1);
		clientes2.add(cl2);
		clientes2.add(cl3);
		clientes2.add(cl4);
		clientes2.add(cl5);
		ArrayList<Coordenadas> resultado3 = FacilityLocation.obtenerCentrosCercanos(1, centros2, clientes2);
		System.out.println("Clientes 2: " + resultado3.get(0).identificacion());
	}
}
