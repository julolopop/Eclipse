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
	Calculadora calculadora;
	

	
	public ServidorHilo(Socket socket) {
		this.socket= socket;
		calculadora = new Calculadora();
	}

	

	@Override
	public void run() {
		BufferedReader br;
		PrintWriter pw = null;
		boolean salir = false;
		float numero1;
		float numero2;
		float solucion;
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
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.suma(numero1,numero2);

				pw.println(solucion);
				break;
			case "2":
				numero1 = Float.parseFloat(br.readLine());
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.resta(numero1,numero2);

				pw.println(solucion);
				break;
			case "3":
				numero1 = Float.parseFloat(br.readLine());
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.producto(numero1,numero2);

				pw.println(solucion);
				break;
			case "4":
				numero1 = Float.parseFloat(br.readLine());
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.division(numero1,numero2);

				pw.println(solucion);
				break;
			case "5":
				numero1 = Float.parseFloat(br.readLine());
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.potencia(numero1,numero2);

				pw.println(solucion);
				break;
			case "6":
				numero1 = Float.parseFloat(br.readLine());
				solucion = calculadora.masNPrimo(numero1);

				pw.println(solucion);
				break;
			case "7":
				numero1 = Float.parseFloat(br.readLine());
				numero2 = Float.parseFloat(br.readLine());
				solucion = calculadora.raizCuadrada(numero1,numero2);

				pw.println(solucion);
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
