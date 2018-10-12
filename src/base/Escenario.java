package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.JFrame;

public class Escenario extends JFrame {

	private JPanel contentPane;

	private static final int ANCHO = 600;
	private static final int ALTURA = 600;

	private int dx, dy;
	private int tam = 20;

	Snake snake;
	private boolean arriba, abajo, derecha, izquierda;
	private boolean corriendo;
	private Timer tiempo;

	public Escenario() {

		super("Slither");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, ANCHO, ALTURA);
		setLocationRelativeTo(null);
		setVisible(true);

		// serpiente
		snake = new Snake(tam, ANCHO / 2, ALTURA / 2);

		tiempo = new Timer(200, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				snake.move(dx, dy);

			}
		});
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					arriba = false;
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					abajo = false;
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					izquierda = false;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					derecha = false;
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					arriba = true;
					if (!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					abajo = true;
					if (!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					izquierda = true;

					if (!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					derecha = true;
					if (!corriendo) {
						tiempo.start();
						corriendo = true;
					}
				}

			}

		});

	}

	public void iniciar() {

		while (true) {
			move();
			paint(this.getGraphics());
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // VUELVO A PINTAR, Y BORRO EL ANTERIOR
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.RED);
		snake.paint(g2d);
	}

	private void move() {

		if (arriba && snake.getY() > 0) {
			dy = -tam;
			dx = 0;

		}

		if (abajo && snake.getY() < ALTURA) {
			dy = tam;
			dx = 0;

		}

		if (izquierda && snake.getX() > 0) {
			dx = -tam;
			dy = 0;

		}

		if (derecha && snake.getX() < ANCHO) {
			dx = tam;
			dy = 0;

		}

	}
}
