package Servidor;

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
			synchronized (this) {
				boolean a = true;//TODO revisar
				if (buffer.retirar() == null) {
					if(a){
//						System.out.println("Buffer vacio");
						a= false;
						yield();
					}
				}
			}
			
			Mensaje mensaje = buffer.retirar();
		}
		//TODO parar servidor: cuando salga del while debería terminar
	System.out.println("termina servidor");
	}
}

