package tp.pr5.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.pr5.control.ControlVentana;

/**
 * Clase que implementa ActionListener y que se encargar� de llevar a cabo la acci�n de pulsar un bot�n en el tablero del juego.
 * @author Rodrigo y Javier
 *
 */
public class ActionListenerCasilla implements ActionListener{
	/**
	 * Columna del bot�n pulsadp
	 */
	private int x;
	
	/**
	 * Fila del bot�n pulsado
	 */
	private int y;
	
	/**
	 * Controlador en el que se ejecutar� la acci�n.
	 */
	private ControlVentana control;
	
	/**
	 * Creaci�n del ActionListener recibiendo la columna y la fila del bot�n y el controlador.
	 * @param x columna
	 * @param y fila
	 * @param control
	 */
	public ActionListenerCasilla(int x, int y, ControlVentana control){
		this.x = x + 1;
		this.y = y + 1;
		this.control = control;
	}
	
	/**
	 * Acci�n que se ejecutar�.
	 */
	public void actionPerformed(ActionEvent e) {
		control.mover(x, y);
	}

}
