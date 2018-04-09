package br.pro.hashi.ensino.desagil.rafaelogic.model;

public abstract class Gate implements Emitter, Receiver {
	String name;
	int size;
	
	protected Gate(String name, int size) {
		this.size = size;
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	public int lenght() {
		return size;
	}
}
