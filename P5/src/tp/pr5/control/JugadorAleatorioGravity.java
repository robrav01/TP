package tp.pr5.control;

import java.util.Random;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoGravity;
import tp.pr5.logica.Tablero;
/** 
 * Clase que representa un jugador aleatorio de gravity
 * @author Rodrigo y Javier
 *
 */
public class JugadorAleatorioGravity implements Jugador{

	/**
	 * Movimiento que ha realizado el jugador y que ser� aleatorio y en cualquier caso v�lido
	 * @param tab tablero en que se ejecutar� el movimiento
	 * @param color Ficha del movimiento
	 * @return MovimientoGravity ya creado
	 */
	public Movimiento getMovimiento(Tablero tab, Ficha color) {
		int col, fil;
		Random r1 = new Random();
		Random r2 = new Random();
		col = r1.nextInt(tab.getAncho())+1;
		fil = r2.nextInt(tab.getAlto())+1;
			
		while(tab.getCasilla(col, fil) != Ficha.VACIA){
			col = r1.nextInt(tab.getAncho())+1;
			fil = r2.nextInt(tab.getAlto())+1;
		}
		return new MovimientoGravity(col, fil, color);
	}

}
