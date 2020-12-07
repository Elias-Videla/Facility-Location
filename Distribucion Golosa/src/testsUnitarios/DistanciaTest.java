package testsUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import algoritmos.Semiverseno;

public class DistanciaTest {

	@Test
	public void distanciaCorrectaTest() 
	{
		double latitud_1  = -34.395285;
		double longitud_1 = -58.740220;
		double latitud_2  = -34.423167;
		double longitud_2 = -58.734405;
		
		double resultadoEsperado = 3.1458968411436627;
		double distancia = Semiverseno.distancia( latitud_1, longitud_1, latitud_2, longitud_2 );
		
		assertEquals( distancia, resultadoEsperado,0 );
	}

}
