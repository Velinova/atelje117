package velin.project.atelje117.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import velin.project.atelje117.service.services.IUserService;
import velin.project.atelje117.viewmodels.users.UserViewModel;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
    @GetMapping("/details/{userId}")
    public UserViewModel getUser(@PathVariable int userId) throws JsonProcessingException {
        UserViewModel user = userService.getUser(userId);
        return user;
    }
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/contentArtist")
    @PreAuthorize("hasRole('ARTIST')")
    public String artistAccess() {
        return "Artist Board.";
    }

    @GetMapping("/contentCoworker")
    @PreAuthorize("hasRole('COWORKER')")
    public String coworkerAccess() {
        return "Coworker Board.";
    }
}