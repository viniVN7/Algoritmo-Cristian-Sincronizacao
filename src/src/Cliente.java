import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	static int relogio = 0;

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		RelogioCliente rc = new RelogioCliente();
		rc.start();

		Socket clientSocket = new Socket("127.0.0.1", 6789);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

	//	Scanner scan = new Scanner(System.in);
	//	scan.nextLine();
		System.out.println("Enviando pedido de sincronizacao");
		int t0 = relogio;
		outToServer.writeBytes("" + '\n');
		int i = Integer.parseInt(inFromServer.readLine());
		int r = Integer.parseInt(inFromServer.readLine());
		int t1 = relogio;
		int d = (t1 - t0 - i) / 2;
		relogio = r + d;
		System.out.println("O valor de r: "+r +" o valor de D: "+ d);
		clientSocket.close();
	}

}
