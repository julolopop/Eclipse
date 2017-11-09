package com.pspro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;



public class RunProcessConestados {

	public static void main(String[] args) {
		// La clase recive como parametro el nombre del proceso a lanzar desde la MV
		if (args.length <= 0) {
			System.err.println("Falta el nombre del ejecutable");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process proceso = pb.start();
			MostrarProcesoSalida(proceso);
			System.exit(0);
		}catch (IOException e) {
			System.err.println("Excepcion de E/S");
			System.exit(-1);
		}
		
	}
	
	private static void MostrarProcesoSalida(Process proceso) {
		try {
			int retorno = proceso.waitFor();
			int contador =0;
			System.out.println("El proceso hijo ha devuelto "+retorno);
			
			InputStreamReader lector = new InputStreamReader(proceso.getInputStream(),"utf-8");
			BufferedReader bf = new BufferedReader(lector);
			String linea;
			while((linea = bf.readLine()) != null) {
				if (contador <=5) {
					System.out.println(linea);
				}
				contador++;
			}
			bf.close();
			if(proceso != null) {
				proceso.destroy();
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
