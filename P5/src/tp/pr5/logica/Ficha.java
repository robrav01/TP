package tp.pr5.logica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Enumerado Ficha que representa una casilla del tablero en la que hay una ficha Negra, Blanca o Vacía si la casilla está vacía
 * 
 * @author Rodrigo y Javier
 *
 */
public enum Ficha{
	VACIA, NEGRA, BLANCA;
	
	/**
	 * Método encargado de devolver la ficha contraria a la ficha que llama la función. Si es vacía devuelve vacía.
	 * @return ficha contraria.
	 */
	public Ficha fichaContraria(){
		if(this == BLANCA){
			return NEGRA;
		}
		if (this == NEGRA){
			return BLANCA;
		}
		return VACIA;
	}
	
	/**
	 * Mï¿½todo que se encarga de convertir una ficha en un String.
	 * @param aux Ficha que transformar
	 * @return el String de la ficha
	 */
	public String mostrarFicha(){
		if(this == Ficha.BLANCA){
			return "blancas";
		}
		else{
			return "negras";
		}
	}
	
	/**
	 * Devuelve el String que representa la ficha
	 */
	public String toString(){
		if(this == Ficha.BLANCA){
			return "O";
		}
		
		if (this == Ficha.NEGRA){
			return "X";
		}
		return " ";
	}
	
	/**
	 * Función que devuelve el icono correspondiente a cada tipo de ficha
	 * @return icono de la ficha
	 */
	public Icon toIcon(){
		if(this == Ficha.BLANCA){
			return new ImageIcon("src/lenny.jpg");
		}
		if(this == Ficha.NEGRA){
			return new ImageIcon("src/carl.png");
		}
			return new ImageIcon("src/images.jpg");
	}
	

	/*public static void main(String[] args){
		//System.out.println(Ficha.BLANCA);
		//StringBuilder cad = new StringBuilder("fsdjfhsd");
		//System.out.println(cad.append(Ficha.NEGRA));
	}*/
}