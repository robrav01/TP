package tp.pr5.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;

public class PanelBotonesSup extends JPanel implements ObservadorPartida{
	
	/**
	 * Bot�n que se encargar� de deshacer un movimiento 
	 */
	private JButton deshacer;
	
	/**
	 * Bot�n que se encargar� de reiniciar la partida
	 */
	private JButton reiniciar;
	
	/**
	 * Controlador en el que se realizar�n las acciones
	 */
	private ControlVentana con;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que crear� el panel de botones y que recibir� como par�metro el controlador 
	 * @param con
	 */
	public PanelBotonesSup(ControlVentana c){
		con = c;
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Partida" ));
		this.setLayout(new FlowLayout());
		
		deshacer = new JButton("Deshacer");
		deshacer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						con.deshacer();
					}	
				}
			);
		
		reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						con.reiniciar();
					}	
				}
			);
		
		this.add(deshacer);
		this.add(reiniciar);
		deshacer.setEnabled(false);
	}

	public void onReset(TableroInmutable t) {
		deshacer.setEnabled(false);
	}

	public void onMove(TableroInmutable t) {
		habilitarDeshacer();
	}

	public void onGameOver() {
		deshacer.setEnabled(false);
	}

	public void onError(String msg) {
		
	}

	public void onUndo(TableroInmutable t) {
		habilitarDeshacer();
	}
	
	/**
	 * M�todo que habilitar� y deshabilitar� el bot�n deshacer
	 */
	private void habilitarDeshacer(){
		if(con.getNumMovimientos() == 0)
			deshacer.setEnabled(false);
		else
			deshacer.setEnabled(true);
	}

}
