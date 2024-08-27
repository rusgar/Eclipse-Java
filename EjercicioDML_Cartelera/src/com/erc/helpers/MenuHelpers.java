package com.erc.helpers;

public class MenuHelpers {
	
	public static void imprimirMenuOpciones
	(CommonHelpers ayuda) {
		ayuda.imprimirSalto("\t\tMenú Opciones");
		ayuda.imprimirSalto("\t\t****");
		ayuda.imprimirSalto("\t1.Buscar ID");
		ayuda.imprimirSalto("\t2.Insertar");
		ayuda.imprimirSalto("\t3.Actualizar");
		ayuda.imprimirSalto("\t4.Borrar");
		ayuda.imprimirSalto("\t5.Listar Tabla");
		ayuda.imprimirSalto("\t0.Salir");
		ayuda.imprimirSalto("\tEscoja una opción:");
	}
	
	public static void imprimirMenuPrincipal
	(CommonHelpers ayuda) {
		ayuda.imprimirSalto("\t\tMenú Principal");
		ayuda.imprimirSalto("\t\t****");
		ayuda.imprimirSalto("\t1.Nacionalidades");
		ayuda.imprimirSalto("\tEscoja una opción:");
	}

}
