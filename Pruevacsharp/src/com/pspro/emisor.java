package com.pspro;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class emisor {

	public static void main(String[] args) {
		
			try {
				Socket socket = new Socket("192.168.2.171", 4444);
				//byte[] mess = "hola caracola".getBytes();
				
				BufferedOutputStream bo = new BufferedOutputStream(socket.getOutputStream());
				
				Dado dado = new Dado("ssds");
				
				
				
				bo.write(ToByteArray(dado));
				bo.flush();
				
				socket.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	
	
	public static byte[] ToByteArray(Dado dado) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(dado);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
	

	
	
}



