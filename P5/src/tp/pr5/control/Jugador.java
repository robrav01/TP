package tp.pr5.control;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.Tablero;

/**
 * Clase que representa al jugador que realiza los movimientos
 * @author Rodrigo y Javier
 *
 */
public interface Jugador {
	
	/**
	 * Movimiento que ha realizado el jugador
	 * @param tab tablero en que se ejecutará el movimiento
	 * @param color Ficha del movimiento
	 * @return Movimiento ya creado
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color);
}
