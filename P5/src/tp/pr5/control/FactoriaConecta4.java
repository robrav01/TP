package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoConecta4;
import tp.pr5.logica.ReglasConecta4;
import tp.pr5.logica.ReglasJuego;

/**
 * Clase que se encargará de crear los elementos necesarios para que el controlador desarrolle el juego Conecta4
 * @author Rodrigo y Javier
 *
 */
public class FactoriaConecta4 implements FactoriaTipoJuego{

	/**
	 * Crea un jugador de tipo aleatorio conecta 4
	 * @return JugadorAleatorioConecta4
	 */
	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioConecta4();
	}
	
	/**
	 * Crea un jugador de tipo humano conecta 4
	 * @param in scanner que se está utilizando
	 * @return JugadorHumanoConecta4
	 */
	public Jugador creaJugadorHumanoConsola(Scanner in) {
		return new JugadorHumanoC4(in);
	}
	
	/**
	 * Crea un movimiento conecta 4 con la columna, fila y color que se le indiquen
	 * @param col columna del movimiento
	 * @param fila fila del movimiento
	 * @param color color del movimiento
	 * @return MovimientoConecta4 ya creado
	 */
	public Movimiento creaMovimiento(int col, int fila, Ficha color) {
		return new MovimientoConecta4(col, color);
	}

	/**
	 * Crea las reglas conecta 4 del juego 
	 * @return ReglasConecta4
	 */
	public ReglasJuego creaReglas() {
		return new ReglasConecta4();
	}

}
