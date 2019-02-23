package Main;

import java.io.IOException;

import Cliente.ClientePrincipal;
import Comunicacion.Buffer;
import Servidor.ServidorPrincipal;

public class main {

	public static void main(String[] args) throws IOException {
		Buffer buffer = new Buffer();
		ServidorPrincipal servidor = new ServidorPrincipal(buffer);
		ClientePrincipal cliente = new ClientePrincipal(buffer);
	}
}
