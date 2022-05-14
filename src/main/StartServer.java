package main;

import java.io.IOException;

import server.Servidor;

public class StartServer {

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
