package com.silviotmalmeida.app.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

// classe de utilidades para requisições http
public class URL {

    // método para decodificar atributos encodados
    public static String decodeParam(String text) {

        // tenda decodificar
        try {
            return URLDecoder.decode(text, "UTF-8");
        }
        // em caso de erro, retorna uma string vazia
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    // método para converter os textos recebidos em Date
    public static Date convertDate(String textDate, Date defaultValue) {

        // determinando o padrão de recebimento da data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // tenda converter
        try {
            return sdf.parse(textDate);
        }
        // em caso de erro, retorna a data definida como padrão
        catch (ParseException e) {
            return defaultValue;
        }
    }
}
