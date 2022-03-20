package by.tms.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp ="[a-zA-Z]+", message = "Name must contain only letters")
    @Size(min = 2, max = 30, message = "Name should be between 2-30 characters")
    private String name;
    @Size(min = 6, max = 30, message = "Username should be between 6-30 characters")
    private String username;
    @Size(min = 6, max = 30, message = "Pass should be between 6-30 characters")
    private String pass;



    public User(){
    }

    public User(String name, String username, String pass) {
        this.name = name;
        this.username = username;
        this.pass = pass;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
