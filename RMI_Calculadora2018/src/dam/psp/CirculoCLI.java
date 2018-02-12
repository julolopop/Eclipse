package dam.psp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CirculoCLI {

	public static String servidor = "192.168.3.57";
	public static int puerto1 = 8888;
	public static int puerto2 = 8889;
	
	public static void main(String[] args) throws RemoteException {
		ICirculo circulo = null;
		ICalculadora calculadora= null;
		
		
		System.out.println("localizando en la red el objeto remoto...");
		Registry registro1 = LocateRegistry.getRegistry(servidor, puerto1);
		Registry registro2 = LocateRegistry.getRegistry(servidor, puerto2);
	
		System.out.println("Obteniendo el falso objeto <stub> del remoto");
		try {
			circulo = (ICirculo) registro1.lookup("Circulo");
			if (circulo != null) {
				circulo.set_radio(20);
				System.out.println("longitud de la circunferencia: " + circulo.longitud());
				System.out.println("área de la circunferencia: " + circulo.area());
			}
			
			calculadora = (ICalculadora) registro2.lookup("Calculadora");
			if (calculadora != null) {
				
				System.out.println("suma " + calculadora.suma(1, 2));
			}
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
