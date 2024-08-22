package com.erc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

public class MainEjemploCartelera {

    public static void main(String[] args) {
        // DEFINICION E INICIALIAZIZACION DE VARIBALES CREANDO LOS OBEJTOS PARA LAS LLAMADAS
        CommonHelpers helpers = new CommonHelpers();
        ConexionBd bd = new ConexionBd();

        String baseDatos = "", usuario = "", password = "";
        // SOLICITO Y GUARDO LOS CAMPOS PARA LA CONEXION

        helpers.imprimirContinuo("Introduce Base de datos: ");
        baseDatos = helpers.leerTeclado();
        helpers.imprimirSalto("");

        helpers.imprimirContinuo("Introduce el usuario: ");
        usuario = helpers.leerTeclado();
        helpers.imprimirSalto("");

        helpers.imprimirContinuo("Introduce la contraseña: ");
        password = helpers.leerTeclado();
        helpers.imprimirSalto("");

        // PASO LOS DATOS A LA AYUDA DE CONEXION
        bd.setBaseDatos(baseDatos);
        bd.setUsuario(usuario);
        bd.setPassword(password);
        try (Connection conexion = bd.generarConexion();
             Statement statement = conexion.createStatement()) {

            helpers.imprimirContinuo("Conexión realizada   ");

            
        
            // DESACTIVAMOS LAS RESTRICCIONES DE LAS CLAVES FORANEAS
            statement.execute("SET FOREIGN_KEY_CHECKS = 0;");
           
            // ELIMINANOS LAS TABLAS SI EXISTEN
            String dropNacionalidades = "DROP TABLE IF EXISTS nacionalidades;";
            String dropPersonas = "DROP TABLE IF EXISTS personas;";
            String dropActores = "DROP TABLE IF EXISTS actores;";
            String dropDirectores = "DROP TABLE IF EXISTS directores;";
            String dropProductores = "DROP TABLE IF EXISTS productores;";
            String dropPersonajes = "DROP TABLE IF EXISTS personajes;";
            String dropTipos = "DROP TABLE IF EXISTS tipos;";
            String dropPremios = "DROP TABLE IF EXISTS premios;";
            String dropGeneros = "DROP TABLE IF EXISTS generos;";
            String dropPeguis = "DROP TABLE IF EXISTS peguis;";
            String dropPeliculas = "DROP TABLE IF EXISTS peliculas;";
            String dropPersonajes_Peliculas = "DROP TABLE IF EXISTS personajes_peliculas;";
            String dropPeliculas_Generos = "DROP TABLE IF EXISTS peliculas_generos;";

            statement.execute(dropPersonajes_Peliculas);
            statement.execute(dropPeliculas_Generos);
            statement.execute(dropPeliculas);
            statement.execute(dropPeguis);
            statement.execute(dropPremios);
            statement.execute(dropTipos);
            statement.execute(dropGeneros);
            statement.execute(dropActores);
            statement.execute(dropDirectores);
            statement.execute(dropProductores);
            statement.execute(dropPersonajes);
            statement.execute(dropPersonas);
            statement.execute(dropNacionalidades);

            helpers.imprimirContinuo("Las tablas han sido borradas   ");
            
           
            // REACTIVAMOS LAS RESTRICCIONES DE LAS CLAVES FORANEAS
            statement.execute("SET FOREIGN_KEY_CHECKS = 1;");

            // CREACION DE LAS TABLAS
            String creacionTablaNacionalidades = "CREATE TABLE IF NOT EXISTS nacionalidades (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "gentilicio VARCHAR(40) NOT NULL," +
                    "pais VARCHAR(40) NOT NULL" +
                    ");";

            String creacionTablaPersonas = "CREATE TABLE IF NOT EXISTS personas (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(80) NOT NULL," +
                    "apellido VARCHAR(80) NOT NULL," +
                    "fecha_nacimiento DATETIME NOT NULL," +
                    "id_nacionalidad INT NOT NULL" +
                    ");";

            String creacionTablaActores = "CREATE TABLE IF NOT EXISTS actores (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "salario DOUBLE NOT NULL," +
                    "id_persona INT NOT NULL" +
                    ");";

            String creacionTablaDirectores = "CREATE TABLE IF NOT EXISTS directores (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "alma_mater VARCHAR(30) NOT NULL," +
                    "id_persona INT NOT NULL" +
                    ");";

            String creacionTablaProductores = "CREATE TABLE IF NOT EXISTS productores (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "inversion DOUBLE NOT NULL," +
                    "id_persona INT NOT NULL" +
                    ");";

            String creacionTablaPersonajes = "CREATE TABLE IF NOT EXISTS personajes (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(80) NOT NULL," +
                    "edad INT NOT NULL," +
                    "descripcion VARCHAR(100) NOT NULL" +
                    ");";

            String creacionTablaTipos = "CREATE TABLE IF NOT EXISTS tipos (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(80) NOT NULL" +
                    ");";

            String creacionTablaPremios = "CREATE TABLE IF NOT EXISTS premios (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(30) NOT NULL," +
                    "fecha DATETIME NOT NULL," +
                    "id_pelicula INT NOT NULL," +
                    "id_tipo INT NOT NULL" +
                    ");";

            String creacionTablaGeneros = "CREATE TABLE IF NOT EXISTS generos (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(80) NOT NULL" +
                    ");";

            String creacionTablaPegui = "CREATE TABLE IF NOT EXISTS peguis (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(80) NOT NULL," +
                    "edad INT NOT NULL" +
                    ");";

            String creacionTablaPeliculas = "CREATE TABLE IF NOT EXISTS peliculas (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "titulo VARCHAR(30) NOT NULL," +
                    "fecha DATETIME NOT NULL," +
                    "duracion INT NOT NULL," +
                    "id_director INT NOT NULL," +
                    "id_productor INT NOT NULL," +
                    "id_pegui INT NOT NULL" +
                    ");";

            String creacionTablaPersonajes_Peliculas = "CREATE TABLE IF NOT EXISTS personajes_peliculas (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "id_personaje INT NOT NULL," +
                    "id_pelicula INT NOT NULL," +
                    "id_actor INT NOT NULL" +
                    ");";

            String creacionTablaPeliculas_Generos = "CREATE TABLE IF NOT EXISTS peliculas_generos (" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "id_genero INT NOT NULL," +
                    "id_pelicula INT NOT NULL" +
                    ");";

            statement.execute(creacionTablaNacionalidades);
            statement.execute(creacionTablaPersonas);
            statement.execute(creacionTablaActores);
            statement.execute(creacionTablaDirectores);
            statement.execute(creacionTablaProductores);
            statement.execute(creacionTablaPersonajes);
            statement.execute(creacionTablaTipos);
            statement.execute(creacionTablaPremios);
            statement.execute(creacionTablaGeneros);
            statement.execute(creacionTablaPegui);
            statement.execute(creacionTablaPeliculas);
            statement.execute(creacionTablaPersonajes_Peliculas);
            statement.execute(creacionTablaPeliculas_Generos);

            helpers.imprimirContinuo("Inserción de tablas creadas    ");

            // INSERCION DE LAS FOREIGN KEY (FK)
            String addFKID_Nacionalidades_Persona = "ALTER TABLE personas " +
                    "ADD CONSTRAINT fk_personas_id_nacionalidad " +
                    "FOREIGN KEY (id_nacionalidad) " +
                    "REFERENCES nacionalidades(id);";

            String addFKID_Persona_Actores = "ALTER TABLE actores " +
                    "ADD CONSTRAINT fk_actores_id_persona " +
                    "FOREIGN KEY (id_persona) " +
                    "REFERENCES personas(id);";

            String addFKID_Persona_Directores = "ALTER TABLE directores " +
                    "ADD CONSTRAINT fk_directores_id_persona " +
                    "FOREIGN KEY (id_persona) " +
                    "REFERENCES personas(id);";

            String addFKID_Persona_Productores = "ALTER TABLE productores " +
                    "ADD CONSTRAINT fk_productores_id_persona " +
                    "FOREIGN KEY (id_persona) " +
                    "REFERENCES personas(id);";

            String addFKID_Tipo_Id_Pelicula_Premios = "ALTER TABLE premios " +
                    "ADD CONSTRAINT fk_premios_id_tipo " +
                    "FOREIGN KEY (id_tipo) " +
                    "REFERENCES tipos(id), " +
                    "ADD CONSTRAINT fk_premios_id_pelicula " +
                    "FOREIGN KEY (id_pelicula) " +
                    "REFERENCES peliculas(id);";

            String addFKID_Productor_Id_Director_ID_Pegui_Peliculas = "ALTER TABLE peliculas " +
                    "ADD CONSTRAINT fk_peliculas_id_productor " +
                    "FOREIGN KEY (id_productor) " +
                    "REFERENCES productores(id), " +
                    "ADD CONSTRAINT fk_peliculas_id_director " +
                    "FOREIGN KEY (id_director) " +
                    "REFERENCES directores(id), " +
                    "ADD CONSTRAINT fk_peliculas_id_pegui " +
                    "FOREIGN KEY (id_pegui) " +
                    "REFERENCES peguis(id); ";

            String addFKID_Personaje_Id_Pelicula_ID_Actor_Personajes_Peliculas = "ALTER TABLE personajes_peliculas " +
                    "ADD CONSTRAINT fk_personajes_peliculas_id_personaje " +
                    "FOREIGN KEY (id_personaje) " +
                    "REFERENCES personajes(id), " +
                    "ADD CONSTRAINT fk_personajes_peliculas_id_pelicula " +
                    "FOREIGN KEY (id_pelicula) " +
                    "REFERENCES peliculas(id), " +
                    "ADD CONSTRAINT fk_personajes_peliculas_id_actor " +
                    "FOREIGN KEY (id_actor) " +
                    "REFERENCES actores(id);";

            String addFKID_Pelicula_Id_Genero_Peliculas_Generos = "ALTER TABLE peliculas_generos " +
                    "ADD CONSTRAINT fk_peliculas_generos_id_pelicula " +
                    "FOREIGN KEY (id_pelicula) " +
                    "REFERENCES peliculas(id), " +
                    "ADD CONSTRAINT fk_peliculas_generos_id_genero " +
                    "FOREIGN KEY (id_genero) " +
                    "REFERENCES generos(id);";

            statement.execute(addFKID_Nacionalidades_Persona);
            statement.execute(addFKID_Persona_Actores);
            statement.execute(addFKID_Persona_Directores);
            statement.execute(addFKID_Persona_Productores);
            statement.execute(addFKID_Tipo_Id_Pelicula_Premios);
            statement.execute(addFKID_Productor_Id_Director_ID_Pegui_Peliculas);
            statement.execute(addFKID_Personaje_Id_Pelicula_ID_Actor_Personajes_Peliculas);
            statement.execute(addFKID_Pelicula_Id_Genero_Peliculas_Generos);

            helpers.imprimirContinuo("Inserción realizada de las FK   ");

        } catch (SQLException sqlException) {
            bd.muestraErrorSQL(sqlException);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
