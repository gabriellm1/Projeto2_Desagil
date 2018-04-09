package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate {

	private NandGate nandGate1;
	private NandGate nandGate2;
	
	public AndGate() {
		super("AND", 2);
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		
		nandGate1.connect(0,nandGate2);
		nandGate1.connect(1,nandGate2);
	}
	
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandGate2.connect(pinIndex, emitter);
	}

	@Override
	public boolean read() {
		return nandGate1.read();
	}
}


