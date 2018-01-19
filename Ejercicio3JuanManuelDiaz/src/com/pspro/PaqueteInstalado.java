package com.pspro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PaqueteInstalado{

	public static void main(String[] args) {
				
		try {
			if(args.length < 1) {
				throw new Exception();
			}
			Proceso(args[0]);

			System.out.println("Fin Del Main");
		} catch (IOException e) {
			System.out.println("Error de I/O en los procesos");
		} catch (InterruptedException e) {
			System.out.println("El proceso ha sido interrumpido");
		} catch (Exception e) {
			System.out.println("Error de entrada/salida de los Argumentos");
		}
		
	}
	
	private static void Proceso(String paquete) throws IOException, InterruptedException {
		ProcessBuilder pb1 = new ProcessBuilder("dpkg","--get-selections");
		ProcessBuilder pb2 = new ProcessBuilder("grep", paquete);
		
		
		Process p1 = pb1.start();
		Process p2 = pb2.start();
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
		String linea = "";
		
		while ((linea = br1.readLine())!= null) {
			bw2.write(linea);
			bw2.newLine();
		}
		
		br1.close();
		bw2.close();
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
		
		while ((linea = br2.readLine())!= null) {
			System.out.println(linea);
		}
		
		br2.close();

		int nProceso1 = p1.waitFor();
		int nProceso2 = p2.waitFor();
		

		System.out.println("\n--------------------------------");
		System.out.println("Salida del dpkg : "+ nProceso1);
		System.out.println("Salida del grep : "+ nProceso2);
		
		
		
		
	}
	
}
