
public class RelogioCliente extends Thread{
   
	public void run(){
		while(true){
			Cliente.relogio++;
			System.out.println(Cliente.relogio);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
