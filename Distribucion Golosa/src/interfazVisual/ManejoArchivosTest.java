package interfazVisual;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Coordenadas;

public class ManejoArchivosTest {
	
	ManejoArchivos archivos;
	
	@Before
	public void inicializar() 
	{
		archivos = new ManejoArchivos();
	}
	
	
	@Test
	public void conjuntoClientes4TamanoCantidadTest() 
	{
		archivos.descargarArchivoClientes();
		int cantidadClientes = 3;
		
		ArrayList<Coordenadas> clientes4 = new ArrayList<Coordenadas>();
		clientes4 = archivos.clientes4();
		
		assertEquals(cantidadClientes, clientes4.size());
	}

}
