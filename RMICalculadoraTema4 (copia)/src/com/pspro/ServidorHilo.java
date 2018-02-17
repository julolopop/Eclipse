package com.pspro;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.xml.crypto.KeySelector.Purpose;

public class ServidorHilo extends Thread{
	
	Socket socket= null;
	ICarculadora calculadora;
	

	
	public ServidorHilo(Socket socket,Registry registro) {
		this.socket= socket;
		try {
			
			calculadora = (ICarculadora) registro.lookup("Calculadora");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void run() {
		BufferedReader br;
		PrintWriter pw = null;
		boolean salir = false;
		float numero1;
		float numero2;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			String entrada;
			while(!salir){
			if(calculadora != null) {
				
			entrada = br.readLine();
			switch (entrada) {
			case "1":
				numero1 = Float.parseFloat(br.readLine());
				//numero2 = Float.parseFloat(br.readLine());
				numero1 = calculadora.masNPrimo((int)numero1);

				pw.println(numero1);
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			case "7":
				
				break;
			case "q":
				salir=true;
				break;
			default:
				pw.println("Clave incorrecta");
				break;
			}
			}else {
				salir = true;
				pw.println("ERROR");
			}
			
			
			}
			pw.println("Adios a mi servidor");
			
			
		} catch (IOException e) {
			pw.println("ERROR");
		}
		
		if(pw != null) {
			pw.flush();//no deveria utilizarse ya que pw lo libera automaticamente
			pw.close();
		}
	}	
	



}
