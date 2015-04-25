package tp.pr5.logica;

/**
 * Clase que lleva las reglas del Complica
 * @author Rodrigo y Javier
 *
 */
public class ReglasComplica extends ReglasJuegoAbstractas {
	private int anchoPredet = 4;
	private int altoPredet = 7;
	
	/**
	 * Comprueba en todo el tablero si se ha formado un grupo de 4 ï¿½ mï¿½s fichas iguales. 
	 * @param t tablero en el que se busca el grupo
	 * @return Ficha Devuelve la ficha del grupo formado, vacï¿½a si no hay grupos o hay de diferentes fichas.
	 */
	public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
		boolean ganador = false, hayBlancas = false, hayNegras = false;
		Ficha posibleG = Ficha.VACIA;
		for(int i = 1; i <= t.getAlto(); i++){
			for(int j = 1; j <= t.getAncho(); j++){
				if( t.getCasilla(j, i) != Ficha.VACIA){
					ganador = t.mirarCuatro(j, i);
					if(ganador){
						posibleG = t.getCasilla(j, i);
						if(posibleG == Ficha.BLANCA){
							 hayBlancas = true;
						}
						else{
							hayNegras = true;
						}
						if(hayNegras && hayBlancas){
							return Ficha.VACIA;
						}
					}
				}
			}
		}
		return posibleG;
	}
	
	/**
	 * Método que devuelve true si la partida ha terminado en tablas
	 */
	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		return false;
	}
	
	/**
	 * Devuelve un Tablero inicializado para jugar a Complica
	 */
	public Tablero iniciaTablero(){
		return new Tablero(anchoPredet, altoPredet);
	}

}
