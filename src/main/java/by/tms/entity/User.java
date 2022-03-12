package by.tms.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @Pattern(regexp ="[a-zA-Z]+", message = "Name must contain only letters")
    @Size(min = 2, max = 30, message = "Name should be between 2-30 characters")
    private String name;
    @Size(min = 6, max = 30, message = "Username should be between 6-30 characters")
    private String username;
    @Size(min = 6, max = 30, message = "Pass should be between 6-30 characters")
    private String pass;
//    @Pattern(regexp = "[1-5]",message = "Choose question")
//    private String question;
//    @Size(min = 2, max = 30, message = "Answer should be between 2-30 characters")
//    private String answer;

    public User(){
    }

    public User(String name, String username, String pass) {
        this.name = name;
        this.username = username;
        this.pass = pass;
//        this.question = question;
//        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
}
