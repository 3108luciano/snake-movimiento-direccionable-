package base;

import java.awt.Graphics2D;

public abstract class Punto {

	private int x;
	private int y;
	private int tam;
	
	public Punto(int x, int y, int tam) {
		this.x=x;
		this.y=y;
		this.tam=tam;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	public void setPosicion(int x, int y) {
		this.x=x;
		this.y=y;
	}

	

	public  abstract void paint(Graphics2D gd2);
	public abstract void move(int x ,int y);
}
