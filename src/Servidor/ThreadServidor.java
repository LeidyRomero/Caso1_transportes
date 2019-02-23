package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServidor extends Thread{
	private Socket sktCliente = null;
	private int id;
	
	public ThreadServidor(Socket pSocket, int pId)
	{
		this.id = pId;
		this.sktCliente = pSocket;
	}
	
}
