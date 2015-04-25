package tp.pr5.logica;

/**
 * Clase que se encargará de ejecutar o deshacer un movimiento del gravity
 * @author Rodrigo y Javier
 *
 */
public class MovimientoGravity extends Movimiento {
	
	/** atributo que contiene el desplazamiento en cualquier dirección y sentido */
	private int d;
	
	/**
	 * Constructor de MovimientoGravity 
	 * @param x columna del movimiento
	 * @param y fila del movimiento
	 * @param color Ficha del movimiento
	 */
	public MovimientoGravity(int x, int y, Ficha color){
		super(x, color);
		fila = y;
		d = 0;
	}
	
	/**
	 * M�todo que ejecuta su movimiento en el tablero que recibe como par�metro.
	 */
	public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido{
		if(tab.posicionValida(donde, fila)){
			if(tab.getCasilla(donde, fila).equals(Ficha.VACIA)){
				posicionar(tab);
			}else
				throw new MovimientoInvalido("Casilla ocupada.");
		}else
			throw new MovimientoInvalido("Posici�n incorrecta.");
	}
	
	/**
	 * Método encargado de desplazar las fichas según la lógica del gravity
	 * @param tab
	 * @throws MovimientoInvalido
	 */
	private void posicionar(Tablero tab) throws MovimientoInvalido{
		int dx, dy;
		
		//calcula la distancia y el desplazamiento horizontal.
		int disX = desplazamiento(tab, donde, tab.getAncho());
		dx = d;
		
		//calcula la distancia y el desplazamiento vertical.
		int disY = desplazamiento(tab, fila, tab.getAlto());
		dy = d;
		
		//compara distancias.
		if((disX > disY) && (dy != 0))
			dx = 0;
		if((disX < disY) && (dx != 0))
			dy = 0;
		
		//realiza el desplazamiento.
		while(tab.getCasilla(donde + dx, fila + dy)==Ficha.VACIA 
				&& (dx != 0||dy != 0) && tab.posicionValida(donde + dx, fila + dy)){
			donde += dx;
			fila += dy;
		}
		tab.setCasilla(donde, fila, color);
	}
	
	/**
	 * Método que calcula los desplazamientos de la ficha y devuelve la distancia a los lados en vertical u horizontal
	 * @param tab
	 * @param pos
	 * @param longitud
	 * @return
	 */
	private int desplazamiento(Tablero tab, int pos, int longitud){
		int mitad = longitud / 2;
		boolean par = true; 
		if(longitud % 2 != 0)
			par = false;
		
		if(pos <= mitad){
			d = -1;
			return pos;
		}
		else if (pos == mitad + 1 && !par){
			d = 0;
			return pos;
		}
		
		d = 1;
		return longitud - pos + 1;
		
	}
}
