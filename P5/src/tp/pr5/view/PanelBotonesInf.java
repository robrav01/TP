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
	 * Botón que se encargará de salir de la aplicación
	 */
	private JButton salir;
	
	
	/**
	 * Botón que se encargará de realizar un movimiento aleatorio
	 */
	private JButton aleatorio;
	
	/**
	 * Controlador en el que se realizarán las acciones
	 */
	private ControlVentana c;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que creará el panel de botones y que recibirá como parámetro el controlador 
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
	 * Creará un panel para confirmar la opción salir
	 */
	public void opcionSalir(){
		int i =  JOptionPane.showConfirmDialog(null, "¿Sayonara Baby? :(", "Vámonos átomos. Venga Vámonos",
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
