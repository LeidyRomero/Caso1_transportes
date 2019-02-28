package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Comunicacion.Buffer;
import Comunicacion.Mensaje;

/**
 * Clase que modela a los diferentes hilos de ejecución de los clientes
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ThreadCliente extends Thread{
	//Instanciar un Mensaje (package comunicacion) 

	public static final int PUERTO = 3400;
	public static final String SERVIDOR = "localhost";
	private int id;
	private int numeroMaxMensajes;
	private static Buffer buffer;

	public ThreadCliente(int pId, int pNumeroMaxMensajes, Buffer pBuffer)
	{
		this.id = pId;
		this.numeroMaxMensajes = pNumeroMaxMensajes;
		this.buffer = pBuffer;
	}

	public void run()
	{
		System.out.println("Inicio de un nuevo thread cliente: "+ id+ ", "+numeroMaxMensajes);

		while(numeroMaxMensajes > 0)
		{
			Mensaje mensajeCliente = new Mensaje((int)Math.round(Math.random()*29),0,id); 
			System.out.println("Thread: "+id+" envía mensaje: "+mensajeCliente.darMensaje());
			buffer.almacenar(mensajeCliente);
			mensajeCliente.enviarMensaje();

			numeroMaxMensajes--;
		}
		
		if(numeroMaxMensajes==0)
		{
			System.out.println("Sale cliente");
			buffer.saleCliente();
		}
	}
}
