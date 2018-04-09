package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javax.swing.JCheckBox;


import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class LogicView extends JPanel implements ActionListener {


	private static final long serialVersionUID = 1L;


	private Gate gate;

	private	JCheckBox receiver0;
	private	JCheckBox receiver1;
	private JCheckBox out;


	public LogicView(Gate gate) {
		this.gate = gate;

		receiver0 = new JCheckBox("Receiver 1");
		receiver1 = new JCheckBox("Receiver 2");
		out = new JCheckBox("Out");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona todas as componentes a este subpainel.
		add(receiver0);
		if (gate.lenght() > 1) {
			add(receiver1);
		}
		add(out);


		receiver0.addActionListener(this);
		receiver1.addActionListener(this);


		out.setEnabled(false);


		update();
	}


// Esse metodo usa as outras classes dos Gates e compara com os estados com os CheckBox da interface
	private void update() {
		boolean stateReceiver0;
		boolean stateReceiver1;
		Source emitterTest0 = new Source();
		Source emitterTest1 = new Source();

		stateReceiver0 = receiver0.isSelected();
		stateReceiver1 = receiver1.isSelected();
		
		
		if (stateReceiver1) {
			emitterTest1.turn(true);
			gate.connect(1, emitterTest1);
		}
		else if (!stateReceiver1) {
			emitterTest1.turn(false);
			gate.connect(1, emitterTest1);
		}
		
		
		if (stateReceiver0) {
			emitterTest0.turn(true);
			gate.connect(0, emitterTest0);
		}
		else if (!stateReceiver0) {
			emitterTest0.turn(false);
			gate.connect(0, emitterTest0);
		}
		
		
		if (gate.read()) {
			out.setSelected(true);
		}
		else {
			out.setSelected(false);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
