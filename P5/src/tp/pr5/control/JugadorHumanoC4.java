package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoConecta4;
import tp.pr5.logica.Tablero;

/**
 * Clase que representa al jugador humano que realiza los movimientos del conecta 4
 * @author Rodrigo y Javier
 *
 */
public class JugadorHumanoC4 extends JugadorHumano {
	public JugadorHumanoC4(Scanner in) {
		super(in);
	}
	
	/**
	 * Método que pedirá por pantalla la columna y devolverá el MovimientoConecta4 creado.
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		return new MovimientoConecta4(getColumna(), color);
	}

}
