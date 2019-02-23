package Cliente;
/**
 * Clase que modela al cliente
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class ThreadCliente extends Thread{
	//Instanciar un Mensaje (package comunicacion) 
	
	public static final int PUERTO = 3400;
	public static final String SERVIDOR = "localhost";
	public int id;
	
	public ThreadCliente(int pId)
	{
		id = pId;
	}
}
