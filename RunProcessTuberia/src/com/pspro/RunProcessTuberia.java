package com.pspro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class RunProcessTuberia {

	public static void main(String[] args) {

		ProcessBuilder procesoA = new ProcessBuilder("/bin/ls","-l","/home/usuario");
		ProcessBuilder procesoB = new ProcessBuilder("tr","a","@");
		
		try {
			Process pA = procesoA.start();
			Process pB = procesoB.start();
			
			BufferedReader SalidaA = new BufferedReader(new InputStreamReader(pA.getInputStream(),"utf-8"));
			
			BufferedWriter EntradaB = new BufferedWriter(new OutputStreamWriter(pB.getOutputStream(),"utf-8"));
			BufferedReader SalidaB = new BufferedReader(new InputStreamReader(pB.getInputStream(),"utf-8"));
						
			//buclea
			String lineaA;
			while((lineaA = SalidaA.readLine()) != null) {
					EntradaB.write(lineaA);
					EntradaB.newLine();
			}
				SalidaA.close();	EntradaB.close();
			//buble de lectura /escritura
			String linea;
			while((linea = SalidaB.readLine()) != null) {
					System.out.println(linea);
			}
			
		
			SalidaB.close();
		
			
			//salida del procesoB por pantalla
			
			int finA = pA.waitFor();
			int finB = pB.waitFor();
			System.out.println("Proceso A y B finalizado: "+finA+" y "+finB);
			SalidaB.close();
			
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
