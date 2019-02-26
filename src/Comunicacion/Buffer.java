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
	//TODO revisar
	public void almacenar(Mensaje mensaje) {
		synchronized (mensaje.darObjetoLleno()) {
			while (buff.size() == capacidad) {
				try {
					System.out.println("Buffer lleno");
					mensaje.darObjetoLleno().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (this) {
			buff.add(mensaje);
		}
		synchronized (mensaje.darObjetoVacio()) {
			mensaje.darObjetoVacio().notify();
		}
	}

	public Mensaje retirar() {
		//			synchronized (mensaje.darObjetoVacio()) {
		while (buff.size() < capacidad) {
			//			try {
			//				System.out.println("Buffer vacio");
			//				//				mensaje.darObjetoVacio().wait();
			//			} catch (InterruptedException e) {
			//				e.printStackTrace();
			//			}
		}
		//}
		Mensaje mensaje;
		synchronized (this) {
			mensaje = buff.remove(0);
		}
		synchronized (mensaje.darObjetoLleno()) {
			mensaje.darObjetoLleno().notify();
		}
		return mensaje;
	}
}
