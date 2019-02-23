package Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase que modela al cliente
 * 
 * @author Maria Ocampo y Leidy Romero
 */
//Instanciar un Mensaje (package comunicacion) 
public class ClientePrincipal {
	public static final String RUTA = "./data/infoMain.txt";
	//Main
	public static void main(String args[]) throws IOException
	{
		boolean continuar = true;
		int numeroActualThreads = 0;
		
		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();
		String[] datos = lector.readLine().split(":");
		int numeroThreadsClientesMax = Integer.parseInt(datos[1]);
	
		while(continuar)
		{
			numeroActualThreads++;
			if(numeroActualThreads<numeroThreadsClientesMax)
			{
				ThreadCliente thread = new ThreadCliente(numeroActualThreads);
				thread.start();
			}
		}
	}
}
