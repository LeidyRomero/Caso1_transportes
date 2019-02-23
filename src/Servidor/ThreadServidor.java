package Servidor;

/**
 * Clase que modela a los diferenes hilos de ejecución del servidor
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ThreadServidor extends Thread{
	private int id;
	
	public ThreadServidor(int pId)
	{
		this.id = pId;
	}
	public void run()
	{
		System.out.println("Inicio de un nuevo thread servidor: "+ id);
		
		//TODO: solicitar mensajes al buffer y responder(incrementar el valor del mensaje y avisarle al cliente que puede continuar)
		
	}
}
