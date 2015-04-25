package tp.pr5.command;

import tp.pr5.logica.MovimientoInvalido;

/**
 * Clase de la que heredarán todos los comandos de nuestro controlador
 * @author Rodrigo y Javier
 *
 */
public abstract class Command {
	
	/**
	 * Atributo encargado de guardar la palabra más significativa de cada comando para parsear
	 */
	protected String reconocedor;
	
	/**
	 * Atributo que guardará la ayuda de todos los comandos declarados
	 */
	protected static String ayuda = "Los comandos disponibles son:\n\n";
	
	/**
	 * Constructor de command que recibe el reconocedor para parsear y la ayuda de cada comando
	 * @param rec String que servvirá para parsear
	 * @param ayu se acumulará la ayuda de los comandos
	 */
	public Command(String rec, String ayu){
		reconocedor = rec;
		ayuda += ayu;
	}
	
	/**
	 * Función que compara opción con la palabra más significativa del comando 
	 * @param opcion 
	 * @return true si coinciden
	 */
	public boolean reconocerCom(String opcion){
		if(reconocedor.equals(opcion))
			return true;
		return false;
	}
	
	/**
	 * Método que ejecutará cada comando
	 * @throws MovimientoInvalido si ha surgido algún error
	 */
	public abstract void ejecutar() throws MovimientoInvalido;
}
