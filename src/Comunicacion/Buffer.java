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
	Object lleno;//TODO revisar
	Object vacio;

	public Buffer() throws IOException {


		//Leyendo la capacidad del buffer:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();//numero de servidores
		lector.readLine();//numero de clientes
		String[] datos = lector.readLine().split(":");
		this.capacidad = Integer.parseInt(datos[1]);
		lector.close();

		buff = new ArrayList<Mensaje>();
		lleno = new Object();
		vacio = new Object();
	}
	//TODO revisar
		public void almacenar(Mensaje i) {
			synchronized (lleno) {
//				while (buff.size() == n) {
//					try {
//						System.out.println("Buffer lleno");
//						lleno.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
			}
			synchronized (this) {
				buff.add(i);
			}
			synchronized (vacio) {
				vacio.notify();
			}
		}
		public Mensaje retirar() {
			synchronized (vacio) {
//				while (buff.size() == 0) {
//					try {
//						System.out.println("Buffer vacio");
//						vacio.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
			}
			Mensaje i;
			synchronized (this) {
				i = buff.remove(0);
			}
			synchronized (lleno) {
				lleno.notify();
			}
			return i;
		}
}
