package tp.pr5.logica;

/**
 * Clase que almacena los últimos 10 movimientos ejecutados en un juego
 * @author Rodrigo y Javier
 *
 */
public class Pila {
	/** array de movimientos */
	private Movimiento[] undoStack;
	/** n�mero de elementos que contiene el array */
	private int numUndo; 
	/** n�mero m�ximo de elementos que puede contener el array */
	private final int MAX = 10;
	
	
	
	/**
	 * Constructor de la clase Pila
	 */
	public Pila (){
		undoStack = new Movimiento[MAX];
		reset();
	}
	
	/**
	 * Vac�a los elementos de pila
	 */
	public void reset (){
		for(int i = 0; i < MAX; i++){
			undoStack[i] = null;
		}
		numUndo = 0;
	}
	
	/**
	 * devuelve el �ltimo elemento de pila y lo elimina
	 * @return �ltimo elemento de la pila
	 */
	public Movimiento ultimoMov(){
		Movimiento aux;
		if(numUndo > 0){
			numUndo--;
			aux = undoStack[numUndo];
			undoStack[numUndo] = null;
			return aux;		
		}
		return null;
	}
	
	/**
	 * M�todo que se encarga de almacenar movimientos
	 */
	public void guardarMovimiento(Movimiento mov){
		if (numUndo == MAX){
			for ( int i = 1; i < MAX; i++){
				undoStack[i-1] = undoStack[i];
			}
			undoStack[numUndo-1] = mov;
		}
		else{
			numUndo++;
			undoStack[numUndo-1] = mov;
			}
	}
	
	/**
	 * Devuelve el n�mero de elementos de la pila
	 * @return n�mero de elementos de la pila
	 */
	public int numElementos(){
		return numUndo;
	}

}
