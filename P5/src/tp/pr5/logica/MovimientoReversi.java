package tp.pr5.logica;

public class MovimientoReversi extends Movimiento{

	public MovimientoReversi(int x, int y, Ficha color) {
		super(x, color);
		donde = y;
	}

	public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido {
		
	}

}
