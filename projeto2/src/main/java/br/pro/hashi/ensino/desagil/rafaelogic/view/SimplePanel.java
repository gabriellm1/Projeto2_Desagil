package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

// criação de JPANEL com tamanho fixo
public class SimplePanel extends JPanel {
	private static final long serialVersionUID = 1L;


	//determina largura e altura do jpanel
	public SimplePanel(int width, int height) {

		//não ter layout para que o tamanho seja fixo
		setLayout(null);

		
		setPreferredSize(new Dimension(width, height));
	}


	// determina posição e tamanho de cada componente
	public Component add(Component comp, int x, int y, int width, int height) {

		// Usa a implementaÃ§Ã£o original do mÃ©todo para adicionar.
		super.add(comp);

		// redefine posição do componente
		comp.setBounds(x, y, width, height);

		return comp;
	}
}
