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
			System.out.println(buffer.darNumeroClientesSalieron());	
			synchronized (this) {
				boolean a = true;//TODO revisar
				while (buffer.retirar() == null) {
					if(a){
						System.out.println("Buffer vacio");
						a= false;
						yield();
					}
				}
			}
			
			Mensaje mensaje = buffer.retirar();
			System.out.println(buffer.darNumeroClientesSalieron());	
		}
		//TODO parar servidor: cuando salga del while debería terminar
	System.out.println("termina servidor");
	}
}

