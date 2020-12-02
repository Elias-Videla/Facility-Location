package testsUnitarios;

import java.util.ArrayList;

import aplicacion.Centro;
import aplicacion.Cliente;
import aplicacion.Coordenadas;

public class RepoClientesYCentros 
{
	ArrayList<Coordenadas> clientes;
	ArrayList<Coordenadas> centros;
	
	Cliente cliente1 = new Cliente(0, -34.431185, -58.713612);
	Cliente cliente2 = new Cliente(1, -34.416600, -58.723226);
	Cliente cliente3 = new Cliente(2, -34.395285, -58.740220);
	Cliente cliente4 = new Cliente(3, -34.430406, -58.757558);
	Cliente cliente5 = new Cliente(4, -34.414193, -58.754382);
	Cliente cliente6 = new Cliente(5, -34.391991, -58.715029);
	
	Centro c0 = new Centro(0, -34.423167, -58.734405);
	Centro c1 = new Centro(1, -34.407324, -58.770862);
	Centro c2 = new Centro(2, -34.416990, -58.698946);
	Centro c3 = new Centro(3, -34.393656, -58.774209);
	Centro c4 = new Centro(4, -34.417344, -58.798027);
	Centro c5 = new Centro(5, -34.428530, -58.795195);
	
	RepoClientesYCentros()
	{
		clientes = new ArrayList<Coordenadas>();
		centros  = new ArrayList<Coordenadas>();
		agregarCentros();
		agregarClientes();
	}
	
	public void agregarClientes() 
	{
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
	}
	
	public void agregarCentros() 
	{
		centros.add(c0);
		centros.add(c1);
		centros.add(c2);
		centros.add(c3);
		centros.add(c4);
		centros.add(c5);
	}
	
	public ArrayList<Coordenadas> clientes()
	{
		return clientes;
	}
	
	public ArrayList<Coordenadas> centros()
	{
		return centros;
	}
	
}
