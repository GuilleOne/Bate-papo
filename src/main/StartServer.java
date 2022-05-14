package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import server.Servidor;

public class StartServer {
	public static void main(String[] args) {
	    try {
	      // Instancia o ServerSocket ouvindo a porta 12345
	      ServerSocket servidor = new ServerSocket(22);
	      System.out.println("Servidor ouvindo a porta 12345");
	      while(true) {
	        // o m�todo accept() bloqueia a execu��o at� que
	        // o servidor receba um pedido de conex�o
	        Socket cliente = servidor.accept();
	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
	        saida.flush();
	        saida.writeObject(new Date());
	        saida.close();
	        cliente.close();
	      }
	    }
	    catch(Exception e) {
	       System.out.println("Erro: " + e.getMessage());
	    }
	    finally {}
	  }
}
