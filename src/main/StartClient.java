package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JOptionPane;

import client.Cliente;

public class StartClient {
	public static void main(String[] args) {
	    try {
	      Socket cliente = new Socket("tcp://0.tcp.sa.ngrok.io:12440", 22);
	      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
	      Date data_atual = (Date)entrada.readObject();
	      JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
	      entrada.close();
	      System.out.println("Conexão encerrada");
	    }
	    catch(Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }
	  }

}
