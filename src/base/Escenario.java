package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Escenario extends JFrame {

	private JPanel contentPane;
	private ArrayList<JLabel>vsnake;
	private JLabel fondo;
	private static final int ANCHO = 600;
	private static final int ALTURA = 600;
	
	private int dx,dy;
	private int tam=20;
	private boolean corriendo;
	
	
	private Timer tiempo;
	
	private boolean arriba,abajo,derecha,izquierda;
	
	public Escenario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ANCHO, ALTURA);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
			//serpiente
			vsnake = new ArrayList<JLabel>();
			
			
			JLabel aux = new JLabel();
			aux.setIcon(new ImageIcon("bin\\imagenes\\parte2.png"));
			aux.setBounds(107, 86, 20, 20);
			vsnake.add(aux);
			contentPane.add(vsnake.get(0));
			
			
			
			fondo = new JLabel();
			fondo.setIcon(new ImageIcon("bin\\imagenes\\tablero.png"));
			fondo.setBounds(10, 0, ANCHO, ALTURA);
			contentPane.add(fondo);
			
		
			
			//tiempo
			
			tiempo = new Timer(400, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					vsnake.get(0).setLocation(vsnake.get(0).getX()+dx,vsnake.get(0).getY()+dy);
					
				}
			});
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					

				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()==KeyEvent.VK_UP) {
						arriba=true;
					
						if(vsnake.get(0).getY()>0) {
							dy= -tam;
							dx=0;
							vsnake.get(0).setIcon(new ImageIcon("bin\\imagenes\\parte3.png"));
						}
						if(!corriendo) {
							tiempo.start();
							corriendo = true;
						}
				}
					if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					abajo=true;
					if(vsnake.get(0).getY()<ALTURA) {
						dy= tam;
						dx=0;
						vsnake.get(0).setIcon(new ImageIcon("bin\\imagenes\\parte4.png"));
					}
					if(!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
					if(e.getKeyCode()==KeyEvent.VK_LEFT) {
						izquierda=true;
					if(vsnake.get(0).getX()>0) {
						dx= -tam;
						dy=0;
						vsnake.get(0).setIcon(new ImageIcon("bin\\imagenes\\parte5.png"));
					}
					if(!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
					if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					derecha=true;
					if(vsnake.get(0).getY()<ANCHO) {
						dx= tam;
						dy=0;
						vsnake.get(0).setIcon(new ImageIcon("bin\\imagenes\\parte2.png"));
					}
					
					if(!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
				}
			});
			setVisible(true);
	}
	
}
	