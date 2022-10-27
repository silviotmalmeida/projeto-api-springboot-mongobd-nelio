package com.silviotmalmeida.app.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// classe de utilidades para requisições http
public class URL {

    // método para decodificar atributos encodados
    public static String decodeParam(String text){

        // tenda decodificar
        try {
            return URLDecoder.decode(text, "UTF-8");
        }
        // em caso de erro, retorna uma string vazia
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    
}
