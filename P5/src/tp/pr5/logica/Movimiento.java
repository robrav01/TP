package tp.pr5.logica;

/**
 * Clase que se encargará de ejecutar o deshacer un movimiento
 * @author Rodrigo y Javier
 *
 */
public abstract class Movimiento {
	
	/** Atributo que guarda la ficha que se va a insertar */
	protected Ficha color;
	/** Atributo que guarda la columna donde se va a insertar la ficha */
	protected int donde;
	/** Atributo que guarda la fila donde se va a insertar la ficha */
	protected int fila;
	
	/**
	 * Constructor de la clase movimiento. Se le pasa la columna y la ficha a colocar.
	 * @param x columna donde insertar la ficha.
	 * @param color ficha a insertar.
	 */
	protected Movimiento (int x, Ficha color){
		this.color = color;
		donde = x;
	}
	
	/**
	 * M�todo encargado de llevar a cabo el movimiento.
	 * @param tab tablero en el que se va a realizar el movimiento
	 * @return true si se ha realixado el movimiento correctamente
	 * @throws MovimientoInvalido 
	 */
	public abstract void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido;
	
	/**
	 * M�todo que devuelve la ficha que tiene el movimiento
	 * @return Ficha
	 */
	public Ficha getJugador(){
		return color;
	}
	
	/**
	 * M�todo que devuelve la columna del movimiento.
	 * @return int columna
	 */
	public int getDonde(){
		return donde;
	}
	
	/**
	 * M�todo que devuelve la fila del movimiento.
	 * @return int fila
	 */
	public int getFila(){
		return fila;
	}
	
	/**
	 * M�todo que inserta la Ficha del movimiento en el tablero dado. M�todo creado para ser utilizado en sus clases hijas en el m�todo ejecuta movimiento
	 * @param tab tablero en el que insertar
	 * @return true si se ha insertado correctamente.
	 * @throws MovimientoInvalido 
	 */
	protected void ponerFicha(Tablero tab, int aux) throws MovimientoInvalido{
			if(aux > -1){
				fila = aux + 1;
				tab.setCasilla(donde, fila, color);
			}else
				throw new MovimientoInvalido("Columna llena.");
	}
	
	/**
	 * M�todo encargado de deshacer el movimiento que lo llama.
	 * @param tab tablero en el que deshacer el movimiento.
	 */
	public void undo(Tablero tab) {
		tab.setCasilla(donde, fila, Ficha.VACIA);
	}
	
}
