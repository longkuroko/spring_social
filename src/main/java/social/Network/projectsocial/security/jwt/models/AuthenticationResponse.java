package social.Network.projectsocial.security.jwt.models;

import lombok.Setter;

public class AuthenticationResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationResponse(String token){
        this.token  = token;
    }

    public AuthenticationResponse(){

    }
}
