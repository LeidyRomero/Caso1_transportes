package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Clase que modela a los diferenes hilos de ejecución del servidor
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ThreadServidor extends Thread{
	private Socket sktCliente = null;
	private int id;
	
	public ThreadServidor(Socket pSocket, int pId)
	{
		this.id = pId;
		this.sktCliente = pSocket;
	}
	public void run()
	{
		System.out.println("Inicio de un nuevo thread servidor: "+ id);
		
		//TODO: solicitar mensajes al buffer y responder(incrementar el valor del mensaje y avisarle al cliente que puede continuar)
		
	}
}
