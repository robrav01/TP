package tp.pr5.control;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Partida;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;
import tp.pr5.observers.ObservadorTablero;

/**
 * Clase Abstracta creada para contener m�todos que se utilizar�n en los distintos tipos de controladores
 * @author Rodrigo y Javier
 *
 */
public abstract class Control {
	
	/** atributo que contiene la factor�a del tipo que se est� usando */
	protected FactoriaTipoJuego f;
	
	/** atributo que contiene la partida */
	protected Partida partida;
	
	/**
	 * Constructor de la clase Control que recibe la Factor�a con la que trabajar� y la Partida en la que actuar�
	 * @param f
	 * @param p
	 */
	public Control(FactoriaTipoJuego f, Partida p){
		this.f = f;
		this.partida = p;
	}
	
	
	/**
	 * Lanzador del controlador
	 */
	public abstract void run();
	
	/**
	 * Devuelve el Tablero de la Partida en forma de TableroInmutable
	 * @return TableroInmutable
	 */
	public TableroInmutable getTablero(){
		return partida.getTablero();
	}
	
	/**
	 * Devuelve el turno de la Partida
	 * @return Ficha correspondiente al color del jugador que tiene el turno
	 */
	public Ficha getTurno(){
		return partida.getTurno();
	}
	
	/**
	 * Devuelve un String que indica qui�n ha ganado la partida o si ha habido tablas.
	 * @return String con la frase que se ha de mostrar.
	 */
	public String getGanador(){
		//Si la Ficha es VACIA la partida ha terminado en tablas.
		if(partida.getGanador().equals(Ficha.VACIA))
			return "Partida terminada en tablas";
		else
			return "Han ganado " + partida.getGanador().mostrarFicha();
	}
	
	/**
	 * A�ade un observador a la Partida.
	 * @param o observador a a�adir
	 */
	public void addObserver(ObservadorPartida o){
		partida.addObserver(o);
	}
	
	/**
	 * Cambia el observador del tablero.
	 * @param o nuevo observador
	 */
	public void setObservadorTablero(ObservadorTablero o){
		partida.getTablero().setObservador(o);
	}
	
}
