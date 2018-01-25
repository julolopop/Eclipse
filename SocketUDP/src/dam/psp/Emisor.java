package dam.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Emisor {

	public static final int PUERTOEMISOR = 5555;
	public static final int PUERTORECEPTOR = 4444;
	public static final String IPEMISOR = "0.0.0.0";
	//public static final String IPRECEPTOR = "192.168.2.171";
	//public static final String IPRECEPTOR = "192.168.3.57";
	public static final String IPRECEPTOR = "192.168.255.255";
	
	public Emisor() {
		DatagramSocket emisor = null;
		DatagramPacket dgp;
		InetAddress IPLocal;
		InetAddress IPRemoto;
		
		byte[] contenido = new DatoUDP("hola don pepito",171).ToByteArray();
		
		try {
			IPLocal = InetAddress.getByName(IPEMISOR);
			IPRemoto = InetAddress.getByName(IPRECEPTOR);
			
			emisor = new DatagramSocket(PUERTOEMISOR,IPLocal);//por donde sale el mensage;
			dgp = new DatagramPacket(contenido, contenido.length,IPRemoto,PUERTORECEPTOR);
			
			emisor.send(dgp);
			System.out.println("datos correctamente enviados");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			emisor.close();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		new Emisor();
	}
}
