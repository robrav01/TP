package tp.pr5.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;

public class PanelBotonesInf extends JPanel implements ObservadorPartida {
	
	/**
	 * Bot�n que se encargar� de salir de la aplicaci�n
	 */
	private JButton salir;
	
	
	/**
	 * Bot�n que se encargar� de realizar un movimiento aleatorio
	 */
	private JButton aleatorio;
	
	/**
	 * Controlador en el que se realizar�n las acciones
	 */
	private ControlVentana c;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que crear� el panel de botones y que recibir� como par�metro el controlador 
	 * @param con
	 */
	public PanelBotonesInf(ControlVentana con){
		c = con;
		this.setLayout(new FlowLayout());
		
		salir = new JButton("Salir");
		salir.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						opcionSalir();
					}	
				}
			);
		
		aleatorio = new JButton("Aleatorio");
		aleatorio.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						c.ponerAleatorio();
					}	
				}
			);
		
		this.add(salir);
		this.add(aleatorio);
		
		aleatorio.setEnabled(true);
	}
	
	/**
	 * Crear� un panel para confirmar la opci�n salir
	 */
	public void opcionSalir(){
		int i =  JOptionPane.showConfirmDialog(null, "�Sayonara Baby? :(", "V�monos �tomos. Venga V�monos",
				JOptionPane.YES_NO_OPTION, JOptionPane.CLOSED_OPTION);
		if(i == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public void onReset(TableroInmutable t) {
		aleatorio.setEnabled(true);
	}

	public void onMove(TableroInmutable t) {
		
	}

	public void onGameOver() {
		aleatorio.setEnabled(false);
	}

	public void onError(String msg) {
		
	}

	public void onUndo(TableroInmutable t) {
		
	}

}
