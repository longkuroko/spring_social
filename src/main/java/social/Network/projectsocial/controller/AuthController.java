package social.Network.projectsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.security.email.RegistrationRequest;
import social.Network.projectsocial.security.jwt.CustomDetailsService;
import social.Network.projectsocial.security.jwt.JwtTokenHelper;
import social.Network.projectsocial.security.jwt.models.AuthenticationRequest;
import social.Network.projectsocial.security.jwt.models.AuthenticationResponse;
import social.Network.projectsocial.service.UserDetailService;
import social.Network.projectsocial.service.UserService;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomDetailsService userDetailService;

    @Autowired
    JwtTokenHelper jwtTokenHelper;


    @PostMapping("/register")
    public String register (@RequestBody RegistrationRequest request){

        return userService.register(request);
    }
    @GetMapping("/confirm")
    public String confirm (@RequestParam("token") String token){
        return userService.confirmToken(token);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login (@RequestBody AuthenticationRequest authenticationRequest)
//        throws Exception{
//        authenticate(authenticationRequest.getUsernameOrEmail(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailService
//                .loadUserByUsername(authenticationRequest.getUsernameOrEmail());
//
//        final String token = jwtTokenHelper.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(token));
//
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        Objects.requireNonNull(username);
//        Objects.requireNonNull(password);
//
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
    @PostMapping("/login")
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest loginRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user=(User)authentication.getPrincipal();
        String jwtToken=jwtTokenHelper.generateToken(user.getUsername());

        AuthenticationResponse response=new AuthenticationResponse();
        response.setToken(jwtToken);


        return ResponseEntity.ok(response);
}

}
