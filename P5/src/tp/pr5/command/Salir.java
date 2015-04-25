package tp.pr5.command;

/**
 *  Clase del comando que se encargará de parsear y ejecutar SALIR. Saldrá de la partida
 * @author Rodrigo y Javier
 *
 */
public class Salir extends Command{
	
	public Salir() {
		super("SALIR", "SALIR: termina la aplicación.\n");
	}

	public void ejecutar() {
		System.exit(0);
	}

}
