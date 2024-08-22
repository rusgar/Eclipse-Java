package com.erc.main;

import com.erc.helpers.ModeloCRUD;

public class MainEjemploCRUD {

    public static void main(String[] args) {
        ModeloCRUD modelo = new ModeloCRUD();

        modelo.inicializar();

        try {
            modelo.ejecutarCRUD();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            modelo.cerrarConexion();
        }
    }
}
