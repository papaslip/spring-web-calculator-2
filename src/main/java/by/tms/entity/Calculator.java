package by.tms.entity;

public class Calculator {
    public String operation (int num1, int num2, String operator){

        int result=0;

        if (operator.equals("sum")){
            result = num1+num2;
            operator="+";
        } else if (operator.equals("sub")){
            result = num1-num2;
            operator="-";
        } else if (operator.equals("mul")){
            result = num1*num2;
            operator="*";
        } else if (operator.equals("div")){
            result = num1/num2;
            operator="/";
        }
        return num1+operator+num2+"="+result;
    }
}
