package base;

public class Snake {

	private int x,y;
	private int tam;
	
	public Snake(int tam) {
		this.tam=tam;
	}

	public void mover(int x,int y) {
		this.x+=x;
		this.y+=y;
	}
	
	public void darposicion(int x ,int y) {
		this.x=x;
		this.y=y;
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
	
	
	
}
