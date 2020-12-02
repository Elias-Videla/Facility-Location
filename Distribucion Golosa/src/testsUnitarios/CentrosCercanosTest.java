package testsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Coordenadas;
import aplicacion.FacilityLocation;


public class CentrosCercanosTest 
{
	RepoClientesYCentros repositorio;

	@Before
	public void inicializacion() 
	{
		repositorio = new RepoClientesYCentros();
	}
	
	@Test
	public void CentroCercanoCorrectoTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		int numeroCentroCorrecto = 1;
		int cantidadCentrosAbiertos = 1;
		
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos(cantidadCentrosAbiertos, centros, clientes);
		
		assertEquals(numeroCentroCorrecto, resultado.get(0).identificacion());
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void parametroNegativoTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		
		int cantidadCentrosAbiertos = -1;
		
		FacilityLocation.obtenerCentrosCercanos(cantidadCentrosAbiertos, centros, clientes);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void parametroExcedidoTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		
		int cantidadCentrosAbiertos = 7;
		
		FacilityLocation.obtenerCentrosCercanos(cantidadCentrosAbiertos, centros, clientes);
	}

}
