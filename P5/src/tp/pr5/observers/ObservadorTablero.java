package tp.pr5.observers;

import tp.pr5.logica.Ficha;

/**
 * Interfaz que representa a los observadores de Tablero
 * @author Rodrigo y Javier
 *
 */
public interface ObservadorTablero {
	
	/**
	 * Tratar� las inserciones en casillas del tablero. Recibir� la posici�n y el color de la Ficha insertada
	 * @param x columna 
	 * @param y fila
	 * @param color Ficha
	 */
	public void cambioCasilla(int x, int y, Ficha color);
}
