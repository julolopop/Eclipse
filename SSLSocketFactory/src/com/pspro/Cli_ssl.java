package com.pspro;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cli_ssl {

	static final String DESTINO = "192.168.2.171";
	static final int PUERTO = 8888;
	
	
	private void mostarCifrado(SSLSocket socket) {
		String[] protocolos = socket.getEnabledProtocols();
		System.out.println("Protocolos habilitados");
		
		for (int i = 0; i < protocolos.length; i++) {
			System.out.println(protocolos[i]);
		}
		String[] ProtocolosSoportados = socket.getSupportedProtocols();
		for (int i = 0; i < ProtocolosSoportados.length; i++) {
			System.out.println(ProtocolosSoportados[i]);
		}
		String[] ProtocolosDeseados = new String[1];
		ProtocolosDeseados[0] = "TLSv1.2";
		
		socket.setEnabledProtocols(ProtocolosDeseados);
		

		System.out.println("Protocolos activos : ");
		
		protocolos = socket.getEnabledProtocols();
		System.out.println("Protocolos habilitados");
		
		for (int i = 0; i < protocolos.length; i++) {
			System.out.println(protocolos[i]);
		}
		ProtocolosSoportados = socket.getSupportedProtocols();
		for (int i = 0; i < ProtocolosSoportados.length; i++) {
			System.out.println(ProtocolosSoportados[i]);
		}
		
	}
	
	public Cli_ssl(String message) throws Exception{
		System.out.println("obteniendo factoria de socker del cliente---");
		SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		
		System.out.println("Creando el socket del cliente-...");
		SSLSocket socketCliente = (SSLSocket) socketFactory.createSocket(DESTINO, PUERTO);
		
		mostarCifrado(socketCliente);
		
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(socketCliente.getOutputStream()),true);
		pw.println(message.getBytes());
		pw.flush();
		
		System.out.println("message send");
		BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
		
		System.out.println("mensage cifrado : "+br.readLine());
		
		pw.close();
		br.close();
		socketCliente.close();
		
		
	}
	
	public static void main(String[] args) {

		System.setProperty("java.net.ss.keyStore", "AlmacenCLi");
		System.setProperty("java.net.ss.keyStorePassword", "87654321");
		System.setProperty("java.net.ss.trustStore", "AlmacenCli");
		System.setProperty("java.net.ss.trustStorePassword", "87654321");
		
		// TODO Auto-generated method stub
		try {
			new Cli_ssl("Hola");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
