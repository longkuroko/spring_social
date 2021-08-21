package social.Network.projectsocial.security.jwt.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
public class AuthenticationRequest {
    private String usernameOrEmail;
    private String password;
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }
}
