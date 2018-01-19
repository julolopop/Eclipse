package com.pspro;

import java.util.Random;

public class Principal {
		
	public static void main(String[] args) {
		Random  rnd = new Random();
		int nGlobos = rnd.nextInt(10);
		if (nGlobos < 3)
			nGlobos = 10;
		Globos[] almacen = new Globos[nGlobos];
		boolean salir = true;
		
		for (int i = 0; i < almacen.length; i++) {
			almacen[i] = new Globos(i);
		}
		HinchaGlobos hg1 = new HinchaGlobos("hg1",almacen[0]);;
		HinchaGlobos hg2 = new HinchaGlobos("hg2",almacen[1]);
		HinchaGlobos hg3 = new HinchaGlobos("hg3",almacen[2]);
		PinchaGlobos pg1 =  new PinchaGlobos("pg1",almacen[0]);
		PinchaGlobos pg2 = new PinchaGlobos("pg2",almacen[1]);
		PinchaGlobos pg3 = new PinchaGlobos("pg3",almacen[2]);
		
		while (salir) {
			int contador =0;
			int[] globosBuenos = {-1,-1,-1};
			boolean[] globosinflandose = {false,false,false};
			int pos = 0;

			for (int i = 0; i < almacen.length; i++) {
				if(almacen[i].getVolumen() == -1)
					contador++;
				else {
					if(pos < 3)
					globosBuenos[pos] = i;
					pos++;
				}
			}
			if (contador == almacen.length)
				salir = false;
			
			

			if (hg1.fin) {
				if(globosBuenos[0] > -1 && !globosinflandose[0]) {
					hg1 = new HinchaGlobos("hg1",almacen[globosBuenos[0]]);
					globosinflandose[0]=true;
				}else {
					if(globosBuenos[1] > -1&& !globosinflandose[1]) {
						hg1 = new HinchaGlobos("hg1",almacen[globosBuenos[1]]);
						globosinflandose[1]=true;
					}else{
						if(globosBuenos[2] > -1&& !globosinflandose[2]) {
							hg1 = new HinchaGlobos("hg1",almacen[globosBuenos[2]]);
							globosinflandose[2]=true;
						}
					}
				}
			}
			
			
			if (hg2.fin) {
				if(globosBuenos[0] > -1&& !globosinflandose[0]) {
					hg2 = new HinchaGlobos("hg2",almacen[globosBuenos[0]]);
					globosinflandose[0]=true;
				}else {
					if(globosBuenos[1] > -1&& !globosinflandose[1]) {
						hg2 = new HinchaGlobos("hg2",almacen[globosBuenos[1]]);
						globosinflandose[1]=true;
					}else{
						if(globosBuenos[2] > -1&& !globosinflandose[2]) {
							hg2 = new HinchaGlobos("hg2",almacen[globosBuenos[2]]);
							globosinflandose[2]=true;
						}
					}
				}
			}
	
				if (hg3.fin) {
					if(globosBuenos[0] > -1&& !globosinflandose[0]) {
						hg3 = new HinchaGlobos("hg3",almacen[globosBuenos[0]]);
						globosinflandose[0]=true;
					}else {
						if(globosBuenos[1] > -1&& !globosinflandose[1]) {
							hg3 = new HinchaGlobos("hg3",almacen[globosBuenos[1]]);
							globosinflandose[1]=true;
						}else{
							if(globosBuenos[2] > -1&& !globosinflandose[2]) {
								hg3 = new HinchaGlobos("hg3",almacen[globosBuenos[2]]);
								globosinflandose[2]=true;
							}
						}
					}
				}
			if (pg1.fin) {
				if(globosinflandose[0]) {
					pg1 = new PinchaGlobos("pg1",almacen[globosBuenos[0]]);
					globosinflandose[0]=false;
				}else {
					if(globosinflandose[1]) {
						pg1 = new PinchaGlobos("pg1",almacen[globosBuenos[1]]);
						globosinflandose[1]=false;
					}else{
						if(globosinflandose[2]) {
							pg1 = new PinchaGlobos("pg1",almacen[globosBuenos[2]]);
							globosinflandose[2]=false;
						}
					}
				}
			}
			
			if (pg2.fin) {
				if(globosinflandose[0]) {
					pg2 = new PinchaGlobos("pg2",almacen[globosBuenos[0]]);
					globosinflandose[0]=false;
				}else {
					if(globosinflandose[1]) {
						pg2 = new PinchaGlobos("pg2",almacen[globosBuenos[1]]);
						globosinflandose[1]=false;
					}else{
						if(globosinflandose[2]) {
							pg2 = new PinchaGlobos("pg2",almacen[globosBuenos[2]]);
							globosinflandose[2]=false;
						}
					}
				}
			}
			
			if (pg3.fin) {
				if(globosinflandose[0]) {
					pg3 = new PinchaGlobos("pg3",almacen[globosBuenos[0]]);
					globosinflandose[0]=false;
				}else {
					if(globosinflandose[1]) {
						pg3 = new PinchaGlobos("pg3",almacen[globosBuenos[1]]);
						globosinflandose[1]=false;
					}else{
						if(globosinflandose[1]) {
							pg3 = new PinchaGlobos("pg3",almacen[globosBuenos[2]]);
							globosinflandose[1]=false;
						}
					}
				}
			}
				
			
					
					
					
			
		}
		
		
	}

}
