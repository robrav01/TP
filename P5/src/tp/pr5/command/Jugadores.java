package tp.pr5.command;

/**
 *  Clase del comando que se encargará de parsear y ejecutar JUGADOR. Cambiará el tipo de jugador
 * @author Rodrigo y Javier
 *
 */
import java.util.Scanner;

import tp.pr5.control.ControladorConsola;
import tp.pr5.control.Jugador;

public class Jugadores extends Command {
	
	/** Atributo que contiene el controlador que ejecuta los comandos */
	private ControladorConsola control;
	
	/** Scanner usado por el programa */
	private Scanner in;
	
	/** Jugador que cambiará a JugadorBlancas */
	private Jugador blancas;
	
	/** Jugador que cambiará a JugadorNegras */
	private Jugador negras;
	
	public Jugadores(ControladorConsola control, Scanner in) {
		super("JUGADOR", "JUGADOR [blancas|negras] [humano|aleatorio]: cambia el tipo de jugador.\n");
		
		this.control = control;
		this.in = in;
	}
	
	/**
	 * Método encargado de parsear el comando Jugador y que le seleccionará color y tipo
	 */
	public boolean reconocerCom(String opcion){
		String[] aux = opcion.split(" ");
		if(super.reconocerCom(aux[0]) && aux.length > 1){
			
			blancas = control.getJugadorBlancas();
			negras = control.getJugadorNegras();
			
			//Reconoce el color del jugador
			if(aux.length == 3){
				if(aux[1].equals("NEGRAS")){
					negras = elegirJugador(aux[2]);
				}else if(aux[1].equals("BLANCAS")){
					blancas = elegirJugador(aux[2]);
				}else
					return false;
				
				//Se comprueba que se ha elegido HUMANO o ALEATORIO
				if(negras.equals(null) || blancas.equals(null))
					return false;
				else
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Ejecuci�n del comando
	 */
	public void ejecutar(){
			control.setJugadorNegras(negras);
			control.setJugadorBlancas(blancas);
	}
	
	/**
	 * Método encargado de devolver el Tipo de Jugador 
	 * @param eleccion
	 * @return null si la selección es incorrecta
	 */
	private Jugador elegirJugador(String eleccion){
		if(eleccion.equals("HUMANO"))
			return control.getFactoria().creaJugadorHumanoConsola(in);
		else if (eleccion.equals("ALEATORIO"))
			return control.getFactoria().creaJugadorAleatorio();
		
		return null;
		
	}

}
