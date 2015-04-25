package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoComplica;
import tp.pr5.logica.Tablero;

/**
 * Clase que representa al jugador humano que realiza los movimientos del complica
 * @author Rodrigo y Javier
 *
 */
public class JugadorHumanoCo extends JugadorHumano{
	public JugadorHumanoCo(Scanner in) {
		super(in);
	}

	/**
	 * Método que pedirá por pantalla la columna y devolverá el MovimientoComplica creado.
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		return new MovimientoComplica(getColumna(), color);
	}

}
