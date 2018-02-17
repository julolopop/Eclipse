package com.pspro;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.pspro.ICarculadora;

public class Calculadora implements ICarculadora {

	@Override
	public float suma(float a, float b) throws RemoteException {
		return a+b;
	}

	@Override
	public float resta(float a, float b) throws RemoteException {
		return a-b;
	}

	@Override
	public float producto(float a, float b) throws RemoteException {
		return a*b;
	}

	@Override
	public float division(float a, float b) throws RemoteException {
		if(b == 0)
			throw new RemoteException("Error division por 0");
		return a/b;
	}

	
	

	@Override
	public float raizCuadrada(float a, float b) throws RemoteException {
		return (float) Math.pow(a, 1/b);
	}

	@Override
	public float potencia(float a, float b) throws RemoteException {
		
		return (float) Math.pow(a, b);
	}

	@Override
	public float masNPrimo(float a) throws RemoteException {
		boolean salida = false;
		boolean primo = true;
		do {
			primo =true;
			a++;
			for (int i = 2; i < a; i++) {
				if(a%i==0)
					primo=false;
			}
			if(primo)
				salida=true;
		}while(!salida);
		
		return a;
	}



	
	
}
