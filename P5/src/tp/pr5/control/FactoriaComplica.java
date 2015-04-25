package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoComplica;
import tp.pr5.logica.ReglasComplica;
import tp.pr5.logica.ReglasJuego;

/**
 * Clase que se encargará de crear los elementos necesarios para que el controlador desarrolle el juego complica
 * @author Rodrigo y Javier
 *
 */
public class FactoriaComplica implements FactoriaTipoJuego{
	
	/**
	 * Crea un jugador de tipo aleatorio complica
	 * @return JugadorAleatorioComplica
	 */
	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioComplica();
	}
	
	/**
	 * Crea un jugador de tipo humano complica
	 * @param in scanner que se está utilizando
	 * @return JugadorHumanoComplica
	 */
	public Jugador creaJugadorHumanoConsola(Scanner in) {
		return new JugadorHumanoCo(in);
	}
	
	/**
	 * Crea un movimiento complica con la columna, fila y color que se le indiquen
	 * @param col columna del movimiento
	 * @param fila fila del movimiento
	 * @param color color del movimiento
	 * @return MovimientoComplica ya creado
	 */
	public Movimiento creaMovimiento(int col, int fila, Ficha color) {
		return new MovimientoComplica(col, color);
	}

	/**
	 * Crea las reglas complica del juego 
	 * @return ReglasComplica
	 */
	public ReglasJuego creaReglas() {
		return new ReglasComplica();
	}

}
