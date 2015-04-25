package tp.pr5.logica;

/**
 * Clase que se encargará de ejecutar o deshacer un movimiento del complica
 * @author Rodrigo y Javier
 *
 */
public class MovimientoComplica extends Movimiento {
	/** Atributo que almacena la Ficha que se puede haber desplazado al ejecutar el movimiento. Vac�a si no se ha desplazado. */
	private Ficha desplazado;
	
	/**
	 * Constructor de MovimientoComplica que llama al constructor de Movimiento e inicializa sus nuevos atributos.
	 * @param x columna donde insertar la ficha.
	 * @param color ficha a insertar.
	 */
	public MovimientoComplica(int x, Ficha color) {
		super(x, color);
		desplazado = Ficha.VACIA;
	}

	public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido {
		if(tab.posicionValida(donde, 1)){
			
			//Si la columna está llena desplaza y coloca la Ficha
			if (tab.getCasilla(donde, 1) != Ficha.VACIA){
				desplazado = tab.getCasilla(donde, tab.getAlto());
				desplaza(tab, true);
				fila = 1;
				tab.setCasilla(donde, 1, color);
			}else //Si la columna no está llena coloca la Ficha
				ponerFicha(tab, tab.ultimaVacia(donde));
		}else
			throw new MovimientoInvalido("Columna incorrecta. Debe estar entre 1 y " + tab.getAncho() +".");
	} 

	public void undo(Tablero tab){
		if (desplazado != Ficha.VACIA){
			desplaza(tab, false);
			tab.setCasilla(donde, tab.getAlto(), desplazado);
		}
		else{
			tab.setCasilla(donde, fila, Ficha.VACIA);
		}
	}
	
	/**
	 * M�todo que desplaza la columna del tablero en la que se va a ejecutar la acci�n del movimiento para arriba o para abajo seg�n el boolean que se le pase.
	 * @param tab tablero en el que desplazar.
	 * @param abajo true si desplazaremos hacia abajo, false para desplazar hacia arriba.
	 */
	private void desplaza(Tablero tab, boolean abajo){
		if(abajo){
			for(int i = tab.getAlto(); i > 1; i--){
			tab.setCasilla(donde, i, tab.getCasilla(donde, i-1));
			}
		}
		else{
			for(int i = 1; i < tab.getAlto(); i++){
				tab.setCasilla(donde, i, tab.getCasilla(donde, i+1));
			}
		}
		
	}
}
