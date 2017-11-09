package com.pspro;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {
		// La clase recive como parametro el nombre del proceso a lanzar desde la MV
		if (args.length <= 0) {
			System.err.println("Falta el nombre del ejecutable");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		String pid; //el pid del proceso como argumento
		pid = ManagementFactory.getRuntimeMXBean().getName();
		
		System.out.println("El PID del padre es "+pid);
		try {
			Process proceso = pb.start();
			int retorno = proceso.waitFor();
			System.out.println("La Ejecucion de "+Arrays.toString(args)+" Devuelve "+retorno);
		}catch (InterruptedException e) {
			System.err.println("Excepcion de Interrupcion");
		} catch (IOException e) {
			System.err.println("Excepcion de E/S");
		}
		
		
	}

}
