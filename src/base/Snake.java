package base;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Snake extends Punto {
	
	private ArrayList<Cuerpo> cuerpos ;
	;
	

	public ArrayList<Cuerpo> getCuerpos() {
		return cuerpos;
	}

	public void setCuerpos(ArrayList<Cuerpo> cuerpos) {
		this.cuerpos = cuerpos;
	}



	public Snake(int tam, int x, int y) {
		super(x, y, tam);
		cuerpos =  new ArrayList<Cuerpo>();
		cuerpos.add(new Cuerpo((x - tam), y, tam));

	}
	
	@Override
	public void paint(Graphics2D g2d) {
		//g2d.fillRect(getX()+1, getY()+1, getTam()-2, getTam()-2);
		for(Cuerpo eslabon : cuerpos) {
			eslabon.paint(g2d);
		}
	
	}

	@Override
	public void move(int x, int y) {
		
		//for(int i=cuerpos.size()-1;i>0;i--) 
			cuerpos.get(0).setPosicion(cuerpos.get(0).getX()+x,cuerpos.get(0).getY()+y);
		//cuerpos.get(0).setPosicion(x, y);
			
			/*setX(getX()+x);
			setY(getY()+y);*/
		
	}
	
	

}
