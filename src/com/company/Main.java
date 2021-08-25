package com.company;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();

        ArrayList<String> validOperations = new ArrayList<>(Arrays.asList("SUM","MINUS","MULTIPLY","DIVIDE","EXIT","SHOW"));

        loop: while (true){

            System.out.println("inserte los parametros: ");
            String line = scan.nextLine();
            String[] params = line.split("\\s+");
            String operation = params[0].toUpperCase(Locale.ROOT);
            String Id = "";
            float x = 0;
            float y = 0;
            boolean ParameterHasId = false;
            float result;

            if(!validOperations.contains(operation)){
                System.out.println("Ingrese una operacion valida");
                continue;
            }


            if(!operation.equals("EXIT") && !operation.equals("SHOW")){

                if(params.length < 3){
                    System.out.println("Numero de parametros Invalidos, intente nuevamente");
                    continue;
                }

                x = GetNumber(params[1], calculator);
                y = GetNumber(params[2], calculator);

                if(params.length == 4){
                    ParameterHasId = true;
                    Id = params[3];
                }

            }

            switch(operation) {
                case "EXIT":
                    break loop;
                case "SHOW":
                    System.out.println(calculator.show(params[1]));
                    break;
                default:
                    if(ParameterHasId){
                        result = calculator.calculate(x,y,operation,Id);
                    } else {
                        result = calculator.calculate(x,y,operation);
                    }
                    System.out.println(result);
            }
        }
    }




    public static boolean IsNumeric(String text){
        if(text == null) return false;

        try {
            float n = Float.parseFloat(text);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static float GetNumber(String param, Calculator calculator){
        if(IsNumeric(param)){
            return Float.parseFloat(param);
        } else {
            try {
                return calculator.show(param);
            } catch (Exception e){
                System.out.println("El ID " + param +  " no existe");
                return Float.MIN_VALUE;
            }
        }
    }
}
