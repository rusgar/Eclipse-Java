package com.erc.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  CON ESTA CLASE URLSHORTENER PROPORCIONAMOS UNA IMPLEMENTACIÓN SIMPLE DE UN ACORTADOR DE URLS. 
 * * CONVIERTE UNA URL LARGA EN UNA URL CORTA UTILIZANDO UN SISTEMA DE CODIFICACIÓN BASE62 
 * @author EDU RUS
 */
public class URLShortener {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // CONJUNTO DE CARACTERES UTILIZANDO CODIFICACION BASE 62
    private static final int BASE = BASE62.length(); // LONGITUD DE LA BASE QUE CORRESPONDE A LOS 62 CARACTERES
    private final Map<String, String> urlMap = new HashMap<>(); // MAPA QUE ALMACENA LA CORRESPONDENCIA DE LAS URL CORTAS
    private final AtomicInteger idCounter = new AtomicInteger(); // CONTADOR ATOMICO QUE GENERRA EL IDCONUNTER
    
    
/**
 *  CON ESTE METODO ACORTAMOS UNA URL LARGA GENERANDO UN IDENTIFICADOR ÚNICO Y CODIFICÁNDOLO EN BASE62. 
 *  LUEGO, ALMACENA LA URL CORTA JUNTO CON SU URL ORIGINAL EN UN MAPA.
 * @param longUrl
 * @return shortURl
 */
    public String shortenURL(String longUrl) {
        int id = idCounter.incrementAndGet();
        String shortUrl = encode(id);
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    /**
     * ASOCIAMOS LA URL ORIGINAL A UNA URL CORTA
     * @param shortUrl
     * @return shortURl
     */
    public String getOriginalURL(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    /**
     * CODIFICAMOS UN NUMERO ENTERO (ID) DE UNA CADENA UTILIZANDO EL BASE 62
     * @param id
     * @return shortURl
     */
    private String encode(int id) {
        StringBuilder shortUrl = new StringBuilder();
        while (id > 0) {
            shortUrl.append(BASE62.charAt(id % BASE));
            id /= BASE;
        }
        return shortUrl.reverse().toString();
    }

    
    /**
     * CON ESTE MÉTODO PRINCIPAL PARA REALIZAR PRUEBAS DEL ACORTADOR DE URLS.
     * GENERA UNA URL CORTA A PARTIR DE UNA URL LARGA, Y LUEGO LA DECODIFICA.
     * @param ARGS
     */
    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String longUrl = "https://www.google.com/maps?q=40.7128,-74.0060";
        String shortUrl = shortener.shortenURL(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.getOriginalURL(shortUrl));
    }
}
