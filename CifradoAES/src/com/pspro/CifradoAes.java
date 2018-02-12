package com.pspro;

import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CifradoAes {

	private static String cifrado = "AES";
	
	
	public static SecretKey obtenerClaveOpaca(int longitud) throws Exception{
	
		KeyGenerator ClaveInstancia = KeyGenerator.getInstance(cifrado);
		ClaveInstancia.init(longitud);//128 en oracle por que si no peta por culpa de EEUU
		
		return ClaveInstancia.generateKey();
	}
	
	
	public SecretKeySpec obtenerClaveTransparente(String miClave) throws Exception{
		
		byte[] miClaveBytes = miClave.getBytes();
		System.out.println("el nash sha2 de la clave es : "+DigesUtils.sha256Hex(miClaveBytes) );
		byte[] miClavesha256 = Arrays.copyOf(DigesUtils.sha256(miClaveBytes),16);
		
		return new SecretKeySpec(miClavesha256, cifrado);
		
	}
	
	public static void main(String[] args) {
		


	}

}
