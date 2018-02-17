package com.pspro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.pspro.ICarculadora;

import jdk.nashorn.internal.ir.BreakableNode;

public class Cliente {

	
	static final String HOST = "localhost";
	static final int PUERTO = 8888;
	
	Scanner entrada;
	
	
	public Cliente() {
		
		try {
			String entrada;
			Socket skcliente = new Socket(HOST, PUERTO);
			BufferedReader br = new BufferedReader(new InputStreamReader(skcliente.getInputStream(),"utf-8"));
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(skcliente.getOutputStream(),"utf-8"),true);
				boolean salida =false;
			
			
			do {
				System.out.println("\n\nCalculadora : elige el numero para hacer la operación");
				System.out.println("1.suma");
				System.out.println("2.resta");
				System.out.println("3.producto");
				System.out.println("4.division");
				System.out.println("5.potencia");
				System.out.println("6.siguiente primo");
				System.out.println("7.raiz");
				System.out.println("q.salir");
				
				entrada = teclado.readLine();
				pw.println(entrada);
				switch (entrada) {
				case "1":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" la suma es : "+entrada);
					break;
				case "2":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" la resta es : "+entrada);
					break;
				case "3":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" el producto es : "+entrada);
					break;
				case "4":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" la division es : "+entrada);
					break;
				case "5":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" la potencia es : "+entrada);
					break;
				case "6":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" el sigiente numero primo es : "+entrada);
					break;
				case "7":
					System.out.println("Escribe el primer numero");
					pw.println(teclado.readLine());
					System.out.println("Escribe el segundo numero");
					pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(" la raiz es : "+entrada);
					break;
					default:
						entrada=br.readLine();
						System.out.println(entrada);
					break;
				}
				System.in.read();
				if(entrada.equals("Adios a mi servidor") || entrada.equals("ERROR"))
					salida = true;
				
			}while(!salida);
		
		
			skcliente.close();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) {

	System.setProperty("java.net.preferIPv4Stack" , "true");
	
	new Cliente();
		

}
}