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
					pw.println(teclado.readLine());
					//pw.println(teclado.readLine());
					entrada=br.readLine();
					System.out.println(entrada);
					break;

				default:
					break;
				}
				
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