package interfazVisual;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import aplicacion.Coordenadas;

public class ManejoArchivos 
{
	private  ArrayList<Coordenadas> clientes1, clientes2, clientes3, clientes4;
	private  ArrayList<Coordenadas> centros1, centros2, centros3;
	
	@SuppressWarnings("unchecked")
	public void descargarArchivoClientes() 
	{
		try 
		{
			FileInputStream fis  = new FileInputStream( "lista_clientes.txt" );
			ObjectInputStream in = new ObjectInputStream( fis );
			
			clientes1 = ( ArrayList< Coordenadas > ) in.readObject();
			clientes2 = ( ArrayList< Coordenadas > ) in.readObject();
			clientes3 = ( ArrayList< Coordenadas > ) in.readObject();
			clientes4 = ( ArrayList< Coordenadas > ) in.readObject();

			in.close();
		}
		catch( Exception ex ) 
		{
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void descargarArchivoCentros() 
	{
		try 
		{
			FileInputStream fis  = new FileInputStream( "lista_centros.txt" );
			ObjectInputStream in = new ObjectInputStream( fis );
			
			centros1 = ( ArrayList< Coordenadas > ) in.readObject();
			centros2 = ( ArrayList< Coordenadas > ) in.readObject();
			centros3 = ( ArrayList< Coordenadas > ) in.readObject();

			in.close();
		}
		catch( Exception ex ) 
		{
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Coordenadas> clientes1()
	{
		return clientes1;
	}
	
	public ArrayList<Coordenadas> clientes2()
	{
		return clientes2;
	}
	
	public ArrayList<Coordenadas> clientes3()
	{
		return clientes3;
	}
	
	public ArrayList<Coordenadas> clientes4()
	{
		return clientes4;
	}
	
	public ArrayList<Coordenadas> centros1()
	{
		return centros1;
	}
	
	public ArrayList<Coordenadas> centros2()
	{
		return centros2;
	}
	
	public ArrayList<Coordenadas> centros3()
	{
		return centros3;
	}
	
	
	
}
