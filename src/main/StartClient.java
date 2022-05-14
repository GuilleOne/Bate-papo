package main;

import java.io.IOException;
import java.net.UnknownHostException;

import client.Cliente;

public class StartClient {

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
