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
			clientSocket = new ClientSocket(
					new Socket(SERVER_ADDRESS, 12345));
			ClientListener list = new ClientListener(clientSocket);
			new Thread(list).start();
			messageSend();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // recebe a ip do servidor e a porta
	
		finally {
			clientSocket.close();  //liberar memoria de arquivos ou conexões abertas.
		}
	}
	

	
	
	
	
	public void messageSend(String...arg) throws IOException{
		String[] msg;
		String newMsg=null;
		String[] vet;
		SeparateSentence sepa = new SeparateSentence();
		
			
		msg = arg;
			
		vet = sepa.separarFraseNormal(msg[0]);
		newMsg= sepa.newFrase(vet);
			
			
		clientSocket.sendMsg(newMsg);
			
		
		
	}
}
