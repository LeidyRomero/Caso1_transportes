package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Protocolo {
	public static void procesar (BufferedReader pIn, PrintWriter pOut, int numeroThread) throws IOException
	{
		String inPutLine;
		String outPutLine;
		
		inPutLine = pIn.readLine();
		System.out.println("Entro a procesar "+numeroThread+": "+inPutLine);
		
		outPutLine = inPutLine;
		System.out.println("Toma tu hermoso resultado: "+numeroThread+": "+ outPutLine);
		
		pOut.println(outPutLine);
	}
}
