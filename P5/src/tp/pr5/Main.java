package tp.pr5;

import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import tp.pr5.VistaConsola.VistaConsola;
import tp.pr5.control.ControlVentana;
import tp.pr5.control.ControladorConsola;
import tp.pr5.control.FactoriaComplica;
import tp.pr5.control.FactoriaConecta4;
import tp.pr5.control.FactoriaGravity;
import tp.pr5.control.FactoriaReversi;
import tp.pr5.control.FactoriaTipoJuego;
import tp.pr5.logica.MovimientoInvalido;
import tp.pr5.logica.Partida;
import tp.pr5.logica.ReglasConecta4;
import tp.pr5.logica.ReglasJuego;
import tp.pr5.view.View;

public class Main {

	public static void main(String[] args) {
		// Inicializaci√≥n de las variables principales del programa
		Scanner in = new Scanner(System.in);
		ReglasJuego reglas = new ReglasConecta4();
		FactoriaTipoJuego f = new FactoriaConecta4();
		boolean cambioVista = false;

		// Preparaci√≥n de los comandos para los argumentos del main
		CommandLineParser parser = new PosixParser();
		Options options = new Options();

		options.addOption("g", "game", true, "Tipo de juego (c4, co, gr, rv). Por defecto, c4.");
		options.getOption("g").setArgName("game");

		options.addOption("x", "tamX", true, "N˙mero de columnas del tablero (sÛlo para Gravity). Por defecto, 10.");
		options.getOption("x").setArgName("columnNumber");

		options.addOption("y", "tamY", true, "N˙mero de filas del tablero (sÛlo para Gravity). Por defecto, 10.");
		options.getOption("y").setArgName("rowNumber");

		options.addOption("h", "help", false, "Muestra esta ayuda.");
		
		options.addOption("u", "ui", true, "Tipo de interfaz (console, window). Pordefecto, console.");
		options.getOption("u").setArgName("tipo");

		// Parseo de los argumentos y captura de errores
		try {
			int tamX = 10, tamY = 10;
			CommandLine cmdLine = parser.parse(options, args);

			if (cmdLine.hasOption("h")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp(Main.class.getName(), options, true);
				System.exit(0);
			}

			else {
				if (cmdLine.hasOption("x")) {
					tamX = Integer.parseInt(cmdLine.getOptionValue("x"));
				}
				if (cmdLine.hasOption("y")) {
					tamY = Integer.parseInt(cmdLine.getOptionValue("y"));
				}
				if (cmdLine.hasOption("u")) {
					if (cmdLine.getOptionValue("u").equalsIgnoreCase("window")) {
						cambioVista = true;
					} else if (cmdLine.getOptionValue("u").equalsIgnoreCase("console")) {
						cambioVista = false; //Por si acaso
					}
					else {
						in.close();
						throw new MovimientoInvalido("Tipo "+ cmdLine.getOptionValue("u") + " incorrecto.");
					}
					if (cmdLine.getArgList().size() > 1) {
						in.close();
						throw new MovimientoInvalido("Argumentos no entendidos: "+ cmdLine.getArgList());
					}
				}
				if (cmdLine.hasOption("g")) {
					if (cmdLine.getOptionValue("g").equalsIgnoreCase("co")) {
						f = new FactoriaComplica();
					} else if (cmdLine.getOptionValue("g").equalsIgnoreCase("c4")) {
						f = new FactoriaConecta4();
					} else if (cmdLine.getOptionValue("g").equalsIgnoreCase("gr")) {
						f = new FactoriaGravity(tamX, tamY);
					} else if (cmdLine.getOptionValue("g").equalsIgnoreCase("gr")) {
						f = new FactoriaReversi();
					} else {
						in.close();
						throw new MovimientoInvalido("Juego "+ cmdLine.getOptionValue("g") + " incorrecto.");
					}
					if (cmdLine.getArgList().size() > 1) {
						in.close();
						throw new MovimientoInvalido("Argumentos no entendidos: "+ cmdLine.getArgList());
					}	
				} 
				else if (cmdLine.getArgList().size() > 1) {
					in.close();
					throw new MovimientoInvalido("Unrecognized option: "+ cmdLine.toString());
				}
			}

			// Cambio del valor de las variables
			reglas = f.creaReglas();
			Partida p = new Partida(reglas);
			
			if(cambioVista){
				ControlVentana c = new ControlVentana(f, p);
				new View(c);
			}else{
				new VistaConsola(new ControladorConsola(f, p, in));
			}
			
			
			
		} catch (ParseException e) {
			System.err.print("Uso incorrecto: ");
			System.err.println(e.getMessage());
			System.err.println("Use -h|--help para m√°s detalles.");
			// e.printStackTrace();
			System.exit(1);
		} catch (MovimientoInvalido c) {
			System.err.print("Uso incorrecto: ");
			System.err.print(c.getMsg());
			System.err.println("Use -h|--help para m√°s detalles.");
			System.exit(1);
		}
		in.close();
	}

}
