package tp.pr5.logica;

import java.util.ArrayList;
import java.util.Collection;

import tp.pr5.observers.Observable;
import tp.pr5.observers.ObservadorPartida;

/**
 * Clase encargada de almacenar los datos de una partida, ademï¿½s de mï¿½todos para devolver sus
 * valores o para modificarla.
 * Contiene el tablero, el turno, el ganador, los movimientos e indica si se ha terminado o no.
 * @author Rodrigo y Javier
 *
 */
public class Partida implements Observable<ObservadorPartida>{
	/** tablero compuesto por un array bidimensional cuadrado de fichas en el que transcurrirá la partida*/
	private Tablero tablero;
	/** Ficha que indica el jugador que va a poner */
	private Ficha turno;
	/** boolean a true si la partida ha terminado*/
	private boolean terminada;
	/** Ficha que indica el jugador que ha ganado. VACIA si no ha ganado nadie*/
	private Ficha ganador;
	/** Reglas de juego que seguirá la partida */
	private ReglasJuego reglas;
	/** Array que contiene los últimos 10 movimientos */
	private Pila pila;
	/** Lista de observadores que utilizará partida */
	private Collection<ObservadorPartida> obs;
	
	/**
	 * Constructor de la clase partida. Inicializa todas las componentes.
	 */
	public Partida(ReglasJuego reglas){
		obs = new ArrayList<ObservadorPartida>();
		pila = new Pila();
		reset(reglas);
	}
	
	/**
	 * Lleva un movimiento a cabo. Comprueba si es posible, lo guarda, lo lleva a cabo y
	 *  cambia el turno
	 * @param color color de la ficha que se quiere poner
	 * @param col columna
	 * @return devuelve true si se ha llevado a cabo el movimiento y si ha pasado lo contrario
	 *  false.
	 * @throws MovimientoInvalido 
	 */
	public void ejecutaMovimiento(Movimiento mov) { 
		//ejecuta el movimiento y comprueba si ha terminado la partida.
		try{	
			if(!terminada){	
				if(turno.equals(mov.getJugador()))
					mov.ejecutaMovimiento(tablero);
				else
					throw new MovimientoInvalido("No es tu turno.");
			}else
				throw new MovimientoInvalido("La partida ha terminado");
			
				//Prepara la siguiente ejecuciï¿½n.
				ganador = reglas.hayGanador(mov, tablero);
				if(ganador != Ficha.VACIA || reglas.tablas(turno, tablero)){
					terminada = true;
				}
				
				//Guarda el movimiento en la pila
				pila.guardarMovimiento(mov);
				
				//Comprueba si la partida ha terminado
				if(!terminada){
					turno = reglas.siguienteTurno(turno, tablero);
					for(ObservadorPartida o : obs){
						o.onMove(tablero);
					}
				}else
					for(ObservadorPartida o : obs){
						o.onGameOver();
					}
				
		}catch(MovimientoInvalido e){
			errores(e.getMsg());
		}		
	}
	
	/**
	 * Mï¿½todo que devuelve un boolean indicando si la funciï¿½n estï¿½ terminada.
	 * @return true si ha terminado y false si no lo ha hecho.
	 */
	public boolean isTerminada(){
		return terminada;
	}
	
	/**
	 * Mï¿½todo que devuelve el turno.
	 * @return Devuelve Blancas si le toca a este jugador o Negras si le toca al otro
	 */
	public Ficha getTurno(){
		return turno;
	}
	
	/**
	 * Mï¿½todo encargado de deshacer un movimiento.
	 * @return Devuelve un boolean a true si se ha podido deshacer.
	 */
	public boolean undo(){
		if (pila.numElementos() == 0){
			return false;
		}
		
		pila.ultimoMov().undo(tablero);
		turno = reglas.siguienteTurno(turno, tablero);
		for(ObservadorPartida o : obs){
			o.onUndo(tablero);
		}
		return true;
	}
	
	/**
	 * Devuelve el ganador de la partida.
	 * @return Devuelve el color del jugador ganador o vacï¿½a si acaba en tablas.
	 */
	public Ficha getGanador(){
		return ganador;
	}
	
	/**
	 * Devuelve el número de movimientos que hay almacenados en la pila de movimientos.
	 * @return número de movimientos
	 */
	public int numMovimientos(){
		return pila.numElementos();
	}
	
	/**
	 * Devuelve el tablero de la partida.
	 * @return tablero de la partida.
	 */
	public Tablero getTablero(){
		return tablero;
	}
	
	/**
	 * Mï¿½todo que reinicia los atributos de la partida
	 */
	public void reset(ReglasJuego reglas){
		this.reglas = reglas;
		tablero = reglas.iniciaTablero();
		turno = this.reglas.jugadorInicial();
		terminada = false;
		ganador = Ficha.VACIA;
		pila.reset();
		
		for(ObservadorPartida o : obs){
			o.onReset(tablero);
		}
	}
	
	/**
	 * Método que devuelve las reglas que se están usando en la partida.
	 * @return Reglas que usa la partida.
	 */
	public ReglasJuego getReglas(){
		return reglas;
	}
	
	/**
	 * Añade un observador a la lista de observadores
	 */
	public void addObserver(ObservadorPartida o) {
		obs.add(o);
	}
	
	/**
	 * Remueve un observador de la lista de observadores
	 */
	public void removeObserver(ObservadorPartida o) {
		obs.remove(o);
	}
	
	/**
	 * Llamada a los observadores para que traten un error con el mensaje que recibe como parámetro.
	 * @param msg mensaje del error
	 */
	private void errores(String msg){
		for(ObservadorPartida o : obs){
			o.onError(msg);
		}
	}
	
	
	
	/*public static void main(String[] args){
		Partida prueba = new Partida();
		Tablero tab = new Tablero(7,6);
		tab.setCasilla(0, 5, Ficha.BLANCA);
		tab.setCasilla(6, 5, Ficha.NEGRA);
		//Ficha aux = Ficha.BLANCA;
		System.out.println(tab.toString());
		//System.out.println(prueba.ejecutaMovimiento(aux, 10));
		prueba.turno = Ficha.BLANCA;
		System.out.println(prueba.undo());
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 5));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 6));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 4));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 5));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 4));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 2));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 3));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 3));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 3));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 10));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, -4));
		System.out.println(prueba.undo());
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 0));
		System.out.println(prueba.ejecutaMovimiento(prueba.turno, 7));
		//System.out.println(prueba.ejecutaMovimiento(prueba.turno, 4));
		System.out.println(prueba.tablero.toString());
		//System.out.println(prueba.ejecutaMovimiento(prueba.turno, 11));
		//System.out.println(prueba.tablero.toString());
		
	}*/
	
}
