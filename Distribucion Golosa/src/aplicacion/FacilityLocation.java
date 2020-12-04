package aplicacion;

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
	
	
	
	public static ArrayList<Coordenadas> obtenerCentrosCercanosInverso
	(int k , ArrayList <Coordenadas> centros , ArrayList <Coordenadas> clientes)
	{
		irepParametroK(k, centros.size());

		int i = clientes.size()-1;

		while( centros.size() != k ) 
		{
			if( i == 0)
				i = clientes.size()-1;

			int indice_centro_mayor_distancia = obtenerCentroMayorDistancia(clientes.get(i), centros);

			centros.remove(indice_centro_mayor_distancia);

			i--;
		}
		return centros;
	}
	
	
	
	public static double sumatoria(Coordenadas centro, ArrayList<Coordenadas> clientes) 
	{
		double sumatoria = 0.0;
		for(int i = 0; i < clientes.size(); i++) 
		{
			sumatoria += Semiverseno.distancia(centro.latitud(), centro.longitud(), 
					clientes.get(i).latitud(), clientes.get(i).longitud());
		}
		
		return sumatoria;
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
	
}
