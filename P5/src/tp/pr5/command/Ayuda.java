package tp.pr5.command;

/**
 *  Clase del comando que se encargará de parsear y ejecutar AYUDA. Devolverá por pantalla la ayuda
 * @author Rodrigo y Javier
 *
 */
public class Ayuda extends Command{

	/**
	 * Constructor de AYUDA
	 */
	public Ayuda() {
		super("AYUDA", "AYUDA: muestra esta ayuda.\n");
	}
	
	/**
	 * Ejecuci�n del comando
	 */
	public void ejecutar() {
		System.out.println(ayuda + "\n");
	}

}
