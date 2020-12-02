package aplicacion;

import java.util.ArrayList;

import algoritmos.Semiverseno;

public class FacilityLocation 
{
	ArrayList<Coordenadas> centros;
	ArrayList<Coordenadas> clientes;
	
	public static ArrayList<Coordenadas> obtenerCentrosCercanos
			(int k , ArrayList <Coordenadas> centros , ArrayList <Coordenadas> clientes)
	{
		irepParametroK(k, centros.size());
		
		int i = 0;
		
		while( centros.size() != k ) 
		{
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
			double distancia_centro = Semiverseno.distancia(cliente.latitud(), cliente.longitud(),
					centros.get(i).latitud(), centros.get(i).longitud());
			
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
			throw new IllegalArgumentException("El parametro no puede ser menor igual a cero: " + k);
		if(k > cantidadCentros)
			throw new IllegalArgumentException("El parametro no puede ser mayor a la cantidad de centros: " + k);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		Cliente cliente1 = new Cliente(0, -34.431185, -58.713612);
		Cliente cliente2 = new Cliente(1, -34.416600, -58.723226);
		Cliente cliente3 = new Cliente(2, -34.395285, -58.740220);
		Cliente cliente4 = new Cliente(3, -34.430406, -58.757558);
		Cliente cliente5 = new Cliente(4, -34.414193, -58.754382);
		Cliente cliente6 = new Cliente(5, -34.391991, -58.715029);
		Centro c0 = new Centro(0, -34.423167, -58.734405);
		Centro c1 = new Centro(1, -34.407324, -58.770862);
		Centro c2 = new Centro(2, -34.416990, -58.698946);
		ArrayList<Coordenadas> centros = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> clientes = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> centros2 = new ArrayList<Coordenadas>();
		
		Centro c3 = new Centro(3, -34.393656, -58.774209);
		Centro c4 = new Centro(4, -34.417344, -58.798027);
		Centro c5 = new Centro(5, -34.428530, -58.795195);
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
		
		System.out.println(FacilityLocation.obtenerCentroMayorDistancia(cliente1, centros));
		int indice = FacilityLocation.obtenerCentroMayorDistancia(cliente1, centros);
		System.out.println(centros.get(indice).latitud());
		
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos(3, centros, clientes);
		System.out.println("numero de centro  " + resultado.get(0).identificacion());
		System.out.println("numero de centro  " + resultado.get(1).identificacion());
		System.out.println("numero de centro  " + resultado.get(2).identificacion());
		System.out.println("tamano " + resultado.size());
		ArrayList<Coordenadas> resultado2 = FacilityLocation.obtenerCentrosCercanos(1, centros2, clientes);
		System.out.println("centros 2 " + resultado2.get(0).identificacion());
	}
}
