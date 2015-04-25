package tp.pr5.logica;

/**
 * Clase que lleva las reglas
 * @author Rodrigo y Javier
 *
 */
public interface ReglasJuego {

	/**
	 * M�todo que comprueba si al realizar un movimiento se ha ganado la partida
	 * @param col columna en la que se ha realizado el movimiento.
	 * @param fil fila en la que se ha realizado el movimiento.
	 * @return devuelve true si ha ganado alg�n jugador.
	 */
	public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t);
	
	/**
	 * Inicia un tablero en el que jugar.
	 * @param y 
	 * @param x 
	 * @return tablero iniciado
	 */
	public Tablero iniciaTablero();
	
	/**
	 * Devuelve el jugador que comienza a jugar
	 * @return jugador
	 */
	public Ficha jugadorInicial();
	
	/**
	 * Devuelve el jugador al que le toca jugar en el siguiente turno
	 * @param ultimoEnPoner jugador que acaba de poner
	 * @param t 
	 * @return jugador al que le toca poner
	 */
	public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t);
	
	/**
	 * Comprueba si hay tablas y no se pueden ejecutar m�s movimientos
	 * 
	 * @return true si hay tablas.
	 */
	public boolean tablas(Ficha ultimoEnPoner, Tablero t);
	
}
