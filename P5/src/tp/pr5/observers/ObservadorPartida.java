package tp.pr5.observers;

import tp.pr5.logica.TableroInmutable;

/**
 * Interfaz que representa a los observadores de Partida
 * @author Rodrigo y Javier
 *
 */
public interface ObservadorPartida {
	
	/**
	 * Método que trata los reset de la partida
	 * @param t tablero de la partida
	 */
	public void onReset(TableroInmutable t); //Crear tablero inmutable tras resolver dudas
	
	/**
	 * Método que trata los movimientos de la partida
	 * @param t tablero de la partida
	 */
	public void onMove(TableroInmutable t);
	
	/**
	 * Método que trata los deshacer movimiento de la partida
	 * @param t tablero de la partida
	 */
	public void onUndo(TableroInmutable t);
	
	/**
	 * Método que trata los GameOver de la partida
	 */
	public void onGameOver();
	
	/**
	 * Método que trata los errores de la partida y muestra el mensaje  que se le pasa como parámetro
	 * @param msg mensaje a mostrar
	 */
	public void onError(String msg);

}
