package tp.pr5.control;

import java.util.Scanner;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoReversi;
import tp.pr5.logica.ReglasJuego;
import tp.pr5.logica.ReglasReversi;

public class FactoriaReversi implements FactoriaTipoJuego{

	public Jugador creaJugadorAleatorio() {
		return new JugadorAleatorioReversi();
	}

	public Jugador creaJugadorHumanoConsola(Scanner in) {
		return new JugadorHumanoReversi(in);
	}

	public Movimiento creaMovimiento(int col, int fila, Ficha color) {
		return new MovimientoReversi(col, fila, color);
	}

	public ReglasJuego creaReglas() {
		return new ReglasReversi();
	}

}
