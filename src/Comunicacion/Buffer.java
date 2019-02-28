package Comunicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que modela al buffer
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Buffer {

	public static final String RUTA = "./data/infoMain.txt";
	private int capacidad = 0;
	private int numeroClientesSalieron;
	private ArrayList<Mensaje> buff;
	private Object lleno;

	public Buffer() throws IOException {
		//Leyendo la capacidad del buffer:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();//{
		lector.readLine();//numero de servidores
		String[] clientes = lector.readLine().split(":");//numero de clientes
		this.numeroClientesSalieron = Integer.parseInt(clientes[1].substring(0, clientes[1].length()-1));
		
		String[] datos = lector.readLine().split(":");
		this.capacidad = Integer.parseInt(datos[1].substring(0, datos[1].length()-1));
		lector.close();

		buff = new ArrayList<Mensaje>();
		lleno = new Object();
	}
	public synchronized void saleCliente()
	{
		numeroClientesSalieron--;
	}
	public int darCapacidad()
	{
		return capacidad;
	}
	public int darNumeroClientesSalieron()
	{
		return numeroClientesSalieron;
	}
	public synchronized int darTamañoActualBuffer()
	{
		return buff.size();
	}
	public void almacenar(Mensaje mensaje) {

		synchronized (lleno) {
			try {
				while(buff.size() == capacidad)
					lleno.wait();
			} 
			catch (InterruptedException e1) {
				// Manejo de excepción
			}
		}	

		synchronized (this) {
			buff.add(mensaje);
			System.out.println("Buffer agrega mensaje: "+mensaje.darMensaje());
		}

//		synchronized (vacio) {
//			vacio.notify();	
//		}
	}

	public Mensaje retirar() {

//		synchronized (vacio) {
//			try {
//				while(buff.size() == 0 && darNumeroClientesSalieron() > 0)
//					vacio.wait();				
//			} 
//			catch (InterruptedException e) {
//				// Manejo de excepción
//			}
//		}
		Mensaje mensaje = null;

		synchronized (this) {
			if(buff.size()>0)
			{
				mensaje = buff.remove(0);
				System.out.println("Servidor retira mensaje: "+mensaje.darMensaje());
				mensaje.aumentarMensaje();
				mensaje.recibirRespuesta();
			}
		}
		synchronized (lleno) {
			lleno.notify();
		}
		return mensaje;
	}
	
	public void terminar()
	{
//		synchronized (vacio) {
//				while(buff.size() == 0 && darNumeroClientesSalieron() == 0 && numeroServidores > 0)
//				{
//					vacio.notifyAll();
//					numeroServidores--;
//					System.out.println("numServidores: " + numeroServidores);
//				}
//		}
	}
}