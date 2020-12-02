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
		int k = 1;
		
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
		
		assertEquals(numeroCentroCorrecto, resultado.get(0).identificacion());
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void parametroNegativoTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		
		int k = -1;
		
		FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void parametroExcedidoTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		
		int k = 7;
		
		FacilityLocation.obtenerCentrosCercanos(k, centros, clientes);
	}
	
	
	@Test 
	public void parametroIgualACantidadCentrosTest() 
	{
		ArrayList<Coordenadas> clientes = repositorio.clientes();
		ArrayList<Coordenadas> centros = repositorio.centros();
		
		int k = 6;
		
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos( k, centros, clientes );
		
		assertEquals( 6, resultado.size() );
	}
	
	
	@Test 
	public void cantidadClientesMenorACantidadCentrosTest() 
	{
		ArrayList<Coordenadas> clientes = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> centros  = repositorio.centros();
		
		clientes.add(repositorio.clientes().get(0));
		clientes.add(repositorio.clientes().get(1));
		
		int k = 1;
		int numeroCentroCorrecto = 2;
		
		ArrayList<Coordenadas> resultado = FacilityLocation.obtenerCentrosCercanos( k, centros, clientes );
		
		assertEquals(numeroCentroCorrecto, resultado.get(0).identificacion());
		
	}

}
