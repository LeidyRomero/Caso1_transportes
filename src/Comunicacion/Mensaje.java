package Comunicacion;
/**
 * Clase que modela al mensaje a enviar
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Mensaje {
	private int mensaje;
	
	public Mensaje(int consulta)
	{
		this.mensaje = consulta;
	}
	public int darMensaje()
	{
		return mensaje;
	}

}
