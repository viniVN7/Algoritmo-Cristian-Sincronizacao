import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorCristian {

	static int relogio=0;
		
	public static void main(String[] args) throws IOException {
		RelogioServidorCristian rel = new RelogioServidorCristian();
		rel.start();
			
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			ConexaoClienteServidor c = new ConexaoClienteServidor(connectionSocket);
			c.start();
		}


		
	}

}
