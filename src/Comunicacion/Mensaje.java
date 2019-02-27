package Comunicacion;
/**
 * Clase que modela al mensaje a enviar
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Mensaje {
	private int mensaje;
	private int contador;

	public Mensaje(int consulta, int contador)
	{
		this.mensaje = consulta;
		this.contador = contador;
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
			notify();
		}
	}

}
