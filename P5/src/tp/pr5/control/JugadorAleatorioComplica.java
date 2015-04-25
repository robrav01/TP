package tp.pr5.control;

import java.util.Random;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoComplica;
import tp.pr5.logica.Tablero;

/** 
 * Clase que representa un jugador aleatorio de complica
 * @author Rodrigo y Javier
 *
 */
public class JugadorAleatorioComplica implements Jugador{

	/**
	 * Movimiento que ha realizado el jugador y que será aleatorio y en cualquier caso válido
	 * @param tab tablero en que se ejecutará el movimiento
	 * @param color Ficha del movimiento
	 * @return MovimientoComplica ya creado
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		int col;
		Random r1 = new Random();
		
		col = r1.nextInt(tab.getAncho()) + 1;
		
		return new MovimientoComplica(col, color);
	}

}
