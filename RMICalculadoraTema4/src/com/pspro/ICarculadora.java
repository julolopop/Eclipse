package com.pspro;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICarculadora{
	public float suma(float a, float b) throws RemoteException;
	public float resta(float a, float b) throws RemoteException;
	public float producto(float a, float b) throws RemoteException;
	public float division(float a, float b) throws RemoteException;
	
	public float raizCuadrada(float a, float b) throws RemoteException;
	public float potencia(float a, float b) throws RemoteException;
	public float masNPrimo(float a) throws RemoteException;
}
