package tp.pr5.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;
import tp.pr5.observers.ObservadorTablero;

public class PanelJugada extends JPanel implements  ObservadorPartida {
	/**
	 * Controlador en el que se realizar�n las acciones
	 */
	private ControlVentana c;
	
	/**
	 * Imagen que mostrar� una peque�a ayuda
	 */
	private JLabel ayuda;
	
	/**
	 * Panel que mostrar� el turno o si la partida ha terminado
	 */
	private JLabel turno;
	
	/**
	 * Panel que representar� el tablero
	 */
	private PanelTablero panelT;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor del panel que recibe el controlador
	 * @param control
	 */
	public PanelJugada(ControlVentana control){
		c = control;
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(new BorderLayout());
		
		iniciar();
		
	}
	
	/**
	 * M�todo que devuelve el observador del tablero
	 * @return observador tablero
	 */
	public ObservadorTablero getObserverTablero(){
		return panelT;
	}
	
	/**
	 * M�todo que inicializa PanelJugada
	 */
	public void iniciar(){
		panelT = new PanelTablero(c);
		turno = new JLabel("Juegan " + c.getTurno().mostrarFicha());
		ayuda = new JLabel(new ImageIcon("src/carlylenny.jpg"));
		
		add(panelT, BorderLayout.NORTH);
		add(ayuda, BorderLayout.CENTER);
		add(turno, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}

	public void onReset(TableroInmutable tab) {
		this.removeAll();
		iniciar();
		this.repaint();
		this.revalidate();
	}

	public void onMove(TableroInmutable t) {
		turno.setText("Juegan " + c.getTurno().mostrarFicha());
	}

	public void onGameOver() {
		turno.setText(c.getGanador());
	}

	public void onError(String msg) {
		
	}

	public void onUndo(TableroInmutable t) {
		turno.setText("Juegan " + c.getTurno().mostrarFicha());
	}

}
