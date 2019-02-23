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
		boolean continuar = true;
		int numeroActualThreads = 0;
		
		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();
		String[] datos = lector.readLine().split(":");
		int numeroThreadsClientesMax = Integer.parseInt(datos[1]);
		lector.readLine();
		String[] datos2 = lector.readLine().split(":");
		int numeroMensajesMaximo = Integer.parseInt(datos2[(int)Math.random()*29]);
		
		while(continuar)
		{
			numeroActualThreads++;
			if(numeroActualThreads<numeroThreadsClientesMax)
			{
				ThreadCliente thread = new ThreadCliente(numeroActualThreads, numeroMensajesMaximo, pBuffer);
				thread.start();
			}
		}
		lector.close();
	}
}
