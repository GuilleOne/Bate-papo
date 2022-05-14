package TesteInicio;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
			clientSocket.close();  //liberar memoria de arquivos ou conex�es abertas.
		}
	}
	
	@Override
	public void run() { // thread para receber mensagens de outras pessoas, sem interrup��o.
		String msg;
		while((msg = clientSocket.getMessage()) != null) {
			System.out.printf("\nMensagem recebida: %s \n", 
				msg);
		}
	}
	
	
	
	private void messageLoop() throws IOException{
		String msg = null;
		do {
			System.out.print("Mensagem (ou 'sair' para finalizar): ");
			msg = scanner.nextLine();
			clientSocket.sendMsg(msg);
			
		} while(!msg.equalsIgnoreCase("sair"));
		
	}

	public static void main(String[] args) {	

		try {
			Cliente client = new Cliente();
			client.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cliente Finalizado");
	}

	

}
