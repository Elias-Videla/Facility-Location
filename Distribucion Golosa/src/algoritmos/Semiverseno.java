package algoritmos;

public class Semiverseno 
{
	private static double  radio = 6371;

	public static double distancia( double lat_1, double lon_1, double lat_2, double lon_2 ) 
	{
		double distanciaLat = Math.toRadians( lat_2 - lat_1 );
		double distanciaLon = Math.toRadians( lon_2 - lon_1 );
		
		double a = Math.sin( distanciaLat /2 ) * Math.sin( distanciaLat /2 ) + Math.cos( Math.toRadians( lat_1 ) )  
				* Math.cos( Math.toRadians( lat_2 ) ) * Math.sin( distanciaLon /2 ) * Math.sin( distanciaLon /2);
		
		double c = 2 * Math.atan2( Math.sqrt( a ), Math.sqrt( 1-a ) );
		
		double distanciaKilometros = radio * c;
		
		return distanciaKilometros;
	}
}