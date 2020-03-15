package velin.project.atelje117.payload.request;


import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String city;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private Set<String> role;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){ return email; }
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getCity(){return city;}
    public Set<String> getRole(){return role;}
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setRole(Set<String>role){
        this.role=role;
    }
}
