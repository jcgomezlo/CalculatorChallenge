package com.company;

import java.util.HashMap;

public class Calculator {

    private HashMap<String, Float> Id;

    public Calculator() {
        Id = new HashMap<String, Float>();
    }

    public float Sum(float a, float b) {
        float c = a + b;
        System.out.println(c);
        return c;
    }

    public void Sum(float a, float b, String id) {
        Id.put(id, Sum(a, b));
    }

    public float Minus(float a, float b) {
        float c = a - b;
        System.out.println(c);
        return c;
    }

    public void Minus(float a, float b, String id) {
        Id.put(id, Minus(a, b));
    }

    public float Multiply(float a, float b) {
        float c = a * b;
        System.out.println(c);
        return c;
    }

    public void Multiply(float a, float b, String id) {
        Id.put(id, Multiply(a, b));
    }

    public float Divide(float a, float b) {
        float c = a / b;
        System.out.println(c);
        return c;
    }

    public void Divide(float a, float b, String id) {
        Id.put(id, Divide(a, b));
    }

    public float Show(String id) {
        return Id.get(id);
    }

}
