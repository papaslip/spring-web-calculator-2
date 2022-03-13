package by.tms.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Operation {
    private int id;
    @Pattern(regexp = "^[0-9]+\\.?[0-9]*$", message = "There is should be number")
    private String num1;
    @Pattern(regexp = "^[0-9]+\\.?[0-9]*$", message = "There is should be number")
    private String num2;
    @NotNull(message = "Select operator")
    private String operator;
    private String result;
    private String username;

    public Operation(String num1, String num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public enum Operators {
        sum,
        sub,
        mul,
        dif
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
