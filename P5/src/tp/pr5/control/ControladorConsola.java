package tp.pr5.control;

import java.util.InputMismatchException;
import java.util.Scanner;

import tp.pr5.command.GestorComandos;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;

/**
 * Clase que contiene una partida y un escaner adem�s de los m�todos para que el jugador conduzca la partida.
 * Controlador asociado a la vista Consola
 * 
 * @author Rodrigo y Javier
 *
 */
public class ControladorConsola extends Control {
	
	/** atributo que contiene el escaner para interactuar con el usuario */
	private Scanner in;
	
	/** atributo que contiene el gestor de comandos que se encargar� de parsearlos y ejecutarlos */
	private GestorComandos gestor;
	
	/** atributo que contiene al jugador blanco y que podr� ser humano o aleatorio */
	private Jugador jugadorBlancas;
	
	/** atributo que contiene al jugador negro y que podr� ser humano o aleatorio */
	private Jugador jugadorNegras;
	
	
	/**
	 * Constructor de la clase controlador. Se pasan como par�metros la partida y el escaner.
	 * @param p  Partida sobre la que se jugar�
	 * @param in Escaner utilizado para interactuar con el usuario
	 */
	public ControladorConsola(FactoriaTipoJuego f, Partida p, Scanner in){
		super(f, p);
		this.in  = in;
		jugadorBlancas = this.f.creaJugadorHumanoConsola(this.in);
		jugadorNegras = this.f.creaJugadorHumanoConsola(this.in);
		gestor = new GestorComandos(this, p, in);
		
	}

	/**
	 * Devuelve el valor del jugadorBlancas
	 * @return valor del jugadorBlancas 
	 */
	public Jugador getJugadorBlancas(){
		return jugadorBlancas;
	}
	
	/**
	 * Devuelve el valor del jugadorNegras
	 * @return valor del jugadorNegras 
	 */
	public Jugador getJugadorNegras(){
		return jugadorNegras;
	}
	
	/**
	 * Cambia el tipo de factor�a que se est� usando
	 * @param fact nuevo tipo
	 */
	public void setFactoria(FactoriaTipoJuego fact){
		f = fact;
	}
	
	/**
	 * Cambia el tipo de jugador que est� jugando como jugadorBlancas
	 * @param j nuevo tipo de jugador
	 */
	public void setJugadorBlancas(Jugador j){
		jugadorBlancas = j;
	}
	
	/**
	 * Devuelve el Scanner que utiliza el Controlador
	 * @return
	 */
	public Scanner getScanner(){
		return in;
	}
	
	/**
	 * Cambia el tipo de jugador que est� jugando como jugadorNegras
	 * @param j nuevo tipo de jugador
	 */
	public void setJugadorNegras(Jugador j){
		jugadorNegras = j;
	}
	
	/**
	 * Devuelve la factor�a que se est� usando
	 * @return factor�a que se est� usanto
	 */
	public FactoriaTipoJuego getFactoria(){
		return f;
	}
	
	
	/**
	 * M�todo encargado de llevar a cabo una partida e interactuar con el usuario
	 * @throws MovimientoInvalido 
	 * @throws InputMismatchException 
	 */
	public void run(String opcion) throws InputMismatchException, MovimientoInvalido{//�PASAR EL RUN A LA VISTA CONSOLA?
		//parseo, ejecuci�n del comando
		gestor.ejecutar(opcion);
	}

	public void run() {
		
	}	
}
