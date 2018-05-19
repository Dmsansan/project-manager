package com.sansan;

public class BaseController {

    public boolean ParameIsNull(String parame){
        if(parame==null || parame.equals("null") || parame.isEmpty()){
            return true;
        }
        return false;
    }
}
