package base;

import java.awt.Graphics2D;

public class Cuerpo extends Punto {

	public Cuerpo(int x, int y, int tam) {
		super(x, y, tam);
	}

	@Override
	public void paint(Graphics2D gd2) {
	
		gd2.fillRect(getX()+1, getY()+1, getTam()-2, getTam()-2);
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
