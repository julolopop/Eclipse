package com.pspro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalcuradora extends Remote {

	public float suma (float a,float b)throws RemoteException;
	public float resta (float a,float b)throws RemoteException;
	public float producto (float a,float b)throws RemoteException;
	public float division (float a,float b)throws RemoteException;
}
