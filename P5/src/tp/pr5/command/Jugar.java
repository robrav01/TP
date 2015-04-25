package tp.pr5.command;

import java.util.InputMismatchException;
import java.util.Scanner;

import tp.pr5.control.ControladorConsola;
import tp.pr5.control.FactoriaComplica;
import tp.pr5.control.FactoriaConecta4;
import tp.pr5.control.FactoriaGravity;
import tp.pr5.control.FactoriaReversi;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;
import tp.pr5.logica.ReglasJuego;

/**
 * Clase encargada de analizar y ejecutar el comando que se encarga de cambiar de juego
 * @author Rodrigo y Javier
 *
 */
public class Jugar extends Command {
	/** escaner utilizado*/
	private Scanner in;
	
	/** controlador en el que se están ejecutando los comandos*/
	private ControladorConsola control;
	
	/** partida que se está jugando */
	private Partida p;
	
	/**
	 * Constructor del comando Jugar
	 * @param control
	 * @param p
	 * @param in
	 */
	public Jugar(ControladorConsola control, Partida p, Scanner in){
		super("JUGAR", "JUGAR [c4|co|gr|rv] [tamX tamY]: cambia el tipo de juego.\n");
		this.in = in;
		this.control = control;
		this.p = p;
	}
	
	/**
	 * Parsea si el comando es Jugar
	 */
	public boolean reconocerCom(String opcion){
		String[] aux = opcion.split(" ");
		if(super.reconocerCom(aux[0]) && aux.length > 1){
			int x = 0;
			int y = 0;
			
			//Elige el tipo de juego
			if(aux.length == 4 && aux[1].equals("GR")){
				//Elige el ancho y el alto.
				try{
					x = Integer.parseInt(aux[2]);
					y = Integer.parseInt(aux[3]);
				}catch(Exception e){
					return false;
				}
				control.setFactoria(new FactoriaGravity(x, y));
				return true;
				
			}else if(aux[1].equals("C4")){
				control.setFactoria(new FactoriaConecta4());
				return true;
				
			}else if(aux[1].equals("CO")){
				control.setFactoria(new FactoriaComplica());
				return true;
			}else if(aux[1].equals("RV")){
				control.setFactoria(new FactoriaReversi());
				return true;
			}else
				return false;
			
		}
		return false;
	}
	
	/**
	 * Método encargado de ejcutar el comando jugar
	 */
	public void ejecutar() throws MovimientoInvalido, InputMismatchException {
		ReglasJuego nuevasReglas;
		
		//Se crean las reglas que indica la factoría
		nuevasReglas = control.getFactoria().creaReglas();
		control.setJugadorBlancas(control.getFactoria().creaJugadorHumanoConsola(in));
		control.setJugadorNegras(control.getFactoria().creaJugadorHumanoConsola(in));
		
		//Las reglas devueltas por el tipo de juego reinician la partida
		p.reset(nuevasReglas);
	}
	
}
