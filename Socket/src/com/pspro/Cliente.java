package com.pspro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.Period;
import java.util.Scanner;

import javax.xml.stream.util.EventReaderDelegate;

public class Cliente {

	static final String HOST = "localhost";
	//static final String HOST = "192.168.3.57";
	static final int PUERTO = 5000;
	
	Scanner entrada;
	
	private String leerMensage() {
		System.out.println("Introduce el mensage para enviar");
		String message = entrada.nextLine();
		return message;
	}
	
	public Cliente() {
	
		try {
			Socket skcliente = new Socket(HOST, PUERTO);
			
			InputStreamReader is = new InputStreamReader(skcliente.getInputStream(),"utf8");
			
			BufferedReader br = new BufferedReader(is);
			
			System.out.println(br.readLine());//una vez recibimos el saludo del servidor cerramos la conexión
			
			skcliente.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) {

	System.setProperty("java.net.preferIPv4Stack" , "true");
	
	new Cliente();
		
	
		
	
}
	
}
