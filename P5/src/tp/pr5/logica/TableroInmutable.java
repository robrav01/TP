package tp.pr5.logica;

public interface TableroInmutable {
	public int getAncho();
	public int getAlto();
	public Ficha getCasilla(int x, int y);
	public String toString();
}
