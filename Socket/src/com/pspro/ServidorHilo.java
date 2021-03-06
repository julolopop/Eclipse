package com.pspro;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		BufferedReader br;
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			pw.print("Bienvenido a mi servidor");
			pw.println(this.id + " : "+ this.mensage);
			
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			System.out.println(br.readLine());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pw != null) {
			pw.flush();//no deveria utilizarse ya que pw lo libera automaticamente
			pw.close();
		}
	}	
	
/*	@Override
	public void run() {
		BufferedOutputStream bo;
		BufferedInputStream is;
		BufferedReader br;
		PrintWriter pw = null;
		
		try {
			bo = new BufferedOutputStream(socket.getOutputStream());
			pw = new PrintWriter(bo, true);
			
			pw.println(this.id + " : "+ this.mensage);
			
			
			// y espera una respuesta en forma de string desde el cliente
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pw != null) {
			pw.flush();//no deveria utilizarse ya que pw lo libera automaticamente
			pw.close();
		}
		
	}*/


}
