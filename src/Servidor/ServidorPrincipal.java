package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPrincipal extends Thread{

	public static final int PUERTO = 3400;
	public static final String RUTA = "./data/infoMain.txt";
	
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = null;
		boolean continuar = true;
		int numeroActualThreads = 0;
		
		System.out.println("Intenta conectarse");

		try
		{
			ss = new ServerSocket(PUERTO);
		}
		catch (IOException e) {
			System.err.println("No se pudo conectar al servidor");
			System.exit(-1);
		}

		//Leyendo el numero de servidores desde el JSON:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		String[] datos = lector.readLine().split(":");
		int numeroThreadsMax = Integer.parseInt(datos[1]);
		
		while(continuar)
		{
			Socket socket = ss.accept();
			numeroActualThreads++;
			if(numeroActualThreads<numeroThreadsMax)
			{
				ThreadServidor thread = new ThreadServidor(socket, numeroActualThreads);
				thread.start();
			}
		}
	}
}
