package tp.pr5.observers;

import tp.pr5.logica.TableroInmutable;

/**
 * Interfaz que representa a los observadores de Partida
 * @author Rodrigo y Javier
 *
 */
public interface ObservadorPartida {
	
	/**
	 * M�todo que trata los reset de la partida
	 * @param t tablero de la partida
	 */
	public void onReset(TableroInmutable t); //Crear tablero inmutable tras resolver dudas
	
	/**
	 * M�todo que trata los movimientos de la partida
	 * @param t tablero de la partida
	 */
	public void onMove(TableroInmutable t);
	
	/**
	 * M�todo que trata los deshacer movimiento de la partida
	 * @param t tablero de la partida
	 */
	public void onUndo(TableroInmutable t);
	
	/**
	 * M�todo que trata los GameOver de la partida
	 */
	public void onGameOver();
	
	/**
	 * M�todo que trata los errores de la partida y muestra el mensaje  que se le pasa como par�metro
	 * @param msg mensaje a mostrar
	 */
	public void onError(String msg);

}
