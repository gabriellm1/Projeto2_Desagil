package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;


import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class LogicView extends SimplePanel implements ActionListener , MouseListener{


	private static final long serialVersionUID = 1L;


	private Gate gate;

	private	JCheckBox receiver0;
	private	JCheckBox receiver1;
	private boolean out;
	
	private Color cor;
	private Image imagem;
	


	public LogicView(Gate gate) {
		
		super(350, 250);
		
		this.gate = gate;

		receiver0 = new JCheckBox("Receiver 1");
		receiver1 = new JCheckBox("Receiver 2");

		// Adiciona todas as componentes a este subpainel com as coordenadas.
		if (this.gate.lenght() == 1){  
			add(receiver0, 55, 90, 20, 20);
		} else if (this.gate.lenght() == 2) {
			add(receiver0, 55, 138, 20, 20);
			add(receiver1, 55, 90, 20, 20);
		}		

		receiver0.addActionListener(this);
		receiver1.addActionListener(this);

		cor = Color.BLACK;
		
		// coloca a imagem da porta logica
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		imagem = new ImageIcon(url).getImage();
		
		update();
		
		addMouseListener(this);
	}


// Esse metodo usa as outras classes dos Gates e compara com os estados com os CheckBox da interface
	private void update() {
		boolean stateReceiver0;
		boolean stateReceiver1;
		
		Source emitterTest0 = new Source();
		Source emitterTest1 = new Source();

		stateReceiver0 = receiver0.isSelected();
		stateReceiver1 = receiver1.isSelected();
		
		emitterTest0.turn(stateReceiver0); 
		emitterTest1.turn(stateReceiver1);
		
		gate.connect(1, emitterTest1); 
		gate.connect(0, emitterTest0);
		
		
		if (gate.read()) {
			//sendo a saida 1, cor vermelha
			out = true;
			cor = Color.RED;
			repaint();
		}
		else {
			//sendo a saida 0, cor preta
			out = false;
			cor = Color.BLACK;
			repaint();
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}

	//criando opção de escolher a cor quando saida for 1
	@Override
	public void mouseClicked(MouseEvent evento) {

		int x = evento.getX();
		int y = evento.getY();
		
		//distância do centro da circunferência
		double distcent = Math.sqrt(Math.pow(290-x, 2)+Math.pow(125-y, 2));

		//se a distância do centro é menor que o raio e a saída é 1
		//poderá se mudar a cor
		if(out == true && distcent<=15) {
			cor = JColorChooser.showDialog(this, null, cor);
			repaint();
			}
		
		
	}

	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		//desenhando porta
		g.drawImage(imagem, 75, 75, 200, 100 ,null);

		g.setColor(cor);
		//desenhando led 
		g.fillArc(275,110, 30, 30, 0, 360);

		getToolkit().sync();
	}
	

	@Override
	public void mouseEntered(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}
}
