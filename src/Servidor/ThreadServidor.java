package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Cliente.ClientePrincipal;
import Comunicacion.Buffer;
import Comunicacion.Mensaje;

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
		
		while(buffer.darNumeroClientesSalieron() > 0)
		{
			Mensaje mensaje = buffer.retirar(this);
		}
	}

}
