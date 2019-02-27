package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Cliente.ClientePrincipal;
import Comunicacion.Buffer;

/**
 * Clase que modela a los diferenes hilos de ejecución del servidor
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ThreadServidor extends Thread{
	private int id;
	private static Buffer buffer;
	
	public ThreadServidor(int pId,Buffer pBuffer)
	{
		this.id = pId;
		this.buffer = pBuffer;
	}
	public void run()
	{
		System.out.println("Inicio de un nuevo thread servidor: "+ id);
		
		while(hayClientes())
		{
			buffer.retirar(this);
		}
	}
	public synchronized boolean hayClientes(){
		int a = 0;
		
		try { a = darNumeroThreads();} 
		catch (IOException e) { e.printStackTrace(); }
		
		return buffer.darNumeroClientesSalieron() != a && buffer.darNumeroClientesSalieron() != 0;
	}
	public int darNumeroThreads() throws IOException
	{
		BufferedReader lector = new BufferedReader(new FileReader(new File(ClientePrincipal.RUTA)));
		lector.readLine();
		lector.readLine();
		String[] datos = lector.readLine().split(":");
		return Integer.parseInt(datos[1].substring(0, datos[1].length()-1));
	}
}
