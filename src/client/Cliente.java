package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import textCensorship.SeparateSentence;




public class Cliente implements Runnable {
	private final String SERVER_ADDRESS = "127.0.0.1";
	private ClientSocket clientSocket;
	
	
	public  Cliente() {
		
	}
	
	
	@Override
	public void run() {
	
			try {
				clientSocket = new ClientSocket(new Socket(SERVER_ADDRESS, 12345));
			} catch (UnknownHostException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			
			ClientListener list = new ClientListener(clientSocket);
			new Thread(list).start();
			
			try {
				messageSend("Entrou");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

	public void messageSend(String arg) throws IOException{

		SeparateSentence sepa = new SeparateSentence();

		clientSocket.sendMsg(sepa.newFrase(sepa.separarFraseNormal(arg)));
			

	}
}
