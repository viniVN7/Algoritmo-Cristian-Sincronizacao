
public class RelogioServidorCristian extends Thread{
   
	public void run(){
		while(true){
			ServidorCristian.relogio++;
			System.out.println(ServidorCristian.relogio);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
