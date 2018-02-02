package com.pspro;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class CirculoSRV implements ICirculo{

	private final double PI = Math.PI;
	private double radio;
	
	public CirculoSRV(Registry registro) {
		System.out.println("Creando objeto Círculo y su inscripción en el registro");
		try {
			registro.bind("Circulo",(ICirculo)UnicastRemoteObject.exportObject(this, 0));
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void setRadio(double radio) throws RemoteException {
		this.radio = radio;
		
	}

	@Override
	public double area() throws RemoteException {
		return PI * this.radio *this.radio;
	}

	@Override
	public double longitud() throws RemoteException {
		return 2 * PI * this.radio;
	}

}
