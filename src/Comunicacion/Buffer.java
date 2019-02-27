package Comunicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Thread;
/**
 * Clase que modela al buffer
 * 
 * @author Maria Ocampo y Leidy Romero
 */
public class Buffer {

	public static final String RUTA = "./data/infoMain.txt";
	private int capacidad = 0;
	private int numeroClientesSalieron = 0;
	private ArrayList<Mensaje> buff;

	public Buffer() throws IOException {
		//Leyendo la capacidad del buffer:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();//numero de servidores
		lector.readLine();//numero de clientes
		String[] datos = lector.readLine().split(":");
		this.capacidad = Integer.parseInt(datos[1].substring(0, datos[1].length()-1));
		lector.close();

		buff = new ArrayList<Mensaje>();
	}
	public void saleCliente()
	{
		numeroClientesSalieron++;
	}
	public int darNumeroClientesSalieron()
	{
		return numeroClientesSalieron;
	}
	public void almacenar(Mensaje mensaje) {
		synchronized (this) {
			while (buff.size() == capacidad) {
				try {
					System.out.println("Buffer lleno");
					this.wait();//se duerme en el buffer
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (this) {
			System.out.println("Agrega");
			buff.add(mensaje);
		}
	}

	public Mensaje retirar(Thread x) {
		synchronized (x) {
//			while (buff.size() < capacidad) {
//				System.out.println("Buffer vacio");
//				x.yield();//TODO revisar
//			}
			Mensaje mensaje;
			synchronized (this) {
				mensaje = buff.remove(0);
				mensaje.aumentarMensaje();
				mensaje.recibirRespuesta();
				notify();
			}
			return mensaje;
		}
	}
}