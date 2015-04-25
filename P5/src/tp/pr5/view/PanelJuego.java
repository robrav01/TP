package tp.pr5.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.pr5.control.ControlVentana;
import tp.pr5.logica.TableroInmutable;
import tp.pr5.observers.ObservadorPartida;

public class PanelJuego extends JPanel implements ObservadorPartida {
	
	/**
	 * Lista que contendrá los juegos diponibles
	 */
	private JComboBox<String> listaJuegos;
	
	/**
	 * Bóton que hará el cambio de juego
	 */
	private JButton cambio;
	
	/**
	 * Guarda el juego que está seleccionado
	 */
	private String juego;
	
	/**
	 * Ancho del gravity
	 */
	private int x;
	
	/**
	 * Alto del Gravity
	 */
	private int y;
	
	/**
	 * Panel en el que se elegirán las dimensiones del Gravity
	 */
	private JPanel dimensiones;
	
	/**
	 * Controlador en el que se realizarán las acciones
	 */
	private ControlVentana control;
	
	/**
	 * Espacio en el que se introducirá el ancho del Gravity
	 */
	private JTextField col;
	
	/**
	 * Espacio en el que se introducirá el alto del Gravity
	 */
	private JTextField fil;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que creará el panel de botones y que recibirá como parámetro el controlador 
	 * @param c
	 */
	public PanelJuego(ControlVentana c){
		x = 10; y = 10;
		juego = "Conecta 4";
		control = c;
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cambio de Juego" ));
		this.setLayout(new BorderLayout());
		//Inicializa los componentes
		listaJuegos = new JComboBox<String>(); 
		listaJuegos.addItem("Conecta 4");
		listaJuegos.addItem("Complica");
		listaJuegos.addItem("Gravity");
		listaJuegos.addItem("Reversi");
		listaJuegos.addActionListener(//Añade el ActionIstener y decide si es visible el componente de elegir dimensiones
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							juego = listaJuegos.getSelectedItem().toString();
							if(juego.equals("Gravity"))
								dimensiones.setVisible(true);
							else
								dimensiones.setVisible(false);
						}
					}
				);
		//Inicializa el botón del cambio
		cambio = new JButton("Cambiar");
		cambio.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							try{
								x = Integer.parseInt(col.getText());
							}catch(Exception e1){
								x = 10;
							}
							try{
								y = Integer.parseInt(fil.getText());
							}catch(Exception e1){
								y = 10;
							}
							control.cambioJuego(juego, x, y);	
						}	
					}
				);
		
		this.add(listaJuegos, BorderLayout.NORTH);
		dimensiones();
		this.add(cambio, BorderLayout.SOUTH);
		dimensiones.setVisible(false);
		this.setVisible(true);
	
	}
	
	/**
	 * Crea el componente de elegir dimensiones
	 */
	private void dimensiones(){
		dimensiones = new JPanel();
		dimensiones.add(new JLabel("Columnas:"));
		col = new JTextField(2);
		fil = new JTextField(2);

		dimensiones.add(col);
		dimensiones.add(new JLabel("Filas:"));
		dimensiones.add(fil);
		add(dimensiones, BorderLayout.CENTER);
	}

	public void onReset(TableroInmutable t) {
		
	}

	public void onMove(TableroInmutable t) {
		
	}

	public void onGameOver() {
		
	}

	public void onError(String msg) {
		
	}

	public void onUndo(TableroInmutable t) {
		
	}

}
