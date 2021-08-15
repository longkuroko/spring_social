package social.Network.projectsocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.repository.UserRepository;
import social.Network.projectsocial.security.token.ConfirmationToken;
import social.Network.projectsocial.security.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG =
             "user with  email %S not found";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    public UserDetailService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return  userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(User user){

         boolean userExists =  userRepository
                 .findByEmail(user.getEmail())
                 .isPresent();

         if(userExists){
             //TODO check of attributes are the same and
             // TODO if mail not confirmed send confirmation email.

             throw new IllegalStateException("email already taken");
         }

         String encodePassword =  bCryptPasswordEncoder
                 .encode(user.getPassword());

         user.setPassword(encodePassword);

         userRepository.save(user);

         String token = UUID.randomUUID().toString();
         //TODO: send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO: send email



        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
