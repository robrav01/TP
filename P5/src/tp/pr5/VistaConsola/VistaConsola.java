package tp.pr5.VistaConsola;

import java.util.InputMismatchException;
import java.util.Scanner;

import tp.pr5.control.ControladorConsola;
import tp.pr5.logica.Ficha;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;
import tp.pr5.observers.ObservadorTablero;

public class VistaConsola implements ObservadorPartida,  ObservadorTablero{
	
	/**
	 * Controlador en el que se realizarán las acciones
	 */
	private ControladorConsola con;
	
	/**
	 * Scanner para comunixarse con el usuario
	 */
	private Scanner in;
	
	/**
	 * Booleano que indica si se ha de salir de la aplicación
	 */
	private boolean salir;
	
	/**
	 * Constructor de la vista al que se le pasa como parámetro el controlador
	 * @param con
	 */
	public VistaConsola(ControladorConsola con){
		this.con = con;
		in = con.getScanner();
		salir = false;
		con.addObserver(this);
		con.setObservadorTablero(this);
		while(!salir){
			//Salidas y entradas por pantalla y ejecuciï¿½n 
			System.out.println(con.getTablero());
			System.out.println("Juegan " + con.getTurno().mostrarFicha());
			System.out.print("Qué quieres hacer? ");
			String opcion = in.nextLine();
			
			try{
				this.con.run(opcion.toUpperCase());
			}catch(MovimientoInvalido c){
				System.err.println(c.getMsg());
			}catch(InputMismatchException e){
				System.err.println("No te entiendo.");
				in.nextLine();
			}
			
		}
	}

	public void onReset(TableroInmutable t) {
		System.out.println("Partida reiniciada.");
	}

	public void onMove(TableroInmutable t) {
		
	}

	public void onUndo(TableroInmutable t) {
		
	}

	public void onGameOver() {
		System.out.println(con.getGanador());
		salir = true;
	}

	public void onError(String msg) {
		System.err.println(msg);
	}


	public void cambioCasilla(int x, int y, Ficha color) {
		
	}

}
