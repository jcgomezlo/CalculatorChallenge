package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Locale;

public class Calculator {

    private HashMap<String, Float> Id;

    public Calculator() {
        Id = new HashMap<String, Float>();
    }

    public float calculate(float x, float y, String operation){
        float result = 0;

        if(operation.equals("SUM")){
            result = x + y;
        } else if(operation.equals("MINUS")){
            result = x - y;
        } else if(operation.equals("MULTIPLY")){
            result = x * y;
        }else if(operation.equals("DIVIDE")){
            result = x / y;
        }
        return result;
    }

    public float calculate(float x, float y, String operation, String IdSave){
        float result = calculate( x,  y, operation);
        Id.put(IdSave,result);
        return result;
    }

    public float show(String id) {
        return Id.get(id);

    }



}
