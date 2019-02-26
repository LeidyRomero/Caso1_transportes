package Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Comunicacion.Buffer;

/**
 * Clase que modela al cliente principal
 * 
 * @author Maria Ocampo y Leidy Romero
 */
//Instanciar un Mensaje (package comunicacion) 
public class ClientePrincipal {
	public static final String RUTA = "./data/infoMain.txt";
	//Main
	public ClientePrincipal(Buffer pBuffer) throws IOException
	{
		int numeroActualThreads = 0;

		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();
		lector.readLine();
		String[] datos = lector.readLine().split(":");
		int numeroThreadsClientesMax = Integer.parseInt(datos[1].substring(0, datos[1].length()-1));
		lector.readLine();
		String[] datos2 = lector.readLine().split(":");

		String[] numeros = datos2[1].substring(1, datos2[1].length()-1).split(",");

		while(numeroActualThreads<numeroThreadsClientesMax)
		{
			int numeroMensajesMaximo = Integer.parseInt(numeros[(int)Math.round(Math.random()*29)]);
			ThreadCliente thread = new ThreadCliente(numeroActualThreads, numeroMensajesMaximo, pBuffer);
			thread.start();
			numeroActualThreads++;
		}
		lector.close();
	}
}
