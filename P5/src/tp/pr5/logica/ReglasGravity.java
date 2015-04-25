package tp.pr5.logica;

/**
 * Clase que lleva las reglas del Gravity
 * @author Rodrigo y Javier
 *
 */
public class ReglasGravity extends ReglasJuegoAbstractas{
	
	private int anchoPredet;
	private int altoPredet;
	
	/**
	 * Constructor de ReglasGravity al que se le pasan como parámetros el ancho y el alto del tablero que creará.
	 * @param x ancho del tablero
	 * @param y alto del tablero
	 */
	public ReglasGravity(int x, int y){
		anchoPredet = x;
		altoPredet = y;
	}
	
	/**
	 * Constructor de ReglasGravity que creará un tablero con su alto y ancho predeterminado para jugar Gravity.
	 */
	public ReglasGravity() {
		anchoPredet = 10;
		altoPredet = 10;
	}

	/**
	 * Método que devuelve true si la partida ha terminado en tablas
	 */
	public Tablero iniciaTablero(){
		return new Tablero(anchoPredet, altoPredet);
	}
	
	/**
	 * Devuelve un Tablero inicializado para jugar a Conecta 4
	 */
	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		for(int i = 1; i <= t.getAncho(); i++){
			for(int j = 1; j <= t.getAlto(); j++){
				if(t.getCasilla(i, j).equals(Ficha.VACIA))
					return false;
			}
		}
		return true;	
	}


	/*public static void main(String[] args) {
		ReglasGravity reglas = new ReglasGravity();
		System.out.println(reglas.anchoPredet);
		reglas.tamaï¿½oTab(4, 4);
		System.out.println(reglas.anchoPredet);
	}*/

}
