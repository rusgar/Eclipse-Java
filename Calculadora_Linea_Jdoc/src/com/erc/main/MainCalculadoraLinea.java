package com.erc.main;

import com.erc.helpers.CommonHelpers;
import com.erc.model.Operaciones;

/**
 * CLASE PRINCIPAL DE LA CALCULADORA EN LINEA
 * @author EDU RC
 */

public class MainCalculadoraLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // OBJETOS O ATRIBUTOS
		Operaciones operaciones = new Operaciones();
		String lineLeida="";
		System.out.println("Introduzca una operacion (3 + 7)");
		lineLeida= CommonHelpers.eliminarEspacios(CommonHelpers.leerTeclado());
	}

}
