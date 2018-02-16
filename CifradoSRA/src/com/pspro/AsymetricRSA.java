package com.pspro;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;


public class AsymetricRSA {

	private static final String TAG = "RSA";
	
	private static String encriptar(String message,KeyPair clave)throws Exception{

		Cipher rsaCifrado = Cipher.getInstance(TAG);
		rsaCifrado.init(Cipher.ENCRYPT_MODE, clave.getPublic());
		
		byte[] criptagramaEnBytes = Base64.getEncoder().encode(rsaCifrado.doFinal(message.getBytes("utf-8")));
		
		
		return new String(criptagramaEnBytes);
	}
	
	private static String desencriptar(String criptograma,KeyPair clave)throws Exception{
		

		Cipher rsaCifrado = Cipher.getInstance(TAG);
		rsaCifrado.init(Cipher.DECRYPT_MODE, clave.getPrivate());
		
		byte[] messageEnBytes = Base64.getDecoder().decode(criptograma.getBytes("utf-8"));
		
		
		return new String(rsaCifrado.doFinal(messageEnBytes));
		
	}
	
	private static void mostrarInfo(KeyPair clave)throws Exception{
		KeyFactory factoria = KeyFactory.getInstance(TAG);
		RSAPublicKeySpec partePublica = factoria.getKeySpec(clave.getPublic(), RSAPublicKeySpec.class);
		RSAPrivateKeySpec partePrivate = factoria.getKeySpec(clave.getPrivate(), RSAPrivateKeySpec.class);

		System.out.println("Clave publica  : ");
		System.out.println("Modulus  : "+partePublica.getModulus());
		System.out.println("Exponentus  : "+partePublica.getPublicExponent());
		System.out.println("Clave privada  : ");
		System.out.println("Modulus  : "+partePrivate.getModulus());
		System.out.println("Exponentus  : "+partePrivate.getPrivateExponent());
					
	}
	
	public static void main(String[] args) {
		String message = "anda la que va a liar paco va ha ser parda";
		
		System.out.println("obteniendo el generado de claves RSA");
		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance(TAG);
			
			System.out.println("generando la clave SRA");
			KeyPair clave = keygen.generateKeyPair();

			mostrarInfo(clave);
			
			String criptograma = encriptar(message, clave);
			
			System.out.println("encriptacion : "+criptograma);
			
			String desencrip = desencriptar(criptograma,clave);
			
			System.out.println("desencriptacion : "+desencrip);
			
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
