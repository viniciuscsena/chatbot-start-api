package br.com.chatbot.start.chatbotstartapi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    private static final Gson parser;

    static{
        parser = new GsonBuilder().serializeNulls().setDateFormat("dd/MM/YYYY").create();
    }

    public static String toJson(Object obj){
        return parser.toJson(obj);
    }
}
