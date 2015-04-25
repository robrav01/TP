package tp.pr5.logica;

/**
 * Clase que lleva los métodos que comparten varias reglas
 * @author Rodrigo y Javier
 *
 */
public abstract class ReglasJuegoAbstractas implements ReglasJuego{
	
	public Ficha jugadorInicial() {
		return Ficha.BLANCA;
	}
	
	
	/**
	 * M�todo encargado de cambiar el turno.
	 */
	public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t) {
		return ultimoEnPoner.fichaContraria();
	}
	
	/**
	 * M�todo que devuelve la Ficha del ganador si lo hay en el �ltimo movimiento ejecutado o Ficha.VACIA si no lo hay.
	 */
	public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
		boolean ganador = false;
		ganador = t.mirarCuatro(ultimoMovimiento.getDonde(), ultimoMovimiento.getFila());
		if(ganador){
			return ultimoMovimiento.getJugador();
		}
		return Ficha.VACIA;
	}
	
}
