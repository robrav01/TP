package tp.pr5.command;

import tp.pr5.control.ControladorConsola;
import tp.pr5.logica.Ficha;
import tp.pr5.logica.Movimiento;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;

public class Poner extends Command{
	
	private ControladorConsola control;
	
	private Partida p;
	
	public Poner(ControladorConsola control, Partida p){
		super("PONER","PONER: utilízalo para poner la siguiente ficha.\n");
		
		this.control = control;
		this.p = p;
	}

	public void ejecutar() throws MovimientoInvalido {
		//Creaci�n del movimiento
		Movimiento mov = crearMovimiento();
		
		//ejecuci�n
		p.ejecutaMovimiento(mov);
	}
	
	/**
	 * Método encargado de crear el movimiento según el jugador, el turno y el tipo de juego
	 * @return
	 */
	private Movimiento crearMovimiento(){
		Ficha color = p.getTurno();
		if(color.equals(Ficha.BLANCA)){
			return control.getJugadorBlancas().getMovimiento(p.getTablero(), color);
		}
		else{
			return control.getJugadorNegras().getMovimiento(p.getTablero(), color);
		}
	}

}
