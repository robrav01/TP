package tp.pr5.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.Ficha;
import tp.pr5.observers.ObservadorTablero;

public class PanelTablero extends JPanel implements ObservadorTablero{
	
	/**
	 * Array de botones que representará al tablero
	 */
	private JButton[][] botones;
	
	/**
	 * Ancho del tablero
	 */
	private int x;
	
	/**
	 * Alto del tablero
	 */
	private int y;
	
	/**
	 * Controlador en el que se realizarán las acciones
	 */
	private ControlVentana control;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de PanelTablero que recibirá el controlador
	 * @param control
	 */
	public PanelTablero(ControlVentana control){
		this.control = control;
		this.control.setObservadorTablero(this);
		iniciarTablero();
		setSize(300,500);
	}
	
	
	/**
	 * Método que inicializa el tablero
	 */
	private void iniciarTablero() {
		x = control.getTablero().getAncho();
		y = control.getTablero().getAlto();
		setLayout(new GridLayout(y, x));
		botones = new JButton[x][y];
		for(int j=0; j< y; j++){
			for(int i = 0; i < x; i++){
				botones[i][j] = new JButton(control.getTablero().getCasilla(i+1, j+1).toIcon());
				botones[i][j].setBackground(Color.white);
				botones[i][j].addActionListener(new ActionListenerCasilla(i, j, control));//Si esto no funciona hacer bucles for
				add(botones[i][j]);
			}
		}
	}
	
	public void cambioCasilla(int posx, int posy, Ficha color) {
		botones[posx][posy].setName(color.toString());
		botones[posx][posy].setIcon(color.toIcon());
	}


}
