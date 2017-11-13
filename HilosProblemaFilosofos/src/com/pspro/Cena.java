package com.pspro;

class Cena{
	Palillo palillos[];
	int comensales;
	public Cena(int invitados) {
		this.comensales = invitados;
		palillos = new Palillo[comensales];
		for(int i = 0;i < comensales;i++){
			palillos[i] = new Palillo(i);
		}
	}
	public Palillo cogerPalillo(int x){
		return palillos[x];
	}
	public int cogerPalilloDerecho(int pos){
		return (pos+1)%comensales;
	}
	public int cogerPalilloIzquierdo(int pos){
		return pos;
	}
}
