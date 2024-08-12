package com.erc.main;

import java.awt.Color;
import java.awt.Font;

public class TipoLetra {
	// ATRIBUTOS
	private String tipo;    // Tipo de letra
	private int tamaño;     // Tamaño de la letra
	private int estilo;		// Estilo de la letra ES ENTERO!!
	private Color color;	// Color de la letra
    
    // GETTERS Y SETTERS
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public int getEstilo() {
		return estilo;
	}
	public void setEstilo(int estilo) {
		this.estilo = estilo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	// CONSTRUCTORES
	public TipoLetra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoLetra(String tipo, int estilo, int tamaño,Color color) {
		super();
		this.tipo = tipo;
		this.estilo = estilo;
		this.tamaño = tamaño;
		this.color = color;
	}
    
    // Método para obtener la fuente
    public Font obtenerTipoLetra() {
        return new Font(tipo, estilo, tamaño);
        
    }


}
