package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.*;
import textCensorship.*;

public class Cliente implements Runnable {
	private final String SERVER_ADDRESS = "127.0.0.1";
	private ClientSocket clientSocket;
	private Scanner scanner;
	
	public  Cliente() {
		scanner = new Scanner(System.in);
	}
	
	public void start() throws UnknownHostException, IOException {
		try {
		clientSocket = new ClientSocket(
				new Socket(SERVER_ADDRESS, Servidor.port));
		
		
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
	
	
	
	private void messageLoop() throws IOException{
		String msg = null;
		String newMsg = null;
		SeparateSentence sepa = new SeparateSentence();
		String[] vet;
		do {
			System.out.print("Mensagem (ou 'sair' para finalizar): ");
			msg = scanner.nextLine();
			
			vet = sepa.separarFraseNormal(msg);
			newMsg = sepa.newFrase(vet);
			
			
			clientSocket.sendMsg(newMsg);
			
		} while(!msg.equalsIgnoreCase("sair"));
		
	}
}
