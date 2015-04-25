package tp.pr5.control;

import java.util.Random;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoConecta4;
import tp.pr5.logica.Tablero;

/** 
 * Clase que representa un jugador aleatorio de conecta 4
 * @author Rodrigo y Javier
 *
 */
public class JugadorAleatorioConecta4 implements Jugador{

	/**
	 * Movimiento que ha realizado el jugador y que ser� aleatorio y en cualquier caso v�lido
	 * @param tab tablero en que se ejecutar� el movimiento
	 * @param color Ficha del movimiento
	 * @return MovimientoConecta4 ya creado
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		int col;
		Random r1 = new Random();
		col = r1.nextInt(tab.getAncho())+1;
		
		//sigue hasta que la columna no est� llena
		while(tab.ultimaVacia(col) == -1)
			col = r1.nextInt(tab.getAncho())+1;
		return new MovimientoConecta4(col, color);
	}

/*	public static void main(String[] args){
		Jugador j = new JugadorAleatorioConecta4();
		Movimiento m = j.getMovimiento(new Tablero(7,7), Ficha.BLANCA);
	}
*/
}
