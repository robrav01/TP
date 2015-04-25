package tp.pr5.command;

import tp.pr5.logica.Partida;

/**
 *  Clase del comando que se encargará de parsear y ejecutar REINICIAR. Reiniciará la partida
 * @author Rodrigo y Javier
 *
 */
public class Reiniciar extends Command{
	
	private Partida p;
	
	public Reiniciar(Partida p){
		super("REINICIAR", "REINICIAR: reinicia la partida.\n");
		
		this.p = p;
	}

	public void ejecutar() {
		p.reset(p.getReglas());
	}

}
