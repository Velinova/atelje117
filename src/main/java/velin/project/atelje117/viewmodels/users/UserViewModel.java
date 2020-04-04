package velin.project.atelje117.viewmodels.users;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import velin.project.atelje117.model.domain.RoleEnum;

@JsonSerialize
public class UserViewModel {
    public int Id;
    public String Name;
    public String Surname;
    public String Username;
    public RoleEnum Role;
    public String City;

}


