package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoGravity;
import tp.pr5.logica.Tablero;

/**
 * Clase que representa al jugador humano que realiza los movimientos del gravity
 * @author Rodrigo y Javier
 *
 */
public class JugadorHumanoGr extends JugadorHumano{

	public JugadorHumanoGr(Scanner in) {
		super(in);
	}
	
	/**
	 * Método que pedirá por pantalla la columna y la fila y devolverá el MovimientoGravity creado.
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		return new MovimientoGravity(getColumna(), getFila(), color);
	}

}
