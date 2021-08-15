package social.Network.projectsocial.security.email;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String email ;
    private final String password;
}
