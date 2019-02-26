package Comunicacion;
/**
 * Clase que modela al mensaje a enviar
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Mensaje {
	private String mensaje;
	Object lleno;
	Object vacio;
	
	public Mensaje(String consulta)
	{
		this.mensaje = consulta;
		this.lleno = new Object();
		this.vacio = new Object();
	}
	public String darMensaje()
	{
		return mensaje;
	}
	public Object darObjetoLleno()
	{
		return lleno;
	}
	public Object darObjetoVacio()
	{
		return vacio;
	}
}
