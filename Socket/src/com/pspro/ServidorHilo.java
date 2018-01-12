package com.pspro;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread{
	
	Socket socket= null;
	int id =0;
	String mensage = "Bienvenido/a a mi servidor";
	
	public ServidorHilo(Socket socket,int id) {
		this.socket= socket;
		this.id =id;

	}
	
	@Override
	public void run() {
		BufferedOutputStream bo;
		PrintWriter pw = null;
		
		try {
			bo = new BufferedOutputStream(socket.getOutputStream());
			pw = new PrintWriter(bo, true);
			
			pw.println(this.id + " : "+ this.mensage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pw != null) {
			pw.flush();//no deveria utilizarse ya que pw lo libera automaticamente
			pw.close();
		}
		
	}

}
