package velin.project.atelje117.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.payload.request.LoginRequest;
import velin.project.atelje117.payload.request.SignupRequest;
import velin.project.atelje117.payload.response.JwtResponse;
import velin.project.atelje117.payload.response.MessageResponse;
import velin.project.atelje117.persistence.implementation.ArtistsRepository;
import velin.project.atelje117.persistence.implementation.CoworkerRepository;
import velin.project.atelje117.persistence.implementation.RoleRepository;
import velin.project.atelje117.persistence.implementation.UserRepository;
import velin.project.atelje117.security.jwt.JwtUtils;
import velin.project.atelje117.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ArtistsRepository artistsRepository;

    @Autowired
    CoworkerRepository coworkerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken tkn = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(tkn);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getName(),
                userDetails.getSurname(),
                userDetails.getCity(),
                roles));
    }

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getSurname(), signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getCity());

        RoleEnum strRole = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        
        if(strRole == RoleEnum.ROLE_ARTIST) {
            Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ARTIST)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found2."));
            roles.add(adminRole);
        }else {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_COWORKER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found3."));
            roles.add(userRole);
        }
//
        user.setRoles(roles);
        User newUser = userRepository.save(user);


        if(strRole == RoleEnum.ROLE_ARTIST) {
            ArtistUser artist = new ArtistUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword(),newUser.getName(), newUser.getSurname(), newUser.getCity(), newUser.getId());
            artistsRepository.save(artist);
        }else{
            CoworkerUser coworker = new CoworkerUser(  newUser.getUsername(), newUser.getEmail(), newUser.getPassword(),newUser.getName(), newUser.getSurname(), newUser.getCity(), newUser.getId());
            coworkerRepository.save(coworker);
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}