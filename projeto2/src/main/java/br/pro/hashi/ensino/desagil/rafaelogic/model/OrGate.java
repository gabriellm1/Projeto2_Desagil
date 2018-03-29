package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{

	private NandGate nandGate1;
	private NandGate nandGate2;
	private NandGate nandGate3;
	
	public OrGate() {
		
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		nandGate3 = new NandGate();
		
		nandGate1.connect(0,nandGate2);
		nandGate1.connect(1,nandGate3);
		
	}
	
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if(pinIndex == 0){
			nandGate2.connect(0, emitter);
			nandGate2.connect(1, emitter);
		}
		if(pinIndex == 1){
			nandGate3.connect(0, emitter);
			nandGate3.connect(1, emitter);
		}

	}

	@Override
	public boolean read() {
		return nandGate1.read();
	}
}
