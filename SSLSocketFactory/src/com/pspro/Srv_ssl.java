package com.pspro;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

class srv_Hilo extends Thread{
	
	SSLSocket socket;
	
	public srv_Hilo(SSLSocket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(socket.getInputStream(),"utf8");
			BufferedReader br = new BufferedReader(is);
			
						
			String message = br.readLine();
			System.out.println(message);
			
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			
			byte[] messageByte = message.getBytes();
			
			
			MessageDigest sha = MessageDigest.getInstance("SHA-128");
		
			
			pw.write(message);
			pw.flush();
			
			
			pw.close();
			br.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


public class Srv_ssl {

	public int PUERTO = 8888;

	public Srv_ssl() throws Exception{
		System.out.println("Obteniendo factoria del socket para el servidor");
		SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		
		System.out.println("Creando socker");
		SSLServerSocket socket = (SSLServerSocket) serverSocketFactory.createServerSocket(PUERTO);
		
		while (true){
			System.out.println("Aceptamos conexión");
			SSLSocket socketdeAtencion = (SSLSocket) socket.accept();
			
			new srv_Hilo(socketdeAtencion).start();;
		}
		
	}
	
	public static void main(String[] args) {
		System.setProperty("java.net.ss.keyStore", "AlmacenSRV");
		System.setProperty("java.net.ss.keyStorePassword", "12345678");
		System.setProperty("java.net.ss.trustStore", "AlmacenSRV");
		System.setProperty("java.net.ss.trustStorePassword", "12345678");
		
		try {
			new Srv_ssl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
