package tp.pr5.control;

import tp.pr5.logica.Ficha;
import tp.pr5.logica.Partida;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;
import tp.pr5.observers.ObservadorTablero;

/**
 * Clase Abstracta creada para contener métodos que se utilizarán en los distintos tipos de controladores
 * @author Rodrigo y Javier
 *
 */
public abstract class Control {
	
	/** atributo que contiene la factorï¿½a del tipo que se estï¿½ usando */
	protected FactoriaTipoJuego f;
	
	/** atributo que contiene la partida */
	protected Partida partida;
	
	/**
	 * Constructor de la clase Control que recibe la Factoría con la que trabajará y la Partida en la que actuará
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
	 * Devuelve un String que indica quién ha ganado la partida o si ha habido tablas.
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
	 * Añade un observador a la Partida.
	 * @param o observador a añadir
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
