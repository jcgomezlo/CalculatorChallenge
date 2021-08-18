package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true){
            System.out.println("inserte los parametros: ");
            String line = scan.nextLine();
            String[] params = line.split("\\s+");
            String operation = params[0];

            if(CheckOperation(operation,"EXIT")){
                break;
            } else if(CheckOperation(operation,"SHOW")){
                try{
                    System.out.println(calculator.Show(params[1]));
                }  catch (Exception e){
                    System.out.println("No se encontro el ID seleccionado");
                }
                continue;
            }

            if(params.length < 3){
                System.out.println("Numero de parametros Invalidos, intente nuevamente");
                continue;
            }

            boolean ParameterHasId = params.length == 4;
            float x,y;

            x = GetNumber(params[1], calculator);
            y = GetNumber(params[2], calculator);



            if(x != Float.MIN_VALUE && y != Float.MIN_VALUE){

                if(CheckOperation(operation,"SUM")){
                    if(!ParameterHasId){
                        calculator.Sum(x,y);
                    } else {
                        calculator.Sum(x,y,params[3]);
                    }
                } else if(CheckOperation(operation,"MINUS")){
                    if(!ParameterHasId){
                        calculator.Minus(x,y);
                    } else {
                        calculator.Minus(x,y,params[3]);
                    }
                } else if(CheckOperation(operation,"MULTIPLY")){
                    if(!ParameterHasId){
                        calculator.Multiply(x,y);
                    } else {
                        calculator.Multiply(x,y,params[3]);
                    }
                } else if(CheckOperation(operation,"DIVIDE")){
                    if(!ParameterHasId){
                        calculator.Divide(x,y);
                    } else {
                        calculator.Divide(x,y,params[3]);
                    }
                } else {
                    System.out.println("Operacion Invalida, intente nuevamente");
                }

            }
        }
    }


    public static boolean CheckOperation(String operation, String parameter){
        return operation.toUpperCase(Locale.ROOT).equals(parameter);
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
                return calculator.Show(param);
            } catch (Exception e){
                System.out.println("El ID " + param +  " no existe");
                return Float.MIN_VALUE;
            }
        }
    }
}
