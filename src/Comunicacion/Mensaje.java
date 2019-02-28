package Comunicacion;
/**
 * Clase que modela al mensaje a enviar
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Mensaje {
	private int mensaje;
	private int contador;
	private int idCliente;

	public Mensaje(int consulta, int contador, int idCliente)
	{
		this.mensaje = consulta;
		this.contador = contador;
		this.idCliente = idCliente;
	}
	public int darMensaje()
	{
		return mensaje;
	}
	
	public void aumentarMensaje()
	{
		mensaje++;
	}

	public synchronized void enviarMensaje()
	{
		contador--;
		if(contador < 0)
		{
			try 
			{
				System.out.println("Thread "+ idCliente + " duerme en mensaje");
				wait();
			} 
			catch (InterruptedException e)
			{
				
			}
		}
	}

	public synchronized void recibirRespuesta()
	{
		contador++;
		if(contador <= 0)
		{
			System.out.println("Mensaje despierta al cliente.");
			notify();
		}
	}

}
