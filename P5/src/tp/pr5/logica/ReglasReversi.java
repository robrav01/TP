package tp.pr5.logica;

public class ReglasReversi extends ReglasJuegoAbstractas{

	public Tablero iniciaTablero() {
		Tablero t = new Tablero(8, 8);
		t.setCasilla(4, 4, Ficha.BLANCA);
		t.setCasilla(5, 5, Ficha.BLANCA);
		t.setCasilla(4, 5, Ficha.NEGRA);
		t.setCasilla(5, 4, Ficha.NEGRA);
		return t;
	}

	public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReglasReversi().iniciaTablero());
	}
	
	public Ficha jugadorInicial() {
		return Ficha.NEGRA;
	}
}
