package velin.project.atelje117.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public void SetUsername(String username){
        this.username = username;
    }
    public void SetPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
