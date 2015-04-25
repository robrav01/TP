package tp.pr5.control;

import tp.pr5.logica.Movimiento;
import tp.pr5.logica.Partida;

/**
 * Controlador asociado a la vista Ventana. Se encargará de llevar a cabo las acciones que ordene el usuario
 * @author Rodrigo y Javier
 *
 */
public class ControlVentana extends Control{
	
	/**
	 * Constructor de la clase Control que recibe la Factoría con la que trabajará y la Partida en la que actuará.
	 * @param f
	 * @param p
	 */
	public ControlVentana(FactoriaTipoJuego f, Partida p){
		super(f, p);
	}
	
	public void run() {
			
	}
	
	
	/**
	 * Método que se encargará de llevar a cabo un movimiento aleatorio
	 */
	public void ponerAleatorio(){
		partida.ejecutaMovimiento(f.creaJugadorAleatorio().getMovimiento(partida.getTablero(), partida.getTurno()));
	}
	
	/**
	 * Método que se encargará de llevar a cabo un movimiento recibiendo una columna y una fila
	 * @param x columna
	 * @param y fila
	 */
	public void mover(int x, int y) {
		Movimiento m = f.creaMovimiento(x, y, partida.getTurno());
		partida.ejecutaMovimiento(m);
	}
	
	/**
	 * Método que se encargará de deshacer el último movimiento
	 */
	public void deshacer() {
		if(partida.undo()){
			//Espacio reservado para posibles throw
		}
	}
	
	public void reiniciar(){
		partida.reset(partida.getReglas());
	}
	
	/**
	 * Método que se encargará de cambiar de juego .
	 * @param juego String que indica el juego.
	 * @param x ancho del tablero (solo para gravity).
	 * @param y alto del tablero (solo para gravity).
	 */
	public void cambioJuego(String juego, int x, int y){
		if(juego.equals("Gravity"))
			f = new FactoriaGravity(x, y);
		else if(juego.equals("Complica"))
			f = new FactoriaComplica();
		else if(juego.equals("Reversi"))
			f = new FactoriaReversi();
		else
			f = new FactoriaConecta4();
		
		partida.reset(f.creaReglas());
	}
	
	/**
	 * Devuelve el número de movimientos almacenados en la pila.
	 * @return número de movimientos.
	 */
	public int getNumMovimientos(){
		return partida.numMovimientos();
	}
	
}

