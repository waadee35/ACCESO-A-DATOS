package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
			
			}
			
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {
		
		String ficheros1 = view.getFichero1().getText();
		String ficheros2 = view.getFichero2().getText();

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		
		
		try {
			
			boolean comprobar=model.compararContenido(ficheros1, ficheros2);
			
			view.getTextArea().setText("Comparado");
		} catch (Exception e) {
			if(view.getFichero1().getText().length() == 0 || view.getFichero2().getText().length() == 0) {
				view.showError("ERROR ,defina el fichero pòr favor");
				view.getTextArea().setText("");
			}else {
				
				view.getTextArea().setText(" ");
				view.showError("Ha ocurrido algun ERROR");
				
			}
			
			
		}
		
		
		
	
		return 1;
		
		
	}

	private int call_buscarPalabra() {
		
		String ficheros1 = view.getFichero1().getText();
		String ficheros2 = view.getFichero2().getText();

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		try {
			if(GestionDatos.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected()) == -1) {
				view.getTextArea().setText("La palabra que busca no se ha encontrado'"+view.getPalabra().getText());
			}else view.getTextArea().setText("La palabra que busca es:'"+view.getPalabra().getText()+"' la cual esta posicionada en la línea nº "+GestionDatos.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected()));
		} catch (Exception e) {
			if(view.getFichero1().getText().length() == 0 || view.getPalabra().getText().length() == 0) {
				view.showError("ERROR, defina los campos porfavor");
				view.getTextArea().setText("");
			}else{
				view.showError("Ha ocurrido algun ERROR");
				view.getTextArea().setText("");
			}
		}
		
		return 1;
	}

}
