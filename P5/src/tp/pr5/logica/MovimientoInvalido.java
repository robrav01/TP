package tp.pr5.logica;

/**
 * Clase encargada de lanzar los errores de movimiento
 * @author Rodrigo y Javier
 *
 */
public class MovimientoInvalido extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	@SuppressWarnings("unused")
	private Throwable arg;
	
	public MovimientoInvalido(){
		
	}
	
	public MovimientoInvalido(String msg){
		this.msg = msg;
	}

	public MovimientoInvalido(String msg, Throwable arg){
		this.msg = msg;
		this.arg = arg;
	}
	
	public MovimientoInvalido(Throwable arg){
		this.arg = arg;
	}
	
	/**
	 * devuelve el mensaje del movimiento inválido
	 * @return mensaje
	 */
	public String getMsg(){
		return msg;
	}
	
}
