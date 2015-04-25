package tp.pr5.command;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tp.pr5.control.ControladorConsola;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;

/**
 * Clase que declarará, parseará y ejecutará los comandos
 * @author Rodrigo y Javier
 *
 */
public class GestorComandos {
	
	/** atributo que contendrá todos los comandos */
	private List<Command> comm;
	
	/** Scanner que usarán los comandos */
	private Scanner in;
	
	/**
	 * Constructor del Gestor de comandos que iniciará todos los comandos y les pasará lo necesario para su ejecución
	 * @param control
	 * @param p
	 * @param in
	 */
	public GestorComandos(ControladorConsola control, Partida p, Scanner escaner){
		this.in = escaner;
		comm = new ArrayList <Command>();
		comm.add(new Poner(control, p));
		comm.add(new Deshacer(p));
		comm.add(new Reiniciar(p));
		comm.add(new Jugar(control, p, in));
		comm.add(new Jugadores(control, in));
		comm.add(new Salir());
		comm.add(new Ayuda());	
	}
	
	
	/**
	 * Método en el que se parsean los comandos y se ejecutan si es necesario
	 * @throws MovimientoInvalido
	 * @throws InputMismatchException
	 */
	public void ejecutar(String opcion) throws MovimientoInvalido, InputMismatchException{
		boolean iterar = true;
		int i = 0;
		
			while(iterar && i < comm.size()){
				if(comm.get(i).reconocerCom(opcion)){
					comm.get(i).ejecutar();
					iterar = false;
				}
				i++;
			}
			
		//Si ninguno de los comandos coincide con la opción
		if(iterar){
			
		}
			//Poner onError
	}
}
