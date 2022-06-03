package client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import frame.Chat;

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
			DateFormat df = new SimpleDateFormat("hh:m:ss");
//			Chat.append_message("<b>" + df.format(new Date()) + " " + msg + "</i><br>");
			Chat.receive(msg);
		}
	}
	
	
	
	

}
