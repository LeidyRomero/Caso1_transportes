package Comunicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

	private ArrayList<Integer> buff;
	private int n;
	Object lleno;
	Object vacio;

	public Buffer(int n) throws IOException {


		//Leyendo la capacidad del buffer:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();//numero de servidores
		lector.readLine();//numero de clientes
		String[] datos = lector.readLine().split(":");
		this.capacidad = Integer.parseInt(datos[1]);


		buff = new ArrayList<Integer>();
		lleno = new Object();
		vacio = new Object();
	}
	//TODO revisar
	//	public void almacenar(Integer i) {
	//		synchronized (lleno) {
	//			while (buff.size() == n) {
	//				try {
	//					System.out.println("Buffer lleno");
	//					lleno.wait();
	//				} catch (InterruptedException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		}
	//		synchronized (this) {
	//			buff.add(i);
	//		}
	//		synchronized (vacio) {
	//			vacio.notify();
	//		}
	//	}
	//	public Integer retirar() {
	//		synchronized (vacio) {
	//			while (buff.size() == 0) {
	//				try {
	//					System.out.println("Buffer vacio");
	//					vacio.wait();
	//				} catch (InterruptedException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		}
	//		Integer i;
	//		synchronized (this) {
	//			i = buff.remove(0);
	//		}
	//		synchronized (lleno) {
	//			lleno.notify();
	//		}
	//		return i;
	//	}
}
