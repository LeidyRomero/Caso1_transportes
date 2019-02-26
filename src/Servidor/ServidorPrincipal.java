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
		int numeroActualThreads = 0;

		System.out.println("Intenta conectarse");

		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();
		String[] datos = lector.readLine().split(":");
		int numeroThreadsMax = Integer.parseInt(datos[1].substring(0, datos[1].length()-1));

		while(numeroActualThreads<numeroThreadsMax)
		{
			ThreadServidor thread = new ThreadServidor(numeroActualThreads);
			thread.start();
			numeroActualThreads++;
		}
		lector.close();
	}
}
