package tp.pr5.logica;

public class MovimientoConecta4 extends Movimiento{
	
	/**
	 * Constructor de MovimientoConecta4 que llama al constructor de Movimiento.
	 * @param donde columna donde insertar la ficha.
	 * @param color ficha a insertar.
	 */
	public MovimientoConecta4(int donde, Ficha color){
		super(donde, color);
	}

	/**
	 * Método que se encargará de ejecutar el movimiento en el tablero que se le pasa como parámetro.
	 */
	public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido{
		if(tab.posicionValida(donde, 1))
			ponerFicha(tab, tab.ultimaVacia(donde));
		else 
			throw new MovimientoInvalido("Columna incorrecta. Debe estar entre 1 y " + tab.getAncho() +".");
	}

}
