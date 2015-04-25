package tp.pr5.control;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.ReglasJuego;

/**
 * Clase que se encargar� de crear los elementos necesarios para que el controlador desarrolle el juego
 * @author Rodrigo y Javier
 *
 */
public interface FactoriaTipoJuego {
	
	/**
	 * Crea un jugador de tipo aleatorio
	 * @return JugadorAleatorio
	 */
	public Jugador creaJugadorAleatorio();
	
	/**
	 * Crea un jugador de tipo humano
	 * @param in scanner que se est� utilizando
	 * @return JugadorHumanoConsola
	 */
	public Jugador creaJugadorHumanoConsola(java.util.Scanner in);
	
	/**
	 * Crea un movimiento con la columna, fila y color que se le indiquen
	 * @param col columna del movimiento
	 * @param fila fila del movimiento
	 * @param color color del movimiento
	 * @return Movimiento ya creado
	 */
	public Movimiento creaMovimiento(int col, int fila, Ficha color);
	
	/**
	 * Crea las reglas del juego al que se est� jugando
	 * @return ReglasJuego
	 */
	public ReglasJuego creaReglas();
}
