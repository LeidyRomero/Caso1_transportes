package Cliente;
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
	
	public ThreadCliente(int pId, int pNumeroMaxMensajes)
	{
		this.id = pId;
		this.numeroMaxMensajes = pNumeroMaxMensajes;
	}
	public void run()
	{
		System.out.println("Inicio de un nuevo thread cliente: "+ id+ ", "+numeroMaxMensajes);
		
		//TODO: instanciar un mensaje y enviarlo al buffer
		
		numeroMaxMensajes--;
		if(numeroMaxMensajes==0)
		{
			//TODO: avisar al buffer que se retira
		}
	}
}
