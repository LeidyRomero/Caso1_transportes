package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Comunicacion.Buffer;
/**
 * Clase que modela al servidor principal
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ServidorPrincipal extends Thread{

	public static final int PUERTO = 3400;
	public static final String RUTA = "./data/infoMain.txt";
	
	public ServidorPrincipal(Buffer pBuffer) throws IOException
	{
		boolean continuar = true;
		int numeroActualThreads = 0;
		
		System.out.println("Intenta conectarse");

		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		String[] datos = lector.readLine().split(":");
		int numeroThreadsMax = Integer.parseInt(datos[1]);
		
		while(continuar)
		{
			numeroActualThreads++;
			if(numeroActualThreads<numeroThreadsMax)
			{
				ThreadServidor thread = new ThreadServidor(numeroActualThreads);
				thread.start();
			}
		}
		lector.close();
	}
}
