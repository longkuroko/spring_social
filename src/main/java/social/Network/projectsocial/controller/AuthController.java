package social.Network.projectsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import social.Network.projectsocial.config.PasswordEncoder;
import social.Network.projectsocial.exception.BadRequestException;
import social.Network.projectsocial.model.AuthProvider;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.payload.ApiResponse;
import social.Network.projectsocial.payload.AuthResponse;
import social.Network.projectsocial.payload.LoginRequest;
import social.Network.projectsocial.payload.SignUpRequest;
import social.Network.projectsocial.repository.UserRepository;
import social.Network.projectsocial.security.email.RegistrationRequest;
import social.Network.projectsocial.security.jwt.CustomUserDetail;
import social.Network.projectsocial.security.jwt.JwtRequestFilter;
import social.Network.projectsocial.security.jwt.JwtUtil;
import social.Network.projectsocial.security.oauth2.usertokenoauth2.TokenProvider;
import social.Network.projectsocial.service.UserDetailService;
import social.Network.projectsocial.service.UserService;

import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailService  userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping()
    public String register (@RequestBody RegistrationRequest request){
        return userService.register(request);
    }
    @GetMapping("/confirm")
    public String confirm (@RequestParam("token") String token){
        return userService.confirmToken(token);
    }

    //TODO : LOGIN WITH OAUTH2
//    @CrossOrigin(origins = "*")
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser( @Valid @RequestBody SignUpRequest signUpRequest) {
//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            throw new BadRequestException("Email address already in use.");
//        }
//        // Creating user's account
//        User user = new User();
//        user.setUsername(signUpRequest.getUsername());
//        user.setEmail(signUpRequest.getEmail());
//        user.setPassword(signUpRequest.getPassword());
//        user.setAuthProvider(AuthProvider.local);
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        User result = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/user/me")
//                .buildAndExpand(result.getId()).toUri();
//
//        return ResponseEntity.created(location)
//                .body(new ApiResponse(true, "User registered successfully@"));
//    }

    //TODO: LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest)
            throws Exception {

        authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        final UserDetails userDetails = userDetailService
                .loadUserByUsername(loginRequest.getEmail());

        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
