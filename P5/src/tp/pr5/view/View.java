package tp.pr5.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;

/**
 * Componente principal que representará a la vista de ventana
 * @author Rodrigo y Javier
 *
 */
public class View extends JFrame implements ObservadorPartida {
	
	/**
	 * Contendrá los elementos del la vista
	 */
	Container panelPrincipal;
	
	/**
	 * Panel que creado para organizar mejor la vista
	 */
	JPanel panelBotones;
	
	/**
	 * Panel en el que se llevará a cabo el cambio de juego
	 */
	PanelJuego panelJuego;
	
	PanelBotonesSup panelSup;
	
	PanelBotonesInf panelInf;
	
	/**
	 * Panel que representará el tablero del juego
	 */
	PanelJugada panelT;
	
	/**
	 * Controlador en el que se realizarán las acciones
	 */
	ControlVentana c;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public View(ControlVentana c){
		super("Práctica 4 - TP");
		this.c = c;
		//Se inicializan los componentes
		panelPrincipal = this.getContentPane();
		panelPrincipal.setLayout(new BorderLayout());
		panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());
		panelJuego = new PanelJuego(c);
		panelSup = new PanelBotonesSup(c);
		panelInf = new PanelBotonesInf(c);
		panelT = new PanelJugada(c);
		
		//Se añaden los componentes
		panelBotones.add(panelSup, BorderLayout.NORTH);
		panelBotones.add(panelJuego, BorderLayout.CENTER);
		
		panelPrincipal.add(panelBotones, BorderLayout.EAST);
		panelPrincipal.add(panelInf, BorderLayout.SOUTH);
		panelPrincipal.add(panelT, BorderLayout.CENTER);//Cambiar
		
		//Se eligen las características de View
		this.setLocation(100, 10);
		this.setSize(900, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Se añaden los observadores
		addObservers();
		
	}
	
	/**
	 * Método que añade los observadores 
	 */
	private void addObservers(){
		c.addObserver(this.panelJuego);
		c.addObserver(this.panelT);
		c.addObserver(this.panelSup);
		c.addObserver(this.panelInf);
		c.addObserver(this);
	}

	
	public void onReset(TableroInmutable t) {
		/*panelPrincipal.remove(panelT);
		panelT = new PanelJugada(c);
		panelPrincipal.add(panelT, BorderLayout.WEST);*/
		//this.repaint();
	}


	public void onMove(TableroInmutable t) {
		
	}


	public void onGameOver() {
		
	}


	public void onError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Alarma silenciosa!!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void onUndo(TableroInmutable t) {
		
	}
	
	/*public static void main(String[] args) {
		Partida p = new Partida(new ReglasComplica());
		ControlVentana c = new ControlVentana(new FactoriaComplica(), p);
		
		Partida p = new Partida(new ReglasConecta4());
		ControlVentana c = new ControlVentana(new FactoriaConecta4(), p);
		
		FactoriaGravity f = new FactoriaGravity(1, 1);
		Partida p = new Partida(f.creaReglas());
		ControlVentana c = new ControlVentana(f, p);
		new View(c); 
	}*/


	

}
