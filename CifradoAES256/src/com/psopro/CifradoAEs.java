package com.psopro;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

//https://commons.apache.org/proper/commons-codec/
public class CifradoAEs {

	private static String cifrado = "AES";
	
	
	public static SecretKey obtenerClaveOpaca(int longitud) throws Exception{
	
		KeyGenerator ClaveInstancia = KeyGenerator.getInstance(cifrado);
		ClaveInstancia.init(longitud);//128 por defecto
		
		return ClaveInstancia.generateKey();
	}
	
	
	public static SecretKeySpec obtenerClaveTransparente(String miClave) throws Exception{
		
		byte[] miClaveBytes = miClave.getBytes();
		System.out.println("el nash sha2 de la clave es : "+DigestUtils.sha256Hex(miClaveBytes) );
		byte[] miClavesha256 = Arrays.copyOf(DigestUtils.sha256(miClaveBytes),16);
		
		return new SecretKeySpec(miClavesha256, cifrado);
		
	}
	
	public static String encriptar(String mensage,SecretKey key) throws Exception {
		
		Cipher c = Cipher.getInstance(cifrado);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(mensage.getBytes("utf-8"));
		
		byte[] encriptogramaEnbyte = Base64.encodeBase64(encValue);
		return new String(encriptogramaEnbyte);
		
		
	}
	

	public static String desencriptar(String criptograma,SecretKey key) throws Exception {
		
		Cipher c = Cipher.getInstance(cifrado);
		c.init(Cipher.DECRYPT_MODE, key);
		
		byte[] desencriptogramaEnbyte = Base64.decodeBase64(criptograma);

		byte[] desValue = c.doFinal(desencriptogramaEnbyte);
		
		return new String(desValue);
		
		
	}
	
	

	public static void main(String[] args) {
	
	String mensage = "vaya melón que tiene un ciceron un veiernes por la noche";
	String key = "123;abc";
	
	System.out.println("Clave encript");
	
	
	try {
		SecretKey miclave = obtenerClaveOpaca(128);
		
		
		System.out.println("mensage en claro : " + mensage);
		
		String criptograma = encriptar(mensage,miclave);
		
		System.out.println("Criptograma "+ criptograma);
		
		String desmensage = desencriptar(criptograma, miclave);
		
		System.out.println(desmensage);
		
		
		System.out.println("Clave mia "+key);
		 miclave = obtenerClaveTransparente(key);

			
		System.out.println("mensage en claro : " + mensage);
			
		criptograma = encriptar(mensage,miclave);
			
		System.out.println("Criptograma "+ criptograma);
			
		desmensage = desencriptar(criptograma, miclave);
			
		System.out.println(desmensage);
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	


	}
}