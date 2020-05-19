package com.example.decodejson;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

public class JWTUtils {

    public static String decoded(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            Log.i("split(0)",getJson(split[0]));
            Log.i("split(1)",getJson(split[1]));

            return "header:"+"\n"+getJson(split[0])+"\n\n\n\n\n"+"PAYLOAD:"+getJson(split[1])+"\n\n\n\n"+"VERIFY SIGNATURE"+"\n"+getJson(split[2]);
        } catch (UnsupportedEncodingException e) {
            return  "failed";

            //Error
        }
    }

    public static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }
}
