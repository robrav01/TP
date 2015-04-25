package tp.pr5.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.pr5.control.ControlVentana;

/**
 * Clase que implementa ActionListener y que se encargará de llevar a cabo la acción de pulsar un botón en el tablero del juego.
 * @author Rodrigo y Javier
 *
 */
public class ActionListenerCasilla implements ActionListener{
	/**
	 * Columna del botón pulsadp
	 */
	private int x;
	
	/**
	 * Fila del botón pulsado
	 */
	private int y;
	
	/**
	 * Controlador en el que se ejecutará la acción.
	 */
	private ControlVentana control;
	
	/**
	 * Creación del ActionListener recibiendo la columna y la fila del botón y el controlador.
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
	 * Acción que se ejecutará.
	 */
	public void actionPerformed(ActionEvent e) {
		control.mover(x, y);
	}

}
