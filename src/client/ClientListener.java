package client;

public class ClientListener implements Runnable{
	ClientSocket socket;

	public ClientListener(ClientSocket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() { // thread para receber mensagens de outras pessoas, sem interrupção.
		String msg;
		while((msg = socket.getMessage()) != null) {
			System.out.printf("\nMensagem recebida: %s \n", 
				msg);
		}
	}
	
	
	
	

}
