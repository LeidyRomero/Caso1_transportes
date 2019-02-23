package Comunicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Buffer {
	
	public static final String RUTA = "./data/infoMain.txt";
	private int capacidad = 0;
	
	public Buffer() throws IOException
	{
		//Leyendo la capacidad del buffer:
		BufferedReader lector = new BufferedReader(new FileReader(new File(RUTA)));
		lector.readLine();//numero de servidores
		lector.readLine();//numero de clientes
		String[] datos = lector.readLine().split(":");
		capacidad = Integer.parseInt(datos[1]);
	}
}
