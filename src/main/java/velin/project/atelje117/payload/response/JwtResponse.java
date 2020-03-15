package velin.project.atelje117.payload.response;

import velin.project.atelje117.model.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class JwtResponse {
    private String token;
    private String type ="Bearer";
    private int id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String city;
    private List<String> roles;


    public JwtResponse(String accessToken, int id, String username, String email, String name, String surname, String city, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
