package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoReversi;
import tp.pr5.logica.Tablero;

public class JugadorHumanoReversi extends JugadorHumano{

	public JugadorHumanoReversi(Scanner in) {
		super(in);
	}

	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		return new MovimientoReversi(getColumna(), getFila(), color);
	}

}
