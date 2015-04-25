package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoGravity;
import tp.pr5.logica.ReglasGravity;
import tp.pr5.logica.ReglasJuego;

/**
 * Clase que se encargará de crear los elementos necesarios para que el controlador desarrolle el juego Gravity
 * @author Rodrigo y Javier
 *
 */
public class FactoriaGravity implements FactoriaTipoJuego{
	
	/** Atributo que contiene el número de columnas del tablero que se va a usar para jugar */
	private int x = 10;
	
	/** Atributo que contiene el número de filas del tablero que se va a usar para jugar */
	private int y = 10;;
	
	/**
	 * Constructor de FactoriaGravity que crea su tablero del tamaño que se le indique. 
	 * @param i ancho que se quiere para el tablero
	 * @param j alto que se quiere para el tablero
	 */
	public FactoriaGravity(int i, int j) {
		x = i;
		y = j;
	}
	
	/**
	 * Crea un jugador de tipo aleatorio gravity
	 * @return JugadorAleatorioGravity
	 */
	public Jugador creaJugadorAleatorio() {	
		return new JugadorAleatorioGravity();
	}
	
	/**
	 * Crea un jugador de tipo humano gravity
	 * @param in scanner que se está utilizando
	 * @return JugadorHumanoGravity
	 */
	public Jugador creaJugadorHumanoConsola(Scanner in) {
		return new JugadorHumanoGr(in);
	}

	/**
	 * Crea un movimiento gravity con la columna, fila y color que se le indiquen
	 * @param col columna del movimiento
	 * @param fila fila del movimiento
	 * @param color color del movimiento
	 * @return MovimientoGravity ya creado
	 */
	public Movimiento creaMovimiento(int col, int fila, Ficha color) {
		return new MovimientoGravity(col, fila, color);
	}

	/**
	 * Crea las reglas gravity del juego 
	 * @return ReglasGravity
	 */
	public ReglasJuego creaReglas() {
		return new ReglasGravity(x, y);
	}
}
