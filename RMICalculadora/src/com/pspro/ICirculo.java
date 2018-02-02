package com.pspro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICirculo extends Remote{
	public void setRadio(double radio) throws RemoteException;
	public double area() throws RemoteException;
	public double longitud() throws RemoteException;

}
