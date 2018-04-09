package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

// A classe View organiza o menu em itens na interface gráfica;
public class View extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;


	// o menu e o subpainel de um Gate.
	private JComboBox<Gate> menu;
	private LogicView logicView;


	public View(LinkedList<Gate> model) {

		//A classe JComboBox representa um componente que pode ser usado como menu
		menu = new JComboBox<>();

		for(Gate gate: model) {
			menu.addItem(gate);
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona o menu a este painel.
		add(menu);

		addGateView(0);

		// ActionListener responde a mudancas no menu
		menu.addActionListener(this);
	}


	// Adiciona o subpainel de um gate a este painel.
	private void addGateView(int index) {
		Gate gate = menu.getItemAt(index);
		logicView = new LogicView(gate);
		add(logicView);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		remove(logicView);
		int index = menu.getSelectedIndex();
		addGateView(index);

		((JFrame) SwingUtilities.getRoot(this)).pack();
	}
}

