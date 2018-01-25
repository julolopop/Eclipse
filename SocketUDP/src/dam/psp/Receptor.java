package dam.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Receptor {
	public static final int PUERTO = 4444;
	public static final String IPEMISOR = "0.0.0.0";
	
	public Receptor() {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PUERTO,InetAddress.getByName(IPEMISOR));
		
			
			System.out.println("Emisor conectado al socker : "+socket.getLocalAddress());
			while (true) {
				DatagramPacket dato = new DatagramPacket(new byte[144], 144);
				//se recibe un dato y se escribe por pantalla 
				socket.receive(dato);//bloqueante
				System.out.println("Recibido un paquete de : "+ dato.getAddress().getHostName() +";");
				DatoUDP contenido = DatoUDP.FromByteArray(dato.getData());
				
				System.out.println(" de longitudad : "+dato.getLength());
				
				//deserializamos a string
				System.out.println(contenido.cadenaTexto+" : "+contenido.valor);
				/*
				for (int i = 0; i < dato.getLength(); i++) {
					System.out.print(dato.getData()[i]);
				}
				System.out.println();
				*/
				
			}			
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			socket.close();
		}
		
	}
	
	
	public static void main(String[] args) {
		new Receptor();
	}

}
