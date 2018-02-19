package com.pspro;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;


public class FirmaDigital {
	private static final String ALG1 = "DSA";
	private static final String ALG2 = "RSA";

	private static final String PROTO1 = "DSA";
	private static final String PROTO2 = "SHA256WithRSA";
	
	//DSA es mas rapido ya que solo firma pero si se necesita firmar y verificar RSA es el que tiene que ser utilizado.
	
	
	
	private static String fimar(String message,KeyPair keyPair)throws Exception {
		System.out.println("Creando un objeto de tipo signature");
		//Signature firmaContenedor = Signature.getInstance(PROTO1);
		Signature firmaContenedor = Signature.getInstance(PROTO2);
		
		System.out.println("Firmando el mensaje con la parte PRIVADA de la clave asimetrica");
		firmaContenedor.initSign(keyPair.getPrivate());
		
		firmaContenedor.update(message.getBytes("utf-8"));
		byte[] firma = firmaContenedor.sign();
		
		return Base64.getEncoder().encodeToString(firma);
	}
	
	private static boolean esFirmaValida(String message,String firma,KeyPair keyPair)throws Exception {
		
		System.out.println("Creando un objeto de tipo signature");
		//Signature firmaContenedor = Signature.getInstance(PROTO1);
		Signature firmaContenedor = Signature.getInstance(PROTO2);
		
		
		byte[] mensajeByte = Base64.getDecoder().decode(firma.getBytes("utf-8"));//desacemos el paddin de 64 
		
		System.out.println("Verificando con la parte PUBLICA");
		firmaContenedor.initVerify(keyPair.getPublic());
		
		firmaContenedor.update(message.getBytes("utf-8"));
		
		
		return firmaContenedor.verify(mensajeByte);
	}
	
	public static void main(String[] args) {
		String mensaje = "en un lugar de la mancha, de cuyo nombre no me quiero acordar...";
		
		//System.out.println("obteniendo un generador de claves : "+ALG1);
		System.out.println("obteniendo un generador de claves : "+ALG2);
		
		try {
			//KeyPairGenerator keygen = KeyPairGenerator.getInstance(ALG1);
			KeyPairGenerator keygen = KeyPairGenerator.getInstance(ALG2);
			
		
			System.out.println("Firmando el mensaje con la parte privada");
			
			KeyPair keyPair = keygen.generateKeyPair();		
		
			
			String firma = fimar(mensaje, keyPair);
			
			System.out.println("se firma el mensaje : "+firma);
			
			System.out.println("se mira si es verdad con la clave publica");
			boolean esReal = esFirmaValida(mensaje, firma, keyPair);
			
			System.out.println("digo si es verdad : "+esReal);
		
			System.out.println("manipulamos el mensaje");
			mensaje += " ";
			esReal = esFirmaValida(mensaje, firma, keyPair);
			
			System.out.println("digo si es verdad : "+esReal);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
