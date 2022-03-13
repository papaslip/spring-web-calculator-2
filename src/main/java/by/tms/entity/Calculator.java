package by.tms.entity;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public String executeOperation (Operation operation){
        double num1double = (double) Double.parseDouble(operation.getNum1());
        double num2double = (double) Double.parseDouble(operation.getNum2());
        String oper = operation.getOperator();
        double result=0;

        if (oper.equals("sum")){
            result = num1double+num2double;
            operation.setOperator("+");
        } else if (oper.equals("sub")){
            result = num1double-num2double;
            operation.setOperator("-");
        } else if (oper.equals("mul")){
            result = num1double*num2double;
            operation.setOperator("*");
        } else if (oper.equals("dif")){
            result = num1double/num2double;
            operation.setOperator("/");
        }
        return num1double+operation.getOperator()+num2double+"="+result;
    }
}
