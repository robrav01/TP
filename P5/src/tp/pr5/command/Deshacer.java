package tp.pr5.command;

import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;

/**
 *  Clase del comando que se encargar√° de parsear y ejecutar DESHACER. Deshar√° el √∫ltimo movimiento.
 * @author Rodrigo y Javier
 *
 */
public class Deshacer extends Command {
	private Partida p;
	
	/**
	 *  Clase del comando que se encargar· de parsear y ejecutar DESHACER. Devolver· por pantalla la ayuda
	 * @author Rodrigo y Javier
	 *
	 */
	public Deshacer(Partida p) {
		super("DESHACER", "DESHACER: deshace el √∫ltimo movimiento hecho en la partida.\n");
		this.p = p;
	}
	
	/**
	 * EjecuciÛn del comando
	 */
	public void ejecutar() throws MovimientoInvalido {
		if(!p.undo()){
			throw new MovimientoInvalido("Imposible deshacer.");
		}
	}

}
