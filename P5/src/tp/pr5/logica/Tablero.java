package tp.pr5.logica;

import tp.pr5.observers.ObservadorTablero;

/**
 * Clase Tablero. Formada por un array de fichas y sus dimensiones. Contiene m�todos para
 * devolver sus valores y para modificarlos
 * 
 * @author Rodrigo y Javier
 *
 */
public class Tablero implements TableroInmutable {
	/** Array bidimensional de fichas que funcionar� como las casillas de un tablero*/
	private Ficha [][] tablero;
	/** Ancho del tablero */
	private int ancho;
	/** alto del tablero */
	private int alto;
	/** atributo que contiene el observador del tablero */
	private ObservadorTablero obsT;
	
	/**
	 * Constructor de la clase Tablero que recibe sus dimensiones. Comenzar� con todas las fichas
	 * vac�as.
	 * @param tx  ancho del tablero.
	 * @param ty  alto del tablero.
	 */
	public Tablero(int tx, int ty){
		if (tx <= 0 || ty <= 0){
			tx = 1;
			ty = 1;
		}
		ancho = tx;
		alto = ty;
		tablero = new Ficha [ancho][alto];
		reset();
	}
	
	/**
	 * M�todo encargado de resetear el tablero y vaciar sus casillas 
	 */
	public void reset(){
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				tablero[i][j] = Ficha.VACIA;
			}
		}
	}
	
	/**
	 * M�todo para saber el alto del tablero.
	 * 
	 * @return alto.
	 */
	public int getAlto(){
		return alto;
	}
	
	/**
	 * M�todo para saber el ancho del tablero.
	 * 
	 * @return ancho.
	 */
	public int getAncho(){
		return ancho;
	}
	
	/**
	 * M�todo que devuelve el valor de la ficha en la posici�n que recibe.
	 * @param x columna de la ficha.
	 * @param y fila de la ficha
	 * @return valor de la ficha. Si la posici�n es incorrecta devuelve Vac�a
	 */
	public Ficha getCasilla(int x, int y){
		x -= 1;
		y -= 1;
		
		if(coordenadasValidas(x, y)){
			return tablero[x][y];
		}
		else{
			return Ficha.VACIA;
		}
	}
	
	/**
	 * Inserta una ficha en la posici�n dada.
	 * @param x  columna de la posici�n
	 * @param y  fila de la posici�n
	 * @param color  valor de la ficha a insertar
	 * @return devuelve un boolean a true si se ha insertado y a false si no.
	 */
	public boolean setCasilla(int x, int y, Ficha color){
		x -= 1;
		y -= 1;
		boolean ok = false;
		
		if(coordenadasValidas(x, y)){
				tablero[x][y] = color;
				
				if(obsT != null)//para poder probar tableros en los main de nuestras funciones
					obsT.cambioCasilla(x, y, color);
				
				ok = true;
			}
		return ok;
	}

	/**
	 * Funci�n que transforma el tablero en un String
	 */
	public String toString() {
		StringBuilder elTablero = new StringBuilder();
		for(int j = 0; j < alto; j++){
			elTablero.append("|");
			for(int i = 0; i < ancho; i++){
				elTablero.append(tablero[i][j]); 
			}
			elTablero.append("|" + "\n");
		}
		elTablero.append("+");
		for(int a = 0; a < ancho; a++){
			elTablero.append("-");
		}
		elTablero.append("+" + "\n" + " ");
		for(int b = 0; b < ancho; b++){
			elTablero.append((b+1)%10);
		}
		elTablero.append("\n");
		return elTablero.toString();
	}
	
	/**
	 * M�todo encargado de buscar en el tablero la �ltima fila vac�a de una columna determinada
	 * @param col columna en la que hay que buscar. El n�mero est� entre 1 y ancho.
	 * @return fila en la que se encuentra la �ltima vac�a. Devuelve la posici�n como si se fuese a usar
	 * en el array de Fichas.
	 */
	public int  ultimaVacia(int col){
		int i = -1;
		while((i < alto - 1) && tablero[col-1][i+1] == Ficha.VACIA){
			i++;
		}
		return i;
	}
	
	/**
	 * M�todo que comprueba si al realizar un movimiento se ha ganado la partida
	 * @param col columna en la que se ha realizado el movimiento.
	 * @param fil fila en la que se ha realizado el movimiento.
	 * @return devuelve true si ha ganado alg�n jugador.
	 */
	public boolean mirarCuatro (int col, int fil){
		col -= 1;
		fil -= 1;
		if (!tablero[col][fil].equals(Ficha.VACIA))
			return (comprobarLinea(col, fil, 0, 1) ||
					comprobarLinea(col, fil, 1, 0) ||
					comprobarLinea(col, fil, 1, 1) ||
					comprobarLinea(col, fil, 1, -1));
		else
			return false;
	}
	
	/**
	 * Funci�n encargada de buscar grupos en horizontal, vertical o diagonal
	 * @param col columna por la que empieza a buscar.
	 * @param fil fila por la que empieza a buscar.
	 * @param mCol par�metro que sumar al contador de la columna
	 * @param mFil par�metro que sumar al contador de la fila
	 * @param invierte booleano que indica a la funci�n si ha de seguir contando por el lado
	 * contrario
	 * @return devuelve el n�mero de fichas iguales.
	 */
	private int compruebaCuatro(int col, int fil, int mCol, int mFil){
		int contador = 0;
		int i = col, j = fil;
		i += mCol;
		j += mFil;
		boolean mismoColor = tablero[col][fil] == getCasilla(i+1, j+1);//se suma 1 debido a que vamos a volver a restar
		//al meternos en getCasilla();
		while(i < ancho && j < alto && contador < 3 && i > -1 && j > -1 && mismoColor){
			contador++;
			i += mCol;
			j += mFil;
			mismoColor = tablero[col][fil] == getCasilla(i+1, j+1);
		}

		return contador;
	}
	
	/**
	 * M�todo encargado de comprobar si hay un grupo de 4 fichas a partir de una fila y columna dadas
	 * @param col columna en la que mirar
	 * @param fil fila en la que mirar
	 * @param mCol iterador de la columna
	 * @param mFil iterador de la fila
	 * @return true si se ha encontrado un grupo
	 */
	private boolean comprobarLinea(int col, int fil, int mCol, int mFil){
		int num = compruebaCuatro(col, fil, mCol, mFil);
		num += compruebaCuatro(col, fil, mCol*-1, mFil*-1);
		return num >= 3;
	}
	
	/**
	 * M�todo que indica si una posici�n dada est� dentro del tablero
	 * @param x columna de la posici�n
	 * @param y fila de la posici�n
	 * @return true si la posici�n est� dentro de los l�mites
	 */
	private boolean coordenadasValidas(int x, int y){
		return (x < ancho && x >= 0 && y >= 0 && y < alto);
	}
	
	/**
	 * Devuelve si una posición es válida
	 * @param x
	 * @param y
	 * @return true si es válida
	 */
	public boolean posicionValida(int x, int y){
		return coordenadasValidas(x - 1, y - 1);
	}
	
	/**
	 * Cambia el observador del tablero
	 * @param o nuevo observador
	 */
	public void setObservador(ObservadorTablero o){
		obsT = o;
	}

	
//	public static void main(String[] args){
//		Ficha prueba = Ficha.BLANCA;
//		Tablero aux = new Tablero(7, 6);
//		System.out.println(prueba == Ficha.BLANCA);
//		System.out.println(prueba == Ficha.NEGRA);
//		aux.setCasilla(1, 6, Ficha.BLANCA);
//		System.out.println(aux.getCasilla(1, 6));
//		System.out.println(aux.getCasilla(8, 1));
//		aux.setCasilla(1, 1, Ficha.VACIA);
//		aux.setCasilla(1, 2, Ficha.BLANCA);
//		aux.setCasilla(1, 3, Ficha.BLANCA);
//		aux.setCasilla(1, 4, Ficha.BLANCA);
//		aux.setCasilla(1, 5, Ficha.BLANCA);
//		aux.setCasilla(1, 6, Ficha.BLANCA);
//		System.out.println(aux);
//		System.out.println(aux.ultimaVacia(1));
		
//		System.out.println(Ficha.BLANCA);
//	}
	
}
