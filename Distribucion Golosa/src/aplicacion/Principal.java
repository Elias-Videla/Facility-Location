package aplicacion;

import java.util.ArrayList;

public class Principal 
{
	public static ArrayList<Coordenadas> obtenerCentrosCercanos
	(int k, ArrayList<Coordenadas> centros, ArrayList<Coordenadas> clientes)
	{
		irepParametroK(k, centros.size());
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
		double suma = FacilityLocation.sumatoria(resultado.get(0), clientes);
		System.out.println("sumaaa " + suma);
		return FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
	}
	
	public static ArrayList<Coordenadas> segundaBusquedaCentrosCercanos
	(int k, ArrayList<Coordenadas> centros, ArrayList<Coordenadas> clientes)
	{
		return FacilityLocation.obtenerCentrosCercanosInverso(k, centros, clientes);
	}
	
	public static ArrayList<Coordenadas> hacerBusquedaIntensiva
	(int k, ArrayList<Coordenadas> centros, ArrayList<Coordenadas> clientes)
	{
		irepParametroK(k, centros.size());
		
		@SuppressWarnings("unchecked")
		ArrayList<Coordenadas> centrosClon = (ArrayList<Coordenadas>) centros.clone();
		
		ArrayList<Coordenadas> centros1 = FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
		ArrayList<Coordenadas> centros2 = FacilityLocation.obtenerCentrosCercanosInverso(k, centrosClon, clientes);
		
		double costoTotal1 = costoTotal(clientes, centros1);
		double costoTotal2 = costoTotal(clientes, centros2);
		
		System.out.println("costo 1 " + costoTotal1);
		System.out.println("costo 2 " + costoTotal2);
		
		if(costoTotal1 <= costoTotal2)
			return centros1;
		else
			return centros2;
		
	}

	private static double costoTotal(ArrayList<Coordenadas> clientes, ArrayList<Coordenadas> centros) 
	{
		double sumatoria = 0.0;
		
		for(int i = 0; i < centros.size(); i++) 
		{
			sumatoria = sumatoria +  FacilityLocation.sumatoria(centros.get(i), clientes);
		}
		
		return sumatoria;
	}
	
	private static void irepParametroK(int k, int cantidadCentros) 
	{
		if(k <= 0)
			throw new IllegalArgumentException("El parametro no puede ser menor igual a cero: " + cantidadCentros);
		if(k > cantidadCentros)
			throw new IllegalArgumentException("El parametro no puede ser mayor a la cantidad de centros: " + cantidadCentros);
	}
}
