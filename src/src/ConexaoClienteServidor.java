import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class ConexaoClienteServidor extends Thread{

	private Socket s;
	
	public ConexaoClienteServidor(Socket s){
		this.s = s;
	}
	
	public void run(){
		try{

		BufferedReader inFromClient = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(
				s.getOutputStream());
		inFromClient.readLine();
		System.out.println("Chegou pedido de requisicao");
		int timeChegada = ServidorCristian.relogio;
		
		this.sleep(2000);
		
		
		outToClient.writeBytes(String.valueOf((ServidorCristian.relogio-timeChegada))+"\n");
		outToClient.writeBytes(String.valueOf(ServidorCristian.relogio)+"\n");
		System.out.println("Servidor enviou resposta: "+ServidorCristian.relogio);
		outToClient.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
}
