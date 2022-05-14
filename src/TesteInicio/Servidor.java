package TesteInicio;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;


public class Servidor {
	public static final int port = 54321;
	private ServerSocket serverSocket;
	private final List<ClientSocket> clients = new LinkedList<>();
	
	public void start() throws IOException{
		System.out.println("Iniciou na porta " + port);
		serverSocket = new ServerSocket(port);
		clientConnectionLoop();
	}
	
	
	private void clientConnectionLoop() throws IOException{
		while(true) {
			ClientSocket clientSocket = new ClientSocket(serverSocket.accept());		
			clients.add(clientSocket);
			new Thread(() ->  clientMessageLoop(clientSocket)).start(); //expressão lambda para simplificar o código
			
	
		}
	}
	
	
	private void clientMessageLoop(ClientSocket clientSocket) { //metodo para receber mensagens.
		String msg;
		try {
			while((msg = clientSocket.getMessage())!= null){
				
				if ("sair".equalsIgnoreCase(msg))  //finaliza o cliente aberto, individualmente, se comando "sair" for utilizado.
					return;
				
				System.out.printf("Mensagem recebida do client %s: %s\n",
						clientSocket.getRemoteSocketAddress(),
						msg);
				sendMsgToAll(clientSocket, msg);
			}
		} finally {
			clientSocket.close();
		}
	}
	

	private void sendMsgToAll(ClientSocket sender, String msg) {
		Iterator<ClientSocket> iterator = clients.iterator();
		
		while(iterator.hasNext()) { // manda a mensagem para todos que não seja o remetente
			ClientSocket clientSocket = iterator.next();
			if(!sender.equals(clientSocket)) {
				if(!clientSocket.sendMsg("cliente " + sender.getRemoteSocketAddress() + ":" + msg)) {
					iterator.remove();
				}

			}
		}	
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			Servidor server = new Servidor();
			server.start();
		} catch (IOException e) {
			
			System.out.println("Erro ao iniciar o servidor: "+ e.getMessage());
		}
		System.out.println("Servidor Finalizado");
	}

}
