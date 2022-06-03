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
	
	public void start() throws UnknownHostException, IOException {
		try {
		clientSocket = new ClientSocket(
				new Socket(SERVER_ADDRESS, 12345)); // recebe a ip do servidor e a porta
		
		
		new Thread(this).start();
		messageLoop();
	
		} finally {
			clientSocket.close();  //liberar memoria de arquivos ou conexões abertas.
		}
	}
	
	@Override
	public void run() { // thread para receber mensagens de outras pessoas, sem interrupção.
		String msg;
		while((msg = clientSocket.getMessage()) != null) {
			System.out.printf("\nMensagem recebida: %s \n", 
				msg);
		}
	}
	
	
	
	
	public void messageLoop(String...arg) throws IOException{
		String[] msg;
		String newMsg=null;
		String[] vet;
		SeparateSentence sepa = new SeparateSentence();
		
		do {
			
			msg = arg;
			
			vet = sepa.separarFraseNormal(msg[0]);
			newMsg= sepa.newFrase(vet);
			
			
			clientSocket.sendMsg(newMsg);
			
		} while(!msg[0].equalsIgnoreCase("sair"));
		
	}
}
