package by.tms.entity;

import javax.validation.constraints.Size;

public class UserDTO {
    @Size(min = 6, max = 30, message = "Username should be between 6-30 characters")
    private String username;
    @Size(min = 6, max = 30, message = "Pass should be between 6-30 characters")
    private String pass;

    public UserDTO(String username, String pass) {
        this.username = username;
        this.pass = pass;
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
