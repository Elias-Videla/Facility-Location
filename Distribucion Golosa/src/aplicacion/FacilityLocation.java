package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.Semiverseno;


public class FacilityLocation implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	ArrayList < Coordenadas > centros;
	ArrayList < Coordenadas > clientes;
	
	
	public static ArrayList< Coordenadas > obtenerCentrosCercanos
			( int k , ArrayList < Coordenadas > centros , ArrayList < Coordenadas > clientes )
	{
		irepParametroK( k, centros.size() );
		
		int i = 0;
		
		while( centros.size() != k ) 
		{
			i = controlIteradorCliente( clientes, i );
			
			borrarCentroMayorDistancia( centros, clientes, i );
			
			i++;
		}
		return centros;
	}


	
	public static ArrayList < Coordenadas > obtenerCentrosCercanosInverso
		( int k , ArrayList < Coordenadas > centros , ArrayList < Coordenadas > clientes )
	{
		irepParametroK( k, centros.size() );

		int i = clientes.size()-1;

		while( centros.size() != k ) 
		{
			i = controlIteradorClienteInverso( clientes, i );

			borrarCentroMayorDistancia( centros, clientes, i );

			i--;
		}
		return centros;
	}


	
	public static double sumatoria( Coordenadas centro, ArrayList< Coordenadas > clientes ) 
	{
		double sumatoria = 0.0;
		for( int i = 0; i < clientes.size(); i++ ) 
		{
			sumatoria += calcularDistancia( clientes.get( i ), centro );
		}
		
		return sumatoria;
	}
	
	
	
	//Metodos privados ------------------------------------------------------------------------------------------------
	
	private static void borrarCentroMayorDistancia( ArrayList< Coordenadas > centros, ArrayList< Coordenadas > clientes, int i ) 
	{
		int indice_centro_mayor_distancia = obtenerCentroMayorDistancia( clientes.get( i ), centros );
		
		centros.remove( indice_centro_mayor_distancia );
	}
	
	
	
	private static int obtenerCentroMayorDistancia( Coordenadas cliente, ArrayList< Coordenadas > centros ) 
	{
		int indiceDelMayor = 0;
		
		double mayorDistancia = calcularDistancia( cliente, centros.get( 0 ) );
		
		for( int i = 1; i < centros.size(); i++ ) 
		{
			double distancia_centro = calcularDistancia( cliente, centros.get( i ) );
			
			if( mayorDistancia < distancia_centro ) 
			{
				mayorDistancia = distancia_centro;
				indiceDelMayor = i;
			}
			
		}
		return indiceDelMayor;
	}

	

	private static double calcularDistancia( Coordenadas cliente, Coordenadas centro ) 
	{
		return Semiverseno.distancia( cliente.latitud(), cliente.longitud(), centro.latitud(), centro.longitud() );
	}
	
	
	
	private static void irepParametroK( int k, int cantidadCentros ) 
	{
		if( k <= 0 )
			throw new IllegalArgumentException( "El parametro no puede ser menor igual a cero: " + cantidadCentros );
		if( k > cantidadCentros )
			throw new IllegalArgumentException( "El parametro no puede ser mayor a la cantidad de centros: " + cantidadCentros );
	}
	
	
	
	private static int controlIteradorCliente( ArrayList< Coordenadas > clientes, int i ) 
	{
		if( i == clientes.size() )
			i = 0;
		return i;
	}
	
	
	
	private static int controlIteradorClienteInverso( ArrayList< Coordenadas > clientes, int i ) 
	{
		if( i == 0 )
			i = clientes.size()-1;
		return i;
	}
	
}
