package tp.pr5.control;

import java.util.Scanner;

/**
 * Clase que representa al jugador humano que realiza los movimientos
 * @author Rodrigo y Javier
 *
 */
public abstract class JugadorHumano implements Jugador{
	
	/**
	 * Scanner que usa jugador humano
	 */
	protected Scanner in;
	
	/**
	 * Constructor de la clase JugadorHumano, igualará su scanner con el del programa.
	 * @param in
	 */
	public JugadorHumano(Scanner in){
		this.in = in;
	}
	
	/**
	 * Pide la columna por consola y la devuelve como parámetro
	 * @return Columna elegida
	 */
	int getColumna(){
		System.out.print("Introduce la columna: ");
		int x = in.nextInt();
		in.nextLine();
		return x;
		
	}
	
	/**
	 * Pide la fila por consola y la devuelve como parámetro
	 * @return Fila elegida
	 */
	int getFila(){
		System.out.print("Introduce la fila: ");
		int y = in.nextInt();
		in.nextLine();
		return y;
	}
}
