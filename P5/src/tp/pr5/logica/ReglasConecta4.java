package tp.pr5.logica;

/**
 * Clase que lleva las reglas del Conecta 4
 * @author Rodrigo y Javier
 *
 */
public class ReglasConecta4 extends ReglasJuegoAbstractas{
	private int anchoPredet = 7;
	private int altoPredet = 6;
	
	/**
	 * Método que devuelve true si la partida ha terminado en tablas
	 */
	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		
		int i = 1;
		while(i <= t.getAncho() && t.getCasilla(i, 1) != Ficha.VACIA){
			i++;
			}
		return (i > t.getAncho());
	}
	
	/**
	 * Devuelve un Tablero inicializado para jugar a Conecta 4
	 */
	public Tablero iniciaTablero(){
		return new Tablero(anchoPredet, altoPredet);
	}
	
}
